package com.smt.web.controller.market;

import com.smt.common.annotation.Log;
import com.smt.common.base.AjaxResult;
import com.smt.common.enums.BusinessType;
import com.smt.common.page.TableDataInfo;
import com.smt.common.utils.poi.ExcelUtil;
import com.smt.framework.web.base.BaseController;
import com.smt.market.domain.SmtBuyer;
import com.smt.market.service.ISmtBuyerService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 采购商 信息操作处理
 * 
 * @author smt
 * @date 2019-10-14
 */
@Controller
@RequestMapping("/market/buyer")
public class SmtBuyerController extends BaseController
{
    private String prefix = "market/buyer";
	
	@Autowired
	private ISmtBuyerService smtBuyerService;
	
	@RequiresPermissions("market:buyer:view")
	@GetMapping()
	public String smtBuyer()
	{
	    return prefix + "/buyer";
	}
	
	/**
	 * 查询采购商列表
	 */
	@RequiresPermissions("market:buyer:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SmtBuyer smtBuyer)
	{
		startPage();
        List<SmtBuyer> list = smtBuyerService.selectSmtBuyerList(smtBuyer);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出采购商列表
	 */
	@RequiresPermissions("market:buyer:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SmtBuyer smtBuyer)
    {
    	List<SmtBuyer> list = smtBuyerService.selectSmtBuyerList(smtBuyer);
        ExcelUtil<SmtBuyer> util = new ExcelUtil<SmtBuyer>(SmtBuyer.class);
        return util.exportExcel(list, "buyer");
    }
	
	/**
	 * 新增采购商
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存采购商
	 */
	@RequiresPermissions("market:buyer:add")
	@Log(title = "采购商", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SmtBuyer smtBuyer)
	{		
		return toAjax(smtBuyerService.insertSmtBuyer(smtBuyer));
	}

	/**
	 * 修改采购商
	 */
	@GetMapping("/edit/{buyerId}")
	public String edit(@PathVariable("buyerId") Integer buyerId, ModelMap mmap)
	{
		SmtBuyer smtBuyer = smtBuyerService.selectSmtBuyerById(buyerId);
		mmap.put("buyer", smtBuyer);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存采购商
	 */
	@RequiresPermissions("market:buyer:edit")
	@Log(title = "采购商", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SmtBuyer smtBuyer)
	{		
		return toAjax(smtBuyerService.updateSmtBuyer(smtBuyer));
	}
	
	/**
	 * 删除采购商
	 */
	@RequiresPermissions("market:buyer:remove")
	@Log(title = "采购商", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(smtBuyerService.deleteSmtBuyerByIds(ids));
	}
	
}
