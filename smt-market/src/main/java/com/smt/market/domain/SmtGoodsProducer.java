package com.smt.market.domain;


import com.smt.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商品与生产商关联表 smt_goods_producer
 * 
 * @author smt
 * @date 2019-09-23
 */
public class SmtGoodsProducer extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 商品ID */
	private Integer goodsId;
	/** 生产商ID */
	private Integer producerId;

	public void setGoodsId(Integer goodsId) 
	{
		this.goodsId = goodsId;
	}

	public Integer getGoodsId() 
	{
		return goodsId;
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
            .append("goodsId", getGoodsId())
            .append("producerId", getProducerId())
            .toString();
    }
}
