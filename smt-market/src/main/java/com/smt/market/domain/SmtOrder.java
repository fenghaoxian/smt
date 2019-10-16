package com.smt.market.domain;


import com.smt.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 交易单表 smt_order
 * 
 * @author smt
 * @date 2019-09-27
 */
public class SmtOrder extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 交易单ID */
	private Integer orderId;
	/** 是否代理收汇 */
	private String isAgencyReceipt;
	/** 境内人民币结算金额 */
	private BigDecimal rmbMoney;
	/** 采购系统返回交易单号 */
	private String tradingNo;
	/** 状态 */
	private String status;
	/** 删除标志 */
	private String delFlag;
	/** 创建人名称 */
	private String createBy;
	/** 创建时间 */
	private Date createTime;
	/** 更新人名称 */
	private String updateBy;
	/** 更新时间 */
	private Date updateTime;
	/** 备注 */
	private String remark;

	private List<SmtOrderDetail> orderDetails;

	public void setOrderId(Integer orderId) 
	{
		this.orderId = orderId;
	}

	public Integer getOrderId() 
	{
		return orderId;
	}
	public void setIsAgencyReceipt(String isAgencyReceipt) 
	{
		this.isAgencyReceipt = isAgencyReceipt;
	}

	public String getIsAgencyReceipt() 
	{
		return isAgencyReceipt;
	}
	public void setRmbMoney(BigDecimal rmbMoney) 
	{
		this.rmbMoney = rmbMoney;
	}

	public BigDecimal getRmbMoney() 
	{
		return rmbMoney;
	}
	public void setTradingNo(String tradingNo) 
	{
		this.tradingNo = tradingNo;
	}

	public String getTradingNo() 
	{
		return tradingNo;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	public void setDelFlag(String delFlag) 
	{
		this.delFlag = delFlag;
	}

	public String getDelFlag() 
	{
		return delFlag;
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
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}

	public List<SmtOrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<SmtOrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderId", getOrderId())
            .append("isAgencyReceipt", getIsAgencyReceipt())
            .append("rmbMoney", getRmbMoney())
            .append("tradingNo", getTradingNo())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
