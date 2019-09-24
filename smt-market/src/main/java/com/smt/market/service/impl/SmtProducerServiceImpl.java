package com.smt.market.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smt.market.mapper.SmtProducerMapper;
import com.smt.market.domain.SmtProducer;
import com.smt.market.service.ISmtProducerService;
import com.smt.common.support.Convert;

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
	
}
