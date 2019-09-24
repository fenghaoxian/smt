package com.smt.market.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smt.market.mapper.SmtGoodsProducerMapper;
import com.smt.market.domain.SmtGoodsProducer;
import com.smt.market.service.ISmtGoodsProducerService;
import com.smt.common.support.Convert;

/**
 * 商品与生产商关联 服务层实现
 * 
 * @author smt
 * @date 2019-09-23
 */
@Service
public class SmtGoodsProducerServiceImpl implements ISmtGoodsProducerService 
{
	@Autowired
	private SmtGoodsProducerMapper smtGoodsProducerMapper;

	/**
     * 查询商品与生产商关联信息
     * 
     * @param goodsId 商品与生产商关联ID
     * @return 商品与生产商关联信息
     */
    @Override
	public SmtGoodsProducer selectSmtGoodsProducerById(Integer goodsId)
	{
	    return smtGoodsProducerMapper.selectSmtGoodsProducerById(goodsId);
	}
	
	/**
     * 查询商品与生产商关联列表
     * 
     * @param smtGoodsProducer 商品与生产商关联信息
     * @return 商品与生产商关联集合
     */
	@Override
	public List<SmtGoodsProducer> selectSmtGoodsProducerList(SmtGoodsProducer smtGoodsProducer)
	{
	    return smtGoodsProducerMapper.selectSmtGoodsProducerList(smtGoodsProducer);
	}
	
    /**
     * 新增商品与生产商关联
     * 
     * @param smtGoodsProducer 商品与生产商关联信息
     * @return 结果
     */
	@Override
	public int insertSmtGoodsProducer(SmtGoodsProducer smtGoodsProducer)
	{
	    return smtGoodsProducerMapper.insertSmtGoodsProducer(smtGoodsProducer);
	}
	
	/**
     * 修改商品与生产商关联
     * 
     * @param smtGoodsProducer 商品与生产商关联信息
     * @return 结果
     */
	@Override
	public int updateSmtGoodsProducer(SmtGoodsProducer smtGoodsProducer)
	{
	    return smtGoodsProducerMapper.updateSmtGoodsProducer(smtGoodsProducer);
	}

	/**
     * 删除商品与生产商关联对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSmtGoodsProducerByIds(String ids)
	{
		return smtGoodsProducerMapper.deleteSmtGoodsProducerByIds(Convert.toStrArray(ids));
	}
	
}
