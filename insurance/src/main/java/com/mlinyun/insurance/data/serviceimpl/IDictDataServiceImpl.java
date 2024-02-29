package com.mlinyun.insurance.data.serviceimpl;

import com.mlinyun.insurance.data.dao.mapper.DictDataMapper;
import com.mlinyun.insurance.data.entity.DictData;
import com.mlinyun.insurance.data.service.IDictDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 数据字典值 服务层实现
 */
@Service
public class IDictDataServiceImpl extends ServiceImpl<DictDataMapper, DictData> implements IDictDataService {

}
