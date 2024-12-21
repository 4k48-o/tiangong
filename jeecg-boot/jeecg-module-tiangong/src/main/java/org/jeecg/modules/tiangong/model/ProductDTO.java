package org.jeecg.modules.tiangong.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.jeecg.modules.tiangong.entity.Product;
import java.io.Serializable;

/**
 * 产品数据传输对象
 */
@Data
@ApiModel(value="ProductDTO", description="产品数据传输对象")
public class ProductDTO extends Product implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "创建人名称")
    private String createByName;

    @ApiModelProperty(value = "更新人名称")
    private String updateByName;
}
