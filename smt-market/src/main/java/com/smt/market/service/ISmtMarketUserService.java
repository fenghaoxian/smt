package com.smt.market.service;

import com.smt.market.domain.SmtMarketUser;

import java.util.Iterator;
import java.util.List;

/**
 * 委托关系 服务层
 * 
 * @author smt
 * @date 2019-10-16
 */
public interface ISmtMarketUserService 
{
	/**
     * 查询委托关系信息
     * 
     * @param marketId 委托关系ID
     * @return 委托关系信息
     */
	public SmtMarketUser selectSmtMarketUserById(Integer marketId);

	public SmtMarketUser selectSmtMarketUserBySgsRegCode(String sgsRegCode);
	
	/**
     * 查询委托关系列表
     * 
     * @param smtMarketUser 委托关系信息
     * @return 委托关系集合
     */
	public List<SmtMarketUser> selectSmtMarketUserList(SmtMarketUser smtMarketUser);
	
	/**
     * 新增委托关系
     * 
     * @param smtMarketUser 委托关系信息
     * @return 结果
     */
	public int insertSmtMarketUser(SmtMarketUser smtMarketUser);
	
	/**
     * 修改委托关系
     * 
     * @param smtMarketUser 委托关系信息
     * @return 结果
     */
	public int updateSmtMarketUser(SmtMarketUser smtMarketUser);
		
	/**
     * 删除委托关系信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSmtMarketUserByIds(String ids);

	public String execClientage(Iterator iterator);

	public String getClientageXml(List<SmtMarketUser> list);

}
