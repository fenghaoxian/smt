package com.smt.market.mapper;

import com.smt.market.domain.SmtGoods;
import java.util.List;	

/**
 * 商品 数据层
 * 
 * @author smt
 * @date 2019-09-23
 */
public interface SmtGoodsMapper 
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
     * 删除商品
     * 
     * @param goodsId 商品ID
     * @return 结果
     */
	public int deleteSmtGoodsById(Integer goodsId);
	
	/**
     * 批量删除商品
     * 
     * @param goodsIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteSmtGoodsByIds(String[] goodsIds);
	
}