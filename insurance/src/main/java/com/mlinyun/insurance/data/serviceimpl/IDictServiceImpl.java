package com.mlinyun.insurance.data.serviceimpl;

import com.mlinyun.insurance.data.dao.mapper.DictMapper;
import com.mlinyun.insurance.data.entity.Dict;
import com.mlinyun.insurance.data.service.IDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 数据字典 服务层实现
 */
@Service
public class IDictServiceImpl extends ServiceImpl<DictMapper, Dict> implements IDictService {

}
