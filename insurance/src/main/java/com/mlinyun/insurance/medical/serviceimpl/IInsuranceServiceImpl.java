package com.mlinyun.insurance.medical.serviceimpl;

import com.mlinyun.insurance.medical.mapper.InsuranceMapper;
import com.mlinyun.insurance.medical.entity.Insurance;
import com.mlinyun.insurance.medical.service.IInsuranceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 医疗保险 服务层接口实现
 */
@Slf4j
@Service
@Transactional
public class IInsuranceServiceImpl extends ServiceImpl<InsuranceMapper, Insurance> implements IInsuranceService {

    @Autowired
    private InsuranceMapper insuranceMapper;
}