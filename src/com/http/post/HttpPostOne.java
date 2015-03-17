package com.http.post;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Proxy;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.PrivateKey;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class HttpPostOne {
	
	 public static String sendPost(String url, String param) {
	        PrintWriter out = null;
	        BufferedReader in = null;
	        String result = "";
	        try {
	        	java.net.Proxy proxy = new java.net.Proxy(java.net.Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1",8888));
	            URL realUrl = new URL(url);
	            // 打开和URL之间的连接
	            HttpURLConnection conn = (HttpURLConnection)realUrl.openConnection(proxy);
//	            URLConnection conn = realUrl.openConnection();
	            // 设置通用的请求属性
//	            conn.setRequestProperty("accept", "*/*");
//	            conn.setRequestProperty("connection", "Keep-Alive");
//	            conn.setRequestProperty("user-agent",
//	                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
	            // 发送POST请求必须设置如下两行
	            conn.setDoOutput(true);
	            conn.setDoInput(true);
	            // 获取URLConnection对象对应的输出流
	            out = new PrintWriter(conn.getOutputStream());
	            // 发送请求参数
	            out.print(param);
	            // flush输出流的缓冲
	            out.flush();
	            // 定义BufferedReader输入流来读取URL的响应
	            in = new BufferedReader(
	                    new InputStreamReader(conn.getInputStream()));
	            String line;
	            while ((line = in.readLine()) != null) {
	                result += line;
	            }
	        } catch (Exception e) {
	            System.out.println("发送 POST 请求出现异常！"+e);
	            e.printStackTrace();
	        }
	        //使用finally块来关闭输出流、输入流
	        finally{
	            try{
	                if(out!=null){
	                    out.close();
	                }
	                if(in!=null){
	                    in.close();
	                }
	            }
	            catch(IOException ex){
	                ex.printStackTrace();
	            }
	        }
	        return result;
	    }    

	 public static void main(String[] args) throws UnsupportedEncodingException{
		 String content = "测试编码";
		 String encode = URLEncoder.encode(content,"utf-8");
		 System.out.println(encode);
		 String key = "album_id=167016&seq=5&color=16724530&start_time=58.667&emoji_type=0&content=";
		 String sr=HttpRequest.sendPost("http://192.168.90.43/danmaku/commit.php?client_id=minghui=", key + encode );
		 	System.out.println(sr);
	 }
}
