package com.smt.market.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.smt.common.config.Global;
import com.smt.common.support.Convert;
import com.smt.common.utils.DateUtils;
import com.smt.common.utils.StringUtils;
import com.smt.market.domain.SmtCompany;
import com.smt.market.domain.SmtCompanyProducer;
import com.smt.market.domain.SmtProducer;
import com.smt.market.mapper.SmtCompanyMapper;
import com.smt.market.mapper.SmtCompanyProducerMapper;
import com.smt.market.mapper.SmtProducerMapper;
import com.smt.market.service.ISmtProducerService;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * 生产商 服务层实现
 * 
 * @author smt
 * @date 2019-09-23
 */
@Service
public class SmtProducerServiceImpl implements ISmtProducerService
{
	@Autowired
	private SmtProducerMapper smtProducerMapper;

	@Autowired
	private SmtCompanyMapper companyMapper;

	@Autowired
	private SmtCompanyProducerMapper companyProducerMapper;

	@Autowired
	private SubjectIntFaceFacadeImpl subjectIntFaceFacade;

	private static final Logger log = LoggerFactory.getLogger(SmtProducerServiceImpl.class);

	/**
     * 查询生产商信息
     * 
     * @param producerId 生产商ID
     * @return 生产商信息
     */
    @Override
	public SmtProducer selectSmtProducerById(Integer producerId)
	{
	    return smtProducerMapper.selectSmtProducerById(producerId);
	}
	
	/**
     * 查询生产商列表
     * 
     * @param smtProducer 生产商信息
     * @return 生产商集合
     */
	@Override
	public List<SmtProducer> selectSmtProducerList(SmtProducer smtProducer)
	{
	    return smtProducerMapper.selectSmtProducerList(smtProducer);
	}
	
    /**
     * 新增生产商
     * 
     * @param smtProducer 生产商信息
     * @return 结果
     */
	@Override
	public int insertSmtProducer(SmtProducer smtProducer)
	{
	    return smtProducerMapper.insertSmtProducer(smtProducer);
	}
	
	/**
     * 修改生产商
     * 
     * @param smtProducer 生产商信息
     * @return 结果
     */
	@Override
	public int updateSmtProducer(SmtProducer smtProducer)
	{
	    return smtProducerMapper.updateSmtProducer(smtProducer);
	}

	/**
     * 删除生产商对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSmtProducerByIds(String ids)
	{
		return smtProducerMapper.deleteSmtProducerByIds(Convert.toStrArray(ids));
	}

	@Override
	public void insertCompanyProducer(SmtCompany company, SmtProducer producer) {
		SmtCompanyProducer companyProducer = new SmtCompanyProducer();
		companyProducer.setCompanyId(company.getCompanyId());
		companyProducer.setProducerId(producer.getProducerId());
		companyProducerMapper.insertSmtCompanyProducer(companyProducer);
	}

	@Override
	public String insert(Iterator iterator) {
		JSONArray jsonArray = new JSONArray();
		JSONObject json = new JSONObject();
		if (iterator.hasNext()) {
			Element element = (Element) iterator.next();
			Iterator manufacturerList = element.elementIterator("ManufacturerList");
			if (manufacturerList.hasNext()) {
				SmtProducer producer = new SmtProducer();
				SmtCompany company = new SmtCompany();
				Element manufacturerEle = (Element) manufacturerList.next();
				String corpCode = manufacturerEle.elementTextTrim("corpCode");
				if (StringUtils.isNotEmpty(corpCode)) {
					producer.setCorpCode(corpCode);
				} else {
					jsonArray.add("组织机构代码为空");
				}
				String corpCname = manufacturerEle.elementTextTrim("corpCname");
				if (StringUtils.isNotEmpty(corpCname)) {
					producer.setCorpCname(corpCname);
				} else {
					jsonArray.add("中文名称为空");
				}
				String companyType = manufacturerEle.elementTextTrim("companyType");
				if (StringUtils.isNotEmpty(companyType)) {
					producer.setCompanyType(companyType);
				}
				String contractMan = manufacturerEle.elementTextTrim("contractMan");
				if (StringUtils.isNotEmpty(contractMan)) {
					producer.setContractMan(contractMan);
				}
				String identCode = manufacturerEle.elementTextTrim("identCode");
				if (StringUtils.isNotEmpty(identCode)) {
					producer.setIdentCode(identCode);
				}
				String telno = manufacturerEle.elementTextTrim("telno");
				if (StringUtils.isNotEmpty(telno)) {
					producer.setTelno(telno);
				}
				String caddress = manufacturerEle.elementTextTrim("caddress");
				if (StringUtils.isNotEmpty(caddress)) {
					producer.setCaddress(caddress);
				}
				String createOrg = manufacturerEle.elementTextTrim("createOrg");
				if (StringUtils.isNotEmpty(createOrg)) {
					company = companyMapper.selectSmtCompanyBySgsRegCode(createOrg);
					if (company == null) {
						jsonArray.add("创建企业编码不存在");
					}
				} else {
					jsonArray.add("创建企业编码为空");
				}
				if (jsonArray.size() > 0) {
					json.put("status", false);
					json.put("msg", jsonArray);
					return json.toString();
				} else {
					String response = execProducer("A", producer, company.getSgsRegCode());
					JSONObject repJson = JSONObject.parseObject(response);
					if (repJson.getBoolean("status")) {
						SmtProducer smtProducer = smtProducerMapper.selectSmtProducerByCorpCode(producer.getCorpCode());
						if (smtProducer != null) {
							smtProducerMapper.updateSmtProducer(producer);
						} else {
							smtProducerMapper.insertSmtProducer(producer);
							insertCompanyProducer(company, producer);
						}
					} else {
						if (response.contains("私有数据已存在不需要新建")) {
							SmtProducer smtProducer = smtProducerMapper.selectSmtProducerByCorpCode(producer.getCorpCode());
							if (smtProducer != null) {
								smtProducerMapper.updateSmtProducer(producer);
							} else {
								smtProducerMapper.insertSmtProducer(producer);
								insertCompanyProducer(company, producer);
							}
						}
					}
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

	/**
	 * 生产商备案
	 * @param opType
	 * @param producer
	 * @param createOrg
	 * @return
	 */
	@Override
	public String execProducer(String opType, SmtProducer producer, String createOrg) {
		JSONArray jsonArray = new JSONArray();
		JSONObject json = new JSONObject();
		String mafXmlStr = getMafXmlStr(opType, producer, createOrg);
		String response = subjectIntFaceFacade.sendDeclaration(Global.getCorpCode(), Global.getCorpName(), Global.getLoginCode(), Global.getLoginPassWord(), mafXmlStr);
		log.info(response);
		if (StringUtils.isEmpty(response)) {
			jsonArray.add("市场采购贸易系统未返回回执");
			json.put("status", false);
			json.put("msg", jsonArray);
			return json.toString();
		}
		JSONObject repJSON = JSONObject.parseObject(response);
		if (StringUtils.isNotEmpty(repJSON.get("errorMessage").toString())) {
			if (response.contains("私有数据已存在不需要新建")) {
				jsonArray.add("私有数据已存在不需要新建");
				json.put("status", false);
				json.put("msg", jsonArray);
				return json.toString();
			} else {
				json.put("status", false);
				json.put("msg", repJSON.get("errorMessage"));
				return json.toString();
			}
		}
		jsonArray.add("发送成功");
		json.put("status", true);
		json.put("msg", jsonArray);
		return json.toString();
	}

	/**
	 * 生产商备案报文
	 * @param opType
	 * @param producer
	 * @param createOrg
	 * @return
	 */
	public String getMafXmlStr(String opType, SmtProducer producer, String createOrg){
		int num=(int)(Math.random()*9000)+1000;
		String messageId = "MAF_"+createOrg+"_"+DateUtils.dateTimeNow()+""+num;
		StringBuilder mafXmlStr = new StringBuilder();
		mafXmlStr.append("<?xml version='1.0' encoding='utf-8'?>\n");
		mafXmlStr.append("<SubjectInfo>\n");
		mafXmlStr.append("<Head>\n");
		mafXmlStr.append("<MessageId>"+messageId+"</MessageId>\n");
		mafXmlStr.append(" <MessageType>MAF</MessageType>\n");
		mafXmlStr.append(" <Sender>"+createOrg+"</Sender>\n");
		mafXmlStr.append(" <Receiver>GZSW</Receiver>\n");
		mafXmlStr.append(" <opType>"+opType+"</opType>\n");
		mafXmlStr.append("</Head>\n");
		mafXmlStr.append("<Declaration>\n");
		mafXmlStr.append("<ManufacturerList>\n");
		mafXmlStr.append("<Manufacturer>\n");
		mafXmlStr.append(" <corpCode>"+(producer.getCorpCode()==null?"":producer.getCorpCode())+"</corpCode>\n");
		mafXmlStr.append(" <corpCname>"+(producer.getCorpCname()==null?"":producer.getCorpCname())+"</corpCname>\n");
		mafXmlStr.append(" <corpEname>"+(producer.getCorpEname()==null?"":producer.getCorpEname())+"</corpEname>\n");
		mafXmlStr.append(" <companyType>"+(producer.getCompanyType()==null?"":producer.getCompanyType())+"</companyType>\n");
		mafXmlStr.append(" <contractMan>"+(producer.getContractMan()==null?"":producer.getContractMan())+"</contractMan>\n");
		mafXmlStr.append(" <identCode>"+(producer.getIdentCode()==null?"":producer.getIdentCode())+"</identCode>\n");
		mafXmlStr.append(" <telno>"+(producer.getTelno()==null?"":producer.getTelno())+"</telno>\n");
		mafXmlStr.append(" <caddress>"+(producer.getCaddress()==null?"":producer.getCaddress())+"</caddress>\n");
		mafXmlStr.append(" <createOrg>"+(createOrg==null?"":createOrg)+"</createOrg>\n");
		mafXmlStr.append("</Manufacturer>\n");
		mafXmlStr.append("</ManufacturerList>\n");
		mafXmlStr.append("</Declaration>\n");
		mafXmlStr.append("</SubjectInfo>");
		return mafXmlStr.toString();
	}

}
