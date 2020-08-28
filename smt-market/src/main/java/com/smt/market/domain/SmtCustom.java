package com.smt.market.domain;


import com.smt.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 一次性录入表 smt_custom
 * 
 * @author smt
 * @date 2019-11-18
 */
public class SmtCustom extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 报关单ID */
	private Integer customId;
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
	/** 报关单状态 */
	private String status;
	/** 报关单状态(联网) */
	private String custStatus;
	/** 是否删除 存在(0), 删除(2) */
	private String delFlag;
	/** 业务类型代码 */
	private String opType;
	/** 报关转关代码 */
	private String decTin;
	/** 报关模式代码 */
	private String decMode;
	/** 担保验放 */
	private String checkSurety;
	/** 备案清单类型 */
	private String billType;
	/** 统一编号 */
	private String seqNo;
	/** 预录入编号 */
	private String preEntryId;
	/** 报关单号 */
	private String entryId;
	/** 出口口岸 */
	private String iePort;
	/** 合同协议号 */
	private String contrNo;
	/** 出口日期 */
	private Date ieDate;
	/** 申报日期 */
	private Date dDate;
	/** 收货人 */
	private String tradeCo;
	/** 收货人名称 */
	private String tradeCoName;
	/** 收发货人(企业类型) */
	private String coOwner;
	/** 经营单位统一编码 */
	private String tradeCoscc;
	/** 生产销售单位 */
	private String ownerCode;
	/** 生产销售单位名称 */
	private String ownerName;
	/** 货主单位统一编码 */
	private String ownerCodeScc;
	/** 申报单位 */
	private String agentCode;
	/** 申报单位名称 */
	private String agentName;
	/** 申报单位统一编码 */
	private String agentCodeScc;
	/** 录入单位统一编码 */
	private String copCodeScc;
	/** 运输方式 */
	private String trafMode;
	/** 运输工具名称 */
	private String trafName;
	/** 航次号 */
	private String voyageNo;
	/** 提运单号 */
	private String billNo;
	/** 监管方式 */
	private String tradeMode;
	/** 征免性质 */
	private String cutMode;
	/** 纳税单位 */
	private String paymentMark;
	/** 许可证号 */
	private String licenseNo;
	/** 贸易国别 */
	private String tradeAreaCode;
	/** 抵运国 */
	private String tradeCountry;
	/** 抵运港 */
	private String distinatePort;
	/** 境内货源地 */
	private String districtCode;
	/** 批准文号 */
	private String apprNo;
	/** 承诺事项 */
	private String promiseItems;
	/** 成交方式 */
	private String transMode;
	/** 运费 */
	private String feeMark;
	/** 运费比率 */
	private String feeRate;
	/** 运费单位 */
	private String feeCurr;
	/** 保费 */
	private String insurMark;
	/** 保费比率 */
	private String insurRate;
	/** 保费单位 */
	private String insurCurr;
	/** 杂费 */
	private String otherMark;
	/** 杂费比率 */
	private String otherRate;
	/** 杂费单位 */
	private String otherCurr;
	/** 件数 */
	private String packNo;
	/** 包装种类 */
	private String wrapType;
	/** 毛重 */
	private String grossWt;
	/** 净重 */
	private String netWt;
	/** 集装箱数量 */
	private String containerNum;
	/** 随附单证 */
	private String certMark;
	/** 自定义编号 */
	private String copId;
	/** 申报地海关 */
	private String customMaster;
	/** 关联报关单 */
	private String relativeId;
	/** 关联备案 */
	private String relativeManualNo;
	/** 保税/监管场所 */
	private String bondedNo;
	/** 货场代码 */
	private String customsFieId;
	/** 操作员 */
	private String typistNo;
	/** 联系方式 */
	private String bpNo;
	/** 报关模式 */
	private String entryType;
	/** 备注 */
	private String noteS;
	/** 创建企业编码 */
	private String createOrg;
	/** 报检企业编码 */
	private String ciqComp;
	/** 货代公司编码 */
	private String packComp;
	/** 装箱仓库 */
	private String packWarehouse;
	/** 单据类型 */
	private String type;
	/** 担保验放 */
	private String chkSurety;
	/** 查验分流 */
	private String checkFlow;
	/** 税收征管标记 */
	private String taxAaminMark;
	/** 标记唛码 */
	private String markNo;
	/** 启运港代码 */
	private String despPortCode;
	/** 入境/离境口岸代码 */
	private String entyPortCode;
	/** 存放地点 */
	private String goodsPlace;
	/** B/L号 */
	private String blNo;
	/** 口岸检验检疫机关 */
	private String inspOrgCode;
	/** 特种业务标识 */
	private String specDeclFalg;
	/** 目的地检验检疫机关 */
	private String purpOrgCode;
	/** 启运日期 */
	private Date despDate;
	/** 卸毕日期 */
	private Date cmplDschrgDt;
	/** 关联理由 */
	private String correlationReasonFlag;
	/** 领证机关 */
	private String vsaOrgCode;
	/** 原集装箱标识 */
	private String origBoxFlag;
	/** 无其他包装 */
	private String noOtherPack;
	/** 检验检疫受理机关 */
	private String orgCode;
	/** 境外收发货人代码 */
	private String overseasConsigneeCode;
	/** 境外收发货人名称 */
	private String overseasConsignorCname;
	/** 境外收发货人名称(外文) */
	private String overseasConsigneeEname;
	/** 境外发货人地址 */
	private String overseasConsignorAddr;
	/** 境内收发货人名称 */
	private String domesticConsigneeEname;
	/** 关联号码 */
	private String correlationNo;
	/** 境内收发货人10位检验检疫编码 */
	private String consignorCode;
	/** 生产销售单位10位检验检疫编码 */
	private String ownereCiqCode;
	/** 申报单位10位检验检疫编码 */
	private String declRegNo;

	public void setCustomId(Integer customId) 
	{
		this.customId = customId;
	}

	public Integer getCustomId() 
	{
		return customId;
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
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	public void setCustStatus(String custStatus) 
	{
		this.custStatus = custStatus;
	}

	public String getCustStatus() 
	{
		return custStatus;
	}
	public void setDelFlag(String delFlag) 
	{
		this.delFlag = delFlag;
	}

	public String getDelFlag() 
	{
		return delFlag;
	}
	public void setOpType(String opType) 
	{
		this.opType = opType;
	}

	public String getOpType() 
	{
		return opType;
	}
	public void setDecTin(String decTin) 
	{
		this.decTin = decTin;
	}

	public String getDecTin() 
	{
		return decTin;
	}
	public void setDecMode(String decMode) 
	{
		this.decMode = decMode;
	}

	public String getDecMode() 
	{
		return decMode;
	}
	public void setCheckSurety(String checkSurety) 
	{
		this.checkSurety = checkSurety;
	}

	public String getCheckSurety() 
	{
		return checkSurety;
	}
	public void setBillType(String billType) 
	{
		this.billType = billType;
	}

	public String getBillType() 
	{
		return billType;
	}
	public void setSeqNo(String seqNo) 
	{
		this.seqNo = seqNo;
	}

	public String getSeqNo() 
	{
		return seqNo;
	}
	public void setPreEntryId(String preEntryId) 
	{
		this.preEntryId = preEntryId;
	}

	public String getPreEntryId() 
	{
		return preEntryId;
	}
	public void setEntryId(String entryId) 
	{
		this.entryId = entryId;
	}

	public String getEntryId() 
	{
		return entryId;
	}
	public void setIePort(String iePort) 
	{
		this.iePort = iePort;
	}

	public String getIePort() 
	{
		return iePort;
	}
	public void setContrNo(String contrNo) 
	{
		this.contrNo = contrNo;
	}

	public String getContrNo() 
	{
		return contrNo;
	}
	public void setIeDate(Date ieDate) 
	{
		this.ieDate = ieDate;
	}

	public Date getIeDate() 
	{
		return ieDate;
	}
	public void setDDate(Date dDate) 
	{
		this.dDate = dDate;
	}

	public Date getDDate() 
	{
		return dDate;
	}
	public void setTradeCo(String tradeCo) 
	{
		this.tradeCo = tradeCo;
	}

	public String getTradeCo() 
	{
		return tradeCo;
	}
	public void setTradeCoName(String tradeCoName) 
	{
		this.tradeCoName = tradeCoName;
	}

	public String getTradeCoName() 
	{
		return tradeCoName;
	}
	public void setCoOwner(String coOwner) 
	{
		this.coOwner = coOwner;
	}

	public String getCoOwner() 
	{
		return coOwner;
	}
	public void setTradeCoscc(String tradeCoscc) 
	{
		this.tradeCoscc = tradeCoscc;
	}

	public String getTradeCoscc() 
	{
		return tradeCoscc;
	}
	public void setOwnerCode(String ownerCode) 
	{
		this.ownerCode = ownerCode;
	}

	public String getOwnerCode() 
	{
		return ownerCode;
	}
	public void setOwnerName(String ownerName) 
	{
		this.ownerName = ownerName;
	}

	public String getOwnerName() 
	{
		return ownerName;
	}
	public void setOwnerCodeScc(String ownerCodeScc) 
	{
		this.ownerCodeScc = ownerCodeScc;
	}

	public String getOwnerCodeScc() 
	{
		return ownerCodeScc;
	}
	public void setAgentCode(String agentCode) 
	{
		this.agentCode = agentCode;
	}

	public String getAgentCode() 
	{
		return agentCode;
	}
	public void setAgentName(String agentName) 
	{
		this.agentName = agentName;
	}

	public String getAgentName() 
	{
		return agentName;
	}
	public void setAgentCodeScc(String agentCodeScc) 
	{
		this.agentCodeScc = agentCodeScc;
	}

	public String getAgentCodeScc() 
	{
		return agentCodeScc;
	}
	public void setCopCodeScc(String copCodeScc) 
	{
		this.copCodeScc = copCodeScc;
	}

	public String getCopCodeScc() 
	{
		return copCodeScc;
	}
	public void setTrafMode(String trafMode) 
	{
		this.trafMode = trafMode;
	}

	public String getTrafMode() 
	{
		return trafMode;
	}
	public void setTrafName(String trafName) 
	{
		this.trafName = trafName;
	}

	public String getTrafName() 
	{
		return trafName;
	}
	public void setVoyageNo(String voyageNo) 
	{
		this.voyageNo = voyageNo;
	}

	public String getVoyageNo() 
	{
		return voyageNo;
	}
	public void setBillNo(String billNo) 
	{
		this.billNo = billNo;
	}

	public String getBillNo() 
	{
		return billNo;
	}
	public void setTradeMode(String tradeMode) 
	{
		this.tradeMode = tradeMode;
	}

	public String getTradeMode() 
	{
		return tradeMode;
	}
	public void setCutMode(String cutMode) 
	{
		this.cutMode = cutMode;
	}

	public String getCutMode() 
	{
		return cutMode;
	}
	public void setPaymentMark(String paymentMark) 
	{
		this.paymentMark = paymentMark;
	}

	public String getPaymentMark() 
	{
		return paymentMark;
	}
	public void setLicenseNo(String licenseNo) 
	{
		this.licenseNo = licenseNo;
	}

	public String getLicenseNo() 
	{
		return licenseNo;
	}
	public void setTradeAreaCode(String tradeAreaCode) 
	{
		this.tradeAreaCode = tradeAreaCode;
	}

	public String getTradeAreaCode() 
	{
		return tradeAreaCode;
	}
	public void setTradeCountry(String tradeCountry) 
	{
		this.tradeCountry = tradeCountry;
	}

	public String getTradeCountry() 
	{
		return tradeCountry;
	}
	public void setDistinatePort(String distinatePort) 
	{
		this.distinatePort = distinatePort;
	}

	public String getDistinatePort() 
	{
		return distinatePort;
	}
	public void setDistrictCode(String districtCode) 
	{
		this.districtCode = districtCode;
	}

	public String getDistrictCode() 
	{
		return districtCode;
	}
	public void setApprNo(String apprNo) 
	{
		this.apprNo = apprNo;
	}

	public String getApprNo() 
	{
		return apprNo;
	}
	public void setPromiseItems(String promiseItems) 
	{
		this.promiseItems = promiseItems;
	}

	public String getPromiseItems() 
	{
		return promiseItems;
	}
	public void setTransMode(String transMode) 
	{
		this.transMode = transMode;
	}

	public String getTransMode() 
	{
		return transMode;
	}
	public void setFeeMark(String feeMark) 
	{
		this.feeMark = feeMark;
	}

	public String getFeeMark() 
	{
		return feeMark;
	}
	public void setFeeRate(String feeRate) 
	{
		this.feeRate = feeRate;
	}

	public String getFeeRate() 
	{
		return feeRate;
	}
	public void setFeeCurr(String feeCurr) 
	{
		this.feeCurr = feeCurr;
	}

	public String getFeeCurr() 
	{
		return feeCurr;
	}
	public void setInsurMark(String insurMark) 
	{
		this.insurMark = insurMark;
	}

	public String getInsurMark() 
	{
		return insurMark;
	}
	public void setInsurRate(String insurRate) 
	{
		this.insurRate = insurRate;
	}

	public String getInsurRate() 
	{
		return insurRate;
	}
	public void setInsurCurr(String insurCurr) 
	{
		this.insurCurr = insurCurr;
	}

	public String getInsurCurr() 
	{
		return insurCurr;
	}
	public void setOtherMark(String otherMark) 
	{
		this.otherMark = otherMark;
	}

	public String getOtherMark() 
	{
		return otherMark;
	}
	public void setOtherRate(String otherRate) 
	{
		this.otherRate = otherRate;
	}

	public String getOtherRate() 
	{
		return otherRate;
	}
	public void setOtherCurr(String otherCurr) 
	{
		this.otherCurr = otherCurr;
	}

	public String getOtherCurr() 
	{
		return otherCurr;
	}
	public void setPackNo(String packNo) 
	{
		this.packNo = packNo;
	}

	public String getPackNo() 
	{
		return packNo;
	}
	public void setWrapType(String wrapType) 
	{
		this.wrapType = wrapType;
	}

	public String getWrapType() 
	{
		return wrapType;
	}
	public void setGrossWt(String grossWt) 
	{
		this.grossWt = grossWt;
	}

	public String getGrossWt() 
	{
		return grossWt;
	}
	public void setNetWt(String netWt) 
	{
		this.netWt = netWt;
	}

	public String getNetWt() 
	{
		return netWt;
	}
	public void setContainerNum(String containerNum) 
	{
		this.containerNum = containerNum;
	}

	public String getContainerNum() 
	{
		return containerNum;
	}
	public void setCertMark(String certMark) 
	{
		this.certMark = certMark;
	}

	public String getCertMark() 
	{
		return certMark;
	}
	public void setCopId(String copId) 
	{
		this.copId = copId;
	}

	public String getCopId() 
	{
		return copId;
	}
	public void setCustomMaster(String customMaster) 
	{
		this.customMaster = customMaster;
	}

	public String getCustomMaster() 
	{
		return customMaster;
	}
	public void setRelativeId(String relativeId) 
	{
		this.relativeId = relativeId;
	}

	public String getRelativeId() 
	{
		return relativeId;
	}
	public void setRelativeManualNo(String relativeManualNo) 
	{
		this.relativeManualNo = relativeManualNo;
	}

	public String getRelativeManualNo() 
	{
		return relativeManualNo;
	}
	public void setBondedNo(String bondedNo) 
	{
		this.bondedNo = bondedNo;
	}

	public String getBondedNo() 
	{
		return bondedNo;
	}
	public void setCustomsFieId(String customsFieId) 
	{
		this.customsFieId = customsFieId;
	}

	public String getCustomsFieId() 
	{
		return customsFieId;
	}
	public void setTypistNo(String typistNo) 
	{
		this.typistNo = typistNo;
	}

	public String getTypistNo() 
	{
		return typistNo;
	}
	public void setBpNo(String bpNo) 
	{
		this.bpNo = bpNo;
	}

	public String getBpNo() 
	{
		return bpNo;
	}
	public void setEntryType(String entryType) 
	{
		this.entryType = entryType;
	}

	public String getEntryType() 
	{
		return entryType;
	}
	public void setNoteS(String noteS) 
	{
		this.noteS = noteS;
	}

	public String getNoteS() 
	{
		return noteS;
	}
	public void setCreateOrg(String createOrg) 
	{
		this.createOrg = createOrg;
	}

	public String getCreateOrg() 
	{
		return createOrg;
	}
	public void setCiqComp(String ciqComp) 
	{
		this.ciqComp = ciqComp;
	}

	public String getCiqComp() 
	{
		return ciqComp;
	}
	public void setPackComp(String packComp) 
	{
		this.packComp = packComp;
	}

	public String getPackComp() 
	{
		return packComp;
	}
	public void setPackWarehouse(String packWarehouse) 
	{
		this.packWarehouse = packWarehouse;
	}

	public String getPackWarehouse() 
	{
		return packWarehouse;
	}
	public void setType(String type) 
	{
		this.type = type;
	}

	public String getType() 
	{
		return type;
	}
	public void setChkSurety(String chkSurety) 
	{
		this.chkSurety = chkSurety;
	}

	public String getChkSurety() 
	{
		return chkSurety;
	}
	public void setCheckFlow(String checkFlow) 
	{
		this.checkFlow = checkFlow;
	}

	public String getCheckFlow() 
	{
		return checkFlow;
	}
	public void setTaxAaminMark(String taxAaminMark) 
	{
		this.taxAaminMark = taxAaminMark;
	}

	public String getTaxAaminMark() 
	{
		return taxAaminMark;
	}
	public void setMarkNo(String markNo) 
	{
		this.markNo = markNo;
	}

	public String getMarkNo() 
	{
		return markNo;
	}
	public void setDespPortCode(String despPortCode) 
	{
		this.despPortCode = despPortCode;
	}

	public String getDespPortCode() 
	{
		return despPortCode;
	}
	public void setEntyPortCode(String entyPortCode) 
	{
		this.entyPortCode = entyPortCode;
	}

	public String getEntyPortCode() 
	{
		return entyPortCode;
	}
	public void setGoodsPlace(String goodsPlace) 
	{
		this.goodsPlace = goodsPlace;
	}

	public String getGoodsPlace() 
	{
		return goodsPlace;
	}
	public void setBlNo(String blNo) 
	{
		this.blNo = blNo;
	}

	public String getBlNo() 
	{
		return blNo;
	}
	public void setInspOrgCode(String inspOrgCode) 
	{
		this.inspOrgCode = inspOrgCode;
	}

	public String getInspOrgCode() 
	{
		return inspOrgCode;
	}
	public void setSpecDeclFalg(String specDeclFalg) 
	{
		this.specDeclFalg = specDeclFalg;
	}

	public String getSpecDeclFalg() 
	{
		return specDeclFalg;
	}
	public void setPurpOrgCode(String purpOrgCode) 
	{
		this.purpOrgCode = purpOrgCode;
	}

	public String getPurpOrgCode() 
	{
		return purpOrgCode;
	}
	public void setDespDate(Date despDate) 
	{
		this.despDate = despDate;
	}

	public Date getDespDate() 
	{
		return despDate;
	}
	public void setCmplDschrgDt(Date cmplDschrgDt) 
	{
		this.cmplDschrgDt = cmplDschrgDt;
	}

	public Date getCmplDschrgDt() 
	{
		return cmplDschrgDt;
	}
	public void setCorrelationReasonFlag(String correlationReasonFlag) 
	{
		this.correlationReasonFlag = correlationReasonFlag;
	}

	public String getCorrelationReasonFlag() 
	{
		return correlationReasonFlag;
	}
	public void setVsaOrgCode(String vsaOrgCode) 
	{
		this.vsaOrgCode = vsaOrgCode;
	}

	public String getVsaOrgCode() 
	{
		return vsaOrgCode;
	}
	public void setOrigBoxFlag(String origBoxFlag) 
	{
		this.origBoxFlag = origBoxFlag;
	}

	public String getOrigBoxFlag() 
	{
		return origBoxFlag;
	}
	public void setNoOtherPack(String noOtherPack) 
	{
		this.noOtherPack = noOtherPack;
	}

	public String getNoOtherPack() 
	{
		return noOtherPack;
	}
	public void setOrgCode(String orgCode) 
	{
		this.orgCode = orgCode;
	}

	public String getOrgCode() 
	{
		return orgCode;
	}
	public void setOverseasConsignorCname(String overseasConsignorCname) 
	{
		this.overseasConsignorCname = overseasConsignorCname;
	}

	public String getOverseasConsignorCname() 
	{
		return overseasConsignorCname;
	}
	public void setOverseasConsigneeEname(String overseasConsigneeEname) 
	{
		this.overseasConsigneeEname = overseasConsigneeEname;
	}

	public String getOverseasConsigneeEname() 
	{
		return overseasConsigneeEname;
	}
	public void setOverseasConsignorAddr(String overseasConsignorAddr) 
	{
		this.overseasConsignorAddr = overseasConsignorAddr;
	}

	public String getOverseasConsignorAddr() 
	{
		return overseasConsignorAddr;
	}
	public void setDomesticConsigneeEname(String domesticConsigneeEname) 
	{
		this.domesticConsigneeEname = domesticConsigneeEname;
	}

	public String getDomesticConsigneeEname() 
	{
		return domesticConsigneeEname;
	}
	public void setCorrelationNo(String correlationNo) 
	{
		this.correlationNo = correlationNo;
	}

	public String getCorrelationNo() 
	{
		return correlationNo;
	}
	public void setConsignorCode(String consignorCode) 
	{
		this.consignorCode = consignorCode;
	}

	public String getConsignorCode() 
	{
		return consignorCode;
	}
	public void setOwnereCiqCode(String ownereCiqCode) 
	{
		this.ownereCiqCode = ownereCiqCode;
	}

	public String getOwnereCiqCode() 
	{
		return ownereCiqCode;
	}
	public void setDeclRegNo(String declRegNo) 
	{
		this.declRegNo = declRegNo;
	}

	public String getDeclRegNo() 
	{
		return declRegNo;
	}

	public Date getdDate() {
		return dDate;
	}

	public void setdDate(Date dDate) {
		this.dDate = dDate;
	}

	public String getOverseasConsigneeCode() {
		return overseasConsigneeCode;
	}

	public void setOverseasConsigneeCode(String overseasConsigneeCode) {
		this.overseasConsigneeCode = overseasConsigneeCode;
	}

	@Override
	public String toString() {
		return "SmtCustom{" +
				"customId=" + customId +
				", createBy='" + createBy + '\'' +
				", createTime=" + createTime +
				", updateBy='" + updateBy + '\'' +
				", updateTime=" + updateTime +
				", remark='" + remark + '\'' +
				", status='" + status + '\'' +
				", custStatus='" + custStatus + '\'' +
				", delFlag='" + delFlag + '\'' +
				", opType='" + opType + '\'' +
				", decTin='" + decTin + '\'' +
				", decMode='" + decMode + '\'' +
				", checkSurety='" + checkSurety + '\'' +
				", billType='" + billType + '\'' +
				", seqNo='" + seqNo + '\'' +
				", preEntryId='" + preEntryId + '\'' +
				", entryId='" + entryId + '\'' +
				", iePort='" + iePort + '\'' +
				", contrNo='" + contrNo + '\'' +
				", ieDate=" + ieDate +
				", dDate=" + dDate +
				", tradeCo='" + tradeCo + '\'' +
				", tradeCoName='" + tradeCoName + '\'' +
				", coOwner='" + coOwner + '\'' +
				", tradeCoscc='" + tradeCoscc + '\'' +
				", ownerCode='" + ownerCode + '\'' +
				", ownerName='" + ownerName + '\'' +
				", ownerCodeScc='" + ownerCodeScc + '\'' +
				", agentCode='" + agentCode + '\'' +
				", agentName='" + agentName + '\'' +
				", agentCodeScc='" + agentCodeScc + '\'' +
				", copCodeScc='" + copCodeScc + '\'' +
				", trafMode='" + trafMode + '\'' +
				", trafName='" + trafName + '\'' +
				", voyageNo='" + voyageNo + '\'' +
				", billNo='" + billNo + '\'' +
				", tradeMode='" + tradeMode + '\'' +
				", cutMode='" + cutMode + '\'' +
				", paymentMark='" + paymentMark + '\'' +
				", licenseNo='" + licenseNo + '\'' +
				", tradeAreaCode='" + tradeAreaCode + '\'' +
				", tradeCountry='" + tradeCountry + '\'' +
				", distinatePort='" + distinatePort + '\'' +
				", districtCode='" + districtCode + '\'' +
				", apprNo='" + apprNo + '\'' +
				", promiseItems='" + promiseItems + '\'' +
				", transMode='" + transMode + '\'' +
				", feeMark='" + feeMark + '\'' +
				", feeRate='" + feeRate + '\'' +
				", feeCurr='" + feeCurr + '\'' +
				", insurMark='" + insurMark + '\'' +
				", insurRate='" + insurRate + '\'' +
				", insurCurr='" + insurCurr + '\'' +
				", otherMark='" + otherMark + '\'' +
				", otherRate='" + otherRate + '\'' +
				", otherCurr='" + otherCurr + '\'' +
				", packNo='" + packNo + '\'' +
				", wrapType='" + wrapType + '\'' +
				", grossWt='" + grossWt + '\'' +
				", netWt='" + netWt + '\'' +
				", containerNum='" + containerNum + '\'' +
				", certMark='" + certMark + '\'' +
				", copId='" + copId + '\'' +
				", customMaster='" + customMaster + '\'' +
				", relativeId='" + relativeId + '\'' +
				", relativeManualNo='" + relativeManualNo + '\'' +
				", bondedNo='" + bondedNo + '\'' +
				", customsFieId='" + customsFieId + '\'' +
				", typistNo='" + typistNo + '\'' +
				", bpNo='" + bpNo + '\'' +
				", entryType='" + entryType + '\'' +
				", noteS='" + noteS + '\'' +
				", createOrg='" + createOrg + '\'' +
				", ciqComp='" + ciqComp + '\'' +
				", packComp='" + packComp + '\'' +
				", packWarehouse='" + packWarehouse + '\'' +
				", type='" + type + '\'' +
				", chkSurety='" + chkSurety + '\'' +
				", checkFlow='" + checkFlow + '\'' +
				", taxAaminMark='" + taxAaminMark + '\'' +
				", markNo='" + markNo + '\'' +
				", despPortCode='" + despPortCode + '\'' +
				", entyPortCode='" + entyPortCode + '\'' +
				", goodsPlace='" + goodsPlace + '\'' +
				", blNo='" + blNo + '\'' +
				", inspOrgCode='" + inspOrgCode + '\'' +
				", specDeclFalg='" + specDeclFalg + '\'' +
				", purpOrgCode='" + purpOrgCode + '\'' +
				", despDate=" + despDate +
				", cmplDschrgDt=" + cmplDschrgDt +
				", correlationReasonFlag='" + correlationReasonFlag + '\'' +
				", vsaOrgCode='" + vsaOrgCode + '\'' +
				", origBoxFlag='" + origBoxFlag + '\'' +
				", noOtherPack='" + noOtherPack + '\'' +
				", orgCode='" + orgCode + '\'' +
				", overseasConsigneeCode='" + overseasConsigneeCode + '\'' +
				", overseasConsignorCname='" + overseasConsignorCname + '\'' +
				", overseasConsigneeEname='" + overseasConsigneeEname + '\'' +
				", overseasConsignorAddr='" + overseasConsignorAddr + '\'' +
				", domesticConsigneeEname='" + domesticConsigneeEname + '\'' +
				", correlationNo='" + correlationNo + '\'' +
				", consignorCode='" + consignorCode + '\'' +
				", ownereCiqCode='" + ownereCiqCode + '\'' +
				", declRegNo='" + declRegNo + '\'' +
				'}';
	}
}
