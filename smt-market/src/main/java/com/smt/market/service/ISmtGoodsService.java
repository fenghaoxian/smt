package com.smt.market.service;

import com.smt.market.domain.SmtCompany;
import com.smt.market.domain.SmtGoods;
import com.smt.market.domain.SmtProducer;

import java.util.Iterator;
import java.util.List;

/**
 * 商品 服务层
 * 
 * @author smt
 * @date 2019-09-23
 */
public interface ISmtGoodsService 
{
	/**
     * 查询商品信息
     * 
     * @param goodsId 商品ID
     * @return 商品信息
     */
	public SmtGoods selectSmtGoodsById(Integer goodsId);

	public SmtGoods selectSmtGoodsByGoodsCode(String goodsCode);
	
	/**
     * 查询商品列表
     * 
     * @param smtGoods 商品信息
     * @return 商品集合
     */
	public List<SmtGoods> selectSmtGoodsList(SmtGoods smtGoods);
	
	/**
     * 新增商品
     * 
     * @param smtGoods 商品信息
     * @return 结果
     */
	public int insertSmtGoods(SmtGoods smtGoods);
	
	/**
     * 修改商品
     * 
     * @param smtGoods 商品信息
     * @return 结果
     */
	public int updateSmtGoods(SmtGoods smtGoods);
		
	/**
     * 删除商品信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSmtGoodsByIds(String ids);

	public void insertGoodsProducer(SmtGoods goods, SmtProducer producer);

	public String insert(Iterator iterator, String opType);

	public String query(Iterator iterator, String messageType);

	public String queryGoods(String opType, SmtGoods goods);

	/**
	 * 商品备案
	 * @param opType
	 * @param goodsList
	 * @param companyList
	 * @return
	 */
	public String execGoods(String opType, List<SmtGoods> goodsList, List<SmtCompany> companyList);

	/**
	 * 商品备案报文
	 * @param opType
	 * @param goodsList
	 * @param companyList
	 * @return
	 */
	public String getGoodsXmlStr(String opType, List<SmtGoods> goodsList, List<SmtCompany> companyList);
	
}
