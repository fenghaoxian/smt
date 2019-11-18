package com.smt.market.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.smt.market.service.*;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.StringReader;
import java.util.Iterator;

/**
 * Date: 2019/9/4
 * Author: fenghx
 * Desc:
 @Component
 @WebService
 */
@Service
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
        JSONArray jsonArray = new JSONArray();
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
                    String opType = recordEle.elementTextTrim("opType");
                    if ("COMP".equals(messageType)) {
                        return companyService.insert(decIter, opType);
                    } else if ("GOODS".equals(messageType)) {
                        return goodsService.insert(decIter);
                    } else if ("TRAD".equals(messageType)) {
                        return orderService.insert(decIter);
                    } else if ("BUYER".equals(messageType)) {
                        return buyerService.insert(decIter);
                    } else if ("MAF".equals(messageType)) {
                        return producerService.insert(decIter);
                    } else if ("CLIENTAGE".equals(messageType)) {
                        return marketUserService.execClientage(decIter);
                    } else if ("AUTO".equals(messageType)) {
                        return marketUserService.execClientage(decIter);
                    } else {
                        jsonArray.add("失败");
                        json.put("msg", jsonArray);
                        json.put("status", false);
                        return json.toString();
                    }
                } else {
                    jsonArray.add("失败");
                    json.put("msg", jsonArray);
                    json.put("status", false);
                    return json.toString();
                }
            } else {
                jsonArray.add("失败");
                json.put("msg", jsonArray);
                json.put("status", false);
                return json.toString();
            }
        } else {
            jsonArray.add("失败");
            json.put("msg", jsonArray);
            json.put("status", false);
            return json.toString();
        }
    }

}
