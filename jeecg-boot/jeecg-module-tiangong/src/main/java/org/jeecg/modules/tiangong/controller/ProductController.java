package org.jeecg.modules.tiangong.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.query.QueryRuleEnum;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.tiangong.entity.Product;
import org.jeecg.modules.tiangong.service.IProductService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;

 /**
 * @Description: biz_product
 * @Author: jeecg-boot
 * @Date:   2024-12-28
 * @Version: V1.0
 */
@Api(tags="biz_product")
@RestController
@RequestMapping("/tiangong/product")
@Slf4j
public class ProductController extends JeecgController<Product, IProductService> {
	@Autowired
	private IProductService productService;
	
	/**
	 * 分页列表查询
	 *
	 * @param product
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "biz_product-分页列表查询")
	@ApiOperation(value="biz_product-分页列表查询", notes="biz_product-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Product>> queryPageList(Product product,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("reservationType", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("ticketCategory", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("ticketType", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("stockType", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<Product> queryWrapper = QueryGenerator.initQueryWrapper(product, req.getParameterMap(),customeRuleMap);
		Page<Product> page = new Page<Product>(pageNo, pageSize);
		IPage<Product> pageList = productService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param product
	 * @return
	 */
	@AutoLog(value = "biz_product-添加")
	@ApiOperation(value="biz_product-添加", notes="biz_product-添加")
	@RequiresPermissions("tiangong:biz_product:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Product product) {
		productService.save(product);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param product
	 * @return
	 */
	@AutoLog(value = "biz_product-编辑")
	@ApiOperation(value="biz_product-编辑", notes="biz_product-编辑")
	@RequiresPermissions("tiangong:biz_product:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Product product) {
		productService.updateById(product);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "biz_product-通过id删除")
	@ApiOperation(value="biz_product-通过id删除", notes="biz_product-通过id删除")
	@RequiresPermissions("tiangong:biz_product:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		productService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "biz_product-批量删除")
	@ApiOperation(value="biz_product-批量删除", notes="biz_product-批量删除")
	@RequiresPermissions("tiangong:biz_product:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.productService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "biz_product-通过id查询")
	@ApiOperation(value="biz_product-通过id查询", notes="biz_product-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Product> queryById(@RequestParam(name="id",required=true) String id) {
		Product product = productService.getById(id);
		if(product==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(product);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param product
    */
    @RequiresPermissions("tiangong:biz_product:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Product product) {
        return super.exportXls(request, product, Product.class, "biz_product");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("tiangong:biz_product:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Product.class);
    }

}
