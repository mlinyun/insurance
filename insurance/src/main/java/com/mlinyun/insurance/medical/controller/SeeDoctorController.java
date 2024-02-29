package com.mlinyun.insurance.medical.controller;

import cn.hutool.core.date.DateUtil;
import com.mlinyun.insurance.basics.utils.PageUtil;
import com.mlinyun.insurance.basics.utils.ResultUtil;
import com.mlinyun.insurance.basics.baseVo.PageVo;
import com.mlinyun.insurance.basics.baseVo.Result;
import com.mlinyun.insurance.data.utils.InsNullUtils;
import com.mlinyun.insurance.medical.entity.Examine;
import com.mlinyun.insurance.medical.entity.Roster;
import com.mlinyun.insurance.medical.entity.SeeDoctor;
import com.mlinyun.insurance.medical.service.IExamineService;
import com.mlinyun.insurance.medical.service.IRosterService;
import com.mlinyun.insurance.medical.service.ISeeDoctorService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RestController
@Api(tags = "看病单管理接口")
@RequestMapping("/ins/seeDoctor")
@Transactional
public class SeeDoctorController {

    @Autowired
    private ISeeDoctorService iSeeDoctorService;

    @Autowired
    private IRosterService iRosterService;

    @Autowired
    private IExamineService iExamineService;

    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    @ApiOperation(value = "查询单条看病单")
    public Result<SeeDoctor> get(@RequestParam String id) {
        return new ResultUtil<SeeDoctor>().setData(iSeeDoctorService.getById(id));
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ApiOperation(value = "查询全部看病单个数")
    public Result<Long> getCount() {
        return new ResultUtil<Long>().setData(iSeeDoctorService.count());
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ApiOperation(value = "查询全部看病单")
    public Result<List<SeeDoctor>> getAll() {
        return new ResultUtil<List<SeeDoctor>>().setData(iSeeDoctorService.list());
    }

    @RequestMapping(value = "/getByPage", method = RequestMethod.GET)
    @ApiOperation(value = "查询看病单")
    public Result<IPage<SeeDoctor>> getByPage(@ModelAttribute SeeDoctor seeDoctor, @ModelAttribute PageVo page) {
        QueryWrapper<SeeDoctor> qw = new QueryWrapper<>();
        if (!InsNullUtils.isNull(seeDoctor.getCreateBy())) {
        }
        IPage<SeeDoctor> data = iSeeDoctorService.page(PageUtil.initMpPage(page), qw);
        return new ResultUtil<IPage<SeeDoctor>>().setData(data);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ApiOperation(value = "新增看病单")
    public Result<SeeDoctor> insert(SeeDoctor seeDoctor) {
        Roster roster = iRosterService.getById(seeDoctor.getUserId());
        roster.setMoney(seeDoctor.getBalanceNew());
        iRosterService.saveOrUpdate(roster);
        seeDoctor.setDate(DateUtil.now());
        /**
         * 保险审核的业务逻辑
         */
        Examine examine = new Examine();
        examine.setUserId(roster.getId());
        examine.setUserName(roster.getName());
        examine.setInsuranceId(roster.getInsuranceType());
        examine.setInsuranceName(roster.getInsuranceName());
        examine.setMoney(seeDoctor.getPriceSum());
        examine.setStatus(0);
        examine.setMessage("未审核");
        iExamineService.saveOrUpdate(examine);

        iSeeDoctorService.saveOrUpdate(seeDoctor);
        return new ResultUtil<SeeDoctor>().setData(seeDoctor);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "编辑看病单")
    public Result<SeeDoctor> update(SeeDoctor seeDoctor) {
        iSeeDoctorService.saveOrUpdate(seeDoctor);
        return new ResultUtil<SeeDoctor>().setData(seeDoctor);
    }

    @RequestMapping(value = "/insertOrUpdate", method = RequestMethod.POST)
    @ApiOperation(value = "增改看病单")
    public Result<SeeDoctor> saveOrUpdate(SeeDoctor seeDoctor) {
        if (iSeeDoctorService.saveOrUpdate(seeDoctor)) {
            return new ResultUtil<SeeDoctor>().setData(seeDoctor);
        }
        return ResultUtil.error();
    }

    @RequestMapping(value = "/delByIds", method = RequestMethod.POST)
    @ApiOperation(value = "删除看病单")
    public Result<Object> delByIds(@RequestParam String[] ids) {
        for (String id : ids) {
            iSeeDoctorService.removeById(id);
        }
        return ResultUtil.success();
    }
}
