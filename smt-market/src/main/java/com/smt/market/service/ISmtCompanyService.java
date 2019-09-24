package com.smt.market.service;

import com.smt.market.domain.SmtCompany;

import java.util.Iterator;
import java.util.List;

/**
 * 企业 服务层
 * 
 * @author smt
 * @date 2019-09-06
 */
public interface ISmtCompanyService 
{
	/**
     * 查询企业信息
     * 
     * @param companyId 企业ID
     * @return 企业信息
     */
	public SmtCompany selectSmtCompanyById(Integer companyId);
	
	/**
     * 查询企业列表
     * 
     * @param smtCompany 企业信息
     * @return 企业集合
     */
	public List<SmtCompany> selectSmtCompanyList(SmtCompany smtCompany);
	
	/**
     * 新增企业
     * 
     * @param smtCompany 企业信息
     * @return 结果
     */
	public int insertSmtCompany(SmtCompany smtCompany);
	
	/**
     * 修改企业
     * 
     * @param smtCompany 企业信息
     * @return 结果
     */
	public int updateSmtCompany(SmtCompany smtCompany);
		
	/**
     * 删除企业信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSmtCompanyByIds(String ids);

	public String insert(Iterator iterator);
	
}
