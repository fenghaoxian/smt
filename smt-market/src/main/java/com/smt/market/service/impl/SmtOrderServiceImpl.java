package com.smt.market.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import com.smt.common.json.JSONObject;
import com.smt.market.domain.SmtOrderDetail;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smt.market.mapper.SmtOrderMapper;
import com.smt.market.domain.SmtOrder;
import com.smt.market.service.ISmtOrderService;
import com.smt.common.support.Convert;

/**
 * 交易单 服务层实现
 * 
 * @author smt
 * @date 2019-09-27
 */
@Service
public class SmtOrderServiceImpl implements ISmtOrderService 
{
	@Autowired
	private SmtOrderMapper smtOrderMapper;

	/**
     * 查询交易单信息
     * 
     * @param orderId 交易单ID
     * @return 交易单信息
     */
    @Override
	public SmtOrder selectSmtOrderById(Integer orderId)
	{
	    return smtOrderMapper.selectSmtOrderById(orderId);
	}
	
	/**
     * 查询交易单列表
     * 
     * @param smtOrder 交易单信息
     * @return 交易单集合
     */
	@Override
	public List<SmtOrder> selectSmtOrderList(SmtOrder smtOrder)
	{
	    return smtOrderMapper.selectSmtOrderList(smtOrder);
	}
	
    /**
     * 新增交易单
     * 
     * @param smtOrder 交易单信息
     * @return 结果
     */
	@Override
	public int insertSmtOrder(SmtOrder smtOrder)
	{
	    return smtOrderMapper.insertSmtOrder(smtOrder);
	}
	
	/**
     * 修改交易单
     * 
     * @param smtOrder 交易单信息
     * @return 结果
     */
	@Override
	public int updateSmtOrder(SmtOrder smtOrder)
	{
	    return smtOrderMapper.updateSmtOrder(smtOrder);
	}

	/**
     * 删除交易单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSmtOrderByIds(String ids)
	{
		return smtOrderMapper.deleteSmtOrderByIds(Convert.toStrArray(ids));
	}

	@Override
	public String insert(Iterator iterator) {
		JSONObject json = new JSONObject();
		JSONObject.JSONArray jsonArray = new JSONObject.JSONArray();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		SmtOrder order = new SmtOrder();
		if (iterator.hasNext()) {
			Element element = (Element) iterator.next();
			Iterator tradeList = element.elementIterator("TradeList");
			if (tradeList.hasNext()) {
				Element tradeEle = (Element) tradeList.next();
				String buyer = tradeEle.elementTextTrim("buyer");
				String solder = tradeEle.elementTextTrim("solder");
				String proxyer = tradeEle.elementTextTrim("proxyer");
				String isAgencyReceipt = tradeEle.elementTextTrim("isAgencyReceipt");
				String rmbMoney = tradeEle.elementTextTrim("rmbMoney");
				String tradingNo = tradeEle.elementTextTrim("tradingNo");
				String remark = tradeEle.elementTextTrim("remark");
				Iterator tradeDetailList = tradeEle.elementIterator("TradeDetailList");
				if (tradeDetailList.hasNext()) {
					SmtOrderDetail orderDetail = new SmtOrderDetail();
					Element tradeDetailEle = (Element) tradeDetailList.next();
					String goodCode = tradeDetailEle.elementTextTrim("goodCode");
					if (goodCode != null && !"".equals(goodCode)) {

					}
					String cAmount = tradeDetailEle.elementTextTrim("cAmount");
					if (cAmount != null && !"".equals(cAmount)) {
						BigDecimal dec = new BigDecimal(cAmount);
						orderDetail.setCamount(dec);
					}
					String quantity = tradeDetailEle.elementTextTrim("quantity");
					if (quantity != null && !"".equals(quantity)) {
						BigDecimal dec = new BigDecimal(quantity);
						orderDetail.setQuantity(dec);
					}
					String weight = tradeDetailEle.elementTextTrim("weight");
					String price = tradeDetailEle.elementTextTrim("price");
					String totalPrice = tradeDetailEle.elementTextTrim("totalPrice");
					String tradeCurr = tradeDetailEle.elementTextTrim("tradeCurr");
					String tradeDetailIdReturn = tradeDetailEle.elementTextTrim("tradeDetailIdReturn");
				}
			}
		}
		return null;
	}

}
