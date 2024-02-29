package com.mlinyun.insurance.data.dao.mapper;

import com.mlinyun.insurance.data.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单 数据链路层接口
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 通过用户id获取
     *
     * @param userId
     * @return
     */
    List<Permission> findByUserId(@Param("userId") String userId);
}
