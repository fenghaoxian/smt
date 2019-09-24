package com.smt.web.controller.market;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.smt.common.annotation.Log;
import com.smt.common.enums.BusinessType;
import com.smt.market.domain.SmtGoods;
import com.smt.market.service.ISmtGoodsService;
import com.smt.framework.web.base.BaseController;
import com.smt.common.page.TableDataInfo;
import com.smt.common.base.AjaxResult;
import com.smt.common.utils.poi.ExcelUtil;

/**
 * 商品 信息操作处理
 * 
 * @author smt
 * @date 2019-09-23
 */
@Controller
@RequestMapping("/market/goods")
public class SmtGoodsController extends BaseController
{
    private String prefix = "market/goods";
	
	@Autowired
	private ISmtGoodsService smtGoodsService;
	
	@RequiresPermissions("market:goods:view")
	@GetMapping()
	public String smtGoods()
	{
	    return prefix + "/goods";
	}
	
	/**
	 * 查询商品列表
	 */
	@RequiresPermissions("market:goods:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SmtGoods smtGoods)
	{
		startPage();
        List<SmtGoods> list = smtGoodsService.selectSmtGoodsList(smtGoods);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出商品列表
	 */
	@RequiresPermissions("market:goods:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SmtGoods smtGoods)
    {
    	List<SmtGoods> list = smtGoodsService.selectSmtGoodsList(smtGoods);
        ExcelUtil<SmtGoods> util = new ExcelUtil<SmtGoods>(SmtGoods.class);
        return util.exportExcel(list, "goods");
    }
	
	/**
	 * 新增商品
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存商品
	 */
	@RequiresPermissions("market:goods:add")
	@Log(title = "商品", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SmtGoods smtGoods)
	{		
		return toAjax(smtGoodsService.insertSmtGoods(smtGoods));
	}

	/**
	 * 修改商品
	 */
	@GetMapping("/edit/{goodsId}")
	public String edit(@PathVariable("goodsId") Integer goodsId, ModelMap mmap)
	{
		SmtGoods smtGoods = smtGoodsService.selectSmtGoodsById(goodsId);
		mmap.put("goods", smtGoods);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存商品
	 */
	@RequiresPermissions("market:goods:edit")
	@Log(title = "商品", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SmtGoods smtGoods)
	{		
		return toAjax(smtGoodsService.updateSmtGoods(smtGoods));
	}
	
	/**
	 * 删除商品
	 */
	@RequiresPermissions("market:goods:remove")
	@Log(title = "商品", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(smtGoodsService.deleteSmtGoodsByIds(ids));
	}
	
}
