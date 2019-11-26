package com.smt.market.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Date: 2019/11/26
 * Author: fenghx
 * Desc:
 */
@WebService
public interface ISmtQueryTradeInfoService {

    @WebMethod
    public String queryTradeInfo(@WebParam(name = "data") String data) throws Exception;
}
