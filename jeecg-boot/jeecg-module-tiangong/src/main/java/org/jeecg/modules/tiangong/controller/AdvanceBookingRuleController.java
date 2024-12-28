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
import org.jeecg.modules.tiangong.entity.AdvanceBookingRule;
import org.jeecg.modules.tiangong.service.IAdvanceBookingRuleService;

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
 * @Description: advance_booking_rule
 * @Author: jeecg-boot
 * @Date:   2024-12-25
 * @Version: V1.0
 */
@Api(tags="advance_booking_rule")
@RestController
@RequestMapping("/tiangong/advanceBookingRule")
@Slf4j
public class AdvanceBookingRuleController extends JeecgController<AdvanceBookingRule, IAdvanceBookingRuleService> {
	@Autowired
	private IAdvanceBookingRuleService advanceBookingRuleService;
	
	/**
	 * 分页列表查询
	 *
	 * @param advanceBookingRule
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "advance_booking_rule-分页列表查询")
	@ApiOperation(value="advance_booking_rule-分页列表查询", notes="advance_booking_rule-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<AdvanceBookingRule>> queryPageList(AdvanceBookingRule advanceBookingRule,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        QueryWrapper<AdvanceBookingRule> queryWrapper = QueryGenerator.initQueryWrapper(advanceBookingRule, req.getParameterMap());
		Page<AdvanceBookingRule> page = new Page<AdvanceBookingRule>(pageNo, pageSize);
		IPage<AdvanceBookingRule> pageList = advanceBookingRuleService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param advanceBookingRule
	 * @return
	 */
	@AutoLog(value = "advance_booking_rule-添加")
	@ApiOperation(value="advance_booking_rule-添加", notes="advance_booking_rule-添加")
	@RequiresPermissions("tiangong:biz_advance_booking_rule:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody AdvanceBookingRule advanceBookingRule) {
		advanceBookingRuleService.save(advanceBookingRule);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param advanceBookingRule
	 * @return
	 */
	@AutoLog(value = "advance_booking_rule-编辑")
	@ApiOperation(value="advance_booking_rule-编辑", notes="advance_booking_rule-编辑")
	@RequiresPermissions("tiangong:biz_advance_booking_rule:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody AdvanceBookingRule advanceBookingRule) {
		advanceBookingRuleService.updateById(advanceBookingRule);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "advance_booking_rule-通过id删除")
	@ApiOperation(value="advance_booking_rule-通过id删除", notes="advance_booking_rule-通过id删除")
	@RequiresPermissions("tiangong:biz_advance_booking_rule:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		advanceBookingRuleService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "advance_booking_rule-批量删除")
	@ApiOperation(value="advance_booking_rule-批量删除", notes="advance_booking_rule-批量删除")
	@RequiresPermissions("tiangong:biz_advance_booking_rule:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.advanceBookingRuleService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "advance_booking_rule-通过id查询")
	@ApiOperation(value="advance_booking_rule-通过id查询", notes="advance_booking_rule-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<AdvanceBookingRule> queryById(@RequestParam(name="id",required=true) String id) {
		AdvanceBookingRule advanceBookingRule = advanceBookingRuleService.getById(id);
		if(advanceBookingRule==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(advanceBookingRule);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param advanceBookingRule
    */
    @RequiresPermissions("tiangong:biz_advance_booking_rule:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, AdvanceBookingRule advanceBookingRule) {
        return super.exportXls(request, advanceBookingRule, AdvanceBookingRule.class, "advance_booking_rule");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("tiangong:biz_advance_booking_rule:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, AdvanceBookingRule.class);
    }

}
