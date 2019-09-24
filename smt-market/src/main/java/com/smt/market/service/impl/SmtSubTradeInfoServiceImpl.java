package com.smt.market.service.impl;

import com.smt.common.json.JSONObject;
import com.smt.market.service.ISmtCompanyService;
import com.smt.market.service.ISmtGoodsService;
import com.smt.market.service.ISmtSubTradeInfoService;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.io.StringReader;
import java.util.Iterator;

/**
 * Date: 2019/9/4
 * Author: fenghx
 * Desc:
 */
@Component
@WebService
public class SmtSubTradeInfoServiceImpl implements ISmtSubTradeInfoService {

    @Autowired
    private ISmtCompanyService companyService;

    @Autowired
    private ISmtGoodsService goodsService;

    @Override
    public String subTradeInfo(String data) throws Exception {
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
