package com.mlinyun.insurance.medical.serviceimpl;

import com.mlinyun.insurance.medical.mapper.ExamineMapper;
import com.mlinyun.insurance.medical.entity.Examine;
import com.mlinyun.insurance.medical.service.IExamineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 保险审核单 服务层接口实现
 */
@Slf4j
@Service
@Transactional
public class IExamineServiceImpl extends ServiceImpl<ExamineMapper, Examine> implements IExamineService {

    @Autowired
    private ExamineMapper examineMapper;
}