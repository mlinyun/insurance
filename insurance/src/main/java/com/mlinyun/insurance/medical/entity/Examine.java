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
@Table(name = "a_examine")
@TableName("a_examine")
@ApiModel(value = "保险审核单")
public class Examine extends InsBaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "参保人员ID")
    private String userId;

    @ApiModelProperty(value = "参保人员")
    private String userName;

    @ApiModelProperty(value = "保险ID")
    private String insuranceId;

    @ApiModelProperty(value = "保险名")
    private String insuranceName;

    @ApiModelProperty(value = "抵扣金额")
    private BigDecimal money;

    @ApiModelProperty(value = "审核状态")
    private Integer status;

    @ApiModelProperty(value = "审核意见")
    private String message;
}