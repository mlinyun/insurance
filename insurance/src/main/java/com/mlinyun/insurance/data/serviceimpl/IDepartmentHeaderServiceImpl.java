package com.mlinyun.insurance.data.serviceimpl;

import com.mlinyun.insurance.data.dao.mapper.DepartmentHeaderMapper;
import com.mlinyun.insurance.data.entity.DepartmentHeader;
import com.mlinyun.insurance.data.service.IDepartmentHeaderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 部门领导 服务层实现
 */
@Service
public class IDepartmentHeaderServiceImpl extends ServiceImpl<DepartmentHeaderMapper, DepartmentHeader> implements IDepartmentHeaderService {

}
