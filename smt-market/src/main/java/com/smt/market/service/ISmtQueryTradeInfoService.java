package com.smt.market.service;

import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 * Date: 2019/11/26
 * Author: fenghx
 * Desc:
 */
@Service
public interface ISmtQueryTradeInfoService {

    @WebMethod
    public String queryTradeInfo(@WebParam(name = "data") String data) throws Exception;
}
