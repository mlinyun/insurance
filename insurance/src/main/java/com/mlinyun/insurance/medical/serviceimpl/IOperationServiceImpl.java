package com.mlinyun.insurance.medical.serviceimpl;

import com.mlinyun.insurance.medical.mapper.OperationMapper;
import com.mlinyun.insurance.medical.entity.Operation;
import com.mlinyun.insurance.medical.service.IOperationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 手术 服务层接口实现
 */
@Slf4j
@Service
@Transactional
public class IOperationServiceImpl extends ServiceImpl<OperationMapper, Operation> implements IOperationService {

    @Autowired
    private OperationMapper operationMapper;
}