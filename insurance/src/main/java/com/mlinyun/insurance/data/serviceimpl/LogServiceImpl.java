package com.mlinyun.insurance.data.serviceimpl;

import com.mlinyun.insurance.data.dao.LogDao;
import com.mlinyun.insurance.data.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 日志接口实现
 */
@Service
@Transactional
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;

    @Override
    public LogDao getRepository() {
        return logDao;
    }
}
