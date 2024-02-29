package com.mlinyun.insurance.data.serviceimpl;

import com.mlinyun.insurance.data.dao.mapper.UserRoleMapper;
import com.mlinyun.insurance.data.entity.Role;
import com.mlinyun.insurance.data.entity.UserRole;
import com.mlinyun.insurance.data.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户-角色关系 服务层实现
 */
@Service
public class IUserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<Role> findByUserId(String userId) {

        return userRoleMapper.findByUserId(userId);
    }

    @Override
    public List<String> findDepIdsByUserId(String userId) {

        return userRoleMapper.findDepIdsByUserId(userId);
    }
}
