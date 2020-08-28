package com.smt.quartz.task;

import com.smt.common.constant.MarketConstants;
import com.smt.market.domain.SmtCompany;
import com.smt.market.service.ISmtCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Date: 2019/11/27
 * Author: fenghx
 * Desc:
 */
@Component("marketTask")
public class MarketTask {

    @Autowired
    private ISmtCompanyService companyService;

    public void queryCompany() {
        List<SmtCompany> smtCompanies = companyService.selectSmtCompanyByStatus(MarketConstants.SMT_COMPANY_STATUS_YTJ);
        if (smtCompanies.size() > 0) {
            for (SmtCompany smtCompany : smtCompanies) {
                companyService.queryCompany("COMP", smtCompany);
            }
        }
    }
}
