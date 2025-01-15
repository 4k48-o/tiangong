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
import org.jeecg.modules.tiangong.entity.InventoryGroup;
import org.jeecg.modules.tiangong.service.IInventoryGroupService;

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
 * @Description: 库存组
 * @Author: jeecg-boot
 * @Date:   2025-01-15
 * @Version: V1.0
 */
@Api(tags="库存组")
@RestController
@RequestMapping("/tiangong/inventoryGroup")
@Slf4j
public class InventoryGroupController extends JeecgController<InventoryGroup, IInventoryGroupService> {
	@Autowired
	private IInventoryGroupService inventoryGroupService;
	
	/**
	 * 分页列表查询
	 *
	 * @param inventoryGroup
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "库存组-分页列表查询")
	@ApiOperation(value="库存组-分页列表查询", notes="库存组-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<InventoryGroup>> queryPageList(InventoryGroup inventoryGroup,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        QueryWrapper<InventoryGroup> queryWrapper = QueryGenerator.initQueryWrapper(inventoryGroup, req.getParameterMap());
		Page<InventoryGroup> page = new Page<InventoryGroup>(pageNo, pageSize);
		IPage<InventoryGroup> pageList = inventoryGroupService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param inventoryGroup
	 * @return
	 */
	@AutoLog(value = "库存组-添加")
	@ApiOperation(value="库存组-添加", notes="库存组-添加")
	@RequiresPermissions("tiangong:biz_inventory_group:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody InventoryGroup inventoryGroup) {
		inventoryGroupService.save(inventoryGroup);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param inventoryGroup
	 * @return
	 */
	@AutoLog(value = "库存组-编辑")
	@ApiOperation(value="库存组-编辑", notes="库存组-编辑")
	@RequiresPermissions("tiangong:biz_inventory_group:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody InventoryGroup inventoryGroup) {
		inventoryGroupService.updateById(inventoryGroup);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "库存组-通过id删除")
	@ApiOperation(value="库存组-通过id删除", notes="库存组-通过id删除")
	@RequiresPermissions("tiangong:biz_inventory_group:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		inventoryGroupService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "库存组-批量删除")
	@ApiOperation(value="库存组-批量删除", notes="库存组-批量删除")
	@RequiresPermissions("tiangong:biz_inventory_group:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.inventoryGroupService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "库存组-通过id查询")
	@ApiOperation(value="库存组-通过id查询", notes="库存组-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<InventoryGroup> queryById(@RequestParam(name="id",required=true) String id) {
		InventoryGroup inventoryGroup = inventoryGroupService.getById(id);
		if(inventoryGroup==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(inventoryGroup);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param inventoryGroup
    */
    @RequiresPermissions("tiangong:biz_inventory_group:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, InventoryGroup inventoryGroup) {
        return super.exportXls(request, inventoryGroup, InventoryGroup.class, "库存组");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("tiangong:biz_inventory_group:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, InventoryGroup.class);
    }

}
