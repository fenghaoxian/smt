package com.smt.market.mapper;

import com.smt.market.domain.SmtBuyer;
import java.util.List;	

/**
 * 采购商 数据层
 * 
 * @author smt
 * @date 2019-10-14
 */
public interface SmtBuyerMapper 
{
	/**
     * 查询采购商信息
     * 
     * @param buyerId 采购商ID
     * @return 采购商信息
     */
	public SmtBuyer selectSmtBuyerById(Integer buyerId);

	public SmtBuyer selectSmtBuyerByCorpCode(String corpCode);
	
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
     * 删除采购商
     * 
     * @param buyerId 采购商ID
     * @return 结果
     */
	public int deleteSmtBuyerById(Integer buyerId);
	
	/**
     * 批量删除采购商
     * 
     * @param buyerIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteSmtBuyerByIds(String[] buyerIds);
	
}