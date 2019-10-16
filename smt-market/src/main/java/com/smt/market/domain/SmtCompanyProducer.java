package com.smt.market.domain;


import com.smt.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商户与生产商关联表 smt_company_producer
 * 
 * @author smt
 * @date 2019-10-16
 */
public class SmtCompanyProducer extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 商户ID */
	private Integer companyId;
	/** 生产商ID */
	private Integer producerId;

	public void setCompanyId(Integer companyId) 
	{
		this.companyId = companyId;
	}

	public Integer getCompanyId() 
	{
		return companyId;
	}
	public void setProducerId(Integer producerId) 
	{
		this.producerId = producerId;
	}

	public Integer getProducerId() 
	{
		return producerId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("companyId", getCompanyId())
            .append("producerId", getProducerId())
            .toString();
    }
}
