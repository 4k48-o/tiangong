package org.jeecg.modules.tiangong.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.system.util.JwtUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.jeecg.modules.tiangong.entity.Product;
import org.jeecg.modules.tiangong.mapper.ProductMapper;
import org.jeecg.modules.tiangong.model.ProductDTO;
import org.jeecg.modules.tiangong.service.IProductService;

import java.util.Date;

/**
 * 产品服务实现类
 */
@Slf4j
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Override
    public IPage<ProductDTO> queryProductList(Page<ProductDTO> page, Product product) {
        return baseMapper.queryProductList(page, product);
    }

    @Override
    public ProductDTO getProductById(String id) {
        return baseMapper.getProductById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveProduct(Product product) {
       
        return save(product);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateProduct(Product product) {
        
        return updateById(product);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteProduct(String id) {
        return removeById(id);
    }
}