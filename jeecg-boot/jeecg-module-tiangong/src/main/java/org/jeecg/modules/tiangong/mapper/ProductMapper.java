package org.jeecg.modules.tiangong.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.tiangong.entity.Product;
import org.jeecg.modules.tiangong.model.ProductDTO;

/**
 * 产品Mapper接口
 */
public interface ProductMapper extends BaseMapper<Product> {
    
    /**
     * 分页查询产品信息
     *
     * @param page 分页参数
     * @param product 查询条件
     * @return 分页结果
     */
    IPage<ProductDTO> queryProductList(Page<ProductDTO> page, @Param("product") Product product);

    /**
     * 根据ID查询产品详情
     *
     * @param id 产品ID
     * @return 产品详情
     */
    ProductDTO getProductById(@Param("id") String id);
}
