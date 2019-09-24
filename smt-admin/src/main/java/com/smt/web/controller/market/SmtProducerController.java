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
import com.smt.market.domain.SmtProducer;
import com.smt.market.service.ISmtProducerService;
import com.smt.framework.web.base.BaseController;
import com.smt.common.page.TableDataInfo;
import com.smt.common.base.AjaxResult;
import com.smt.common.utils.poi.ExcelUtil;

/**
 * 生产商 信息操作处理
 * 
 * @author smt
 * @date 2019-09-23
 */
@Controller
@RequestMapping("/market/producer")
public class SmtProducerController extends BaseController
{
    private String prefix = "market/producer";
	
	@Autowired
	private ISmtProducerService smtProducerService;
	
	@RequiresPermissions("market:producer:view")
	@GetMapping()
	public String smtProducer()
	{
	    return prefix + "/producer";
	}
	
	/**
	 * 查询生产商列表
	 */
	@RequiresPermissions("market:producer:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SmtProducer smtProducer)
	{
		startPage();
        List<SmtProducer> list = smtProducerService.selectSmtProducerList(smtProducer);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出生产商列表
	 */
	@RequiresPermissions("market:producer:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SmtProducer smtProducer)
    {
    	List<SmtProducer> list = smtProducerService.selectSmtProducerList(smtProducer);
        ExcelUtil<SmtProducer> util = new ExcelUtil<SmtProducer>(SmtProducer.class);
        return util.exportExcel(list, "producer");
    }
	
	/**
	 * 新增生产商
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存生产商
	 */
	@RequiresPermissions("market:producer:add")
	@Log(title = "生产商", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SmtProducer smtProducer)
	{		
		return toAjax(smtProducerService.insertSmtProducer(smtProducer));
	}

	/**
	 * 修改生产商
	 */
	@GetMapping("/edit/{producerId}")
	public String edit(@PathVariable("producerId") Integer producerId, ModelMap mmap)
	{
		SmtProducer smtProducer = smtProducerService.selectSmtProducerById(producerId);
		mmap.put("producer", smtProducer);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存生产商
	 */
	@RequiresPermissions("market:producer:edit")
	@Log(title = "生产商", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SmtProducer smtProducer)
	{		
		return toAjax(smtProducerService.updateSmtProducer(smtProducer));
	}
	
	/**
	 * 删除生产商
	 */
	@RequiresPermissions("market:producer:remove")
	@Log(title = "生产商", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(smtProducerService.deleteSmtProducerByIds(ids));
	}
	
}
