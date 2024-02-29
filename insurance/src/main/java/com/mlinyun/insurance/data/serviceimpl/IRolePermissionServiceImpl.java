package com.mlinyun.insurance.data.serviceimpl;

import com.mlinyun.insurance.data.dao.mapper.RolePermissionMapper;
import com.mlinyun.insurance.data.entity.RolePermission;
import com.mlinyun.insurance.data.service.IRolePermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色-菜单关系 服务层实现
 */
@Service
public class IRolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements IRolePermissionService {

}
