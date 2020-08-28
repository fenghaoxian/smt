package com.smt.market.mapper;

import com.smt.market.domain.SmtCustom;
import java.util.List;	

/**
 * 一次性录入 数据层
 * 
 * @author smt
 * @date 2019-11-18
 */
public interface SmtCustomMapper 
{
	/**
     * 查询一次性录入信息
     * 
     * @param customId 一次性录入ID
     * @return 一次性录入信息
     */
	public SmtCustom selectSmtCustomById(Integer customId);
	
	/**
     * 查询一次性录入列表
     * 
     * @param smtCustom 一次性录入信息
     * @return 一次性录入集合
     */
	public List<SmtCustom> selectSmtCustomList(SmtCustom smtCustom);
	
	/**
     * 新增一次性录入
     * 
     * @param smtCustom 一次性录入信息
     * @return 结果
     */
	public int insertSmtCustom(SmtCustom smtCustom);
	
	/**
     * 修改一次性录入
     * 
     * @param smtCustom 一次性录入信息
     * @return 结果
     */
	public int updateSmtCustom(SmtCustom smtCustom);
	
	/**
     * 删除一次性录入
     * 
     * @param customId 一次性录入ID
     * @return 结果
     */
	public int deleteSmtCustomById(Integer customId);
	
	/**
     * 批量删除一次性录入
     * 
     * @param customIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteSmtCustomByIds(String[] customIds);
	
}