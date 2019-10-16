package com.smt.market.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.smt.market.service.*;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.StringReader;
import java.util.Iterator;

/**
 * Date: 2019/9/4
 * Author: fenghx
 * Desc:
 @Component
 @WebService
 */
public class SmtSubTradeInfoServiceImpl implements ISmtSubTradeInfoService {

    @Autowired
    private ISmtCompanyService companyService;

    @Autowired
    private ISmtGoodsService goodsService;

    @Autowired
    private ISmtOrderService orderService;

    @Autowired
    private ISmtProducerService producerService;

    @Autowired
    private ISmtBuyerService buyerService;

    @Autowired
    private ISmtMarketUserService marketUserService;

    Logger logger = LoggerFactory.getLogger(SmtSubTradeInfoServiceImpl.class);

    @Override
    public String subTradeInfo(String data) throws Exception {
        logger.info(data);
        JSONObject json = new JSONObject();
        SAXReader reader = new SAXReader();
        Document document = reader.read(new StringReader(data));
        if (document != null) {
            Element rootElt = document.getRootElement();
            Iterator headIter = rootElt.elementIterator("Head");
            if (headIter.hasNext()) {
                Element recordEle = (Element) headIter.next();
                Iterator decIter = rootElt.elementIterator("Declaration");
                if (decIter.hasNext()) {
                    String messageType = recordEle.elementTextTrim("MessageType");
                    if ("COMP".equals(messageType)) {
                        String msg = companyService.insert(decIter);
                        return msg;
                    } else if ("GOODS".equals(messageType)) {
                        String msg = goodsService.insert(decIter);
                        return msg;
                    } else if ("TRAD".equals(messageType)) {
                        String msg = orderService.insert(decIter);
                        return msg;
                    } else if ("BUYER".equals(messageType)) {
                        String msg = buyerService.insert(decIter);
                        return msg;
                    } else if ("MAF".equals(messageType)) {
                        String msg = producerService.insert(decIter);
                        return msg;
                    } else if ("CLIENTAGE".equals(messageType)) {
                        String msg = marketUserService.execClientage(decIter);
                        return msg;
                    } else {
                        json.put("msg", "失败");
                        json.put("status", false);
                        return json.toString();
                    }
                } else {
                    json.put("msg", "失败");
                    json.put("status", false);
                    return json.toString();
                }
            } else {
                json.put("msg", "失败");
                json.put("status", false);
                return json.toString();
            }
        } else {
            json.put("msg", "失败");
            json.put("status", false);
            return json.toString();
        }
    }

}
