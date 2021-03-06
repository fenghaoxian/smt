package com.smt.market.mapper;

import com.smt.market.domain.SmtUserCompany;
import java.util.List;	

/**
 * 用户与企业关联 数据层
 * 
 * @author smt
 * @date 2019-09-03
 */
public interface SmtUserCompanyMapper 
{
	/**
     * 查询用户与企业关联信息
     * 
     * @param userId 用户与企业关联ID
     * @return 用户与企业关联信息
     */
	public SmtUserCompany selectSmtUserCompanyById(Integer userId);
	
	/**
     * 查询用户与企业关联列表
     * 
     * @param smtUserCompany 用户与企业关联信息
     * @return 用户与企业关联集合
     */
	public List<SmtUserCompany> selectSmtUserCompanyList(SmtUserCompany smtUserCompany);
	
	/**
     * 新增用户与企业关联
     * 
     * @param smtUserCompany 用户与企业关联信息
     * @return 结果
     */
	public int insertSmtUserCompany(SmtUserCompany smtUserCompany);
	
	/**
     * 修改用户与企业关联
     * 
     * @param smtUserCompany 用户与企业关联信息
     * @return 结果
     */
	public int updateSmtUserCompany(SmtUserCompany smtUserCompany);
	
	/**
     * 删除用户与企业关联
     * 
     * @param userId 用户与企业关联ID
     * @return 结果
     */
	public int deleteSmtUserCompanyById(Integer userId);
	
	/**
     * 批量删除用户与企业关联
     * 
     * @param userIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteSmtUserCompanyByIds(String[] userIds);
	
}