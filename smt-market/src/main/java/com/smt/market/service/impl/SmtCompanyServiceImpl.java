package com.smt.market.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.smt.common.config.Global;
import com.smt.common.support.Convert;
import com.smt.common.utils.DateUtils;
import com.smt.common.utils.Md5Utils;
import com.smt.common.utils.StringUtils;
import com.smt.common.utils.SymmetricEncoder;
import com.smt.market.domain.SmtCompany;
import com.smt.market.mapper.SmtCompanyMapper;
import com.smt.market.service.ISmtCompanyService;
import com.smt.system.domain.SysRole;
import com.smt.system.domain.SysUser;
import com.smt.system.service.impl.SysRoleServiceImpl;
import com.smt.system.service.impl.SysUserServiceImpl;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 企业 服务层实现
 * 
 * @author smt
 * @date 2019-09-06
 */
@Service
public class SmtCompanyServiceImpl implements ISmtCompanyService 
{
	@Autowired
	private SmtCompanyMapper smtCompanyMapper;

	@Autowired
	private SysRoleServiceImpl roleService;

	@Autowired
	private SysUserServiceImpl userService;

	@Autowired
    private SubjectIntFaceFacadeImpl subjectIntFaceFacade;

    private static final Logger log = LoggerFactory.getLogger(SmtCompanyServiceImpl.class);

	private SmtCompany company;

	/**
     * 查询企业信息
     * 
     * @param companyId 企业ID
     * @return 企业信息
     */
    @Override
	public SmtCompany selectSmtCompanyById(Integer companyId)
	{
	    return smtCompanyMapper.selectSmtCompanyById(companyId);
	}

	public SmtCompany selectSmtCompanyBySgsRegCode(String sgsRegCode) {
        return smtCompanyMapper.selectSmtCompanyBySgsRegCode(sgsRegCode);
    }
	
	/**
     * 查询企业列表
     * 
     * @param smtCompany 企业信息
     * @return 企业集合
     */
	@Override
	public List<SmtCompany> selectSmtCompanyList(SmtCompany smtCompany)
	{
	    return smtCompanyMapper.selectSmtCompanyList(smtCompany);
	}
	
    /**
     * 新增企业
     * 
     * @param smtCompany 企业信息
     * @return 结果
     */
	@Override
	public int insertSmtCompany(SmtCompany smtCompany)
	{
	    return smtCompanyMapper.insertSmtCompany(smtCompany);
	}
	
	/**
     * 修改企业
     * 
     * @param smtCompany 企业信息
     * @return 结果
     */
	@Override
	public int updateSmtCompany(SmtCompany smtCompany)
	{
	    return smtCompanyMapper.updateSmtCompany(smtCompany);
	}

	/**
     * 删除企业对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSmtCompanyByIds(String ids)
	{
		return smtCompanyMapper.deleteSmtCompanyByIds(Convert.toStrArray(ids));
	}

	@Override
	public String insert(Iterator iterator, String opType) {
        JSONArray jsonArray = new JSONArray();
        JSONObject json = new JSONObject();
		SmtCompany company = new SmtCompany();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        SysUser user = new SysUser();
		if (iterator.hasNext()) {
			Element element = (Element) iterator.next();
			Iterator companyIter = element.elementIterator("Company");
			if (companyIter.hasNext()) {
				Element ele = (Element) companyIter.next();
				String username = ele.elementTextTrim("username");
				String password = ele.elementText("password");
				password = SymmetricEncoder.AES_Decrypt(password, "gz201988i1039com");
				if (username != null && !"".equals(username) && password != null && !"".equals(password)) {
                    user.setLoginName(username);
                    user.setSalt(Md5Utils.randomSalt());
                    user.setPassword(new Md5Hash(username + password + user.getSalt()).toHex().toString());
                    user.setDeptId((long)202);
                    user.setCreateBy("admin");
                    user.setCreateTime(DateUtils.getNowDate());
                    ArrayList<SysRole> list = new ArrayList<>();
                    String characters = ele.elementTextTrim("characters");
                    if (characters != null && !"".equals(characters)) {
                        String[] split = characters.split(",");
                        SysRole sysRole;
                        for (String s : split) {
                            if ("1".equals(s)) {
                                sysRole = roleService.selectRoleById((long) 100);
                                list.add(sysRole);
                            } else if ("9".equals(s)) {
                                sysRole = roleService.selectRoleById((long) 101);
                                list.add(sysRole);
                            } else if ("2".equals(s)) {
                                sysRole = roleService.selectRoleById((long) 103);
                                list.add(sysRole);
                            } else if ("5".equals(s)) {
                                sysRole = roleService.selectRoleById((long) 102);
                                list.add(sysRole);
                            } else if ("4".equals(s)) {
                                sysRole = roleService.selectRoleById((long) 104);
                                list.add(sysRole);
                            }
                        }
                    } else {
                        jsonArray.add("角色字段为空");
                        json.put("status", false);
                        json.put("msg", jsonArray);
                        return json.toString();
                    }
                    user.setRoles(list);
                } else {
				    jsonArray.add("平台用户名或密码为空");
				    json.put("status", false);
				    json.put("msg", jsonArray);
				    return json.toString();
                }

				String sgsRegCode = ele.elementTextTrim("sgsRegCode");
				if (sgsRegCode != null && !"".equals(sgsRegCode)) {
					company.setSgsRegCode(sgsRegCode);
				}
				String corpCname = ele.elementTextTrim("corpCname");
				if (corpCname != null && !"".equals(corpCname)) {
					company.setCorpCname(corpCname);
				}
				String corpEname = ele.elementTextTrim("corpEname");
				company.setCorpEname(corpEname);
				String corpShortName = ele.elementTextTrim("corpShortName");
				if (corpShortName != null && !"".equals(corpShortName)) {
					company.setCorpShortName(corpShortName);
				}
				String corpOrgCode = ele.elementTextTrim("corpOrgCode");
				if (corpOrgCode != null && !"".equals(corpOrgCode)) {
					company.setCorpOrgCode(corpOrgCode);
				}
				String corpType = ele.elementTextTrim("corpType");
				if (corpType != null && !"".equals(corpType)) {
					company.setCorpType(corpType);
				}
				String characters = ele.elementTextTrim("characters");
				if (characters != null && !"".equals(characters)) {
					company.setCharacters(characters);
				}
				String legalName = ele.elementTextTrim("legalName");
				if (legalName != null && !"".equals(legalName)) {
					company.setLegalName(legalName);
				}
				String identCode = ele.elementTextTrim("identCode");
				if (identCode != null && !"".equals(identCode)) {
					company.setIdentCode(identCode);
				}
				String legalIdCode = ele.elementTextTrim("legalIdCode");
				if (legalIdCode != null && !"".equals(legalIdCode)) {
					company.setIdentIdCode(legalIdCode);
				}
				String contractMan = ele.elementTextTrim("contractMan");
                if (contractMan != null &&!"".equals(contractMan)) {
                    company.setContractMan(contractMan);
                }

                String loginUserName = ele.elementTextTrim("loginUserName");

                String cellphoneNo = ele.elementTextTrim("cellphoneNo");
                if (cellphoneNo != null && !"".equals(cellphoneNo)) {
                    company.setCellPhoneNo(cellphoneNo);
                }
                String email = ele.elementTextTrim("email");
                company.setEmail(email);
                String wisdomCheckNo = ele.elementTextTrim("wisdomCheckNo");
                company.setWisdomCheckNo(wisdomCheckNo);
                String faxNo = ele.elementTextTrim("faxNo");
                company.setFaxNo(faxNo);
                String postCode = ele.elementTextTrim("postCode");
                company.setPostCode(postCode);
                String caddress = ele.elementTextTrim("caddress");
                if (caddress != null && !"".equals(caddress)) {
                    company.setCaddress(caddress);
                }
				String regMoney = ele.elementTextTrim("regMoney");
                if (regMoney != null && !"".equals(regMoney)) {
                    company.setRegMoney(regMoney);
                }

                String companyType = ele.elementTextTrim("companyType");
                if (companyType != null && !"".equals(companyType)) {
                    company.setCompanyType(companyType);
                }
                String scope = ele.elementTextTrim("scope");
                if (scope != null && !"".equals(scope)) {
                    company.setScope(scope);
                }
                String industryType = ele.elementTextTrim("industryType");
                if (industryType != null && !"".equals(industryType)) {
                    company.setIndustryCode(industryType);
                }
                String taxIdentCode = ele.elementTextTrim("taxIdentCode");
                if (taxIdentCode != null && !"".equals(taxIdentCode)) {
                    company.setTaxIdentCode(taxIdentCode);
                }
                String corpTaxType = ele.elementTextTrim("corpTaxType");
                if (corpTaxType != null && !"".equals(corpTaxType)) {
                    company.setCorpTaxType(corpTaxType);
                }
                String customCode = ele.elementTextTrim("customCode");
                company.setCustomCode(customCode);
                String declCode = ele.elementTextTrim("declCode");
                company.setDeclCode(declCode);
                String ioCorpCode = ele.elementTextTrim("ioCorpCode");
                company.setIoCorpCode(ioCorpCode);
                String creditLevel = ele.elementTextTrim("creditLevel");
                if (creditLevel != null && !"".equals(creditLevel)) {
                    company.setCreditLevel(creditLevel);
                }
				try {
                    String validateBeg = ele.elementTextTrim("validateBeg");
                    if (validateBeg != null && !"".equals(validateBeg)) {
                        company.setValidateBeg(sdf.parse(validateBeg));
                    }
                    String validateEnd = ele.elementTextTrim("validateEnd");
                    if (validateEnd != null && !"".equals(validateEnd)) {
                        company.setValidateEng(sdf.parse(validateEnd));
                    }
                    String regDate = ele.elementTextTrim("regDate");
                    if (regDate != null && !"".equals(regDate)) {
                        company.setRegDate(sdf.parse(regDate));
                    }
                    String openDate = ele.elementTextTrim("openDate");
                    if (openDate != null && !"".equals(openDate)) {
						company.setOpenDate(sdf.parse(openDate));
					}
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                String resCountry = ele.elementTextTrim("resCountry");
                company.setResCountry(resCountry);
                String orgAddress = ele.elementTextTrim("orgAddress");
                if (orgAddress != null && !"".equals(orgAddress)) {
                    company.setOrgAddress(orgAddress);
                }
                String finvest1 = ele.elementTextTrim("finvest1");
                company.setFinvest1(finvest1);
                String finvest2 = ele.elementTextTrim("finvest2");
                company.setFinvest2(finvest2);
                String finvest3 = ele.elementTextTrim("finvest3");
                company.setFinvest3(finvest3);
                String finvest4 = ele.elementTextTrim("finvest4");
                company.setFinvest4(finvest4);
                String finvest5 = ele.elementTextTrim("finvest5");
                company.setFinvest5(finvest5);
                String economyType = ele.elementTextTrim("economyType");
                company.setEconomyType(economyType);
                String locationfCode = ele.elementTextTrim("locationfCode");
                company.setLocationfCode(locationfCode);
                String isSpecialCorp = ele.elementTextTrim("isSpecialCorp");
                company.setIsSpecialCorp(isSpecialCorp);
                String specialCorpType = ele.elementTextTrim("specialCorpType");
                company.setSpecialCorpType(specialCorpType);
                String period = ele.elementTextTrim("period");
                company.setPeriod(period);
                String investMoneyKind = ele.elementTextTrim("investMoneyKind");
                company.setInvestMoneyKind(investMoneyKind);
                String fregMoneyDollar = ele.elementTextTrim("fregMoneyDollar");
                if (fregMoneyDollar != null && !"".equals(fregMoneyDollar)) {
                    BigDecimal fre = new BigDecimal(fregMoneyDollar);
                    company.setFregMoneyDollar(fre);
                }
                String investSumMoney = ele.elementTextTrim("investSumMoney");
                company.setInvestSumMoney(investSumMoney);
                String rmbInvestSumMoney = ele.elementTextTrim("rmbInvestSumMoney");
                company.setRmbInvestSumMoney(rmbInvestSumMoney);
                String finvestSumMoneyDollar = ele.elementTextTrim("finvestSumMoneyDollar");
                company.setFinvestSumMoneyDollar(finvestSumMoneyDollar);
                String orgType = ele.elementTextTrim("orgType");
                company.setOrgType(orgType);
                String remark = ele.elementTextTrim("remark");
                company.setRemark(remark);
                String orgId = ele.elementTextTrim("orgId");
                company.setOrgId(orgId);
                company.setDelFlag("0");
                company.setCreateBy("1");
                company.setCreateTime(DateUtils.getNowDate());
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
        String response = "";
        if ("1".equals(company.getCharacters())) {
            String compXml = this.getCompXmlStr(opType, company);
            response = execBusiness(compXml);
        } else {
            String businessXml = this.getBusinessXmlStr(opType, company);
            response = execBusiness(businessXml);
        }
        if ("true".equals(response)) {
            if ("A".equals(opType)) {
                userService.insertUser(user);
                insertSmtCompany(company);
            } else if ("M".equals(opType)) {
                userService.updateUser(user);
                SmtCompany company1 = selectSmtCompanyBySgsRegCode(company.getSgsRegCode());
                company.setCompanyId(company1.getCompanyId());
                updateSmtCompany(company);
            }
        }
        return response;
    }

    /**
     * 企业备案发送
     * @param xml
     * @return
     */
    public String execBusiness(String xml) {
        JSONArray jsonArray = new JSONArray();
        JSONObject json = new JSONObject();
        String response = subjectIntFaceFacade.sendDeclaration(Global.getCorpCode(), Global.getCorpName(), Global.getLoginCode(), Global.getLoginPassWord(), xml);
        log.info(response);
        if (StringUtils.isEmpty(response)) {
            jsonArray.add("市场采购贸易系统未返回回执");
            json.put("status", false);
            json.put("msg", jsonArray);
            return json.toString();
        }
        JSONObject repJson = JSONObject.parseObject(response);
        if (repJson.getInteger("result") == 1 && !"".equals(repJson.get("otherMessage"))) {
            JSONArray repArray = repJson.getJSONArray("otherMessage");
            json.put("status", true);
            json.put("msg", repArray);
            return json.toString();
        } else if (response.contains("统一社会信用代码已存在")) {
            json.put("status", true);
            json.put("msg", jsonArray.add("统一社会信用代码已存在"));
            return json.toString();
        } else if (repJson.getInteger("result") == 0 && !"".equals(repJson.get("errorMessage"))) {
            JSONArray errArray = repJson.getJSONArray("errorMessage");
            json.put("status", false);
            json.put("msg", errArray);
            return json.toString();
        }
        jsonArray.add("发送失败");
        json.put("status", false);
        json.put("msg", jsonArray);
        return json.toString();
    }

    /**
     * 商户备案报文
     * @param opType
     * @param company
     * @return
     */
    public String getCompXmlStr(String opType, SmtCompany company){
        int num=(int)(Math.random()*9000)+1000;
        String messageId = "COMP_"+company.getSgsRegCode()+"_"+DateUtils.dateTimeNow()+""+num;
        StringBuilder compXmlStr = new StringBuilder();
        compXmlStr.append("<?xml version='1.0' encoding='utf-8'?>\n");
        compXmlStr.append("<SubjectInfo>\n");
        compXmlStr.append("<Head>\n");
        compXmlStr.append(" <MessageId>"+messageId+"</MessageId>\n");
        compXmlStr.append("	<MessageType>COMP</MessageType>\n");
        compXmlStr.append("	<Sender>"+company.getSgsRegCode()+"</Sender>\n");
        compXmlStr.append("	<Receiver>GZSW</Receiver>\n");
        compXmlStr.append(" <opType>"+opType+"</opType>\n");
        compXmlStr.append("</Head>\n");
        compXmlStr.append("<Declaration>\n");
        compXmlStr.append("<DsqCorp>\n");
        compXmlStr.append("	<orgId>"+(company.getOrgId()==null?"":company.getOrgId())+"</orgId>\n");
        compXmlStr.append("	<sgsRegCode>"+(company.getSgsRegCode()==null?"":company.getSgsRegCode().toString().trim())+"</sgsRegCode>\n");
        compXmlStr.append("	<corpCname>"+(company.getCorpCname()==null?"":company.getCorpCname().toString().trim())+"</corpCname>\n");
        compXmlStr.append("	<corpEname>"+(company.getCorpEname()==null?"":company.getCorpEname())+"</corpEname>\n");
        compXmlStr.append("	<corpShortName>"+(company.getCorpShortName()==null?"":company.getCorpShortName())+"</corpShortName>\n");
        compXmlStr.append("	<corpOrgCode>"+(company.getCorpOrgCode()==null?"":company.getCorpOrgCode().toString().trim())+"</corpOrgCode>\n");
        compXmlStr.append("	<locationfCode>"+(company.getLocationfCode()==null?"":company.getLocationfCode().toString().trim())+"</locationfCode>\n");
        compXmlStr.append("	<corpType>1</corpType>\n");
        compXmlStr.append("	<characters>"+company.getCharacters()+"</characters>\n");
        compXmlStr.append("	<legalName>"+(company.getLegalName()==null?"":company.getLegalName())+"</legalName>\n");
        compXmlStr.append("	<identCode>"+(company.getIdentCode()==null?"":company.getIdentCode())+"</identCode>\n");
        compXmlStr.append("	<legalIdCode>"+(company.getIdentIdCode()==null?"":company.getIdentIdCode())+"</legalIdCode>\n");
        compXmlStr.append("	<contractMan>"+(company.getContractMan()==null?"":company.getContractMan())+"</contractMan>\n");
        compXmlStr.append("	<loginUserName>"+(company.getLoginUserName()==null?"":company.getLoginUserName())+"</loginUserName>\n");
        compXmlStr.append("	<cellphoneNo>"+(company.getCellPhoneNo()==null?"":company.getCellPhoneNo())+"</cellphoneNo>\n");
        compXmlStr.append("	<email>"+(company.getEmail()==null?"":company.getEmail())+"</email>\n");
        compXmlStr.append("	<faxNo>"+(company.getFaxNo()==null?"":company.getFaxNo())+"</faxNo>\n");
        compXmlStr.append("	<postCode>"+(company.getPostCode()==null?"":company.getPostCode())+"</postCode>\n");
        compXmlStr.append("	<caddress>"+(company.getCaddress()==null?"":company.getCaddress())+"</caddress>\n");
        compXmlStr.append("	<regMoney>"+(company.getRegMoney()==null?"":company.getRegMoney())+"</regMoney>\n");
        compXmlStr.append("	<companyType>"+(company.getCompanyType()==null?"":company.getCompanyType())+"</companyType>\n");
        compXmlStr.append("	<scope>"+(company.getScope()==null?"":company.getScope())+"</scope>\n");
        compXmlStr.append("	<industryType>"+(company.getIndustryCode()==null?"":company.getIndustryCode())+"</industryType>\n");
        compXmlStr.append("	<taxIdentCode>"+(company.getTaxIdentCode()==null?"":company.getTaxIdentCode())+"</taxIdentCode>\n");
        compXmlStr.append("	<corpTaxType>"+(company.getCorpTaxType()==null?"":company.getCorpTaxType())+"</corpTaxType>\n");
        compXmlStr.append("	<customCode>"+(company.getCustomCode()==null?"":company.getCustomCode())+"</customCode>\n");
        compXmlStr.append("	<declCode>"+(company.getDeclCode()==null?"":company.getDeclCode())+"</declCode>\n");
        compXmlStr.append(" <ioCorpCode>"+(company.getIoCorpCode()==null?"":company.getIoCorpCode())+"</ioCorpCode>\n");
        compXmlStr.append("	<creditLevel>"+(company.getCreditLevel()==null?"":company.getCreditLevel())+"</creditLevel>\n");
        compXmlStr.append("	<validateBeg>"+(company.getValidateBeg()==null?"":DateUtils.parseDateToStr("yyyy-MM-dd", company.getValidateBeg())+"</validateBeg>\n"));
        compXmlStr.append("	<validateEnd>"+(company.getValidateEng()==null?"":DateUtils.parseDateToStr("yyyy-MM-dd", company.getValidateEng())+"</validateEnd>\n"));
        compXmlStr.append("	<regDate>"+(company.getRegDate()==null?"":DateUtils.parseDateToStr("yyyy-MM-dd", company.getRegDate())+"</regDate>\n"));
        compXmlStr.append("	<openDate></openDate>\n");
        compXmlStr.append("	<wisdomCheckNo></wisdomCheckNo>\n");
        compXmlStr.append("	<resCountry></resCountry>\n");
        compXmlStr.append("	<orgAddress>"+(company.getOrgAddress()==null?"":company.getOrgAddress())+"</orgAddress>\n");
        compXmlStr.append("	<finvest1></finvest1>\n");
        compXmlStr.append("	<finvest2></finvest2>\n");
        compXmlStr.append("	<finvest3></finvest3>\n");
        compXmlStr.append("	<finvest4></finvest4>\n");
        compXmlStr.append("	<finvest5></finvest5>\n");
        compXmlStr.append("	<economyType></economyType>\n");
        compXmlStr.append("	<isSpecialCorp></isSpecialCorp>\n");
        compXmlStr.append("	<specialCorpType></specialCorpType>\n");
        compXmlStr.append("	<period></period>\n");
        compXmlStr.append("	<investMoneyKind></investMoneyKind>\n");
        compXmlStr.append("	<fregMoneyDollar></fregMoneyDollar>\n");
        compXmlStr.append("	<investSumMoney></investSumMoney>\n");
        compXmlStr.append("	<rmbInvestSumMoney></rmbInvestSumMoney>\n");
        compXmlStr.append("	<finvestSumMoneyDollar></finvestSumMoneyDollar>\n");
        compXmlStr.append("	<orgType></orgType>\n");
        compXmlStr.append("	<regionCode>"+(company.getRegionCode()==null?"":company.getRegionCode().toString().trim())+"</regionCode>\n");
        compXmlStr.append("	<remark>"+(company.getRemark()==null?"":company.getRemark())+"</remark>\n");
        compXmlStr.append("</DsqCorp>\n");
        compXmlStr.append("</Declaration>\n");
        compXmlStr.append("</SubjectInfo>");
        return compXmlStr.toString();
    }

    /**
     * 企业备案报文
     * @param opType
     * @param company
     * @return
     */
    public String getBusinessXmlStr(String opType, SmtCompany company){
        int num=(int)(Math.random()*9000)+1000;
        String messageId = "COMP_"+company.getSgsRegCode()+"_"+DateUtils.dateTimeNow()+""+num;
        String taxAuthoritiesCode="";
        StringBuilder compXmlStr = new StringBuilder();
        compXmlStr.append("<?xml version='1.0' encoding='utf-8'?>\n");
        compXmlStr.append("<SubjectInfo>\n");
        compXmlStr.append("<Head>\n");
        compXmlStr.append(" <MessageId>"+messageId+"</MessageId>\n");
        compXmlStr.append("	<MessageType>COMP</MessageType>\n");
        compXmlStr.append("	<Sender>"+company.getSgsRegCode()+"</Sender>\n");
        compXmlStr.append("	<Receiver>GZSW</Receiver>\n");
        compXmlStr.append("	<opType>"+opType+"</opType>\n");
        compXmlStr.append("</Head>\n");
        compXmlStr.append("<Declaration>\n");
        compXmlStr.append("<DsqCorp>\n");
        compXmlStr.append("	<orgId>"+(company.getOrgId()==null?"":company.getOrgId())+"</orgId>\n");
        compXmlStr.append("	<sgsRegCode>"+(company.getSgsRegCode()==null?"":company.getSgsRegCode().toString().trim())+"</sgsRegCode>\n");
        compXmlStr.append("	<regionCode>"+(company.getRegionCode()==null?"":company.getRegionCode())+"</regionCode>\n");
        compXmlStr.append(" <taxAuthoritiesCode>"+taxAuthoritiesCode+"</taxAuthoritiesCode>\n");
        compXmlStr.append("	<locationfCode>"+(company.getLocationfCode()==null?"":company.getLocationfCode())+"</locationfCode>\n");
        compXmlStr.append("	<corpCname>"+(company.getCorpCname()==null?"":company.getCorpCname().toString().trim())+"</corpCname>\n");
        compXmlStr.append("	<corpEname>"+(company.getCorpEname()==null?"":company.getCorpEname())+"</corpEname>\n");
        compXmlStr.append("	<corpShortName>"+(company.getCorpShortName()==null?"":company.getCorpShortName())+"</corpShortName>\n");
        compXmlStr.append("	<corpOrgCode>"+(company.getCorpOrgCode()==null?"":company.getCorpOrgCode().toString().trim())+"</corpOrgCode>\n");
        compXmlStr.append("	<corpType>2</corpType>\n");
        compXmlStr.append("	<characters>"+company.getCharacters()+"</characters>\n");
        compXmlStr.append("	<legalName>"+(company.getLegalName()==null?"":company.getLegalName())+"</legalName>\n");
        compXmlStr.append("	<identCode>"+(company.getIdentCode()==null?"":company.getIdentCode())+"</identCode>\n");
        compXmlStr.append("	<legalIdCode>"+(company.getIdentIdCode()==null?"":company.getIdentIdCode())+"</legalIdCode>\n");
        compXmlStr.append("	<contractMan>"+(company.getContractMan()==null?"":company.getContractMan())+"</contractMan>\n");
        compXmlStr.append("	<loginUserName>"+(company.getLoginUserName()==null?"":company.getLoginUserName())+"</loginUserName>\n");
        compXmlStr.append("	<cellphoneNo>"+(company.getCellPhoneNo()==null?"":company.getCellPhoneNo())+"</cellphoneNo>\n");
        compXmlStr.append("	<email>"+(company.getEmail()==null?"":company.getEmail())+"</email>\n");
        compXmlStr.append("	<faxNo>"+(company.getFaxNo()==null?"":company.getFaxNo())+"</faxNo>\n");
        compXmlStr.append("	<postCode>"+(company.getPostCode()==null?"":company.getPostCode())+"</postCode>\n");
        compXmlStr.append("	<caddress>"+(company.getCaddress()==null?"":company.getCaddress())+"</caddress>\n");
        compXmlStr.append("	<regMoney>"+(company.getRegMoney()==null?"":company.getRegMoney())+"</regMoney>\n");
        compXmlStr.append("	<companyType>"+(company.getCompanyType()==null?"":company.getCompanyType())+"</companyType>\n");
        compXmlStr.append("	<scope>"+(company.getScope()==null?"":company.getScope())+"</scope>\n");
        compXmlStr.append("	<industryType>"+(company.getIndustryCode()==null?"":company.getIndustryCode())+"</industryType>\n");
        compXmlStr.append("	<taxIdentCode>"+(company.getTaxIdentCode()==null?"":company.getTaxIdentCode())+"</taxIdentCode>\n");
        compXmlStr.append("	<corpTaxType>"+(company.getCorpTaxType()==null?"":company.getCorpTaxType())+"</corpTaxType>\n");
        compXmlStr.append("	<customCode>"+(company.getCustomCode() ==null?"":company.getCustomCode())+"</customCode>\n");
        compXmlStr.append("	<declCode>"+(company.getDeclCode()==null?"":company.getDeclCode())+"</declCode>\n");
        compXmlStr.append(" <ioCorpCode>"+(company.getIoCorpCode()==null?"":company.getIoCorpCode())+"</ioCorpCode>\n");
        compXmlStr.append("	<creditLevel>"+(company.getCreditLevel()==null?"":company.getCreditLevel())+"</creditLevel>\n");
        compXmlStr.append("	<validateBeg>"+(company.getValidateBeg()==null?"":DateUtils.parseDateToStr("yyyy-MM-dd", company.getValidateBeg()))+"</validateBeg>\n");
        compXmlStr.append("	<validateEnd>"+(company.getValidateEng()==null?"":DateUtils.parseDateToStr("yyyy-MM-dd", company.getValidateEng()))+"</validateEnd>\n");
        compXmlStr.append("	<regDate>"+(company.getRegDate()==null?"":DateUtils.parseDateToStr("yyyy-MM-dd", company.getRegDate()))+"</regDate>\n");
        compXmlStr.append("	<openDate></openDate>\n");
        compXmlStr.append("	<wisdomCheckNo></wisdomCheckNo>\n");
        compXmlStr.append("	<resCountry></resCountry>\n");
        compXmlStr.append("	<orgAddress>"+(company.getOrgAddress()==null?"":company.getOrgAddress())+"</orgAddress>\n");
        compXmlStr.append("	<finvest1></finvest1>\n");
        compXmlStr.append("	<finvest2></finvest2>\n");
        compXmlStr.append("	<finvest3></finvest3>\n");
        compXmlStr.append("	<finvest4></finvest4>\n");
        compXmlStr.append("	<finvest5></finvest5>\n");
        compXmlStr.append("	<economyType></economyType>\n");
        compXmlStr.append("	<isSpecialCorp></isSpecialCorp>\n");
        compXmlStr.append("	<specialCorpType></specialCorpType>\n");
        compXmlStr.append("	<period></period>\n");
        compXmlStr.append("	<investMoneyKind></investMoneyKind>\n");
        compXmlStr.append("	<fregMoneyDollar></fregMoneyDollar>\n");
        compXmlStr.append("	<investSumMoney></investSumMoney>\n");
        compXmlStr.append("	<rmbInvestSumMoney></rmbInvestSumMoney>\n");
        compXmlStr.append("	<finvestSumMoneyDollar></finvestSumMoneyDollar>\n");
        compXmlStr.append("	<orgType></orgType>\n");
        compXmlStr.append("	<remark>"+(company.getRemark()==null?"":company.getRemark())+"</remark>\n");
        compXmlStr.append("</DsqCorp>\n");
        compXmlStr.append("</Declaration>\n");
        compXmlStr.append("</SubjectInfo>");
        return compXmlStr.toString();
    }
}
