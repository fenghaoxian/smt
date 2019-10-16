package com.smt.market.mapper;

import com.smt.market.domain.SmtCompanyProducer;
import java.util.List;	

/**
 * 商户与生产商关联 数据层
 * 
 * @author smt
 * @date 2019-10-16
 */
public interface SmtCompanyProducerMapper 
{
	/**
     * 查询商户与生产商关联信息
     * 
     * @param companyId 商户与生产商关联ID
     * @return 商户与生产商关联信息
     */
	public SmtCompanyProducer selectSmtCompanyProducerById(Integer companyId);
	
	/**
     * 查询商户与生产商关联列表
     * 
     * @param smtCompanyProducer 商户与生产商关联信息
     * @return 商户与生产商关联集合
     */
	public List<SmtCompanyProducer> selectSmtCompanyProducerList(SmtCompanyProducer smtCompanyProducer);
	
	/**
     * 新增商户与生产商关联
     * 
     * @param smtCompanyProducer 商户与生产商关联信息
     * @return 结果
     */
	public int insertSmtCompanyProducer(SmtCompanyProducer smtCompanyProducer);
	
	/**
     * 修改商户与生产商关联
     * 
     * @param smtCompanyProducer 商户与生产商关联信息
     * @return 结果
     */
	public int updateSmtCompanyProducer(SmtCompanyProducer smtCompanyProducer);
	
	/**
     * 删除商户与生产商关联
     * 
     * @param companyId 商户与生产商关联ID
     * @return 结果
     */
	public int deleteSmtCompanyProducerById(Integer companyId);
	
	/**
     * 批量删除商户与生产商关联
     * 
     * @param companyIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteSmtCompanyProducerByIds(String[] companyIds);
	
}