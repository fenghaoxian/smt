package com.smt.market.service;

import com.smt.market.domain.SmtOrder;

import java.util.Iterator;
import java.util.List;

/**
 * 交易单 服务层
 * 
 * @author smt
 * @date 2019-09-27
 */
public interface ISmtOrderService 
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
     * 删除交易单信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSmtOrderByIds(String ids);

	public String insert(Iterator iterator);
	
}
