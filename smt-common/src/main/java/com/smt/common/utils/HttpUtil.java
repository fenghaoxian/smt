package com.smt.common.utils;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import sun.misc.BASE64Encoder;

import javax.net.ssl.*;
import java.io.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.List;


public class HttpUtil {
	/** 
	 * 绕过验证 
	 *   
	 * @return 
	 * @throws NoSuchAlgorithmException  
	 * @throws KeyManagementException  
	 */  
	public static SSLContext createIgnoreVerifySSL() throws NoSuchAlgorithmException, KeyManagementException {
		SSLContext sc = SSLContext.getInstance("SSLv3");

		// 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
		X509TrustManager trustManager = new X509TrustManager() {
			@Override
			public void checkClientTrusted(
				java.security.cert.X509Certificate[] paramArrayOfX509Certificate, String paramString) throws CertificateException {

				}

			@Override
			public void checkServerTrusted(
				java.security.cert.X509Certificate[] paramArrayOfX509Certificate, String paramString) throws CertificateException {

	        	}
			@Override
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};

		sc.init(null, new TrustManager[] { trustManager }, null);
		return sc;
	}
	/* public static String sendPost(String url,List<NameValuePair> nvps ) throws Exception{
		 CloseableHttpClient httpClient = HttpClients.createDefault();
		 HttpPost httpPost=new HttpPost(url);//HTTP Get请求(POST雷同)
         httpPost.setEntity(new UrlEncodedFormEntity(nvps,"utf-8")); 
 		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(30000).setConnectTimeout(30000).build();//设置请求和传输超时时间
 		 httpPost.setConfig(requestConfig);
 		 HttpEntity hEntity;
 		try {
 			HttpResponse response = httpClient.execute(httpPost);//执行请求
 			hEntity = response.getEntity();
 			String result = EntityUtils.toString(hEntity);
 			
 			System.out.println("result:"+result);
 			return result;
 		} catch (ClientProtocolException e) {
 			e.printStackTrace();
 			return "";
 		} 
	}*/
	public static String sendPost(String url,List<NameValuePair> nvps)  throws Exception{
		//采用绕过验证的方式处理https请求
	    SSLContext sslcontext = createIgnoreVerifySSL();

			// 设置协议http和https对应的处理socket链接工厂的对象
			Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
	           .register("http", PlainConnectionSocketFactory.INSTANCE)  
	           .register("https", new SSLConnectionSocketFactory(sslcontext, new HostnameVerifier(){  
                 @Override  
                 public boolean verify(String hostname, SSLSession session) {  
                    /* hostname = "*.singlewindow.gz.cn";  
                     return SSLConnectionSocketFactory.getDefaultHostnameVerifier().verify(hostname, session);  */
                 	return true;
                 }  
           
     }) )  
	           .build();  
	       PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);  
	       HttpClients.custom().setConnectionManager(connManager);  
	  
	       //创建自定义的httpclient对象  
	    CloseableHttpClient client = HttpClients.custom().setConnectionManager(connManager).build();  
	//      CloseableHttpClient client = HttpClients.createDefault();  
	      
	    //创建post方式请求对象  
	    HttpPost httpPost = new HttpPost(url);  
	      
	    //设置参数到请求对象中  
	    httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));  
	      
	    //执行请求操作，并拿到结果（同步阻塞）  
	    CloseableHttpResponse response = client.execute(httpPost);  
	    //获取结果实体  
	    HttpEntity entity = response.getEntity(); 
		String result = EntityUtils.toString(entity);
		return result;
	} 
	
	public static String PDFToBase64(File file) {
//    	String filePath1 ="深圳市大疆百旺科技有限公司发票--7999.pdf";
//    	File file = new File(filePath1);
        BASE64Encoder encoder = new BASE64Encoder();
        FileInputStream fin =null;
        BufferedInputStream bin =null;
        ByteArrayOutputStream baos = null;
        BufferedOutputStream bout =null;
        try {
            fin = new FileInputStream(file);
            bin = new BufferedInputStream(fin);
            baos = new ByteArrayOutputStream();
            bout = new BufferedOutputStream(baos);
            byte[] buffer = new byte[1024];
            int len = bin.read(buffer);
            while(len != -1){
                bout.write(buffer, 0, len);
                len = bin.read(buffer);
            }
            //刷新此输出流并强制写出所有缓冲的输出字节
            bout.flush();
            byte[] bytes = baos.toByteArray();
            return encoder.encodeBuffer(bytes).trim();  

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fin.close();
                bin.close();
                bout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    //文件base64编码
    public static void base64(String[] argsS) throws UnsupportedEncodingException, FileNotFoundException{
  	//	String filePath1 ="深圳市大疆百旺科技有限公司发票--7999.pdf";
  		String filePath1 ="D://文档2.pdf";
  		File file1 = new File(filePath1);
  		//生成加密文件
        String d= PDFToBase64(file1);
        FileWriter fw = null;
        File f = new File("D://a.txt");
         try {
          if(!f.exists()){
             f.createNewFile();
          }
          fw = new FileWriter(f);
          BufferedWriter out = new BufferedWriter(fw);
          out.write(d, 0, d.length()-1);
          out.close();
         } catch (IOException e) {
          e.printStackTrace();
         }
    }
}
