package com.mlinyun.insurance.basics.security.jwt;

import com.mlinyun.insurance.basics.utils.ResponseUtil;
import com.mlinyun.insurance.basics.utils.SecurityUtil;
import com.mlinyun.insurance.basics.baseVo.TokenUser;
import com.mlinyun.insurance.basics.parameter.InsLoginProperties;
import com.mlinyun.insurance.data.utils.InsNullUtils;
import com.google.gson.Gson;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
public class JwtRoleFilter extends BasicAuthenticationFilter {

    private SecurityUtil securityUtil;

    private StringRedisTemplate stringRedisTemplate;

    private InsLoginProperties insLoginProperties;

    private static final boolean RESPONSE_FAIL_FLAG = false;

    private static final int RESPONSE_NO_ROLE_CODE = 401;

    @ApiOperation(value = "判断登陆是否失效")
    private UsernamePasswordAuthenticationToken getUsernamePasswordAuthenticationToken(String header, HttpServletResponse response) {
        String userName = null;
        String tokenInRedis = stringRedisTemplate.opsForValue().get(InsLoginProperties.HTTP_TOKEN_PRE + header);
        if (InsNullUtils.isNull(tokenInRedis)) {
            ResponseUtil.out(response, ResponseUtil.resultMap(RESPONSE_FAIL_FLAG, RESPONSE_NO_ROLE_CODE, "登录状态失效，需要重登！"));
            return null;
        }
        TokenUser tokenUser = new Gson().fromJson(tokenInRedis, TokenUser.class);
        userName = tokenUser.getUsername();
        List<GrantedAuthority> permissionList = new ArrayList<>();
        if (insLoginProperties.getSaveRoleFlag()) {
            for (String permission : tokenUser.getPermissions()) {
                permissionList.add(new SimpleGrantedAuthority(permission));
            }
        } else {
            permissionList = securityUtil.getCurrUserPerms(userName);
        }
        if (!tokenUser.getSaveLogin()) {
            stringRedisTemplate.opsForValue().set(InsLoginProperties.USER_TOKEN_PRE + userName, header, insLoginProperties.getUserTokenInvalidDays(), TimeUnit.MINUTES);
            stringRedisTemplate.opsForValue().set(InsLoginProperties.HTTP_TOKEN_PRE + header, tokenInRedis, insLoginProperties.getUserTokenInvalidDays(), TimeUnit.MINUTES);
        }
        if (!InsNullUtils.isNull(userName)) {
            User user = new User(userName, "", permissionList);
            return new UsernamePasswordAuthenticationToken(user, null, permissionList);
        }
        return null;
    }

    @Override
    @ApiOperation(value = "自定义权限过滤")
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String tokenHeader = request.getHeader(InsLoginProperties.HTTP_HEADER);
        if (InsNullUtils.isNull(tokenHeader)) {
            tokenHeader = request.getParameter(InsLoginProperties.HTTP_HEADER);
        }
        if (InsNullUtils.isNull(tokenHeader)) {
            chain.doFilter(request, response);
            return;
        }
        try {
            UsernamePasswordAuthenticationToken token = getUsernamePasswordAuthenticationToken(tokenHeader, response);
            SecurityContextHolder.getContext().setAuthentication(token);
        } catch (Exception e) {
            log.warn("自定义权限过滤失败" + e);
        }
        chain.doFilter(request, response);
    }

    /**
     * 默认类构造器
     */
    public JwtRoleFilter(AuthenticationManager manager, AuthenticationEntryPoint point) {
        super(manager, point);
    }

    public JwtRoleFilter(AuthenticationManager manager, InsLoginProperties loginProperties, StringRedisTemplate redis, SecurityUtil securityUtil) {
        super(manager);
        this.stringRedisTemplate = redis;
        this.securityUtil = securityUtil;
        this.insLoginProperties = loginProperties;
    }
}

