package com.smt.market.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.smt.common.config.Global;
import com.smt.common.support.Convert;
import com.smt.common.utils.DateUtils;
import com.smt.common.utils.StringUtils;
import com.smt.market.domain.SmtCompany;
import com.smt.market.domain.SmtGoods;
import com.smt.market.domain.SmtGoodsProducer;
import com.smt.market.domain.SmtProducer;
import com.smt.market.mapper.SmtCompanyMapper;
import com.smt.market.mapper.SmtGoodsMapper;
import com.smt.market.mapper.SmtGoodsProducerMapper;
import com.smt.market.mapper.SmtProducerMapper;
import com.smt.market.service.ISmtGoodsService;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 商品 服务层实现
 * 
 * @author smt
 * @date 2019-09-23
 */
@Service
public class SmtGoodsServiceImpl implements ISmtGoodsService 
{
	@Autowired
	private SmtGoodsMapper smtGoodsMapper;

	@Autowired
	private SmtCompanyMapper companyMapper;

	@Autowired
	private SmtGoodsProducerMapper goodsProducerMapper;

	@Autowired
	private SmtProducerMapper producerMapper;

	@Autowired
	private SubjectIntFaceFacadeImpl subjectIntFaceFacade;

	Logger logger = LoggerFactory.getLogger(SmtGoodsServiceImpl.class);

	/**
     * 查询商品信息
     * 
     * @param goodsId 商品ID
     * @return 商品信息
     */
    @Override
	public SmtGoods selectSmtGoodsById(Integer goodsId)
	{
	    return smtGoodsMapper.selectSmtGoodsById(goodsId);
	}

	@Override
	public SmtGoods selectSmtGoodsByGoodsCode(String goodsCode) {
    	return smtGoodsMapper.selectSmtGoodsByGoodsCode(goodsCode);
	}

	/**
     * 查询商品列表
     * 
     * @param smtGoods 商品信息
     * @return 商品集合
     */
	@Override
	public List<SmtGoods> selectSmtGoodsList(SmtGoods smtGoods)
	{
	    return smtGoodsMapper.selectSmtGoodsList(smtGoods);
	}
	
    /**
     * 新增商品
     * 
     * @param smtGoods 商品信息
     * @return 结果
     */
	@Override
	public int insertSmtGoods(SmtGoods smtGoods)
	{
	    return smtGoodsMapper.insertSmtGoods(smtGoods);
	}
	
	/**
     * 修改商品
     * 
     * @param smtGoods 商品信息
     * @return 结果
     */
	@Override
	public int updateSmtGoods(SmtGoods smtGoods)
	{
	    return smtGoodsMapper.updateSmtGoods(smtGoods);
	}

	/**
     * 删除商品对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSmtGoodsByIds(String ids)
	{
		return smtGoodsMapper.deleteSmtGoodsByIds(Convert.toStrArray(ids));
	}

	@Override
	public void insertGoodsProducer(SmtGoods goods, SmtProducer producer) {
		SmtGoodsProducer goodsProducer = new SmtGoodsProducer();
		goodsProducer.setGoodsId(goods.getGoodsId());
		goodsProducer.setProducerId(producer.getProducerId());
		goodsProducerMapper.insertSmtGoodsProducer(goodsProducer);
	}

	@Override
	public String insert(Iterator iterator, String opType) {
		JSONArray jsonArray = new JSONArray();
		JSONObject json = new JSONObject();
		ArrayList<Map<String, ArrayList>> list = new ArrayList<>();
		ArrayList<SmtGoods> goodsList = new ArrayList<>();
		ArrayList<SmtProducer> producerList = new ArrayList<>();
		ArrayList<SmtCompany> companyList = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		if (iterator.hasNext()) {
			Element element = (Element) iterator.next();
			Iterator goodsListIter = element.elementIterator("GoodsList");
			int i = 1;
			if (goodsListIter.hasNext()) {
				Element goodsListEle = (Element) goodsListIter.next();
				Iterator goodsIter = goodsListEle.elementIterator("Goods");
				while (goodsIter.hasNext()) {
					SmtCompany company = new SmtCompany();
					SmtGoods goods = new SmtGoods();
					Element goodsEle = (Element) goodsIter.next();
					String goodsCname = goodsEle.elementTextTrim("goodsCname");
					if (goodsCname != null && !"".equals(goodsCname)) {
						goods.setGoodsCname(goodsCname);
					} else {
						jsonArray.add("第"+i+"个商品中文名称为空");
					}
					String hsCode = goodsEle.elementTextTrim("hsCode");
					if (hsCode != null && !"".equals(hsCode)) {
						goods.setHsCode(hsCode);
					}
					String hsCodes = goodsEle.elementTextTrim("hsCodes");
					if (hsCodes != null && !"".equals(hsCodes)) {
						goods.setHsCodes(hsCodes);
					}
					String corpOwnerCode = goodsEle.elementTextTrim("corpOwnerCode");
					if (corpOwnerCode != null && !"".equals(corpOwnerCode)) {
						goods.setCorpOwnerCode(corpOwnerCode);
					} else {
						jsonArray.add("第"+i+"个商品企业自有编码为空");
					}
					String goodsType = goodsEle.elementTextTrim("goodsType");
					if (goodsType != null && !"".equals(goodsType)) {
						goods.setGoodsType(goodsType);
					}
					String goodsEname = goodsEle.elementTextTrim("goodsEname");
					if (goodsEname != null && !"".equals(goodsEname)){
						goods.setGoodsEname(goodsEname);
					}
					String model = goodsEle.elementTextTrim("model");
					if (model != null && !"".equals(model)) {
						goods.setModel(model);
					} else {
						jsonArray.add("第"+1+"个商品规格型号为空");
					}
					String isBrand = goodsEle.elementTextTrim("isBrand");
					if (isBrand != null && !"".equals(isBrand)) {
						goods.setIsBrand(isBrand);
					}
					String cBrand = goodsEle.elementTextTrim("cBrand");
					if (cBrand != null && !"".equals(cBrand)) {
						goods.setCBrand(cBrand);
					}
					String eBrand = goodsEle.elementTextTrim("eBrand");
					if (eBrand != null && !"".equals(eBrand)) {
						goods.setEBrand(eBrand);
					}
					String producer = goodsEle.elementTextTrim("producer");
					if (producer != null && !"".equals(producer)) {
						SmtProducer smtProducer = producerMapper.selectSmtProducerByCorpCode(producer);
						if (smtProducer != null && !"".equals(smtProducer.getCorpCode())) {
							goods.setProducer(producer);
							producerList.add(smtProducer);
						} else {
							jsonArray.add("第"+i+"个商品生产厂家不存在");
						}
					} else {
						jsonArray.add("第"+i+"个商品生产厂家为空");
					}
					String cunit = goodsEle.elementTextTrim("cunit");
					if (cunit != null && !"".equals(cunit)) {
						goods.setCunit(cunit);
					} else {
						jsonArray.add("第"+i+"个商品成交单位为空");
					}
					String qunit = goodsEle.elementTextTrim("qunit");
					if (qunit != null && !"".equals(qunit)) {
						goods.setQunit(qunit);
					} else {
						jsonArray.add("第"+i+"个商品法定单位为空");
					}
					String wunit = goodsEle.elementTextTrim("wunit");
					if (wunit != null && !"".equals(wunit)) {
						goods.setWunit(wunit);
					}
					String goodsImage = goodsEle.elementTextTrim("goodsImage");
					if (goodsImage != null && !"".equals(goodsImage)) {
						goods.setGoodsImage(goodsImage);
					}
					String goodsCode = goodsEle.elementTextTrim("goodsCode");
					if (goodsCode != null && !"".equals(goodsCode)) {
						goods.setGoodsCode(goodsCode);
					}
					String createOrg = goodsEle.elementTextTrim("createOrg");
					if (createOrg != null && !"".equals(createOrg)) {
						company = companyMapper.selectSmtCompanyBySgsRegCode(createOrg);
						if (company == null) {
							jsonArray.add("第"+i+"个商品创建企业编码不存在");
						}
					}
					goods.setUnId(UUID.randomUUID().toString().replace("-", ""));
					goodsList.add(goods);
					companyList.add(company);
				}
			}
			if (jsonArray.size() > 0) {
				json.put("status", false);
				json.put("msg", jsonArray);
				return json.toString();
			}
			String response = execGoods(opType, goodsList, companyList);
			logger.info(response);
			if (response.contains("true")) {
				int index = 0;
				for (SmtGoods goods : goodsList) {
					insertSmtGoods(goods);
					insertGoodsProducer(goods, producerList.get(index++));
				}
			}
			return response;
		} else {
			jsonArray.add("报文信息有误");
			json.put("status", false);
			json.put("msg", jsonArray);
			return json.toString();
		}
	}

	@Override
	public String query(Iterator iterator, String opType) {
		SmtGoods goods = new SmtGoods();
		JSONArray jsonArray = new JSONArray();
		JSONObject json = new JSONObject();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (iterator.hasNext()) {
			Element element = (Element) iterator.next();
			Iterator goodsIterator = element.elementIterator("GoodsRecordInfo");
			if (goodsIterator.hasNext()) {
				Element goodsEle = (Element) goodsIterator.next();
				String goodsCode = goodsEle.elementTextTrim("goodsCode");
				if (StringUtils.isEmpty(goodsCode)) {
					jsonArray.add("商品编码为空");
					json.put("status", false);
					json.put("msg", jsonArray);
					return json.toString();
				} else {
					SmtGoods smtGoods = selectSmtGoodsByGoodsCode(goodsCode);
					if (smtGoods != null && smtGoods.getGoodsCode() != null) {
						return queryGoods(opType, smtGoods);
					} else {
						jsonArray.add("商品库无对应的商品:" + goodsCode);
						json.put("status", false);
						json.put("msg", jsonArray);
						return json.toString();
					}
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

	@Override
	public String queryGoods(String opType, SmtGoods goods) {
		String response = subjectIntFaceFacade.queryTradeInfo(opType, goods.getGoodsCode());
		logger.info(response);
		if(StringUtils.isNotEmpty(response)){
			JSONObject jsonObject = JSONObject.parseObject(response);
			//正确请求
			if(jsonObject.get("result").equals("1")){
				JSONArray dataList = jsonObject.getJSONArray("dataList");
				if(dataList!=null && dataList.size() >0){
					JSONObject data= (JSONObject) dataList.get(0);
					goods.setStatus(data.get("statusCode").toString());
					int i = this.updateSmtGoods(goods);
				}
			}
		}
		return null;
	}

	/**
	 * 商品备案
	 * @param opType
	 * @param goodsList
	 * @param companyList
	 * @return
	 */
	@Override
	public String execGoods(String opType, List<SmtGoods> goodsList, List<SmtCompany> companyList) {
		JSONArray jsonArray = new JSONArray();
		JSONObject json = new JSONObject();
		String goodsXmlStr = getGoodsXmlStr(opType, goodsList, companyList);
		logger.info(goodsXmlStr);
		String response = subjectIntFaceFacade.sendDeclaration(Global.getCorpCode(), Global.getCorpName(), Global.getLoginCode(), Global.getLoginPassWord(), goodsXmlStr);
		logger.info(response);
		if (StringUtils.isEmpty(response)) {
			jsonArray.add("市场采购贸易系统未返回回执");
			json.put("status", false);
			json.put("msg", jsonArray);
			return json.toString();
		}
		JSONObject repJson = JSONObject.parseObject(response);
		if (repJson.getInteger("result") == 1 && repJson.get("otherMessage") != null) {
			json.put("status", true);
			json.put("msg", repJson.get("otherMessage"));
			return json.toString();
		} else if (repJson.getInteger("result") == 0) {
			json.put("status", false);
			json.put("msg", repJson.get("errorMessage"));
			return json.toString();
		} else {
			jsonArray.add("发送失败");
			System.out.println(response);
			json.put("status", false);
			json.put("msg", jsonArray);
			return json.toString();
		}
	}

	/**
	 * 商品备案报文
	 * @param opType
	 * @param goodsList
	 * @param companyList
	 * @return
	 */
	@Override
	public String getGoodsXmlStr(String opType, List<SmtGoods> goodsList, List<SmtCompany> companyList) {
		int num=(int)(Math.random()*9000)+1000;
		String messageId = "GOODS_"+"91440101MA59LFNE0E"+"_"+DateUtils.dateTimeNow()+""+num;
		StringBuilder goodsXmlStr = new StringBuilder();
		goodsXmlStr.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
		goodsXmlStr.append("<SubjectInfo>\n");
		goodsXmlStr.append("<Head>\n");
		goodsXmlStr.append(" <MessageId>"+messageId+"</MessageId>\n");
		goodsXmlStr.append(" <MessageType>GOODS</MessageType>\n");
		goodsXmlStr.append(" <Sender>"+"91440101MA59LFNE0E"+"</Sender>\n");
		goodsXmlStr.append(" <Receiver>GZSW</Receiver>\n");
		goodsXmlStr.append(" <opType>"+opType+"</opType>\n");
		goodsXmlStr.append("</Head>\n");
		goodsXmlStr.append("<Declaration>\n");
		goodsXmlStr.append("<GoodList>\n");
		for (SmtGoods goods : goodsList) {
			int i = 0;
			SmtCompany company = companyList.get(i++);
			goodsXmlStr.append("<Good>\n");
			goodsXmlStr.append(" <createOrg>"+(company.getSgsRegCode()==null?"":company.getSgsRegCode())+"</createOrg>\n");
			goodsXmlStr.append(" <goodsCname>"+(goods.getGoodsCname()==null?"":goods.getGoodsCname())+"</goodsCname>\n");
			goodsXmlStr.append(" <goodsEname>"+(goods.getGoodsEname()==null?"":goods.getGoodsEname())+"</goodsEname>\n");
			goodsXmlStr.append(" <goodsId>"+(goods.getGoodsId()==null?"":goods.getGoodsId())+"</goodsId>\n");
			goodsXmlStr.append(" <goodsImage></goodsImage>\n");
			goodsXmlStr.append(" <isBrand>"+(goods.getIsBrand()==null?"":goods.getIsBrand())+"</isBrand>\n");
			goodsXmlStr.append(" <model>"+(goods.getModel()==null?"":goods.getModel())+"</model>\n");
			goodsXmlStr.append(" <producer>"+(goods.getProducer()==null?"":goods.getProducer())+"</producer>\n");
			goodsXmlStr.append(" <qunit>"+(goods.getQunit()==null?"":goods.getQunit())+"</qunit>\n");
			goodsXmlStr.append(" <wunit>"+(goods.getWunit()==null?"":goods.getWunit())+"</wunit>\n");
			goodsXmlStr.append(" <cunit>"+(goods.getCunit()==null?"":goods.getCunit())+"</cunit>\n");
			goodsXmlStr.append(" <remark>"+(goods.getRemark()==null?"":goods.getRemark())+"</remark>\n");
			goodsXmlStr.append(" <cBrand>"+(goods.getCBrand()==null?"":goods.getCBrand())+"</cBrand>\n");
			goodsXmlStr.append(" <eBrand>"+(goods.getEBrand()==null?"":goods.getEBrand())+"</eBrand>\n");
			goodsXmlStr.append(" <goodsCode>"+(goods.getGoodsCode()==null?"":goods.getGoodsCode())+"</goodsCode>\n");
			goodsXmlStr.append(" <reason></reason>\n");
			goodsXmlStr.append(" <hsCode>"+(goods.getHsCode()==null?"":goods.getHsCode())+"</hsCode>\n");
			goodsXmlStr.append(" <hsCodeS>"+(goods.getHsCodes()==null?"":goods.getHsCodes())+"</hsCodeS>\n");
			goodsXmlStr.append(" <corpOwnerCode>"+(goods.getCorpOwnerCode()==null?"":goods.getCorpOwnerCode())+"</corpOwnerCode>\n");
			goodsXmlStr.append(" <goodsType>"+(goods.getGoodsType()==null?"":goods.getGoodsType())+"</goodsType>\n");
			goodsXmlStr.append("</Good>\n");
		}
		goodsXmlStr.append("</GoodList>\n");
		goodsXmlStr.append("</Declaration>\n");
		goodsXmlStr.append("</SubjectInfo>");
		return goodsXmlStr.toString();
	}

}
