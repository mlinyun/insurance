package com.mlinyun.insurance.data.serviceimpl;

import com.mlinyun.insurance.data.dao.mapper.PermissionMapper;
import com.mlinyun.insurance.data.entity.Permission;
import com.mlinyun.insurance.data.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单 服务层实现
 */
@Service
public class IPermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> findByUserId(String userId) {
        return permissionMapper.findByUserId(userId);
    }
}
