package com.smt.web.core.config;

import com.smt.market.service.ISmtSubTradeInfoService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * Date: 2019/9/5
 * Author: fenghx
 * Desc:
 */
@Configuration
public class WebServiceConfig {

    @Autowired
    private ISmtSubTradeInfoService subTradeInfoService;

    @Autowired
    private Bus bus;

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, subTradeInfoService);
        endpoint.publish("/subTradeInfo");
        endpoint.publish("/queryTradeInfo");
        return endpoint;
    }
}
