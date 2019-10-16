package com.smt.market.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.smt.common.config.Global;
import com.smt.common.support.Convert;
import com.smt.common.utils.DateUtils;
import com.smt.common.utils.DesEcrypt;
import com.smt.common.utils.StringUtils;
import com.smt.common.utils.SymmetricEncoder;
import com.smt.market.domain.SmtMarketUser;
import com.smt.market.mapper.SmtMarketUserMapper;
import com.smt.market.service.ISmtMarketUserService;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 委托关系 服务层实现
 * 
 * @author smt
 * @date 2019-10-16
 */
@Service
public class SmtMarketUserServiceImpl implements ISmtMarketUserService 
{
	@Autowired
	private SmtMarketUserMapper smtMarketUserMapper;

	@Autowired
	private SubjectIntFaceFacadeImpl subjectIntFaceFacade;

	/**
     * 查询委托关系信息
     * 
     * @param marketId 委托关系ID
     * @return 委托关系信息
     */
    @Override
	public SmtMarketUser selectSmtMarketUserById(Integer marketId)
	{
	    return smtMarketUserMapper.selectSmtMarketUserById(marketId);
	}
	
	/**
     * 查询委托关系列表
     * 
     * @param smtMarketUser 委托关系信息
     * @return 委托关系集合
     */
	@Override
	public List<SmtMarketUser> selectSmtMarketUserList(SmtMarketUser smtMarketUser)
	{
	    return smtMarketUserMapper.selectSmtMarketUserList(smtMarketUser);
	}
	
    /**
     * 新增委托关系
     * 
     * @param smtMarketUser 委托关系信息
     * @return 结果
     */
	@Override
	public int insertSmtMarketUser(SmtMarketUser smtMarketUser)
	{
	    return smtMarketUserMapper.insertSmtMarketUser(smtMarketUser);
	}
	
	/**
     * 修改委托关系
     * 
     * @param smtMarketUser 委托关系信息
     * @return 结果
     */
	@Override
	public int updateSmtMarketUser(SmtMarketUser smtMarketUser)
	{
	    return smtMarketUserMapper.updateSmtMarketUser(smtMarketUser);
	}

	/**
     * 删除委托关系对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSmtMarketUserByIds(String ids)
	{
		return smtMarketUserMapper.deleteSmtMarketUserByIds(Convert.toStrArray(ids));
	}

	public String execClientage(Iterator iterator) {
		JSONArray jsonArray = new JSONArray();
		JSONObject json = new JSONObject();
		List<SmtMarketUser> marketUserList = new ArrayList<>();
		if (iterator.hasNext()) {
			Element element = (Element) iterator.next();
			Iterator clientage = element.elementIterator("ClientageList");
			if (clientage.hasNext()) {
				while (clientage.hasNext()) {
					SmtMarketUser marketUser = new SmtMarketUser();
					Element ele = (Element) clientage.next();
					String sgsRegCode = ele.elementTextTrim("sgsRegCode");
					if (StringUtils.isNotEmpty(sgsRegCode)) {
						marketUser.setSgsRegCode(sgsRegCode);
					} else {
						jsonArray.add("统一社会信用代码为空");
					}
					String corpName = ele.elementTextTrim("corpName");
					if (StringUtils.isNotEmpty(corpName)) {
						marketUser.setCorpName(corpName);
					} else {
						jsonArray.add("委托企业名称为空");
					}
					String loginName = ele.elementTextTrim("loginName");
					if (StringUtils.isNotEmpty(loginName)) {
						marketUser.setLoginName(loginName);
					} else {
						jsonArray.add("委托企业登录名为空");
					}
					String loginPassWord = ele.elementTextTrim("loginPassWord");
					if (StringUtils.isNotEmpty(loginPassWord)) {
						marketUser.setLoginPassword(loginPassWord);
					} else {
						jsonArray.add("委托企业登录密码为空");
					}
					if (jsonArray.size() > 0) {
						json.put("status", false);
						json.put("msg", jsonArray);
						return json.toString();
					}
					marketUserList.add(marketUser);
				}
				String clientageXml = getClientageXml(marketUserList);
				String response = subjectIntFaceFacade.sendDeclaration(Global.getCorpCode(), Global.getCorpName(), Global.getLoginCode(), Global.getLoginPassWord(), clientageXml);
				JSONObject repJson = JSONObject.parseObject(response);
				if (repJson.getInteger("status") == 1) {
					json.put("status", true);
					json.put("msg", jsonArray.add("发送成功"));
					for (SmtMarketUser marketUser : marketUserList) {
						smtMarketUserMapper.insertSmtMarketUser(marketUser);
					}
					return json.toString();
				} else {
					json.put("status", false);
					json.put("msg", jsonArray.add("发送失败"));
					return json.toString();
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

	public String getClientageXml(List<SmtMarketUser> list) {
		DesEcrypt asd =new DesEcrypt();
		StringBuffer sb = new StringBuffer();
		try {
			int num=(int)(Math.random()*9000)+1000;
			String messageId = "CLIENTAGE_"+Global.getCorpCode()+"_"+DateUtils.dateTimeNow()+""+num;
			sb.append("<?xml version='1.0' encoding='utf-8'?>\n");
			sb.append("<SubjectInfo>\n");
			sb.append("<Head>\n");
			sb.append("  <opType>A</opType>\n");
			sb.append("  <MessageId>").append(messageId).append("</MessageId>\n");
			sb.append("  <MessageType>CLIENTAGE</MessageType>\n");
			sb.append("  <Sender>").append(Global.getCorpCode()).append("</Sender>\n");
			sb.append("  <Receiver>GZSW</Receiver>\n");
			sb.append("</Head>\n");
			sb.append("<Declaration>\n");
			sb.append("	 <Clientage>\n");
			sb.append("  <sgsRegCode>").append(Global.getConfig("trade.corpCode")).append("</sgsRegCode>\n");
			sb.append("  <corpName>").append(Global.getConfig("trade.corpName")).append("</corpName>\n");
			sb.append("  <loginName>").append(asd.EncryStrHex(asd.GB2Code(Global.getConfig("trade.loginCode")), "GZMARKET2017")).append("</loginName>\n");
			sb.append("  <loginPassWord>").append(asd.EncryStrHex(asd.GB2Code(Global.getConfig("trade.loginPassWord")), "GZMARKET2017")).append("</loginPassWord>\n");
			sb.append("  <ClientageList>\n");
			for (SmtMarketUser marketUser : list) {
				sb.append("  <ClientageDetail>\n");
				sb.append("  <sgsRegCode>").append(marketUser.getSgsRegCode()).append("</sgsRegCode>\n");
				sb.append("  <corpName>").append(marketUser.getCorpName()).append("</corpName>\n");
				sb.append("  <loginName>").append(asd.EncryStrHex(asd.GB2Code(marketUser.getLoginName()), "GZMARKET2017")).append("</loginName>\n");
				sb.append("  <loginPassWord>").append(asd.EncryStrHex(asd.GB2Code(SymmetricEncoder.AES_Decrypt("gz201988i1039com", marketUser.getLoginPassword())), "GZMARKET2017")).append("</loginPassWord>\n");
				sb.append("  </ClientageDetail>\n");
			}
			sb.append("  </ClientageList>\n");
			sb.append("  </Clientage>\n");
			sb.append("</Declaration>\n");
			sb.append("</SubjectInfo>\n");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
