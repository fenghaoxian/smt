package com.smt.web.controller.market;

import com.smt.common.annotation.Log;
import com.smt.common.base.AjaxResult;
import com.smt.common.enums.BusinessType;
import com.smt.common.page.TableDataInfo;
import com.smt.common.utils.poi.ExcelUtil;
import com.smt.framework.web.base.BaseController;
import com.smt.market.domain.SmtCompany;
import com.smt.market.service.ISmtCompanyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Date: 2019/8/30
 * Author: fenghx
 * Desc: 商户信息
 */
@Controller
@RequestMapping("/market/company")
public class SmtCompanyController extends BaseController
{
    private String prefix = "market/company";

    @Autowired
    private ISmtCompanyService companyService;

    @RequiresPermissions("market:company:view")
    @GetMapping()
    public String company()
    {
        return prefix + "/company";
    }

    /**
     * 查询企业列表
     */
    @RequiresPermissions("market:company:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SmtCompany company)
    {
        startPage();
        List<SmtCompany> list = companyService.selectSmtCompanyList(company);
        return getDataTable(list);
    }

    /**
     * 导出企业列表
     */
    @RequiresPermissions("market:company:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SmtCompany company)
    {
        List<SmtCompany> list = companyService.selectSmtCompanyList(company);
        ExcelUtil<SmtCompany> util = new ExcelUtil<SmtCompany>(SmtCompany.class);
        return util.exportExcel(list, "企业");
    }

    /**
     * 新增保存企业
     */
    @RequiresPermissions("market:company:add")
    @Log(title = "企业", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SmtCompany company)
    {
        return toAjax(companyService.insertSmtCompany(company));
    }

    /**
     * 修改保存企业
     */
    @RequiresPermissions("market:company:edit")
    @Log(title = "企业", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SmtCompany company)
    {
        return toAjax(companyService.updateSmtCompany(company));
    }

    /**
     * 删除企业
     */
    @RequiresPermissions("market:company:remove")
    @Log(title = "企业", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(companyService.deleteSmtCompanyByIds(ids));
    }
}
