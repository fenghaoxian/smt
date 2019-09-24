package com.smt.market.service;

import com.smt.market.domain.SmtGoodsProducer;
import java.util.List;

/**
 * 商品与生产商关联 服务层
 * 
 * @author smt
 * @date 2019-09-23
 */
public interface ISmtGoodsProducerService 
{
	/**
     * 查询商品与生产商关联信息
     * 
     * @param goodsId 商品与生产商关联ID
     * @return 商品与生产商关联信息
     */
	public SmtGoodsProducer selectSmtGoodsProducerById(Integer goodsId);
	
	/**
     * 查询商品与生产商关联列表
     * 
     * @param smtGoodsProducer 商品与生产商关联信息
     * @return 商品与生产商关联集合
     */
	public List<SmtGoodsProducer> selectSmtGoodsProducerList(SmtGoodsProducer smtGoodsProducer);
	
	/**
     * 新增商品与生产商关联
     * 
     * @param smtGoodsProducer 商品与生产商关联信息
     * @return 结果
     */
	public int insertSmtGoodsProducer(SmtGoodsProducer smtGoodsProducer);
	
	/**
     * 修改商品与生产商关联
     * 
     * @param smtGoodsProducer 商品与生产商关联信息
     * @return 结果
     */
	public int updateSmtGoodsProducer(SmtGoodsProducer smtGoodsProducer);
		
	/**
     * 删除商品与生产商关联信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSmtGoodsProducerByIds(String ids);
	
}
