package com.smt.market.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smt.market.mapper.SmtCompanyBuyerMapper;
import com.smt.market.domain.SmtCompanyBuyer;
import com.smt.market.service.ISmtCompanyBuyerService;
import com.smt.common.support.Convert;

/**
 * 商户与采购商关联 服务层实现
 * 
 * @author smt
 * @date 2019-10-14
 */
@Service
public class SmtCompanyBuyerServiceImpl implements ISmtCompanyBuyerService 
{
	@Autowired
	private SmtCompanyBuyerMapper smtCompanyBuyerMapper;

	/**
     * 查询商户与采购商关联信息
     * 
     * @param companyId 商户与采购商关联ID
     * @return 商户与采购商关联信息
     */
    @Override
	public SmtCompanyBuyer selectSmtCompanyBuyerById(Integer companyId)
	{
	    return smtCompanyBuyerMapper.selectSmtCompanyBuyerById(companyId);
	}
	
	/**
     * 查询商户与采购商关联列表
     * 
     * @param smtCompanyBuyer 商户与采购商关联信息
     * @return 商户与采购商关联集合
     */
	@Override
	public List<SmtCompanyBuyer> selectSmtCompanyBuyerList(SmtCompanyBuyer smtCompanyBuyer)
	{
	    return smtCompanyBuyerMapper.selectSmtCompanyBuyerList(smtCompanyBuyer);
	}
	
    /**
     * 新增商户与采购商关联
     * 
     * @param smtCompanyBuyer 商户与采购商关联信息
     * @return 结果
     */
	@Override
	public int insertSmtCompanyBuyer(SmtCompanyBuyer smtCompanyBuyer)
	{
	    return smtCompanyBuyerMapper.insertSmtCompanyBuyer(smtCompanyBuyer);
	}
	
	/**
     * 修改商户与采购商关联
     * 
     * @param smtCompanyBuyer 商户与采购商关联信息
     * @return 结果
     */
	@Override
	public int updateSmtCompanyBuyer(SmtCompanyBuyer smtCompanyBuyer)
	{
	    return smtCompanyBuyerMapper.updateSmtCompanyBuyer(smtCompanyBuyer);
	}

	/**
     * 删除商户与采购商关联对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSmtCompanyBuyerByIds(String ids)
	{
		return smtCompanyBuyerMapper.deleteSmtCompanyBuyerByIds(Convert.toStrArray(ids));
	}
	
}
