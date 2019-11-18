package com.smt.market.service.impl;

import com.smt.common.config.Global;
import com.smt.common.utils.DesEcrypt;
import com.smt.common.utils.HttpUtil;
import com.smt.market.service.SubjectIntFaceFacade;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2019/10/12
 * Author: fenghx
 * Desc:
 */
@WebService(serviceName = "SubjectIntFaceFacade")
@Service("subjectIntFaceFacade")
@Transactional
public class SubjectIntFaceFacadeImpl implements SubjectIntFaceFacade {

    /**
     * 发送报文
     * @param corpCode
     * @param corpName
     * @param loginCode
     * @param loginPassWord
     * @param xmlStr
     * @return
     */
    @Override
    public String sendDeclaration(@WebParam(name = "corpCode")String corpCode, @WebParam(name = "corpName")String corpName, @WebParam(name = "loginCode")String loginCode, @WebParam(name = "loginPassWord")String loginPassWord, @WebParam(name = "xmlStr") String xmlStr) {
        String response = "";
        DesEcrypt asd =new DesEcrypt();
        try {
            //设置登录参数
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            nvps.add(new BasicNameValuePair("corpCode",asd.EncryStrHex(asd.GB2Code(corpCode), "GZMARKET2017")));
            nvps.add(new BasicNameValuePair("corpName",asd.EncryStrHex(asd.GB2Code(corpName), "GZMARKET2017")));
            nvps.add(new BasicNameValuePair("loginCode",asd.EncryStrHex(asd.GB2Code(loginCode), "GZMARKET2017")));
            nvps.add(new BasicNameValuePair("loginPassWord",asd.EncryStrHex(asd.GB2Code(loginPassWord), "GZMARKET2017")));
            nvps.add(new BasicNameValuePair("report",xmlStr)); //必填 xml格式报文字符串
            response= HttpUtil.sendPost(Global.getConfig("trade.tradeUrl"), nvps);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * 数据状态查询
     * @param opType
     * @param param
     * @return
     */
    public String queryTradeInfo(@WebParam(name = "opType")String opType, @WebParam(name = "param")String param){
        String response = "";
        DesEcrypt asd =new DesEcrypt();
        try {
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            nvps.add(new BasicNameValuePair("corpCode",asd.EncryStrHex(asd.GB2Code(Global.getConfig("trade.corpCode")), "GZMARKET2017")));
            nvps.add(new BasicNameValuePair("corpName",asd.EncryStrHex(asd.GB2Code(Global.getConfig("trade.corpName")), "GZMARKET2017")));
            nvps.add(new BasicNameValuePair("loginCode",asd.EncryStrHex(asd.GB2Code(Global.getConfig("loginCode")), "GZMARKET2017")));
            nvps.add(new BasicNameValuePair("loginPassWord",asd.EncryStrHex(asd.GB2Code(Global.getConfig("loginPassWord")), "GZMARKET2017")));
            nvps.add(new BasicNameValuePair("opType",asd.EncryStrHex(asd.GB2Code(opType), "GZMARKET2017")));
            nvps.add(new BasicNameValuePair("param",asd.EncryStrHex(asd.GB2Code(param), "GZMARKET2017")));
            response= HttpUtil.sendPost(Global.getConfig("trade.queryTradeUrl"), nvps);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

}
