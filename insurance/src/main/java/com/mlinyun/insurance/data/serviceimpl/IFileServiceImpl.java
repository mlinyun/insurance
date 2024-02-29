package com.mlinyun.insurance.data.serviceimpl;

import com.mlinyun.insurance.data.dao.mapper.FileMapper;
import com.mlinyun.insurance.data.entity.File;
import com.mlinyun.insurance.data.service.IFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 系统文件 服务层实现
 */
@Service
public class IFileServiceImpl extends ServiceImpl<FileMapper, File> implements IFileService {

}
