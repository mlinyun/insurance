package com.mlinyun.insurance.medical.controller;

import com.mlinyun.insurance.basics.utils.PageUtil;
import com.mlinyun.insurance.basics.utils.ResultUtil;
import com.mlinyun.insurance.basics.baseVo.PageVo;
import com.mlinyun.insurance.basics.baseVo.Result;
import com.mlinyun.insurance.data.utils.InsNullUtils;
import com.mlinyun.insurance.medical.entity.Operation;
import com.mlinyun.insurance.medical.service.IOperationService;
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
@Api(tags = "手术管理接口")
@RequestMapping("/ins/operation")
@Transactional
public class OperationController {

    @Autowired
    private IOperationService iOperationService;

    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    @ApiOperation(value = "查询单条手术")
    public Result<Operation> get(@RequestParam String id) {
        return new ResultUtil<Operation>().setData(iOperationService.getById(id));
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ApiOperation(value = "查询全部手术个数")
    public Result<Long> getCount() {
        return new ResultUtil<Long>().setData(iOperationService.count());
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ApiOperation(value = "查询全部手术")
    public Result<List<Operation>> getAll() {
        return new ResultUtil<List<Operation>>().setData(iOperationService.list());
    }

    @RequestMapping(value = "/getByPage", method = RequestMethod.GET)
    @ApiOperation(value = "查询手术")
    public Result<IPage<Operation>> getByPage(@ModelAttribute Operation operation, @ModelAttribute PageVo page) {
        QueryWrapper<Operation> qw = new QueryWrapper<>();
        if (!InsNullUtils.isNull(operation.getCreateBy())) {
        }
        IPage<Operation> data = iOperationService.page(PageUtil.initMpPage(page), qw);
        return new ResultUtil<IPage<Operation>>().setData(data);
    }

    @RequestMapping(value = "/insertOrUpdate", method = RequestMethod.POST)
    @ApiOperation(value = "增改手术")
    public Result<Operation> saveOrUpdate(Operation operation) {
        if (iOperationService.saveOrUpdate(operation)) {
            return new ResultUtil<Operation>().setData(operation);
        }
        return ResultUtil.error();
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ApiOperation(value = "新增手术")
    public Result<Operation> insert(Operation operation) {
        iOperationService.saveOrUpdate(operation);
        return new ResultUtil<Operation>().setData(operation);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "编辑手术")
    public Result<Operation> update(Operation operation) {
        iOperationService.saveOrUpdate(operation);
        return new ResultUtil<Operation>().setData(operation);
    }

    @RequestMapping(value = "/delByIds", method = RequestMethod.POST)
    @ApiOperation(value = "删除手术")
    public Result<Object> delByIds(@RequestParam String[] ids) {
        for (String id : ids) {
            iOperationService.removeById(id);
        }
        return ResultUtil.success();
    }
}
