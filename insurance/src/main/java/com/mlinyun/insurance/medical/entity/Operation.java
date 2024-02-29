package com.mlinyun.insurance.medical.entity;

import com.mlinyun.insurance.basics.baseClass.InsBaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "a_operation")
@TableName("a_operation")
@ApiModel(value = "手术")
public class Operation extends InsBaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "手术名称")
    private String title;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "功能主治")
    private String efficacy;
}