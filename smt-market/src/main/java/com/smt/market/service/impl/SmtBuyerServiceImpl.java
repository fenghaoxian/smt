package com.smt.market.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.smt.common.config.Global;
import com.smt.common.support.Convert;
import com.smt.common.utils.DateUtils;
import com.smt.common.utils.StringUtils;
import com.smt.market.domain.SmtBuyer;
import com.smt.market.domain.SmtCompany;
import com.smt.market.domain.SmtCompanyBuyer;
import com.smt.market.mapper.SmtBuyerMapper;
import com.smt.market.mapper.SmtCompanyBuyerMapper;
import com.smt.market.mapper.SmtCompanyMapper;
import com.smt.market.service.ISmtBuyerService;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

/**
 * 采购商 服务层实现
 * 
 * @author smt
 * @date 2019-10-14
 */
@Service
public class SmtBuyerServiceImpl implements ISmtBuyerService 
{
	@Autowired
	private SmtBuyerMapper smtBuyerMapper;

	@Autowired
	private SmtCompanyMapper companyMapper;

	@Autowired
	private SmtCompanyBuyerMapper companyBuyerMapper;

	@Autowired
	private SubjectIntFaceFacadeImpl subjectIntFaceFacade;

	/**
     * 查询采购商信息
     * 
     * @param buyerId 采购商ID
     * @return 采购商信息
     */
    @Override
	public SmtBuyer selectSmtBuyerById(Integer buyerId)
	{
	    return smtBuyerMapper.selectSmtBuyerById(buyerId);
	}

	@Override
	public SmtBuyer selectSmtBuyerByCorpCode(String corpCode) {
    	return smtBuyerMapper.selectSmtBuyerBycorpCode(corpCode);
	}

	/**
     * 查询采购商列表
     * 
     * @param smtBuyer 采购商信息
     * @return 采购商集合
     */
	@Override
	public List<SmtBuyer> selectSmtBuyerList(SmtBuyer smtBuyer)
	{
	    return smtBuyerMapper.selectSmtBuyerList(smtBuyer);
	}
	
    /**
     * 新增采购商
     * 
     * @param smtBuyer 采购商信息
     * @return 结果
     */
	@Override
	public int insertSmtBuyer(SmtBuyer smtBuyer)
	{
	    return smtBuyerMapper.insertSmtBuyer(smtBuyer);
	}
	
	/**
     * 修改采购商
     * 
     * @param smtBuyer 采购商信息
     * @return 结果
     */
	@Override
	public int updateSmtBuyer(SmtBuyer smtBuyer)
	{
	    return smtBuyerMapper.updateSmtBuyer(smtBuyer);
	}

	/**
     * 删除采购商对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSmtBuyerByIds(String ids)
	{
		return smtBuyerMapper.deleteSmtBuyerByIds(Convert.toStrArray(ids));
	}

	@Override
	public void insertCompanyBuyer(SmtBuyer buyer, SmtCompany company) {
		SmtCompanyBuyer companyBuyer = new SmtCompanyBuyer();
		companyBuyer.setBuyerId(buyer.getBuyerId());
		companyBuyer.setCompanyId(company.getCompanyId());
		companyBuyerMapper.insertSmtCompanyBuyer(companyBuyer);
	}

	@Override
	public String insert(Iterator iterator) {
		JSONArray jsonArray = new JSONArray();
		JSONObject json = new JSONObject();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		if (iterator.hasNext()) {
			Element element = (Element) iterator.next();
			Iterator buyersListIter = element.elementIterator("BuyersList");
			if (buyersListIter.hasNext()) {
				SmtBuyer buyer = new SmtBuyer();
				SmtCompany company = new SmtCompany();
				Element buyerEle = (Element) buyersListIter.next();
				String corpCode = buyerEle.elementTextTrim("corpCode");
				if (StringUtils.isNotEmpty(corpCode)) {
					buyer.setCorpCode(corpCode);
				} else {
					jsonArray.add("证件号为空");
				}
				String corpCname = buyerEle.elementTextTrim("corpCname");
				if (StringUtils.isNotEmpty(corpCname)) {
					buyer.setCorpCName(corpCname);
				} else {
					jsonArray.add("采购商名称为空");
				}
				String companyType = buyerEle.elementTextTrim("companyType");
				if (StringUtils.isNotEmpty(companyType)) {
					buyer.setCompanyType(companyType);
				}
				String contractMan = buyerEle.elementTextTrim("contractMan");
				if (StringUtils.isNotEmpty(contractMan)) {
					buyer.setContractMan(contractMan);
				}
				String finvest1 = buyerEle.elementTextTrim("finvest1");
				if (StringUtils.isNotEmpty(finvest1)) {
					buyer.setFinvest1(finvest1);
				}
				String telno = buyerEle.elementTextTrim("telno");
				if (StringUtils.isNotEmpty(telno)) {
					buyer.setTelno(telno);
				}
				String address = buyerEle.elementTextTrim("address");
				if (StringUtils.isNotEmpty(address)) {
					buyer.setAddress(address);
				}
				String createOrg = buyerEle.elementTextTrim("createOrg");
				if (StringUtils.isNotEmpty(createOrg)) {
					company = companyMapper.selectSmtCompanyBySgsRegCode(createOrg);
				} else {
					jsonArray.add("创建企业编码为空");
				}
				String response = execBuyer("A", buyer, company.getSgsRegCode());
				JSONObject repJSON = JSONObject.parseObject(response);
				if (repJSON.getBoolean("status") || response.contains("私有数据已存在不需要新建")) {
					SmtBuyer smtBuyer = selectSmtBuyerByCorpCode(buyer.getCorpCode());
					if (smtBuyer != null) {
						buyer.setBuyerId(smtBuyer.getBuyerId());
						this.updateSmtBuyer(buyer);
					} else {
						this.insertSmtBuyer(buyer);
						this.insertCompanyBuyer(buyer, company);
					}
					return response;
				} else {
					return response;
				}
			} else {
				jsonArray.add("报文信息有误");
				json.put("status", false);
				json.put("msg", jsonArray);
				return json.toString();
			}
		} else {
			jsonArray.add("报文信息有误");
			json.put("status", false);
			json.put("msg", jsonArray);
			return json.toString();
		}
	}

	public String execBuyer(String opType, SmtBuyer buyer, String createOrg) {
		JSONArray jsonArray = new JSONArray();
		JSONObject json = new JSONObject();
		json.put("status", true);
		String buyerXmlStr = this.getBuyerXmlStr(opType, buyer, createOrg);
		String response = subjectIntFaceFacade.sendDeclaration(Global.getCorpCode(), Global.getCorpName(), Global.getLoginCode(), Global.getLoginPassWord(), buyerXmlStr);
		if (StringUtils.isEmpty(response)) {
			jsonArray.add("市场采购贸易系统未返回回执");
			json.put("status", false);
			json.put("msg", jsonArray);
			return json.toString();
		}
		JSONObject repJson = JSONObject.parseObject(response);
		if (StringUtils.isNotEmpty(repJson.get("errorMessage").toString())) {
			json.put("status", false);
			json.put("msg", repJson.get("errorMessage"));
			return json.toString();
		}
		json.put("msg", repJson.get("otherMessage"));
		return json.toString();
	}

	/**
	 * 采购商备案报文
	 * @param opType
	 * @param buyer
	 * @return
	 */
	public String getBuyerXmlStr(String opType, SmtBuyer buyer, String createOrg) {
		int num=(int)(Math.random()*9000)+1000;
		String messageId = "BUYER_"+createOrg+"_"+DateUtils.dateTimeNow()+""+num;
		StringBuilder buyerXmlStr = new StringBuilder();
		buyerXmlStr.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		buyerXmlStr.append("<SubjectInfo>\n");
		buyerXmlStr.append("<Head>\n");
		buyerXmlStr.append(" <MessageId>"+messageId+"</MessageId>\n");
		buyerXmlStr.append(" <MessageType>BUYER</MessageType>\n");
		buyerXmlStr.append(" <Sender>"+createOrg+"</Sender>\n");
		buyerXmlStr.append(" <Receiver>GZSW</Receiver>\n");
		buyerXmlStr.append(" <opType>"+opType+"</opType>\n");
		buyerXmlStr.append("</Head>\n");
		buyerXmlStr.append("<Declaration>\n");
		buyerXmlStr.append("<BuyerList>\n");
		buyerXmlStr.append("<Buyer>\n");
		buyerXmlStr.append(" <corpCode>"+(buyer.getCorpCode()==null?"":buyer.getCorpCode())+"</corpCode>\n");
		buyerXmlStr.append(" <corpCname>"+(buyer.getCorpCName()==null?"":buyer.getCorpCName())+"</corpCname>\n");
		buyerXmlStr.append(" <companyType>"+(buyer.getCompanyType()==null?"":buyer.getCompanyType())+"</companyType>\n");
		buyerXmlStr.append(" <contractMan>"+(buyer.getContractMan()==null?"":buyer.getContractMan())+"</contractMan>\n");
		buyerXmlStr.append(" <finvest1>"+(buyer.getFinvest1()==null?"":buyer.getFinvest1())+"</finvest1>\n");
		buyerXmlStr.append(" <telno>"+(buyer.getTelno()==null?"":buyer.getTelno())+"</telno>\n");
		buyerXmlStr.append(" <address>"+(buyer.getAddress()==null?"":buyer.getAddress())+"</address>\n");
		buyerXmlStr.append(" <createOrg>"+(createOrg==null?"":createOrg)+"</createOrg>\n");
		buyerXmlStr.append("</Buyer>\n");
		buyerXmlStr.append("</BuyerList>\n");
		buyerXmlStr.append("</Declaration>\n");
		buyerXmlStr.append("</SubjectInfo>");
		return buyerXmlStr.toString();
	}

}
