package com.mlinyun.insurance.data.serviceimpl;

import com.mlinyun.insurance.data.dao.mapper.LogMapper;
import com.mlinyun.insurance.data.entity.Log;
import com.mlinyun.insurance.data.service.ILogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 系统日志 服务层实现
 */
@Service
public class ILogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService {

}
