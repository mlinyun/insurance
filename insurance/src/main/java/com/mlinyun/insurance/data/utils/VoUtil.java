package com.mlinyun.insurance.data.utils;

import com.mlinyun.insurance.data.entity.Permission;
import com.mlinyun.insurance.data.vo.MenuVo;
import cn.hutool.core.bean.BeanUtil;
import io.swagger.annotations.ApiOperation;

/**
 * 菜单转换VO类
 */
public class VoUtil {

    @ApiOperation(value = "菜单转换VO类")
    public static MenuVo permissionToMenuVo(Permission permission) {
        MenuVo vo = new MenuVo();
        BeanUtil.copyProperties(permission, vo);
        return vo;
    }
}
