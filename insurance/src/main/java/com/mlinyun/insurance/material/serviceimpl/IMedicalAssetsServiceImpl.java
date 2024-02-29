package com.mlinyun.insurance.material.serviceimpl;

import com.mlinyun.insurance.material.entity.MedicalAssets;
import com.mlinyun.insurance.material.mapper.MedicalAssetsMapper;
import com.mlinyun.insurance.material.service.IMedicalAssetsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 医疗资产接口实现
 */
@Service
@Transactional
public class IMedicalAssetsServiceImpl extends ServiceImpl<MedicalAssetsMapper, MedicalAssets> implements IMedicalAssetsService {

}