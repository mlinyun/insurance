package com.mlinyun.insurance.data.controller;

import com.mlinyun.insurance.basics.log.LogType;
import com.mlinyun.insurance.basics.log.SystemLog;
import com.mlinyun.insurance.basics.utils.PageUtil;
import com.mlinyun.insurance.basics.utils.ResultUtil;
import com.mlinyun.insurance.basics.baseVo.PageVo;
import com.mlinyun.insurance.basics.baseVo.Result;
import com.mlinyun.insurance.data.entity.User;
import com.mlinyun.insurance.data.service.IUserService;
import com.mlinyun.insurance.data.utils.InsNullUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@Api(tags = "mybatis用户接口")
@RequestMapping("/ins/myUser")
@Transactional
public class MyUserController {

    @Autowired
    private IUserService iUserService;

    @SystemLog(about = "查询用户", type = LogType.DATA_CENTER, doType = "USER-01")
    @RequestMapping(value = "/getByPage", method = RequestMethod.GET)
    @ApiOperation(value = "查询用户")
    public Result<IPage<User>> getByPage(@ModelAttribute User user, @ModelAttribute PageVo page) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        if (user.getDepartmentId() != null && !InsNullUtils.isNull(user.getDepartmentId())) {
            qw.like("department_id", user.getDepartmentId());
        }
        if (user.getNickname() != null && !InsNullUtils.isNull(user.getNickname())) {
            qw.like("nickname", user.getNickname());
        }
        IPage<User> data = iUserService.page(PageUtil.initMpPage(page), qw);
        return new ResultUtil<IPage<User>>().setData(data);
    }
}
