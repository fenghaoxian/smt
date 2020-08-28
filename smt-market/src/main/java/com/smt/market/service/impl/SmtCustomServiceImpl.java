package com.smt.market.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.smt.common.support.Convert;
import com.smt.common.utils.StringUtils;
import com.smt.market.domain.SmtCustom;
import com.smt.market.mapper.SmtCustomMapper;
import com.smt.market.service.ISmtCustomService;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

/**
 * 一次性录入 服务层实现
 * 
 * @author smt
 * @date 2019-11-18
 */
@Service
public class SmtCustomServiceImpl implements ISmtCustomService 
{
	@Autowired
	private SmtCustomMapper smtCustomMapper;

	/**
     * 查询一次性录入信息
     * 
     * @param customId 一次性录入ID
     * @return 一次性录入信息
     */
    @Override
	public SmtCustom selectSmtCustomById(Integer customId)
	{
	    return smtCustomMapper.selectSmtCustomById(customId);
	}
	
	/**
     * 查询一次性录入列表
     * 
     * @param smtCustom 一次性录入信息
     * @return 一次性录入集合
     */
	@Override
	public List<SmtCustom> selectSmtCustomList(SmtCustom smtCustom)
	{
	    return smtCustomMapper.selectSmtCustomList(smtCustom);
	}
	
    /**
     * 新增一次性录入
     * 
     * @param smtCustom 一次性录入信息
     * @return 结果
     */
	@Override
	public int insertSmtCustom(SmtCustom smtCustom)
	{
	    return smtCustomMapper.insertSmtCustom(smtCustom);
	}
	
	/**
     * 修改一次性录入
     * 
     * @param smtCustom 一次性录入信息
     * @return 结果
     */
	@Override
	public int updateSmtCustom(SmtCustom smtCustom)
	{
	    return smtCustomMapper.updateSmtCustom(smtCustom);
	}

	/**
     * 删除一次性录入对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSmtCustomByIds(String ids)
	{
		return smtCustomMapper.deleteSmtCustomByIds(Convert.toStrArray(ids));
	}

	@Override
	public String insert(Iterator iterator, String opType) {
		JSONArray jsonArray = new JSONArray();
		JSONObject json = new JSONObject();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		try {
			if (iterator.hasNext()) {
				Element element = (Element) iterator.next();
				Iterator customIter = element.elementIterator("CustomHead");
				if (customIter.hasNext()) {
					SmtCustom custom = new SmtCustom();
					Element ele = (Element) customIter.next();
					String type = ele.elementTextTrim("opType");
					if (StringUtils.isNotEmpty(type)) {
						custom.setOpType(type);
					} else {
						jsonArray.add("业务类型代码为空");
					}
					String decTin = ele.elementTextTrim("decTin");
					if (StringUtils.isNotEmpty(decTin)) {
						custom.setDecTin(decTin);
					}
					String decMode = ele.elementTextTrim("decMode");
					if (StringUtils.isNotEmpty(decMode)) {
						custom.setDecMode(decMode);
					} else {
						jsonArray.add("报关模式代码为空");
					}
					String checkSurety = ele.elementTextTrim("checkSurety");
					if (StringUtils.isNotEmpty(checkSurety)) {
						custom.setCheckSurety(checkSurety);
					}
					String billType = ele.elementTextTrim("billType");
					if (StringUtils.isNotEmpty(billType)) {
						custom.setBillType(billType);
					}
					String seqNo = ele.elementTextTrim("seqNo");
					if (StringUtils.isNotEmpty(seqNo)) {
						custom.setSeqNo(seqNo);
					}
					String preEntryId = ele.elementTextTrim("preEntryId");
					if (StringUtils.isNotEmpty(preEntryId)) {
						custom.setPreEntryId(preEntryId);
					}
					String entryId = ele.elementTextTrim("entryId");
					if (StringUtils.isNotEmpty(entryId)) {
						custom.setEntryId(entryId);
					}
					String iEPort = ele.elementTextTrim("iEPort");
					if (StringUtils.isNotEmpty(iEPort)) {
						custom.setIePort(iEPort);
					} else {
						jsonArray.add("出口口岸代码为空");
					}
					String contrNo = ele.elementTextTrim("contrNo");
					if (StringUtils.isNotEmpty(contrNo)) {
						custom.setContrNo(contrNo);
					}
					String iEDate = ele.elementTextTrim("iEDate");
					if (StringUtils.isNotEmpty(iEDate)) {
						custom.setIeDate(sdf.parse(iEDate));
					}
					String dDate = ele.elementTextTrim("dDate");
					if (StringUtils.isNotEmpty(dDate)) {
						custom.setDDate(sdf.parse(dDate));
					} else {
						jsonArray.add("申报日期为空");
					}
					String tradeCo = ele.elementTextTrim("tradeCo");
					if (StringUtils.isNotEmpty(tradeCo)) {
						custom.setTradeCo(tradeCo);
					} else {
						jsonArray.add("收发货人海关代码为空");
					}
					String tradeCoName = ele.elementTextTrim("tradeCoName");
					if (StringUtils.isNotEmpty(tradeCoName)) {
						custom.setTradeCoName(tradeCoName);
					} else {
						jsonArray.add("收发货人名称为空");
					}
					String coOwner = ele.elementTextTrim("coOwner");
					if (StringUtils.isNotEmpty(coOwner)) {
						custom.setCoOwner(coOwner);
					}
					String tradeCoscc = ele.elementTextTrim("tradeCoscc");
					if (StringUtils.isNotEmpty(tradeCoscc)) {
						custom.setTradeCoscc(tradeCoscc);
					}
					String ownerCode = ele.elementTextTrim("ownerCode");
					if (StringUtils.isNotEmpty(ownerCode)) {
						custom.setOwnerCode(ownerCode);
					} else {
						jsonArray.add("生产销售单位海关代码为空");
					}
					String ownerName = ele.elementTextTrim("ownerName");
					if (StringUtils.isNotEmpty(ownerName)) {
						custom.setOwnerName(ownerName);
					} else {
						jsonArray.add("生产销售单位名称为空");
					}
					String ownerCodeScc = ele.elementTextTrim("ownerCodeScc");
					if (StringUtils.isNotEmpty(ownerCodeScc)) {
						custom.setOwnerCodeScc(ownerCodeScc);
					}
					String agentCode = ele.elementTextTrim("agentCode");
					if (StringUtils.isNotEmpty(agentCode)) {
						custom.setAgentCode(agentCode);
					} else {
						jsonArray.add("申报单位海关代码为空");
					}
					String agentName = ele.elementTextTrim("agentName");
					if (StringUtils.isNotEmpty(agentName)) {
						custom.setAgentName(agentName);
					} else {
						jsonArray.add("申报单位名称为空");
					}
					String agentCodeScc = ele.elementTextTrim("agentCodeScc");
					if (StringUtils.isNotEmpty(agentCodeScc)) {
						custom.setAgentCodeScc(agentCodeScc);
					}
					String copCodeScc = ele.elementTextTrim("copCodeScc");
					if (StringUtils.isNotEmpty(copCodeScc)) {
						custom.setCopCodeScc(copCodeScc);
					}
					String trafMode = ele.elementTextTrim("trafMode");
					if (StringUtils.isNotEmpty(trafMode)) {
						custom.setTrafMode(trafMode);
					} else {
						jsonArray.add("运输方式代码为空");
					}
					String trafName = ele.elementTextTrim("trafName");
					if (StringUtils.isNotEmpty(trafName)) {
						custom.setTrafName(trafName);
					} else {
						jsonArray.add("运输工具名称为空");
					}
					String voyageNo = ele.elementTextTrim("voyageNo");
					if (StringUtils.isNotEmpty(voyageNo)) {
						custom.setVoyageNo(voyageNo);
					}
					String billNo = ele.elementTextTrim("billNo");
					if (StringUtils.isNotEmpty(billNo)) {
						custom.setBillNo(billNo);
					}
					String tradeMode = ele.elementTextTrim("tradeMode");
					if (StringUtils.isNotEmpty(tradeMode)) {
						custom.setTradeMode(tradeMode);
					} else {
						jsonArray.add("监管方式代码为空");
					}
					String cutMode = ele.elementTextTrim("cutMode");
					if (StringUtils.isNotEmpty(cutMode)) {
						custom.setCutMode(cutMode);
					}
					String paymentMark = ele.elementTextTrim("paymentMark");
					if (StringUtils.isNotEmpty(paymentMark)) {
						custom.setPaymentMark(paymentMark);
					}
					String licenseNo = ele.elementTextTrim("licenseNo");
					if (StringUtils.isNotEmpty(licenseNo)) {
						custom.setLicenseNo(licenseNo);
					}
					String tradeAreaCode = ele.elementTextTrim("tradeAreaCode");
					if (StringUtils.isNotEmpty(tradeAreaCode)) {
						custom.setTradeAreaCode(tradeAreaCode);
					} else {
						jsonArray.add("贸易国别代码为空");
					}
					String tradeCountry = ele.elementTextTrim("tradeCountry");
					if (StringUtils.isNotEmpty(tradeCountry)) {
						custom.setTradeCountry(tradeCountry);
					} else {
						jsonArray.add("抵运国代码为空");
					}
					String distinatePort = ele.elementTextTrim("distinatePort");
					if (StringUtils.isNotEmpty(distinatePort)) {
						custom.setDistinatePort(distinatePort);
					} else {
						jsonArray.add("抵运港代码为空");
					}
					String districtCode = ele.elementTextTrim("districtCode");
					if (StringUtils.isNotEmpty(districtCode)) {
						custom.setDistrictCode(districtCode);
					} else {
						jsonArray.add("境内货源地代码为空");
					}
					String apprNo = ele.elementTextTrim("apprNo");
					if (StringUtils.isNotEmpty(apprNo)) {
						custom.setApprNo(apprNo);
					} else {
						jsonArray.add("批准文号");
					}
					String promiseItems = ele.elementTextTrim("promiseItems");
					if (StringUtils.isNotEmpty(promiseItems)) {
						custom.setPromiseItems(promiseItems);
					}
					String transMode = ele.elementTextTrim("transMode");
					if (StringUtils.isNotEmpty(transMode)) {
						custom.setTransMode(transMode);
					} else {
						jsonArray.add("成交方式代码为空");
					}
					String feeMark = ele.elementTextTrim("feeMark");
					if (StringUtils.isNotEmpty(feeMark)) {
						custom.setFeeMark(feeMark);
					}
					String feeRate = ele.elementTextTrim("feeRate");
					if (StringUtils.isNotEmpty(feeRate)) {
						custom.setFeeRate(feeRate);
					}
					String feeCurr = ele.elementTextTrim("feeCurr");
					if (StringUtils.isNotEmpty(feeCurr)) {
						custom.setFeeCurr(feeCurr);
					}
					String insurMark = ele.elementTextTrim("insurMark");
					if (StringUtils.isNotEmpty(insurMark)) {
						custom.setInsurMark(insurMark);
					}
					String insurRate = ele.elementTextTrim("insurRate");
					if (StringUtils.isNotEmpty(insurRate)) {
						custom.setInsurRate(insurRate);
					}
					String insurCurr = ele.elementTextTrim("insurCurr");
					if (StringUtils.isNotEmpty(insurCurr)) {
						custom.setInsurCurr(insurCurr);
					}
					String otherMark = ele.elementTextTrim("otherMark");
					if (StringUtils.isNotEmpty(otherMark)) {
						custom.setOtherMark(otherMark);
					}
					String otherRate = ele.elementTextTrim("otherRate");
					if (StringUtils.isNotEmpty(otherRate)) {
						custom.setOtherRate(otherRate);
					}
					String otherCurr = ele.elementTextTrim("otherCurr");
					if (StringUtils.isNotEmpty(otherCurr)) {
						custom.setOtherCurr(otherCurr);
					}
					String packNo = ele.elementTextTrim("packNo");
					if (StringUtils.isNotEmpty(packNo)) {
						custom.setPackNo(packNo);
					}
					String wrapType = ele.elementTextTrim("wrapType");
					if (StringUtils.isNotEmpty(wrapType)) {
						custom.setWrapType(wrapType);
					} else {
						jsonArray.add("包装种类代码为空");
					}
					String grossWt = ele.elementTextTrim("grossWt");
					if (StringUtils.isNotEmpty(grossWt)) {
						custom.setGrossWt(grossWt);
					}
					String netWt = ele.elementTextTrim("netWt");
					if (StringUtils.isNotEmpty(netWt)) {
						custom.setNetWt(netWt);
					}
					String containerNum = ele.elementTextTrim("containerNum");
					if (StringUtils.isNotEmpty(containerNum)) {
						custom.setContainerNum(containerNum);
					}
					String certMark = ele.elementTextTrim("certMark");
					if (StringUtils.isNotEmpty(certMark)) {
						custom.setCertMark(certMark);
					}
					String copId = ele.elementTextTrim("copId");
					if (StringUtils.isNotEmpty(copId)) {
						custom.setCopId(copId);
					}
					String customMaster = ele.elementTextTrim("customMaster");
					if (StringUtils.isNotEmpty(customMaster)) {
						custom.setCustomMaster(customMaster);
					} else {
						jsonArray.add("申报地海关代码为空");
					}
					String relativeId = ele.elementTextTrim("relativeId");
					if (StringUtils.isNotEmpty(relativeId)) {
						custom.setRelativeId(relativeId);
					}
					String relativeManualNo = ele.elementTextTrim("relativeManualNo");
					if (StringUtils.isNotEmpty(relativeManualNo)) {
						custom.setRelativeManualNo(relativeManualNo);
					}
					String bondedNo = ele.elementTextTrim("bondedNo");
					if (StringUtils.isNotEmpty(bondedNo)) {
						custom.setBondedNo(bondedNo);
					}
					String customsField = ele.elementTextTrim("customsField");
					if (StringUtils.isNotEmpty(customsField)) {
						custom.setCustomsFieId(customsField);
					}
					String typistNo = ele.elementTextTrim("typistNo");
					if (StringUtils.isNotEmpty(typistNo)) {
						custom.setTypistNo(typistNo);
					}
					String bpNo = ele.elementTextTrim("bpNo");
					if (StringUtils.isNotEmpty(bpNo)) {
						custom.setBpNo(bpNo);
					}
					String entryType = ele.elementTextTrim("entryType");
					if (StringUtils.isNotEmpty(entryType)) {
						custom.setEntryType(entryType);
					}
					String noteS = ele.elementTextTrim("noteS");
					if (StringUtils.isNotEmpty(noteS)) {
						custom.setNoteS(noteS);
					}
					String createOrg = ele.elementTextTrim("createOrg");
					if (StringUtils.isNotEmpty(createOrg)) {
						custom.setCreateOrg(createOrg);
					} else {
						jsonArray.add("创建企业社会信用代码为空");
					}
					String ciqComp = ele.elementTextTrim("ciqComp");
					if (StringUtils.isNotEmpty(ciqComp)) {
						custom.setCiqComp(ciqComp);
					} else {
						jsonArray.add("报检企业社会信用代码为空");
					}
					String packComp = ele.elementTextTrim("packComp");
					if (StringUtils.isNotEmpty(packComp)) {
						custom.setPackComp(packComp);
					} else {
						jsonArray.add("货代企业社会信用代码为空");
					}
					String packWarehouse = ele.elementTextTrim("packWarehouse");
					if (StringUtils.isNotEmpty(packWarehouse)) {
						custom.setPackWarehouse(packWarehouse);
					}
					String djType = ele.elementTextTrim("type");
					if (StringUtils.isNotEmpty(djType)) {
						custom.setType(djType);
					}
					String chkSurety = ele.elementTextTrim("ChkSurety");
					if (StringUtils.isNotEmpty(chkSurety)) {
						custom.setChkSurety(chkSurety);
					}
					String checkFlow = ele.elementTextTrim("CheckFlow");
					if (StringUtils.isNotEmpty(checkFlow)) {
						custom.setCheckFlow(checkFlow);
					}
					String taxAaminMark = ele.elementTextTrim("TaxAaminMark");
					if (StringUtils.isNotEmpty(taxAaminMark)) {
						custom.setTaxAaminMark(taxAaminMark);
					}
					String markNo = ele.elementTextTrim("MarkNo");
					if (StringUtils.isNotEmpty(markNo)) {
						custom.setMarkNo(markNo);
					}
					String despPortCode = ele.elementTextTrim("DespPortCode");
					if (StringUtils.isNotEmpty(despPortCode)) {
						custom.setDespPortCode(despPortCode);
					}
					String entyPortCode = ele.elementTextTrim("EntyPortCode");
					if (StringUtils.isNotEmpty(entyPortCode)) {
						custom.setEntyPortCode(entyPortCode);
					}
					String goodsPlace = ele.elementTextTrim("GoodsPlace");
					if (StringUtils.isNotEmpty(goodsPlace)) {
						custom.setGoodsPlace(goodsPlace);
					}
					String blNo = ele.elementTextTrim("BLNo");
					if (StringUtils.isNotEmpty(blNo)) {
						custom.setBlNo(blNo);
					}
					String inspOrgCode = ele.elementTextTrim("InspOrgCode");
					if (StringUtils.isNotEmpty(inspOrgCode)) {
						custom.setInspOrgCode(inspOrgCode);
					}
					String specDeclFlag = ele.elementTextTrim("SpecDeclFlag");
					if (StringUtils.isNotEmpty(specDeclFlag)) {
						custom.setSpecDeclFalg(specDeclFlag);
					}
					String purpOrgCode = ele.elementTextTrim("PurpOrgCode");
					if (StringUtils.isNotEmpty(purpOrgCode)) {
						custom.setPurpOrgCode(purpOrgCode);
					}
					String despDate = ele.elementTextTrim("DespDate");
					if (StringUtils.isNotEmpty(despDate)) {
						custom.setDespDate(sdf.parse(despDate));
					}
					String cmplDschrgDt = ele.elementTextTrim("CmplDschrgDt");
					if (StringUtils.isNotEmpty(cmplDschrgDt)) {
						custom.setCmplDschrgDt(sdf.parse(cmplDschrgDt));
					}
					String correlationReasonFlag = ele.elementTextTrim("CorrelationReasonFlag");
					if (StringUtils.isNotEmpty(correlationReasonFlag)) {
						custom.setCorrelationReasonFlag(correlationReasonFlag);
					}
					String vsaOrgCode = ele.elementTextTrim("VsaOrgCode");
					if (StringUtils.isNotEmpty(vsaOrgCode)) {
						custom.setVsaOrgCode(vsaOrgCode);
					}
					String origBoxFlag = ele.elementTextTrim("OrigBoxFlag");
					if (StringUtils.isNotEmpty(origBoxFlag)) {
						custom.setOrigBoxFlag(origBoxFlag);
					}
					String noOtherPack = ele.elementTextTrim("NoOtherPack");
					if (StringUtils.isNotEmpty(noOtherPack)) {
						custom.setNoOtherPack(noOtherPack);
					}
					String orgCode = ele.elementTextTrim("OrgCode");
					if (StringUtils.isNotEmpty(orgCode)) {
						custom.setOrgCode(orgCode);
					}
					String overseasConsigneeCode = ele.elementTextTrim("OverseasConsigneeCode");
					if (StringUtils.isNotEmpty(overseasConsigneeCode)) {
						custom.setOverseasConsigneeCode(overseasConsigneeCode);
					}
					String overseasConsignorCname = ele.elementTextTrim("OverseasConsignorCname");
					if (StringUtils.isNotEmpty(overseasConsignorCname)) {
						custom.setOverseasConsignorCname(overseasConsignorCname);
					}
					String overseasConsigneeEname = ele.elementTextTrim("OverseasConsigneeEname");
					if (StringUtils.isNotEmpty(overseasConsigneeEname)) {
						custom.setOverseasConsigneeEname(overseasConsigneeEname);
					}
					String overseasConsignorAddr = ele.elementTextTrim("OverseasConsignorAddr");
					if (StringUtils.isNotEmpty(overseasConsignorAddr)) {
						custom.setOverseasConsignorAddr(overseasConsignorAddr);
					}
					String domesticConsigneeEname = ele.elementTextTrim("DomesticConsigneeEname");
					if (StringUtils.isNotEmpty(domesticConsigneeEname)) {
						custom.setDomesticConsigneeEname(domesticConsigneeEname);
					}
					String correlationNo = ele.elementTextTrim("CorrelationNo");
					if (StringUtils.isNotEmpty(correlationNo)) {
						custom.setCorrelationNo(correlationNo);
					}
					String consignorCode = ele.elementTextTrim("ConsignorCode");
					if (StringUtils.isNotEmpty(consignorCode)) {
						custom.setConsignorCode(consignorCode);
					}
					String ownerCiqCode = ele.elementTextTrim("OwnerCiqCode");
					if (StringUtils.isNotEmpty(ownerCiqCode)) {
						custom.setOwnereCiqCode(ownerCiqCode);
					}
					String declRegNo = ele.elementTextTrim("DeclRegNo");
					if (StringUtils.isNotEmpty(declRegNo)) {
						custom.setDeclRegNo(declRegNo);
					}
					Iterator containerList = ele.elementIterator("ContainerList");
					while (containerList.hasNext()) {
						Element containerEle = (Element) containerList.next();
					}
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
			jsonArray.add("数据日期格式有误");
			json.put("msg", jsonArray);
			json.put("status", false);
			return json.toString();
		}
	}
}
