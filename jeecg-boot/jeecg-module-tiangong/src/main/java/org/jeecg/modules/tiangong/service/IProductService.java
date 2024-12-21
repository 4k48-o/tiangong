package org.jeecg.modules.tiangong.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.tiangong.entity.Product;
import org.jeecg.modules.tiangong.model.ProductDTO;

/**
 * 产品服务接口
 */
public interface IProductService extends IService<Product> {

    /**
     * 分页查询产品信息
     *
     * @param page 分页参数
     * @param product 查询条件
     * @return 分页结果
     */
    IPage<ProductDTO> queryProductList(Page<ProductDTO> page, Product product);

    /**
     * 根据ID查询产品详情
     *
     * @param id 产品ID
     * @return 产品详情
     */
    ProductDTO getProductById(String id);

    /**
     * 新增产品
     *
     * @param product 产品信息
     * @return 是否成功
     */
    boolean saveProduct(Product product);

    /**
     * 修改产品
     *
     * @param product 产品信息
     * @return 是否成功
     */
    boolean updateProduct(Product product);

    /**
     * 删除产品
     *
     * @param id 产品ID
     * @return 是否成功
     */
    boolean deleteProduct(String id);
}
