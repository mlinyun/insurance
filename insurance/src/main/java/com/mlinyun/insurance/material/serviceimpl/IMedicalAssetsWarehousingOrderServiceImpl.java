package com.mlinyun.insurance.material.serviceimpl;

import com.mlinyun.insurance.material.entity.MedicalAssetsWarehousingOrder;
import com.mlinyun.insurance.material.mapper.MedicalAssetsWarehousingOrderMapper;
import com.mlinyun.insurance.material.service.IMedicalAssetsWarehousingOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 入库管理接口实现
 */
@Slf4j
@Service
@Transactional
public class IMedicalAssetsWarehousingOrderServiceImpl extends ServiceImpl<MedicalAssetsWarehousingOrderMapper, MedicalAssetsWarehousingOrder> implements IMedicalAssetsWarehousingOrderService {

}