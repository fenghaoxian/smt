package com.smt.market.service;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Date: 2019/10/12
 * Author: fenghx
 * Desc:
 */
@WebService
public interface SubjectIntFaceFacade {

    public String sendDeclaration(@WebParam(name = "corpCode")String corpCode, @WebParam(name = "corpName")String corpName, @WebParam(name = "loginCode")String loginCode, @WebParam(name = "loginPassWord")String loginPassWord, @WebParam(name = "xmlStr") String xmlStr);

    /**
     * 数据状态查询
     * @param opType
     * @param param
     * @return
     */
    public String queryTradeInfo(@WebParam(name = "opType")String opType, @WebParam(name = "param")String param);

}
