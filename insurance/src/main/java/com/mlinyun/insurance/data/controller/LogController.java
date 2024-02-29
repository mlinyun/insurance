package com.mlinyun.insurance.data.controller;

import com.mlinyun.insurance.basics.log.LogType;
import com.mlinyun.insurance.basics.log.SystemLog;
import com.mlinyun.insurance.basics.utils.PageUtil;
import com.mlinyun.insurance.basics.utils.ResultUtil;
import com.mlinyun.insurance.basics.baseVo.PageVo;
import com.mlinyun.insurance.basics.baseVo.Result;
import com.mlinyun.insurance.data.entity.Log;
import com.mlinyun.insurance.data.service.ILogService;
import com.mlinyun.insurance.data.utils.InsNullUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * 系统日志
 */
@RestController
@Api(tags = "日志管理接口")
@RequestMapping("/ins/log")
@Transactional
public class LogController {

    @Autowired
    private ILogService iLogService;

    @SystemLog(about = "查询日志", type = LogType.DATA_CENTER, doType = "LOG-01")
    @RequestMapping(value = "/getAllByPage", method = RequestMethod.GET)
    @ApiOperation(value = "查询日志")
    public Result<Object> getAllByPage(@ModelAttribute Log log, @ModelAttribute PageVo page) {
        QueryWrapper<Log> qw = new QueryWrapper<>();
        if (!InsNullUtils.isNull(log.getName())) {
            qw.like("name", log.getName());
        }
        if (log.getLogType() != null) {
            qw.eq("log_type", log.getLogType());
        }
        if (!InsNullUtils.isNull(log.getUsername())) {
            qw.like("username", log.getUsername());
        }
        if (!InsNullUtils.isNull(log.getIp())) {
            qw.like("ip", log.getIp());
        }
        if (!InsNullUtils.isNull(log.getStartDate())) {
            qw.ge("create_time", log.getStartDate());
            qw.le("create_time", log.getEndDate());
        }
        return ResultUtil.data(iLogService.page(PageUtil.initMpPage(page), qw));
    }
}
