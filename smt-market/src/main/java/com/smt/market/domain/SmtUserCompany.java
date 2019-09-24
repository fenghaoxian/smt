package com.smt.market.domain;


import com.smt.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 用户与企业关联表 smt_user_company
 * 
 * @author smt
 * @date 2019-09-03
 */
public class SmtUserCompany extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 用户ID */
	private Integer userId;
	/** 企业ID */
	private Integer companyId;

	public void setUserId(Integer userId) 
	{
		this.userId = userId;
	}

	public Integer getUserId() 
	{
		return userId;
	}
	public void setCompanyId(Integer companyId) 
	{
		this.companyId = companyId;
	}

	public Integer getCompanyId() 
	{
		return companyId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("companyId", getCompanyId())
            .toString();
    }
}
