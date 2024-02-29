package com.mlinyun.insurance.data.dao.mapper;

import com.mlinyun.insurance.data.entity.Role;
import com.mlinyun.insurance.data.entity.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户-角色关系 数据链路层接口
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {

    /**
     * 通过用户id获取
     *
     * @param userId
     * @return
     */
    List<Role> findByUserId(@Param("userId") String userId);

    /**
     * 通过用户id获取用户角色关联的部门数据
     *
     * @param userId
     * @return
     */
    List<String> findDepIdsByUserId(@Param("userId") String userId);
}
