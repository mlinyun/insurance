package com.mlinyun.insurance.data.entity;

import com.mlinyun.insurance.basics.baseClass.InsBaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "a_setting")
@TableName("a_setting")
@ApiModel(value = "配置")
@NoArgsConstructor
public class Setting extends InsBaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设置内容")
    private String value;

    public Setting(String id) {
        super.setId(id);
    }
}