package com.smt.market.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.smt.common.json.JSONObject;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smt.market.mapper.SmtGoodsMapper;
import com.smt.market.domain.SmtGoods;
import com.smt.market.service.ISmtGoodsService;
import com.smt.common.support.Convert;

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
	public String insert(Iterator iterator) {
		JSONObject json = new JSONObject();
		ArrayList<SmtGoods> goodsList = new ArrayList<SmtGoods>();
		JSONObject.JSONArray jsonArray = new JSONObject.JSONArray();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		if (iterator.hasNext()) {
			Element element = (Element) iterator.next();
			Iterator goodsListIter = element.elementIterator("GoodsList");
			if (goodsListIter.hasNext()) {
				SmtGoods goods = new SmtGoods();
				Element goodsEle = (Element) goodsListIter.next();
				String goodsCname = goodsEle.elementTextTrim("goodsCname");
				if (goodsCname != null && !"".equals(goodsCname)) {
					goods.setGoodsCname(goodsCname);
				} else {
					jsonArray.add("商品中文名称为空");
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
					jsonArray.add("企业自有编码为空");
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
					jsonArray.add("规格型号为空");
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
					goods.setProducer(producer);
				} else {
					jsonArray.add("生产厂家为空");
				}
				String cunit = goodsEle.elementTextTrim("cunit");
				if (cunit != null && !"".equals(cunit)) {
					goods.setCunit(cunit);
				} else {
					jsonArray.add("成交单位为空");
				}
				String qunit = goodsEle.elementTextTrim("qunit");
				if (qunit != null && !"".equals(qunit)) {
					goods.setQunit(qunit);
				} else {
					jsonArray.add("法定单位为空");
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

				}
				goodsList.add(goods);
			}
			if (goodsList.size() > 0) {
				for (SmtGoods goods : goodsList) {
					insertSmtGoods(goods);
				}
			}
			if (jsonArray.size() > 0) {
				json.put("status", false);
				json.put("msg", jsonArray);
				return json.toString();
			} else {
				jsonArray.add("发送成功");
				json.put("status", true);
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

}
