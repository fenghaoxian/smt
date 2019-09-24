package com.smt.market.domain;


import com.smt.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 生产商表 smt_producer
 * 
 * @author smt
 * @date 2019-09-23
 */
public class SmtProducer extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 生产商ID */
	private Integer producerId;
	/** 组织机构代码 */
	private String corpCode;
	/** 中文名称 */
	private String corpCname;
	/** 英文名称 */
	private String corpEname;
	/** 企业类型 */
	private String companyType;
	/** 联系人 */
	private String contractMan;
	/** 证件号 */
	private String identCode;
	/** 联系电话 */
	private String telno;
	/** 企业地址 */
	private String caddress;
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
	/** 删除标志 */
	private String delFlag;

	public void setProducerId(Integer producerId) 
	{
		this.producerId = producerId;
	}

	public Integer getProducerId() 
	{
		return producerId;
	}
	public void setCorpCode(String corpCode) 
	{
		this.corpCode = corpCode;
	}

	public String getCorpCode() 
	{
		return corpCode;
	}
	public void setCorpCname(String corpCname) 
	{
		this.corpCname = corpCname;
	}

	public String getCorpCname() 
	{
		return corpCname;
	}
	public void setCorpEname(String corpEname) 
	{
		this.corpEname = corpEname;
	}

	public String getCorpEname() 
	{
		return corpEname;
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
	public void setIdentCode(String identCode) 
	{
		this.identCode = identCode;
	}

	public String getIdentCode() 
	{
		return identCode;
	}
	public void setTelno(String telno) 
	{
		this.telno = telno;
	}

	public String getTelno() 
	{
		return telno;
	}
	public void setCaddress(String caddress) 
	{
		this.caddress = caddress;
	}

	public String getCaddress() 
	{
		return caddress;
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
	public void setDelFlag(String delFlag) 
	{
		this.delFlag = delFlag;
	}

	public String getDelFlag() 
	{
		return delFlag;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("producerId", getProducerId())
            .append("corpCode", getCorpCode())
            .append("corpCname", getCorpCname())
            .append("corpEname", getCorpEname())
            .append("companyType", getCompanyType())
            .append("contractMan", getContractMan())
            .append("identCode", getIdentCode())
            .append("telno", getTelno())
            .append("caddress", getCaddress())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
