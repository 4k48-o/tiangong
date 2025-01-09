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
import org.jeecg.modules.tiangong.entity.ScenicArea;
import org.jeecg.modules.tiangong.service.IScenicAreaService;

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
 * @Description: 景区表
 * @Author: jeecg-boot
 * @Date:   2025-01-06
 * @Version: V1.0
 */
@Api(tags="景区表")
@RestController
@RequestMapping("/tiangong/scenicArea")
@Slf4j
public class ScenicAreaController extends JeecgController<ScenicArea, IScenicAreaService> {
	@Autowired
	private IScenicAreaService scenicAreaService;
	
	/**
	 * 分页列表查询
	 *
	 * @param scenicArea
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "景区表-分页列表查询")
	@ApiOperation(value="景区表-分页列表查询", notes="景区表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<ScenicArea>> queryPageList(ScenicArea scenicArea,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        QueryWrapper<ScenicArea> queryWrapper = QueryGenerator.initQueryWrapper(scenicArea, req.getParameterMap());
		Page<ScenicArea> page = new Page<ScenicArea>(pageNo, pageSize);
		IPage<ScenicArea> pageList = scenicAreaService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param scenicArea
	 * @return
	 */
	@AutoLog(value = "景区表-添加")
	@ApiOperation(value="景区表-添加", notes="景区表-添加")
	@RequiresPermissions("tiangong:biz_scenic_area:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody ScenicArea scenicArea) {
		scenicAreaService.save(scenicArea);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param scenicArea
	 * @return
	 */
	@AutoLog(value = "景区表-编辑")
	@ApiOperation(value="景区表-编辑", notes="景区表-编辑")
	@RequiresPermissions("tiangong:biz_scenic_area:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody ScenicArea scenicArea) {
		scenicAreaService.updateById(scenicArea);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "景区表-通过id删除")
	@ApiOperation(value="景区表-通过id删除", notes="景区表-通过id删除")
	@RequiresPermissions("tiangong:biz_scenic_area:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		scenicAreaService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "景区表-批量删除")
	@ApiOperation(value="景区表-批量删除", notes="景区表-批量删除")
	@RequiresPermissions("tiangong:biz_scenic_area:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.scenicAreaService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "景区表-通过id查询")
	@ApiOperation(value="景区表-通过id查询", notes="景区表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<ScenicArea> queryById(@RequestParam(name="id",required=true) String id) {
		ScenicArea scenicArea = scenicAreaService.getById(id);
		if(scenicArea==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(scenicArea);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param scenicArea
    */
    @RequiresPermissions("tiangong:biz_scenic_area:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, ScenicArea scenicArea) {
        return super.exportXls(request, scenicArea, ScenicArea.class, "景区表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("tiangong:biz_scenic_area:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, ScenicArea.class);
    }

}
