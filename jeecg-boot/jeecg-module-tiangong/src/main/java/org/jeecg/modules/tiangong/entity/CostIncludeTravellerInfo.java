package org.jeecg.modules.tiangong.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 费用包含的出行人数量信息
 */
@Data
@ApiModel(value="CostIncludeTravellerInfo对象", description="费用包含的出行人数量信息")
public class CostIncludeTravellerInfo implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "青年数量")
    private Integer seniorNumber;

    @ApiModelProperty(value = "学生数量")
    private Integer studentNumber;

    @ApiModelProperty(value = "儿童数量")
    private Integer childrenNumber;

    @ApiModelProperty(value = "成人数量")
    private Integer adultNumber;
}
