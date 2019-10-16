package com.smt.market.mapper;

import com.smt.market.domain.SmtOrder;
import java.util.List;	

/**
 * 交易单 数据层
 * 
 * @author smt
 * @date 2019-09-27
 */
public interface SmtOrderMapper 
{
	/**
     * 查询交易单信息
     * 
     * @param orderId 交易单ID
     * @return 交易单信息
     */
	public SmtOrder selectSmtOrderById(Integer orderId);
	
	/**
     * 查询交易单列表
     * 
     * @param smtOrder 交易单信息
     * @return 交易单集合
     */
	public List<SmtOrder> selectSmtOrderList(SmtOrder smtOrder);
	
	/**
     * 新增交易单
     * 
     * @param smtOrder 交易单信息
     * @return 结果
     */
	public int insertSmtOrder(SmtOrder smtOrder);
	
	/**
     * 修改交易单
     * 
     * @param smtOrder 交易单信息
     * @return 结果
     */
	public int updateSmtOrder(SmtOrder smtOrder);
	
	/**
     * 删除交易单
     * 
     * @param orderId 交易单ID
     * @return 结果
     */
	public int deleteSmtOrderById(Integer orderId);
	
	/**
     * 批量删除交易单
     * 
     * @param orderIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteSmtOrderByIds(String[] orderIds);
	
}