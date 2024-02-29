package com.mlinyun.insurance.data.serviceimpl;

import com.mlinyun.insurance.data.dao.mapper.UserMapper;
import com.mlinyun.insurance.data.entity.User;
import com.mlinyun.insurance.data.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户 服务层实现
 */
@Service
public class IUserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
