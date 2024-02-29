package com.mlinyun.insurance.medical.controller;

import com.mlinyun.insurance.basics.utils.PageUtil;
import com.mlinyun.insurance.basics.utils.ResultUtil;
import com.mlinyun.insurance.basics.baseVo.PageVo;
import com.mlinyun.insurance.basics.baseVo.Result;
import com.mlinyun.insurance.data.utils.InsNullUtils;
import com.mlinyun.insurance.medical.entity.Insurance;
import com.mlinyun.insurance.medical.service.IInsuranceService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RestController
@Api(tags = "医疗保险管理接口")
@RequestMapping("/ins/insurance")
@Transactional
public class InsuranceController {

    @Autowired
    private IInsuranceService iInsuranceService;

    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    @ApiOperation(value = "查询单条医疗保险")
    public Result<Insurance> get(@RequestParam String id) {
        return new ResultUtil<Insurance>().setData(iInsuranceService.getById(id));
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ApiOperation(value = "查询全部医疗保险个数")
    public Result<Long> getCount() {
        return new ResultUtil<Long>().setData(iInsuranceService.count());
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ApiOperation(value = "查询全部医疗保险")
    public Result<List<Insurance>> getAll() {
        return new ResultUtil<List<Insurance>>().setData(iInsuranceService.list());
    }

    @RequestMapping(value = "/getByPage", method = RequestMethod.GET)
    @ApiOperation(value = "查询医疗保险")
    public Result<IPage<Insurance>> getByPage(@ModelAttribute Insurance insurance, @ModelAttribute PageVo page) {
        QueryWrapper<Insurance> qw = new QueryWrapper<>();
        if (!InsNullUtils.isNull(insurance.getCreateBy())) {
        }
        IPage<Insurance> data = iInsuranceService.page(PageUtil.initMpPage(page), qw);
        return new ResultUtil<IPage<Insurance>>().setData(data);
    }

    @RequestMapping(value = "/insertOrUpdate", method = RequestMethod.POST)
    @ApiOperation(value = "增改医疗保险")
    public Result<Insurance> saveOrUpdate(Insurance insurance) {
        if (iInsuranceService.saveOrUpdate(insurance)) {
            return new ResultUtil<Insurance>().setData(insurance);
        }
        return ResultUtil.error();
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ApiOperation(value = "新增医疗保险")
    public Result<Insurance> insert(Insurance insurance) {
        iInsuranceService.saveOrUpdate(insurance);
        return new ResultUtil<Insurance>().setData(insurance);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "编辑医疗保险")
    public Result<Insurance> update(Insurance insurance) {
        iInsuranceService.saveOrUpdate(insurance);
        return new ResultUtil<Insurance>().setData(insurance);
    }

    @RequestMapping(value = "/delByIds", method = RequestMethod.POST)
    @ApiOperation(value = "删除医疗保险")
    public Result<Object> delByIds(@RequestParam String[] ids) {
        for (String id : ids) {
            iInsuranceService.removeById(id);
        }
        return ResultUtil.success();
    }
}
