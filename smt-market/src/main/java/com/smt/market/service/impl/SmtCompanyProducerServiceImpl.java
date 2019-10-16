package com.smt.market.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smt.market.mapper.SmtCompanyProducerMapper;
import com.smt.market.domain.SmtCompanyProducer;
import com.smt.market.service.ISmtCompanyProducerService;
import com.smt.common.support.Convert;

/**
 * 商户与生产商关联 服务层实现
 * 
 * @author smt
 * @date 2019-10-16
 */
@Service
public class SmtCompanyProducerServiceImpl implements ISmtCompanyProducerService 
{
	@Autowired
	private SmtCompanyProducerMapper smtCompanyProducerMapper;

	/**
     * 查询商户与生产商关联信息
     * 
     * @param companyId 商户与生产商关联ID
     * @return 商户与生产商关联信息
     */
    @Override
	public SmtCompanyProducer selectSmtCompanyProducerById(Integer companyId)
	{
	    return smtCompanyProducerMapper.selectSmtCompanyProducerById(companyId);
	}
	
	/**
     * 查询商户与生产商关联列表
     * 
     * @param smtCompanyProducer 商户与生产商关联信息
     * @return 商户与生产商关联集合
     */
	@Override
	public List<SmtCompanyProducer> selectSmtCompanyProducerList(SmtCompanyProducer smtCompanyProducer)
	{
	    return smtCompanyProducerMapper.selectSmtCompanyProducerList(smtCompanyProducer);
	}
	
    /**
     * 新增商户与生产商关联
     * 
     * @param smtCompanyProducer 商户与生产商关联信息
     * @return 结果
     */
	@Override
	public int insertSmtCompanyProducer(SmtCompanyProducer smtCompanyProducer)
	{
	    return smtCompanyProducerMapper.insertSmtCompanyProducer(smtCompanyProducer);
	}
	
	/**
     * 修改商户与生产商关联
     * 
     * @param smtCompanyProducer 商户与生产商关联信息
     * @return 结果
     */
	@Override
	public int updateSmtCompanyProducer(SmtCompanyProducer smtCompanyProducer)
	{
	    return smtCompanyProducerMapper.updateSmtCompanyProducer(smtCompanyProducer);
	}

	/**
     * 删除商户与生产商关联对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSmtCompanyProducerByIds(String ids)
	{
		return smtCompanyProducerMapper.deleteSmtCompanyProducerByIds(Convert.toStrArray(ids));
	}
	
}
