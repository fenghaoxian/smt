package com.smt.market.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Date: 2019/9/4
 * Author: fenghx
 * Desc:
 */
@WebService
public interface ISmtSubTradeInfoService {

    @WebMethod
    public String subTradeInfo(@WebParam(name = "data") String data) throws Exception;
}
