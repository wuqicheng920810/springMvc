package com.test.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
  
public class test  
{  
  
    /** 
     * @param args 
     */  
    public static void main(String[] args)  
    {  

    
    	 CloseableHttpClient httpclient = HttpClients.createDefault();  
         // 创建httppost    
         HttpPost httppost = new HttpPost("http://localhost:8080/SpringMVC/billAction/ajaxs.do");  
         // 创建参数队列    
         List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
         formparams.add(new BasicNameValuePair("username", "admin"));  
         formparams.add(new BasicNameValuePair("password", "123456"));  
         UrlEncodedFormEntity uefEntity;  
         try {  
             uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");  
             httppost.setEntity(uefEntity);  
             System.out.println("executing request " + httppost.getURI());  
             CloseableHttpResponse response = httpclient.execute(httppost);  
             try {  
                 HttpEntity entity = response.getEntity();  
                 if (entity != null) {  
                     System.out.println("--------------------------------------");  
                     System.out.println("Response content: " + EntityUtils.toString(entity, "UTF-8"));  
                     System.out.println("--------------------------------------");  
                 }  
             } finally {  
                 response.close();  
             }  
         } catch (ClientProtocolException e) {  
             e.printStackTrace();  
         } catch (UnsupportedEncodingException e1) {  
             e1.printStackTrace();  
         } catch (IOException e) {  
             e.printStackTrace();  
         } finally {  
             // 关闭连接,释放资源    
             try {  
                 httpclient.close();  
             } catch (IOException e) {  
                 e.printStackTrace();  
             }  
         }  
      
    }  
  
    
    public static String convertStreamToString(InputStream is) {      
        /*  
          * To convert the InputStream to String we use the BufferedReader.readLine()  
          * method. We iterate until the BufferedReader return null which means  
          * there's no more data to read. Each line will appended to a StringBuilder  
          * and returned as String.  
          */     
         BufferedReader reader = new BufferedReader(new InputStreamReader(is));      
         StringBuilder sb = new StringBuilder();      
     
         String line = null;      
        try {      
            while ((line = reader.readLine()) != null) {      
                 sb.append(line + "\n");      
             }      
         } catch (IOException e) {      
             e.printStackTrace();      
         } finally {      
            try {      
                 is.close();      
             } catch (IOException e) {      
                 e.printStackTrace();      
             }      
         }      
     
        return sb.toString();      
     }      
    
} 