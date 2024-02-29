package com.mlinyun.insurance.medical.serviceimpl;

import com.mlinyun.insurance.medical.mapper.SeeDoctorMapper;
import com.mlinyun.insurance.medical.entity.SeeDoctor;
import com.mlinyun.insurance.medical.service.ISeeDoctorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 看病单 服务层接口实现
 */
@Slf4j
@Service
@Transactional
public class ISeeDoctorServiceImpl extends ServiceImpl<SeeDoctorMapper, SeeDoctor> implements ISeeDoctorService {

    @Autowired
    private SeeDoctorMapper seeDoctorMapper;
}