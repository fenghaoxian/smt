package com.smt.web.controller.market;

import com.smt.common.annotation.Log;
import com.smt.common.base.AjaxResult;
import com.smt.common.enums.BusinessType;
import com.smt.common.page.TableDataInfo;
import com.smt.common.utils.poi.ExcelUtil;
import com.smt.framework.web.base.BaseController;
import com.smt.market.domain.SmtMarketUser;
import com.smt.market.service.ISmtMarketUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 委托关系 信息操作处理
 * 
 * @author smt
 * @date 2019-10-16
 */
@Controller
@RequestMapping("/market/smtMarketUser")
public class SmtMarketUserController extends BaseController
{
    private String prefix = "market/smtMarketUser";
	
	@Autowired
	private ISmtMarketUserService smtMarketUserService;
	
	@RequiresPermissions("market:smtMarketUser:view")
	@GetMapping()
	public String smtMarketUser()
	{
	    return prefix + "/smtMarketUser";
	}
	
	/**
	 * 查询委托关系列表
	 */
	@RequiresPermissions("market:smtMarketUser:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SmtMarketUser smtMarketUser)
	{
		startPage();
        List<SmtMarketUser> list = smtMarketUserService.selectSmtMarketUserList(smtMarketUser);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出委托关系列表
	 */
	@RequiresPermissions("market:smtMarketUser:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SmtMarketUser smtMarketUser)
    {
    	List<SmtMarketUser> list = smtMarketUserService.selectSmtMarketUserList(smtMarketUser);
        ExcelUtil<SmtMarketUser> util = new ExcelUtil<SmtMarketUser>(SmtMarketUser.class);
        return util.exportExcel(list, "smtMarketUser");
    }
	
	/**
	 * 新增委托关系
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存委托关系
	 */
	@RequiresPermissions("market:smtMarketUser:add")
	@Log(title = "委托关系", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SmtMarketUser smtMarketUser)
	{		
		return toAjax(smtMarketUserService.insertSmtMarketUser(smtMarketUser));
	}

	/**
	 * 修改委托关系
	 */
	@GetMapping("/edit/{marketId}")
	public String edit(@PathVariable("marketId") Integer marketId, ModelMap mmap)
	{
		SmtMarketUser smtMarketUser = smtMarketUserService.selectSmtMarketUserById(marketId);
		mmap.put("smtMarketUser", smtMarketUser);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存委托关系
	 */
	@RequiresPermissions("market:smtMarketUser:edit")
	@Log(title = "委托关系", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SmtMarketUser smtMarketUser)
	{		
		return toAjax(smtMarketUserService.updateSmtMarketUser(smtMarketUser));
	}
	
	/**
	 * 删除委托关系
	 */
	@RequiresPermissions("market:smtMarketUser:remove")
	@Log(title = "委托关系", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(smtMarketUserService.deleteSmtMarketUserByIds(ids));
	}
	
}
