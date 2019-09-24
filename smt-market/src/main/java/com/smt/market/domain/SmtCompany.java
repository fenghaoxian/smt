package com.smt.market.domain;


import com.smt.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 企业表 smt_company
 * 
 * @author smt
 * @date 2019-09-06
 */
public class SmtCompany extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 商户id */
	private Integer companyId;
	/** 统一社会信用代码 */
	private String sgsRegCode;
	/** 行政区域代码 */
	private String regionCode;
	/** 税务机关代码 */
	private String taxAuthoritiesCode;
	/** 企业中文名称 */
	private String corpCname;
	/** 企业英文名称 */
	private String corpEname;
	/** 企业简称 */
	private String corpShortName;
	/** 组织机构代码 */
	private String corpOrgCode;
	/** 企业类型 */
	private String corpType;
	/** 角色 商户(1),外贸公司(9),货代(2),报关(5),报检(4) */
	private String characters;
	/** 法人代表 */
	private String legalName;
	/** 证件类型   身份证(1),港澳通行证(2),军官证(3),其他(4) */
	private String identCode;
	/** 证件号 */
	private String identIdCode;
	/** 联系人 */
	private String contractMan;
	/** 单一窗口登录账号 */
	private String loginUserName;
	/** 联系电话 */
	private String cellPhoneNo;
	/** 电子邮箱 */
	private String email;
	/** 智检备案号 */
	private String wisdomCheckNo;
	/** 传真 */
	private String faxNo;
	/** 邮编 */
	private String postCode;
	/** 经营场所中文 */
	private String caddress;
	/** 注册资本 */
	private String regMoney;
	/** 公司类型 国有企业(1),集体企业(5),中外合作企业(2),外商独资企业(4),私营企业(6),中外合作企业(3),其他(9) */
	private String companyType;
	/** 经营范围 */
	private String scope;
	/** 行业类型 */
	private String industryCode;
	/** 纳税人识别号 */
	private String taxIdentCode;
	/** 企业税务类型 一般纳税人(105_01),小规模纳税人(105_02) */
	private String corpTaxType;
	/** 海关代码 */
	private String customCode;
	/** 企业CIQ登记号 */
	private String declCode;
	/** 进出口代码 */
	private String ioCorpCode;
	/** 企业信用等级 A级企业(信誉优良)(A),B级企业(信誉一般)(B),C级企业(信誉差)(C) */
	private String creditLevel;
	/** 执照有效期开始日 */
	private Date validateBeg;
	/** 执照有效期结束日 */
	private Date validateEng;
	/** 发证日期 */
	private Date regDate;
	/** 开业日期 */
	private Date openDate;
	/** 常驻国家 */
	private String resCountry;
	/** 企业地址 */
	private String orgAddress;
	/** 外方投资者国别(地区)1 */
	private String finvest1;
	/** 外方投资者国别(地区)2 */
	private String finvest2;
	/** 外方投资者国别(地区)3 */
	private String finvest3;
	/** 外方投资者国别(地区)4 */
	private String finvest4;
	/** 外方投资者国别(地区)5 */
	private String finvest5;
	/** 经济类型 */
	private String economyType;
	/** 所在地外汇局代码 */
	private String locationfCode;
	/** 是否特殊监管区域内企业 */
	private String isSpecialCorp;
	/** 特殊监管区域内企业类型 */
	private String specialCorpType;
	/** 经营期限 */
	private String period;
	/** 投资币种 */
	private String investMoneyKind;
	/** 外币注册资本折美元 */
	private BigDecimal fregMoneyDollar;
	/** 投资总额 */
	private String investSumMoney;
	/** 人民币投资总额 */
	private String rmbInvestSumMoney;
	/** 外币折美元投资总额 */
	private String finvestSumMoneyDollar;
	/** 机构类型 */
	private String orgType;
	/** 授信商户类型 展销商户(1),集群商户(2) */
	private String corpBussinessType;
	/** 展销商品 */
	private String showSellGoods;
	/** 关联外贸公司统一社会信用代码 */
	private String relateCorp;
	/** 采购系统企业主键 */
	private String orgId;
	/** 删除标志 存在(0),删除(2) */
	private String delFlag;
	/** 备注 */
	private String remark;
	/** 创建者 */
	private String createBy;
	/** 创建时间 */
	private Date createTime;
	/** 更新者 */
	private String updateBy;
	/** 更新时间 */
	private Date updateTime;

	public void setCompanyId(Integer companyId) 
	{
		this.companyId = companyId;
	}

	public Integer getCompanyId() 
	{
		return companyId;
	}
	public void setSgsRegCode(String sgsRegCode) 
	{
		this.sgsRegCode = sgsRegCode;
	}

	public String getSgsRegCode() 
	{
		return sgsRegCode;
	}
	public void setRegionCode(String regionCode) 
	{
		this.regionCode = regionCode;
	}

	public String getRegionCode() 
	{
		return regionCode;
	}
	public void setTaxAuthoritiesCode(String taxAuthoritiesCode) 
	{
		this.taxAuthoritiesCode = taxAuthoritiesCode;
	}

	public String getTaxAuthoritiesCode() 
	{
		return taxAuthoritiesCode;
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
	public void setCorpShortName(String corpShortName) 
	{
		this.corpShortName = corpShortName;
	}

	public String getCorpShortName() 
	{
		return corpShortName;
	}
	public void setCorpOrgCode(String corpOrgCode) 
	{
		this.corpOrgCode = corpOrgCode;
	}

	public String getCorpOrgCode() 
	{
		return corpOrgCode;
	}
	public void setCorpType(String corpType) 
	{
		this.corpType = corpType;
	}

	public String getCorpType() 
	{
		return corpType;
	}
	public void setCharacters(String characters) 
	{
		this.characters = characters;
	}

	public String getCharacters() 
	{
		return characters;
	}
	public void setLegalName(String legalName) 
	{
		this.legalName = legalName;
	}

	public String getLegalName() 
	{
		return legalName;
	}
	public void setIdentCode(String identCode) 
	{
		this.identCode = identCode;
	}

	public String getIdentCode() 
	{
		return identCode;
	}
	public void setIdentIdCode(String identIdCode) 
	{
		this.identIdCode = identIdCode;
	}

	public String getIdentIdCode() 
	{
		return identIdCode;
	}
	public void setContractMan(String contractMan) 
	{
		this.contractMan = contractMan;
	}

	public String getContractMan() 
	{
		return contractMan;
	}
	public void setLoginUserName(String loginUserName) 
	{
		this.loginUserName = loginUserName;
	}

	public String getLoginUserName() 
	{
		return loginUserName;
	}
	public void setCellPhoneNo(String cellPhoneNo) 
	{
		this.cellPhoneNo = cellPhoneNo;
	}

	public String getCellPhoneNo() 
	{
		return cellPhoneNo;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getEmail() 
	{
		return email;
	}
	public void setWisdomCheckNo(String wisdomCheckNo) 
	{
		this.wisdomCheckNo = wisdomCheckNo;
	}

	public String getWisdomCheckNo() 
	{
		return wisdomCheckNo;
	}
	public void setFaxNo(String faxNo) 
	{
		this.faxNo = faxNo;
	}

	public String getFaxNo() 
	{
		return faxNo;
	}
	public void setPostCode(String postCode) 
	{
		this.postCode = postCode;
	}

	public String getPostCode() 
	{
		return postCode;
	}
	public void setCaddress(String caddress) 
	{
		this.caddress = caddress;
	}

	public String getCaddress() 
	{
		return caddress;
	}
	public void setRegMoney(String regMoney) 
	{
		this.regMoney = regMoney;
	}

	public String getRegMoney() 
	{
		return regMoney;
	}
	public void setCompanyType(String companyType) 
	{
		this.companyType = companyType;
	}

	public String getCompanyType() 
	{
		return companyType;
	}
	public void setScope(String scope) 
	{
		this.scope = scope;
	}

	public String getScope() 
	{
		return scope;
	}
	public void setIndustryCode(String industryCode) 
	{
		this.industryCode = industryCode;
	}

	public String getIndustryCode() 
	{
		return industryCode;
	}
	public void setTaxIdentCode(String taxIdentCode) 
	{
		this.taxIdentCode = taxIdentCode;
	}

	public String getTaxIdentCode() 
	{
		return taxIdentCode;
	}
	public void setCorpTaxType(String corpTaxType) 
	{
		this.corpTaxType = corpTaxType;
	}

	public String getCorpTaxType() 
	{
		return corpTaxType;
	}
	public void setCustomCode(String customCode) 
	{
		this.customCode = customCode;
	}

	public String getCustomCode() 
	{
		return customCode;
	}
	public void setDeclCode(String declCode) 
	{
		this.declCode = declCode;
	}

	public String getDeclCode() 
	{
		return declCode;
	}
	public void setIoCorpCode(String ioCorpCode) 
	{
		this.ioCorpCode = ioCorpCode;
	}

	public String getIoCorpCode() 
	{
		return ioCorpCode;
	}
	public void setCreditLevel(String creditLevel) 
	{
		this.creditLevel = creditLevel;
	}

	public String getCreditLevel() 
	{
		return creditLevel;
	}
	public void setValidateBeg(Date validateBeg) 
	{
		this.validateBeg = validateBeg;
	}

	public Date getValidateBeg()
	{
		return validateBeg;
	}
	public void setValidateEng(Date validateEng) 
	{
		this.validateEng = validateEng;
	}

	public Date getValidateEng() 
	{
		return validateEng;
	}
	public void setRegDate(Date regDate) 
	{
		this.regDate = regDate;
	}

	public Date getRegDate() 
	{
		return regDate;
	}
	public void setOpenDate(Date openDate) 
	{
		this.openDate = openDate;
	}

	public Date getOpenDate() 
	{
		return openDate;
	}
	public void setResCountry(String resCountry) 
	{
		this.resCountry = resCountry;
	}

	public String getResCountry() 
	{
		return resCountry;
	}
	public void setOrgAddress(String orgAddress) 
	{
		this.orgAddress = orgAddress;
	}

	public String getOrgAddress() 
	{
		return orgAddress;
	}
	public void setFinvest1(String finvest1) 
	{
		this.finvest1 = finvest1;
	}

	public String getFinvest1() 
	{
		return finvest1;
	}
	public void setFinvest2(String finvest2) 
	{
		this.finvest2 = finvest2;
	}

	public String getFinvest2() 
	{
		return finvest2;
	}
	public void setFinvest3(String finvest3) 
	{
		this.finvest3 = finvest3;
	}

	public String getFinvest3() 
	{
		return finvest3;
	}
	public void setFinvest4(String finvest4) 
	{
		this.finvest4 = finvest4;
	}

	public String getFinvest4() 
	{
		return finvest4;
	}
	public void setFinvest5(String finvest5) 
	{
		this.finvest5 = finvest5;
	}

	public String getFinvest5() 
	{
		return finvest5;
	}
	public void setEconomyType(String economyType) 
	{
		this.economyType = economyType;
	}

	public String getEconomyType() 
	{
		return economyType;
	}
	public void setLocationfCode(String locationfCode) 
	{
		this.locationfCode = locationfCode;
	}

	public String getLocationfCode() 
	{
		return locationfCode;
	}
	public void setIsSpecialCorp(String isSpecialCorp) 
	{
		this.isSpecialCorp = isSpecialCorp;
	}

	public String getIsSpecialCorp() 
	{
		return isSpecialCorp;
	}
	public void setSpecialCorpType(String specialCorpType) 
	{
		this.specialCorpType = specialCorpType;
	}

	public String getSpecialCorpType() 
	{
		return specialCorpType;
	}
	public void setPeriod(String period) 
	{
		this.period = period;
	}

	public String getPeriod() 
	{
		return period;
	}
	public void setInvestMoneyKind(String investMoneyKind) 
	{
		this.investMoneyKind = investMoneyKind;
	}

	public String getInvestMoneyKind() 
	{
		return investMoneyKind;
	}
	public void setFregMoneyDollar(BigDecimal fregMoneyDollar)
	{
		this.fregMoneyDollar = fregMoneyDollar;
	}

	public BigDecimal getFregMoneyDollar() 
	{
		return fregMoneyDollar;
	}
	public void setInvestSumMoney(String investSumMoney) 
	{
		this.investSumMoney = investSumMoney;
	}

	public String getInvestSumMoney() 
	{
		return investSumMoney;
	}
	public void setRmbInvestSumMoney(String rmbInvestSumMoney) 
	{
		this.rmbInvestSumMoney = rmbInvestSumMoney;
	}

	public String getRmbInvestSumMoney() 
	{
		return rmbInvestSumMoney;
	}
	public void setFinvestSumMoneyDollar(String finvestSumMoneyDollar) 
	{
		this.finvestSumMoneyDollar = finvestSumMoneyDollar;
	}

	public String getFinvestSumMoneyDollar() 
	{
		return finvestSumMoneyDollar;
	}
	public void setOrgType(String orgType) 
	{
		this.orgType = orgType;
	}

	public String getOrgType() 
	{
		return orgType;
	}
	public void setCorpBussinessType(String corpBussinessType) 
	{
		this.corpBussinessType = corpBussinessType;
	}

	public String getCorpBussinessType() 
	{
		return corpBussinessType;
	}
	public void setShowSellGoods(String showSellGoods) 
	{
		this.showSellGoods = showSellGoods;
	}

	public String getShowSellGoods() 
	{
		return showSellGoods;
	}
	public void setRelateCorp(String relateCorp) 
	{
		this.relateCorp = relateCorp;
	}

	public String getRelateCorp() 
	{
		return relateCorp;
	}
	public void setOrgId(String orgId) 
	{
		this.orgId = orgId;
	}

	public String getOrgId() 
	{
		return orgId;
	}
	public void setDelFlag(String delFlag) 
	{
		this.delFlag = delFlag;
	}

	public String getDelFlag() 
	{
		return delFlag;
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
            .append("companyId", getCompanyId())
            .append("sgsRegCode", getSgsRegCode())
            .append("regionCode", getRegionCode())
            .append("taxAuthoritiesCode", getTaxAuthoritiesCode())
            .append("corpCname", getCorpCname())
            .append("corpEname", getCorpEname())
            .append("corpShortName", getCorpShortName())
            .append("corpOrgCode", getCorpOrgCode())
            .append("corpType", getCorpType())
            .append("characters", getCharacters())
            .append("legalName", getLegalName())
            .append("identCode", getIdentCode())
            .append("identIdCode", getIdentIdCode())
            .append("contractMan", getContractMan())
            .append("loginUserName", getLoginUserName())
            .append("cellPhoneNo", getCellPhoneNo())
            .append("email", getEmail())
            .append("wisdomCheckNo", getWisdomCheckNo())
            .append("faxNo", getFaxNo())
            .append("postCode", getPostCode())
            .append("caddress", getCaddress())
            .append("regMoney", getRegMoney())
            .append("companyType", getCompanyType())
            .append("scope", getScope())
            .append("industryCode", getIndustryCode())
            .append("taxIdentCode", getTaxIdentCode())
            .append("corpTaxType", getCorpTaxType())
            .append("customCode", getCustomCode())
            .append("declCode", getDeclCode())
            .append("ioCorpCode", getIoCorpCode())
            .append("creditLevel", getCreditLevel())
            .append("validateBeg", getValidateBeg())
            .append("validateEng", getValidateEng())
            .append("regDate", getRegDate())
            .append("openDate", getOpenDate())
            .append("resCountry", getResCountry())
            .append("orgAddress", getOrgAddress())
            .append("finvest1", getFinvest1())
            .append("finvest2", getFinvest2())
            .append("finvest3", getFinvest3())
            .append("finvest4", getFinvest4())
            .append("finvest5", getFinvest5())
            .append("economyType", getEconomyType())
            .append("locationfCode", getLocationfCode())
            .append("isSpecialCorp", getIsSpecialCorp())
            .append("specialCorpType", getSpecialCorpType())
            .append("period", getPeriod())
            .append("investMoneyKind", getInvestMoneyKind())
            .append("fregMoneyDollar", getFregMoneyDollar())
            .append("investSumMoney", getInvestSumMoney())
            .append("rmbInvestSumMoney", getRmbInvestSumMoney())
            .append("finvestSumMoneyDollar", getFinvestSumMoneyDollar())
            .append("orgType", getOrgType())
            .append("corpBussinessType", getCorpBussinessType())
            .append("showSellGoods", getShowSellGoods())
            .append("relateCorp", getRelateCorp())
            .append("orgId", getOrgId())
            .append("delFlag", getDelFlag())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
