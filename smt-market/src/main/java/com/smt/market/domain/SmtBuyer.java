package com.smt.market.domain;


import com.smt.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 采购商表 smt_buyer
 * 
 * @author smt
 * @date 2019-10-14
 */
public class SmtBuyer extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 采购商ID */
	private Integer buyerId;
	/** 证件号 */
	private String corpCode;
	/** 企业名称 */
	private String corpCName;
	/** 企业类型 */
	private String companyType;
	/** 联系人 */
	private String contractMan;
	/** 国籍 */
	private String finvest1;
	/** 联系电话 */
	private String telno;
	/** 企业地址 */
	private String address;
	/** 删除标志 */
	private String delFlag;
	/** 创建时间 */
	private Date createTime;
	/** 创建人 */
	private String createBy;
	/** 更新时间 */
	private Date updateTime;
	/** 更新人 */
	private String updateBy;
	/** 备注 */
	private String remark;

	public void setBuyerId(Integer buyerId) 
	{
		this.buyerId = buyerId;
	}

	public Integer getBuyerId() 
	{
		return buyerId;
	}
	public void setCorpCode(String corpCode) 
	{
		this.corpCode = corpCode;
	}

	public String getCorpCode() 
	{
		return corpCode;
	}
	public void setCorpCName(String corpCName) 
	{
		this.corpCName = corpCName;
	}

	public String getCorpCName() 
	{
		return corpCName;
	}
	public void setCompanyType(String companyType) 
	{
		this.companyType = companyType;
	}

	public String getCompanyType() 
	{
		return companyType;
	}
	public void setContractMan(String contractMan) 
	{
		this.contractMan = contractMan;
	}

	public String getContractMan() 
	{
		return contractMan;
	}
	public void setFinvest1(String finvest1) 
	{
		this.finvest1 = finvest1;
	}

	public String getFinvest1() 
	{
		return finvest1;
	}
	public void setTelno(String telno) 
	{
		this.telno = telno;
	}

	public String getTelno() 
	{
		return telno;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getAddress() 
	{
		return address;
	}
	public void setDelFlag(String delFlag) 
	{
		this.delFlag = delFlag;
	}

	public String getDelFlag() 
	{
		return delFlag;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setCreateBy(String createBy) 
	{
		this.createBy = createBy;
	}

	public String getCreateBy() 
	{
		return createBy;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime()
	{
		return updateTime;
	}
	public void setUpdateBy(String updateBy) 
	{
		this.updateBy = updateBy;
	}

	public String getUpdateBy() 
	{
		return updateBy;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("buyerId", getBuyerId())
            .append("corpCode", getCorpCode())
            .append("corpCName", getCorpCName())
            .append("companyType", getCompanyType())
            .append("contractMan", getContractMan())
            .append("finvest1", getFinvest1())
            .append("telno", getTelno())
            .append("address", getAddress())
            .append("delFlag", getDelFlag())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .toString();
    }
}
