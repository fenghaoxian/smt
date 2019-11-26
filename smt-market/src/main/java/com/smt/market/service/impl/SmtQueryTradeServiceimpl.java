package com.smt.market.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.smt.market.service.ISmtCompanyService;
import com.smt.market.service.ISmtQueryTradeInfoService;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Iterator;

/**
 * Date: 2019/11/26
 * Author: fenghx
 * Desc:
 */
public class SmtQueryTradeServiceimpl implements ISmtQueryTradeInfoService {

    @Autowired
    private ISmtCompanyService companyService;

    Logger logger = LoggerFactory.getLogger(SmtSubTradeInfoServiceImpl.class);

    @Override
    public String queryTradeInfo(String data) throws Exception {
        logger.info(data);
        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        SAXReader reader = new SAXReader();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
                        return companyService.query(decIter, messageType);
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
