package com.smt.web.controller.market;

import com.smt.common.annotation.Log;
import com.smt.common.base.AjaxResult;
import com.smt.common.enums.BusinessType;
import com.smt.common.page.TableDataInfo;
import com.smt.common.utils.poi.ExcelUtil;
import com.smt.framework.web.base.BaseController;
import com.smt.market.domain.SmtOrder;
import com.smt.market.service.ISmtOrderService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 交易单 信息操作处理
 * 
 * @author smt
 * @date 2019-09-27
 */
@Controller
@RequestMapping("/market/smtOrder")
public class SmtOrderController extends BaseController
{
    private String prefix = "market/smtOrder";
	
	@Autowired
	private ISmtOrderService smtOrderService;
	
	@RequiresPermissions("market:smtOrder:view")
	@GetMapping()
	public String smtOrder()
	{
	    return prefix + "/smtOrder";
	}
	
	/**
	 * 查询交易单列表
	 */
	@RequiresPermissions("market:smtOrder:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SmtOrder smtOrder)
	{
		startPage();
        List<SmtOrder> list = smtOrderService.selectSmtOrderList(smtOrder);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出交易单列表
	 */
	@RequiresPermissions("market:smtOrder:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SmtOrder smtOrder)
    {
    	List<SmtOrder> list = smtOrderService.selectSmtOrderList(smtOrder);
        ExcelUtil<SmtOrder> util = new ExcelUtil<SmtOrder>(SmtOrder.class);
        return util.exportExcel(list, "smtOrder");
    }
	
	/**
	 * 新增交易单
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存交易单
	 */
	@RequiresPermissions("market:smtOrder:add")
	@Log(title = "交易单", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SmtOrder smtOrder)
	{		
		return toAjax(smtOrderService.insertSmtOrder(smtOrder));
	}

	/**
	 * 修改交易单
	 */
	@GetMapping("/edit/{orderId}")
	public String edit(@PathVariable("orderId") Integer orderId, ModelMap mmap)
	{
		SmtOrder smtOrder = smtOrderService.selectSmtOrderById(orderId);
		mmap.put("smtOrder", smtOrder);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存交易单
	 */
	@RequiresPermissions("market:smtOrder:edit")
	@Log(title = "交易单", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SmtOrder smtOrder)
	{		
		return toAjax(smtOrderService.updateSmtOrder(smtOrder));
	}
	
	/**
	 * 删除交易单
	 */
	@RequiresPermissions("market:smtOrder:remove")
	@Log(title = "交易单", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(smtOrderService.deleteSmtOrderByIds(ids));
	}
	
}
