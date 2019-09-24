package com.smt.market.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smt.market.mapper.SmtUserCompanyMapper;
import com.smt.market.domain.SmtUserCompany;
import com.smt.market.service.ISmtUserCompanyService;
import com.smt.common.support.Convert;

/**
 * 用户与企业关联 服务层实现
 * 
 * @author smt
 * @date 2019-09-03
 */
@Service
public class SmtUserCompanyServiceImpl implements ISmtUserCompanyService 
{
	@Autowired
	private SmtUserCompanyMapper smtUserCompanyMapper;

	/**
     * 查询用户与企业关联信息
     * 
     * @param userId 用户与企业关联ID
     * @return 用户与企业关联信息
     */
    @Override
	public SmtUserCompany selectSmtUserCompanyById(Integer userId)
	{
	    return smtUserCompanyMapper.selectSmtUserCompanyById(userId);
	}
	
	/**
     * 查询用户与企业关联列表
     * 
     * @param smtUserCompany 用户与企业关联信息
     * @return 用户与企业关联集合
     */
	@Override
	public List<SmtUserCompany> selectSmtUserCompanyList(SmtUserCompany smtUserCompany)
	{
	    return smtUserCompanyMapper.selectSmtUserCompanyList(smtUserCompany);
	}
	
    /**
     * 新增用户与企业关联
     * 
     * @param smtUserCompany 用户与企业关联信息
     * @return 结果
     */
	@Override
	public int insertSmtUserCompany(SmtUserCompany smtUserCompany)
	{
	    return smtUserCompanyMapper.insertSmtUserCompany(smtUserCompany);
	}
	
	/**
     * 修改用户与企业关联
     * 
     * @param smtUserCompany 用户与企业关联信息
     * @return 结果
     */
	@Override
	public int updateSmtUserCompany(SmtUserCompany smtUserCompany)
	{
	    return smtUserCompanyMapper.updateSmtUserCompany(smtUserCompany);
	}

	/**
     * 删除用户与企业关联对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSmtUserCompanyByIds(String ids)
	{
		return smtUserCompanyMapper.deleteSmtUserCompanyByIds(Convert.toStrArray(ids));
	}
	
}
