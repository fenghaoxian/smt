package com.smt.market.service;

import com.smt.market.domain.SmtBuyer;
import com.smt.market.domain.SmtCompany;

import java.util.Iterator;
import java.util.List;

/**
 * 采购商 服务层
 * 
 * @author smt
 * @date 2019-10-14
 */
public interface ISmtBuyerService 
{
	/**
     * 查询采购商信息
     * 
     * @param buyerId 采购商ID
     * @return 采购商信息
     */
	public SmtBuyer selectSmtBuyerById(Integer buyerId);
	
	/**
     * 查询采购商列表
     * 
     * @param smtBuyer 采购商信息
     * @return 采购商集合
     */
	public List<SmtBuyer> selectSmtBuyerList(SmtBuyer smtBuyer);
	
	/**
     * 新增采购商
     * 
     * @param smtBuyer 采购商信息
     * @return 结果
     */
	public int insertSmtBuyer(SmtBuyer smtBuyer);
	
	/**
     * 修改采购商
     * 
     * @param smtBuyer 采购商信息
     * @return 结果
     */
	public int updateSmtBuyer(SmtBuyer smtBuyer);
		
	/**
     * 删除采购商信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSmtBuyerByIds(String ids);

	public void insertCompanyBuyer(SmtBuyer buyer, SmtCompany company);

	public String insert(Iterator iterator);

	public String execBuyer(String opType, SmtBuyer buyer, String createOrg);

	public String getBuyerXmlStr(String opType, SmtBuyer buyer, String createOrg);
	
}
