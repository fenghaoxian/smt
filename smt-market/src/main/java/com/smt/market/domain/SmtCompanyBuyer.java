package com.smt.market.domain;


import com.smt.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商户与采购商关联表 smt_company_buyer
 * 
 * @author smt
 * @date 2019-10-14
 */
public class SmtCompanyBuyer extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 商户ID */
	private Integer companyId;
	/** 采购商ID */
	private Integer buyerId;

	public void setCompanyId(Integer companyId) 
	{
		this.companyId = companyId;
	}

	public Integer getCompanyId() 
	{
		return companyId;
	}
	public void setBuyerId(Integer buyerId) 
	{
		this.buyerId = buyerId;
	}

	public Integer getBuyerId() 
	{
		return buyerId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("companyId", getCompanyId())
            .append("buyerId", getBuyerId())
            .toString();
    }
}
