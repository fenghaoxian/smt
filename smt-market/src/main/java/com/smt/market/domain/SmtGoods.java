package com.smt.market.domain;


import com.smt.common.base.BaseEntity;

import java.util.Date;

/**
 * 商品表 smt_goods
 * 
 * @author smt
 * @date 2019-10-16
 */
public class SmtGoods extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 商品ID */
	private Integer goodsId;
	/** 商品中文名称 */
	private String goodsCname;
	/** 海关编码 */
	private String hsCode;
	/** 附加编码 */
	private String hsCodes;
	/** 企业自有编码 */
	private String corpOwnerCode;
	/** 商品类别 */
	private String goodsType;
	/** 商品英文名称 */
	private String goodsEname;
	/** 规格型号 */
	private String model;
	/** 是否品牌授权 */
	private String isBrand;
	/** 品牌中文名 */
	private String cBrand;
	/** 品牌英文名 */
	private String eBrand;
	/** 生产厂家代码 */
	private String producer;
	/** 成交单位 */
	private String cunit;
	/** 法定单位 */
	private String qunit;
	/** 第二单位 */
	private String wunit;
	/** 商品图片 */
	private String goodsImage;
	/** 商品编码 */
	private String goodsCode;
	/** 唯一ID */
	private String unId;
	/** 商品状态 */
	private String status;
	/** 市场核实状态 */
	private String chkMarket;
	/** 删除标志 */
	private String delFlag;
	/** 创建人 */
	private String createBy;
	/** 创建时间 */
	private Date createTime;
	/** 更新人 */
	private String updateBy;
	/** 更新时间 */
	private Date updateTime;
	/** 备注 */
	private String remark;

	public void setGoodsId(Integer goodsId) 
	{
		this.goodsId = goodsId;
	}

	public Integer getGoodsId() 
	{
		return goodsId;
	}
	public void setGoodsCname(String goodsCname) 
	{
		this.goodsCname = goodsCname;
	}

	public String getGoodsCname() 
	{
		return goodsCname;
	}
	public void setHsCode(String hsCode) 
	{
		this.hsCode = hsCode;
	}

	public String getHsCode() 
	{
		return hsCode;
	}
	public void setHsCodes(String hsCodes) 
	{
		this.hsCodes = hsCodes;
	}

	public String getHsCodes() 
	{
		return hsCodes;
	}
	public void setCorpOwnerCode(String corpOwnerCode) 
	{
		this.corpOwnerCode = corpOwnerCode;
	}

	public String getCorpOwnerCode() 
	{
		return corpOwnerCode;
	}
	public void setGoodsType(String goodsType) 
	{
		this.goodsType = goodsType;
	}

	public String getGoodsType() 
	{
		return goodsType;
	}
	public void setGoodsEname(String goodsEname) 
	{
		this.goodsEname = goodsEname;
	}

	public String getGoodsEname() 
	{
		return goodsEname;
	}
	public void setModel(String model) 
	{
		this.model = model;
	}

	public String getModel() 
	{
		return model;
	}
	public void setIsBrand(String isBrand) 
	{
		this.isBrand = isBrand;
	}

	public String getIsBrand() 
	{
		return isBrand;
	}
	public void setCBrand(String cBrand) 
	{
		this.cBrand = cBrand;
	}

	public String getCBrand() 
	{
		return cBrand;
	}
	public void setEBrand(String eBrand) 
	{
		this.eBrand = eBrand;
	}

	public String getEBrand() 
	{
		return eBrand;
	}
	public void setProducer(String producer) 
	{
		this.producer = producer;
	}

	public String getProducer() 
	{
		return producer;
	}
	public void setCunit(String cunit) 
	{
		this.cunit = cunit;
	}

	public String getCunit() 
	{
		return cunit;
	}
	public void setQunit(String qunit) 
	{
		this.qunit = qunit;
	}

	public String getQunit() 
	{
		return qunit;
	}
	public void setWunit(String wunit) 
	{
		this.wunit = wunit;
	}

	public String getWunit() 
	{
		return wunit;
	}
	public void setGoodsImage(String goodsImage) 
	{
		this.goodsImage = goodsImage;
	}

	public String getGoodsImage() 
	{
		return goodsImage;
	}
	public void setGoodsCode(String goodsCode) 
	{
		this.goodsCode = goodsCode;
	}

	public String getGoodsCode() 
	{
		return goodsCode;
	}
	public void setUnId(String unId) 
	{
		this.unId = unId;
	}

	public String getUnId() 
	{
		return unId;
	}
	public void setChkMarket(String chkMarket) 
	{
		this.chkMarket = chkMarket;
	}

	public String getChkMarket() 
	{
		return chkMarket;
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

	public String getcBrand() {
		return cBrand;
	}

	public void setcBrand(String cBrand) {
		this.cBrand = cBrand;
	}

	public String geteBrand() {
		return eBrand;
	}

	public void seteBrand(String eBrand) {
		this.eBrand = eBrand;
	}

	@Override
	public String toString() {
		return "SmtGoods{" +
				"goodsId=" + goodsId +
				", goodsCname='" + goodsCname + '\'' +
				", hsCode='" + hsCode + '\'' +
				", hsCodes='" + hsCodes + '\'' +
				", corpOwnerCode='" + corpOwnerCode + '\'' +
				", goodsType='" + goodsType + '\'' +
				", goodsEname='" + goodsEname + '\'' +
				", model='" + model + '\'' +
				", isBrand='" + isBrand + '\'' +
				", cBrand='" + cBrand + '\'' +
				", eBrand='" + eBrand + '\'' +
				", producer='" + producer + '\'' +
				", cunit='" + cunit + '\'' +
				", qunit='" + qunit + '\'' +
				", wunit='" + wunit + '\'' +
				", goodsImage='" + goodsImage + '\'' +
				", goodsCode='" + goodsCode + '\'' +
				", unId='" + unId + '\'' +
				", status='" + status + '\'' +
				", chkMarket='" + chkMarket + '\'' +
				", delFlag='" + delFlag + '\'' +
				", createBy='" + createBy + '\'' +
				", createTime=" + createTime +
				", updateBy='" + updateBy + '\'' +
				", updateTime=" + updateTime +
				", remark='" + remark + '\'' +
				'}';
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
