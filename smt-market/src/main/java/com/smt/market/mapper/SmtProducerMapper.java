package com.smt.market.mapper;

import com.smt.market.domain.SmtProducer;
import java.util.List;	

/**
 * 生产商 数据层
 * 
 * @author smt
 * @date 2019-09-23
 */
public interface SmtProducerMapper 
{
	/**
     * 查询生产商信息
     * 
     * @param producerId 生产商ID
     * @return 生产商信息
     */
	public SmtProducer selectSmtProducerById(Integer producerId);

	/**
	 * 查询生产商信息
	 * @param corpCode 证件代码
	 * @return
	 */
	public SmtProducer selectSmtProducerByCorpCode(String corpCode);
	
	/**
     * 查询生产商列表
     * 
     * @param smtProducer 生产商信息
     * @return 生产商集合
     */
	public List<SmtProducer> selectSmtProducerList(SmtProducer smtProducer);
	
	/**
     * 新增生产商
     * 
     * @param smtProducer 生产商信息
     * @return 结果
     */
	public int insertSmtProducer(SmtProducer smtProducer);
	
	/**
     * 修改生产商
     * 
     * @param smtProducer 生产商信息
     * @return 结果
     */
	public int updateSmtProducer(SmtProducer smtProducer);
	
	/**
     * 删除生产商
     * 
     * @param producerId 生产商ID
     * @return 结果
     */
	public int deleteSmtProducerById(Integer producerId);
	
	/**
     * 批量删除生产商
     * 
     * @param producerIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteSmtProducerByIds(String[] producerIds);
	
}