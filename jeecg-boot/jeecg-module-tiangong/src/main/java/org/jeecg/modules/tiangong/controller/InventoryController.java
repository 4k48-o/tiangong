package org.jeecg.modules.tiangong.controller;

import org.jeecg.common.system.query.QueryGenerator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.jeecg.common.system.query.QueryRuleEnum;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.common.api.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import java.util.Arrays;
import java.util.HashMap;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.tiangong.entity.BizInventoryItem;
import org.jeecg.modules.tiangong.entity.Inventory;
import org.jeecg.modules.tiangong.service.IInventoryService;
import org.jeecg.modules.tiangong.service.IBizInventoryItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.SecurityUtils;
import org.jeecg.common.system.vo.LoginUser;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.shiro.authz.annotation.RequiresPermissions;
 /**
 * @Description: 库存
 * @Author: jeecg-boot
 * @Date:   2025-01-09
 * @Version: V1.0
 */
@Api(tags="库存")
@RestController
@RequestMapping("/tiangong/inventory")
@Slf4j
public class InventoryController extends JeecgController<Inventory, IInventoryService> {

	@Autowired
	private IInventoryService inventoryService;

	@Autowired
	private IBizInventoryItemService bizInventoryItemService;


	/*---------------------------------主表处理-begin-------------------------------------*/

	/**
	 * 分页列表查询
	 * @param inventory
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "库存-分页列表查询")
	@ApiOperation(value="库存-分页列表查询", notes="库存-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Inventory>> queryPageList(Inventory inventory,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
      	QueryWrapper<Inventory> queryWrapper = QueryGenerator.initQueryWrapper(inventory, req.getParameterMap());
		Page<Inventory> page = new Page<Inventory>(pageNo, pageSize);
		IPage<Inventory> pageList = inventoryService.page(page, queryWrapper);
		return Result.OK(pageList);
	}

	/**
     *   添加
     * @param inventory
     * @return
     */
    @AutoLog(value = "库存-添加")
    @ApiOperation(value="库存-添加", notes="库存-添加")
    @RequiresPermissions("tiangong:biz_inventory:add")
    @PostMapping(value = "/add")
    public Result<String> add(@RequestBody Inventory inventory) {
        inventoryService.save(inventory);
        return Result.OK("添加成功！");
    }

    /**
     *  编辑
     * @param inventory
     * @return
     */
    @AutoLog(value = "库存-编辑")
    @ApiOperation(value="库存-编辑", notes="库存-编辑")
    @RequiresPermissions("tiangong:biz_inventory:edit")
    @RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
    public Result<String> edit(@RequestBody Inventory inventory) {
        inventoryService.updateById(inventory);
        return Result.OK("编辑成功!");
    }

    /**
     * 通过id删除
     * @param id
     * @return
     */
    @AutoLog(value = "库存-通过id删除")
    @ApiOperation(value="库存-通过id删除", notes="库存-通过id删除")
    @RequiresPermissions("tiangong:biz_inventory:delete")
    @DeleteMapping(value = "/delete")
    public Result<String> delete(@RequestParam(name="id",required=true) String id) {
        inventoryService.delMain(id);
        return Result.OK("删除成功!");
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @AutoLog(value = "库存-批量删除")
    @ApiOperation(value="库存-批量删除", notes="库存-批量删除")
    @RequiresPermissions("tiangong:biz_inventory:deleteBatch")
    @DeleteMapping(value = "/deleteBatch")
    public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
        this.inventoryService.delBatchMain(Arrays.asList(ids.split(",")));
        return Result.OK("批量删除成功!");
    }

    /**
     * 导出
     * @return
     */
    @RequiresPermissions("tiangong:biz_inventory:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Inventory inventory) {
        return super.exportXls(request, inventory, Inventory.class, "库存");
    }

    /**
     * 导入
     * @return
     */
    @RequiresPermissions("tiangong:biz_inventory:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Inventory.class);
    }
	/*---------------------------------主表处理-end-------------------------------------*/
	

    /*--------------------------------子表处理-库存时段表-begin----------------------------------------------*/
	/**
	 * 通过主表ID查询
	 * @return
	 */
	//@AutoLog(value = "库存时段表-通过主表ID查询")
	@ApiOperation(value="库存时段表-通过主表ID查询", notes="库存时段表-通过主表ID查询")
	@GetMapping(value = "/listBizInventoryItemByMainId")
    public Result<IPage<BizInventoryItem>> listBizInventoryItemByMainId(BizInventoryItem bizInventoryItem,
                                                    @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                    @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                    HttpServletRequest req) {
        QueryWrapper<BizInventoryItem> queryWrapper = QueryGenerator.initQueryWrapper(bizInventoryItem, req.getParameterMap());
        Page<BizInventoryItem> page = new Page<BizInventoryItem>(pageNo, pageSize);
        IPage<BizInventoryItem> pageList = bizInventoryItemService.page(page, queryWrapper);
        return Result.OK(pageList);
    }

	/**
	 * 添加
	 * @param bizInventoryItem
	 * @return
	 */
	@AutoLog(value = "库存时段表-添加")
	@ApiOperation(value="库存时段表-添加", notes="库存时段表-添加")
	@PostMapping(value = "/addBizInventoryItem")
	public Result<String> addBizInventoryItem(@RequestBody BizInventoryItem bizInventoryItem) {
		bizInventoryItemService.save(bizInventoryItem);
		return Result.OK("添加成功！");
	}

    /**
	 * 编辑
	 * @param bizInventoryItem
	 * @return
	 */
	@AutoLog(value = "库存时段表-编辑")
	@ApiOperation(value="库存时段表-编辑", notes="库存时段表-编辑")
	@RequestMapping(value = "/editBizInventoryItem", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> editBizInventoryItem(@RequestBody BizInventoryItem bizInventoryItem) {
		bizInventoryItemService.updateById(bizInventoryItem);
		return Result.OK("编辑成功!");
	}

	/**
	 * 通过id删除
	 * @param id
	 * @return
	 */
	@AutoLog(value = "库存时段表-通过id删除")
	@ApiOperation(value="库存时段表-通过id删除", notes="库存时段表-通过id删除")
	@DeleteMapping(value = "/deleteBizInventoryItem")
	public Result<String> deleteBizInventoryItem(@RequestParam(name="id",required=true) String id) {
		bizInventoryItemService.removeById(id);
		return Result.OK("删除成功!");
	}

	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "库存时段表-批量删除")
	@ApiOperation(value="库存时段表-批量删除", notes="库存时段表-批量删除")
	@DeleteMapping(value = "/deleteBatchBizInventoryItem")
	public Result<String> deleteBatchBizInventoryItem(@RequestParam(name="ids",required=true) String ids) {
	    this.bizInventoryItemService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}

    /**
     * 导出
     * @return
     */
    @RequestMapping(value = "/exportBizInventoryItem")
    public ModelAndView exportBizInventoryItem(HttpServletRequest request, BizInventoryItem bizInventoryItem) {
		 // Step.1 组装查询条件
		 QueryWrapper<BizInventoryItem> queryWrapper = QueryGenerator.initQueryWrapper(bizInventoryItem, request.getParameterMap());
		 LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();

		 // Step.2 获取导出数据
		 List<BizInventoryItem> pageList = bizInventoryItemService.list(queryWrapper);
		 List<BizInventoryItem> exportList = null;

		 // 过滤选中数据
		 String selections = request.getParameter("selections");
		 if (oConvertUtils.isNotEmpty(selections)) {
			 List<String> selectionList = Arrays.asList(selections.split(","));
			 exportList = pageList.stream().filter(item -> selectionList.contains(item.getId())).collect(Collectors.toList());
		 } else {
			 exportList = pageList;
		 }

		 // Step.3 AutoPoi 导出Excel
		 ModelAndView mv = new ModelAndView(new JeecgEntityExcelView());
		 //此处设置的filename无效,前端会重更新设置一下
		 mv.addObject(NormalExcelConstants.FILE_NAME, "库存时段表");
		 mv.addObject(NormalExcelConstants.CLASS, BizInventoryItem.class);
		 mv.addObject(NormalExcelConstants.PARAMS, new ExportParams("库存时段表报表", "导出人:" + sysUser.getRealname(), "库存时段表"));
		 mv.addObject(NormalExcelConstants.DATA_LIST, exportList);
		 return mv;
    }

    /**
     * 导入
     * @return
     */
    @RequestMapping(value = "/importBizInventoryItem/{mainId}")
    public Result<?> importBizInventoryItem(HttpServletRequest request, HttpServletResponse response, @PathVariable("mainId") String mainId) {
		 MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		 Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		 for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
       // 获取上传文件对象
			 MultipartFile file = entity.getValue();
			 ImportParams params = new ImportParams();
			 params.setTitleRows(2);
			 params.setHeadRows(1);
			 params.setNeedSave(true);
			 try {
				 List<BizInventoryItem> list = ExcelImportUtil.importExcel(file.getInputStream(), BizInventoryItem.class, params);
				 for (BizInventoryItem temp : list) {
                    temp.setInventoryId(mainId);
				 }
				 long start = System.currentTimeMillis();
				 bizInventoryItemService.saveBatch(list);
				 log.info("消耗时间" + (System.currentTimeMillis() - start) + "毫秒");
				 return Result.OK("文件导入成功！数据行数：" + list.size());
			 } catch (Exception e) {
				 log.error(e.getMessage(), e);
				 return Result.error("文件导入失败:" + e.getMessage());
			 } finally {
				 try {
					 file.getInputStream().close();
				 } catch (IOException e) {
					 e.printStackTrace();
				 }
			 }
		 }
		 return Result.error("文件导入失败！");
    }

    /*--------------------------------子表处理-库存时段表-end----------------------------------------------*/




}
