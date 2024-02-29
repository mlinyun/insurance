package com.mlinyun.insurance.material.serviceimpl;

import com.mlinyun.insurance.material.entity.MedicalAssetsOutboundOrder;
import com.mlinyun.insurance.material.mapper.MedicalAssetsOutboundOrderMapper;
import com.mlinyun.insurance.material.service.IMedicalAssetsOutboundOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 医疗资产出库单接口实现
 */
@Service
@Transactional
public class IMedicalAssetsOutboundOrderServiceImpl extends ServiceImpl<MedicalAssetsOutboundOrderMapper, MedicalAssetsOutboundOrder> implements IMedicalAssetsOutboundOrderService {

}