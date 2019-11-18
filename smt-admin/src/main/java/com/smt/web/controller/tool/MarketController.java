package com.smt.web.controller.tool;

import com.smt.framework.web.base.BaseController;
import com.smt.market.service.ISmtCompanyService;
import com.smt.market.service.ISmtSubTradeInfoService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Date: 2019/11/18
 * Author: fenghx
 * Desc:
 */
@Controller
@RequestMapping("/tool/market")
public class MarketController extends BaseController {

    @Autowired
    ISmtSubTradeInfoService subTradeInfoService;

    @Autowired
    ISmtCompanyService companyService;

    private String prefix = "tool/market";

    @ApiOperation(value = "报文测试", notes = "报文测试")
    @RequiresPermissions("tool:market:insert")
    @PostMapping("/insert")
    @ResponseBody
    public String companyInsert(HttpServletRequest request, @RequestParam(value = "file", required = true)MultipartFile companyXml) throws Exception {
        InputStream inputStream = companyXml.getInputStream();
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        String str = result.toString(StandardCharsets.UTF_8.name());
        return subTradeInfoService.subTradeInfo(str);
        /*SAXReader reader = new SAXReader();
        Document document = reader.read(new StringReader(str));
        if (document != null) {
            Element rootElt = document.getRootElement();
            Iterator headIter = rootElt.elementIterator("Head");
            if (headIter.hasNext()) {
                Iterator decIter = rootElt.elementIterator("Declaration");
                if (decIter.hasNext()) {
                    return companyService.insert(decIter);
                }
            }
            return "";
        }*/
    }

    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<SubjectInfo>\n" +
                        " <Head>\n" +
                        "  <opType>A</opType>\n" +
                        "  <MessageId>COMP_JB1039_201911181019511775</MessageId>\n" +
                        "  <MessageType>COMP</MessageType>\n" +
                        "  <Sender>JB1039</Sender>\n" +
                        "  <Receiver>i1039</Receiver>\n" +
                        " </Head>\n" +
                        " <Declaration>\n" +
                        "  <Company>\n" +
                        "   <sgsRegCode>92440101MA5AU3M662</sgsRegCode>\n" +
                        "   <regionCode>440114</regionCode>\n" +
                        "   <taxAuthoritiesCode>440114</taxAuthoritiesCode>\n" +
                        "   <corpCname>广州市花都区狮岭呵营贸易商行</corpCname>\n" +
                        "   <corpEname>TESTaaa</corpEname>\n" +
                        "   <corpShortName>呵营贸易商行</corpShortName>\n" +
                        "   <corpOrgCode>92440101MA5AU3M662</corpOrgCode>\n" +
                        "   <corpType>1</corpType>\n" +
                        "   <characters>9</characters>\n" +
                        "   <legalName>吴燕妹</legalName>\n" +
                        "   <identCode>1</identCode>\n" +
                        "   <legalIdCode>445281199905175849</legalIdCode>\n" +
                        "   <contractMan>雷前星</contractMan>\n" +
                        "   <username>king</username>\n" +
                        "   <password>pNsE+ekdwsxxcNSKa9igQg==</password>\n" +
                        "   <loginUserName></loginUserName>\n" +
                        "   <logPassWd></logPassWd>\n" +
                        "   <cellphoneNo>14514585069</cellphoneNo>\n" +
                        "   <caddress>广州市花都区狮岭镇贵丽南横街14号之145273</caddress>\n" +
                        "   <regMoney>100</regMoney>\n" +
                        "   <companyType>1</companyType>\n" +
                        "   <scope>商品批发贸易（许可审批类商品除外）;商品零售贸易（许可审批类商品除外）;五金产品批发;五金零售;</scope>\n" +
                        "   <industryType>107_0100</industryType>\n" +
                        "   <taxIdentCode>92440101MA5AU3M662</taxIdentCode>\n" +
                        "   <corpTaxType>105_01</corpTaxType>\n" +
                        "   <customCode></customCode>\n" +
                        "   <declCode></declCode>\n" +
                        "   <ioCorpCode>92440101MA5AU3M662</ioCorpCode>\n" +
                        "   <creditLevel>A</creditLevel>\n" +
                        "   <validateBeg>1970-01-01</validateBeg>\n" +
                        "   <validateEnd>1970-01-01</validateEnd>\n" +
                        "   <regDate>2018-09-29</regDate>\n" +
                        "   <orgAddress>广州市花都区狮岭镇贵丽南横街14号之145273</orgAddress>\n" +
                        "   <locationfCode>440000</locationfCode>\n" +
                        "  </Company>\n" +
                        " </Declaration>\n" +
                        "</SubjectInfo>";
        //String s = formatXml(xml);
        //System.out.println(s);

        String s = test1();
        System.out.println(s);
    }

    public static String formatXml(String inputXML) throws Exception {
        String xml = null;
        SAXReader reader = new SAXReader();
        XMLWriter writer = null;
        org.dom4j.Document document = reader.read(new StringReader(inputXML));
        try {
            if (document != null) {
                StringWriter stringWriter = new StringWriter();
                OutputFormat format = OutputFormat.createPrettyPrint();
                format.setNewLineAfterDeclaration(false);
                writer = new XMLWriter(stringWriter, format);
                writer.write(document);
                writer.flush();
                xml = stringWriter.getBuffer().toString();
            }
        } finally {
            if (writer != null) {
                try {
                    writer.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return xml;
    }

    public static String test1 () {
        SAXReader saxReader=new SAXReader();
        Document document;
        String xmlString="";
        try {
            document = saxReader.read(new File("F:\\360MoveData\\Users\\Administrator\\Desktop\\报文.xml"));
            xmlString=document.asXML();//将xml内容转化为字符串
        } catch (Exception e) {
// TODO Auto-generated catch block
            e.printStackTrace();
            xmlString="";
        }
//String xmlString=document.asXML();
        return xmlString;
    }
}
