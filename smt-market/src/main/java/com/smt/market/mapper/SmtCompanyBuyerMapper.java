package com.smt.market.mapper;

import com.smt.market.domain.SmtCompanyBuyer;
import java.util.List;	

/**
 * 商户与采购商关联 数据层
 * 
 * @author smt
 * @date 2019-10-14
 */
public interface SmtCompanyBuyerMapper 
{
	/**
     * 查询商户与采购商关联信息
     * 
     * @param companyId 商户与采购商关联ID
     * @return 商户与采购商关联信息
     */
	public SmtCompanyBuyer selectSmtCompanyBuyerById(Integer companyId);
	
	/**
     * 查询商户与采购商关联列表
     * 
     * @param smtCompanyBuyer 商户与采购商关联信息
     * @return 商户与采购商关联集合
     */
	public List<SmtCompanyBuyer> selectSmtCompanyBuyerList(SmtCompanyBuyer smtCompanyBuyer);
	
	/**
     * 新增商户与采购商关联
     * 
     * @param smtCompanyBuyer 商户与采购商关联信息
     * @return 结果
     */
	public int insertSmtCompanyBuyer(SmtCompanyBuyer smtCompanyBuyer);
	
	/**
     * 修改商户与采购商关联
     * 
     * @param smtCompanyBuyer 商户与采购商关联信息
     * @return 结果
     */
	public int updateSmtCompanyBuyer(SmtCompanyBuyer smtCompanyBuyer);
	
	/**
     * 删除商户与采购商关联
     * 
     * @param companyId 商户与采购商关联ID
     * @return 结果
     */
	public int deleteSmtCompanyBuyerById(Integer companyId);
	
	/**
     * 批量删除商户与采购商关联
     * 
     * @param companyIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteSmtCompanyBuyerByIds(String[] companyIds);
	
}