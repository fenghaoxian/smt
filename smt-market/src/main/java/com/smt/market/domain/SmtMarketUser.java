package com.smt.market.domain;


import com.smt.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 委托关系表 smt_market_user
 * 
 * @author smt
 * @date 2019-10-16
 */
public class SmtMarketUser extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer marketId;
	/**  统一社会信用代码 */
	private String sgsRegCode;
	/** 企业名称 */
	private String corpName;
	/** 登录名 */
	private String loginName;
	/** 登录密码 */
	private String loginPassword;
	/** 备注 */
	private String remark;
	/** 创建人 */
	private String createBy;
	/** 创建时间 */
	private Date createTime;
	/** 更新人 */
	private String updateBy;
	/** 更新时间 */
	private Date updateTime;

	public void setMarketId(Integer marketId) 
	{
		this.marketId = marketId;
	}

	public Integer getMarketId() 
	{
		return marketId;
	}
	public void setSgsRegCode(String sgsRegCode) 
	{
		this.sgsRegCode = sgsRegCode;
	}

	public String getSgsRegCode() 
	{
		return sgsRegCode;
	}
	public void setCorpName(String corpName) 
	{
		this.corpName = corpName;
	}

	public String getCorpName() 
	{
		return corpName;
	}
	public void setLoginName(String loginName) 
	{
		this.loginName = loginName;
	}

	public String getLoginName() 
	{
		return loginName;
	}
	public void setLoginPassword(String loginPassword) 
	{
		this.loginPassword = loginPassword;
	}

	public String getLoginPassword() 
	{
		return loginPassword;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}
	public void setCreateBy(String createBy) 
	{
		this.createBy = createBy;
	}

	public String getCreateBy() 
	{
		return createBy;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setUpdateBy(String updateBy) 
	{
		this.updateBy = updateBy;
	}

	public String getUpdateBy() 
	{
		return updateBy;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() 
	{
		return updateTime;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("marketId", getMarketId())
            .append("sgsRegCode", getSgsRegCode())
            .append("corpName", getCorpName())
            .append("loginName", getLoginName())
            .append("loginPassword", getLoginPassword())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
