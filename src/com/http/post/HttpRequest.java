package com.http.post;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.PrivateKey;
import java.util.List;
import java.util.Map;

public class HttpRequest {
	
	 public static String sendPost(String url, String param) {
	        PrintWriter out = null;
	        BufferedReader in = null;
	        String result = "";
	        try {
	            URL realUrl = new URL(url);
	            // �򿪺�URL֮�������
	            URLConnection conn = realUrl.openConnection();
	            // ����ͨ�õ���������
//	            conn.setRequestProperty("accept", "*/*");
//	            conn.setRequestProperty("connection", "Keep-Alive");
//	            conn.setRequestProperty("user-agent",
//	                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
	            // ����POST�������������������
	            conn.setDoOutput(true);
	            conn.setDoInput(true);
	            // ��ȡURLConnection�����Ӧ�������
	            out = new PrintWriter(conn.getOutputStream());
	            // �����������
	            out.print(param);
	            // flush������Ļ���
	            out.flush();
	            // ����BufferedReader����������ȡURL����Ӧ
	            in = new BufferedReader(
	                    new InputStreamReader(conn.getInputStream()));
	            String line;
	            while ((line = in.readLine()) != null) {
	                result += line;
	            }
	        } catch (Exception e) {
	            System.out.println("���� POST ��������쳣��"+e);
	            e.printStackTrace();
	        }
	        //ʹ��finally�����ر��������������
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
		 String[] content = {"1234567912",
				 			 "����233333",				 	
		 						};
//		 String[] content = {"%e9%80%97%e9%80%bc%e5%92%a8%e8%af%a2%e7%83%ad%e7%ba%bf%e8%80%81%e5%ad%90%e6%95%99%e4%bd%a0%e6%b3%a1%e5%a6%9e"};
		 String key = "album_id=167017&seq=2&color=16724530&start_time=80&emoji_type=0&content=";
		 for(int i=0;i<content.length;i++){
			String enconde = URLEncoder.encode(content[i],"UTF-8"); 
		 	String sr=HttpRequest.sendPost("http://192.168.90.43/danmaku/commit.php?client_id=mazhi123=", key + enconde);
		 	System.out.println(sr);
		 	System.out.println(enconde);
		 	try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 	}
	 }
}
