package com.mlinyun.insurance.data.serviceimpl;

import com.mlinyun.insurance.data.dao.mapper.SettingMapper;
import com.mlinyun.insurance.data.entity.Setting;
import com.mlinyun.insurance.data.service.ISettingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 设置 服务层实现
 */
@Service
public class ISettingServiceImpl extends ServiceImpl<SettingMapper, Setting> implements ISettingService {

}
