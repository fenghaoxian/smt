package com.smt.web.controller.market;

import com.smt.common.annotation.Log;
import com.smt.common.base.AjaxResult;
import com.smt.common.enums.BusinessType;
import com.smt.common.page.TableDataInfo;
import com.smt.common.utils.poi.ExcelUtil;
import com.smt.framework.web.base.BaseController;
import com.smt.market.domain.SmtCustom;
import com.smt.market.service.ISmtCustomService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 一次性录入 信息操作处理
 * 
 * @author smt
 * @date 2019-11-18
 */
@Controller
@RequestMapping("/market/smtCustom")
public class SmtCustomController extends BaseController
{
    private String prefix = "market/smtCustom";
	
	@Autowired
	private ISmtCustomService smtCustomService;
	
	@RequiresPermissions("market:smtCustom:view")
	@GetMapping()
	public String smtCustom()
	{
	    return prefix + "/smtCustom";
	}
	
	/**
	 * 查询一次性录入列表
	 */
	@RequiresPermissions("market:smtCustom:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SmtCustom smtCustom)
	{
		startPage();
        List<SmtCustom> list = smtCustomService.selectSmtCustomList(smtCustom);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出一次性录入列表
	 */
	@RequiresPermissions("market:smtCustom:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SmtCustom smtCustom)
    {
    	List<SmtCustom> list = smtCustomService.selectSmtCustomList(smtCustom);
        ExcelUtil<SmtCustom> util = new ExcelUtil<SmtCustom>(SmtCustom.class);
        return util.exportExcel(list, "smtCustom");
    }
	
	/**
	 * 新增一次性录入
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存一次性录入
	 */
	@RequiresPermissions("market:smtCustom:add")
	@Log(title = "一次性录入", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SmtCustom smtCustom)
	{		
		return toAjax(smtCustomService.insertSmtCustom(smtCustom));
	}

	/**
	 * 修改一次性录入
	 */
	@GetMapping("/edit/{customId}")
	public String edit(@PathVariable("customId") Integer customId, ModelMap mmap)
	{
		SmtCustom smtCustom = smtCustomService.selectSmtCustomById(customId);
		mmap.put("smtCustom", smtCustom);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存一次性录入
	 */
	@RequiresPermissions("market:smtCustom:edit")
	@Log(title = "一次性录入", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SmtCustom smtCustom)
	{		
		return toAjax(smtCustomService.updateSmtCustom(smtCustom));
	}
	
	/**
	 * 删除一次性录入
	 */
	@RequiresPermissions("market:smtCustom:remove")
	@Log(title = "一次性录入", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(smtCustomService.deleteSmtCustomByIds(ids));
	}
	
}
