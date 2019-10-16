package com.smt.market.domain;


import com.smt.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 交易单详情表 smt_order_detail
 * 
 * @author smt
 * @date 2019-09-27
 */
public class SmtOrderDetail extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 交易单明细ID */
	private Integer orderDetailId;
	/** 采购系统中返回的商品编码 */
	private String oodCode;
	/** 成交数量 */
	private BigDecimal camount;
	/** 法定数量 */
	private BigDecimal quantity;
	/** 第二数量 */
	private BigDecimal weight;
	/** 单价 */
	private BigDecimal price;
	/** 总计 */
	private BigDecimal totalPrice;
	/** 币种 */
	private String tradeCurr;
	/** 采购系统返回的ID */
	private String tradeDetailId;
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

	public void setOrderDetailId(Integer orderDetailId) 
	{
		this.orderDetailId = orderDetailId;
	}

	public Integer getOrderDetailId() 
	{
		return orderDetailId;
	}
	public void setOodCode(String oodCode) 
	{
		this.oodCode = oodCode;
	}

	public String getOodCode() 
	{
		return oodCode;
	}
	public void setCamount(BigDecimal camount) 
	{
		this.camount = camount;
	}

	public BigDecimal getCamount() 
	{
		return camount;
	}
	public void setQuantity(BigDecimal quantity) 
	{
		this.quantity = quantity;
	}

	public BigDecimal getQuantity() 
	{
		return quantity;
	}
	public void setWeight(BigDecimal weight) 
	{
		this.weight = weight;
	}

	public BigDecimal getWeight() 
	{
		return weight;
	}
	public void setPrice(BigDecimal price) 
	{
		this.price = price;
	}

	public BigDecimal getPrice() 
	{
		return price;
	}
	public void setTotalPrice(BigDecimal totalPrice) 
	{
		this.totalPrice = totalPrice;
	}

	public BigDecimal getTotalPrice() 
	{
		return totalPrice;
	}
	public void setTradeCurr(String tradeCurr) 
	{
		this.tradeCurr = tradeCurr;
	}

	public String getTradeCurr() 
	{
		return tradeCurr;
	}
	public void setTradeDetailId(String tradeDetailId) 
	{
		this.tradeDetailId = tradeDetailId;
	}

	public String getTradeDetailId() 
	{
		return tradeDetailId;
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

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderDetailId", getOrderDetailId())
            .append("oodCode", getOodCode())
            .append("camount", getCamount())
            .append("quantity", getQuantity())
            .append("weight", getWeight())
            .append("price", getPrice())
            .append("totalPrice", getTotalPrice())
            .append("tradeCurr", getTradeCurr())
            .append("tradeDetailId", getTradeDetailId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
