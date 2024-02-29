package com.mlinyun.insurance.data.serviceimpl;

import com.mlinyun.insurance.data.dao.mapper.RoleMapper;
import com.mlinyun.insurance.data.entity.Role;
import com.mlinyun.insurance.data.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色 服务层实现
 */
@Service
public class IRoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
