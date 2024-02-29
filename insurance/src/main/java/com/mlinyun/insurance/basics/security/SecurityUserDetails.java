package com.mlinyun.insurance.basics.security;

import com.mlinyun.insurance.basics.parameter.CommonConstant;
import com.mlinyun.insurance.data.entity.User;
import com.mlinyun.insurance.data.utils.InsNullUtils;
import com.mlinyun.insurance.data.vo.PermissionDTO;
import com.mlinyun.insurance.data.vo.RoleDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class SecurityUserDetails extends User implements UserDetails {

    private static final long serialVersionUID = 1L;

    private List<RoleDTO> roles;

    private List<PermissionDTO> permissions;

    @Override
    @ApiOperation(value = "查询用户的角色和菜单权限")
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        // 菜单权限
        if (permissions != null && permissions.size() > 0) {
            for (PermissionDTO dto : permissions) {
                if (!InsNullUtils.isNull(dto.getTitle()) && !InsNullUtils.isNull(dto.getPath())) {
                    grantedAuthorityList.add(new SimpleGrantedAuthority(dto.getTitle()));
                }
            }
        }
        // 角色
        if (roles != null && roles.size() > 0) {
            roles.forEach(role -> {
                if (!InsNullUtils.isNull(role.getName())) {
                    grantedAuthorityList.add(new SimpleGrantedAuthority(role.getName()));
                }
            });
        }
        return grantedAuthorityList;
    }

    @Override
    @ApiOperation(value = "账号是否启用")
    public boolean isEnabled() {
        return Objects.equals(CommonConstant.USER_STATUS_NORMAL, this.getStatus());
    }

    @ApiOperation(value = "账号是否过期")
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @ApiOperation(value = "账号密码是否过期")
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @ApiOperation(value = "账号是否禁用")
    public boolean isAccountNonLocked() {
        return !Objects.equals(CommonConstant.USER_STATUS_LOCK, this.getStatus());
    }

    /**
     * 自定义类构造器
     *
     * @param user 系统账户
     */
    public SecurityUserDetails(User user) {
        if (user != null) {
            this.setUsername(user.getUsername());
            this.setPassword(user.getPassword());
            this.setStatus(user.getStatus());
            this.permissions = user.getPermissions();
            this.roles = user.getRoles();
        }
    }
}