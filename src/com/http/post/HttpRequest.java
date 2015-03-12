package com.http.post;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
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

	 public static void main(String[] args){
		 String[] content = {"%e6%b5%8b%e8%af%95%e5%bc%b9%e5%b9%95%e6%9c%8d%e5%8a%a1%e7%ab%af1%e5%88%86%e9%92%9f%e9%99%90%e5%88%b61",
				 			 "%e6%b5%8b%e8%af%95%e5%bc%b9%e5%b9%95%e6%9c%8d%e5%8a%a1%e7%ab%af1%e5%88%86%e9%92%9f%e9%99%90%e5%88%b62",
				 			 "%e6%b5%8b%e8%af%95%e5%bc%b9%e5%b9%95%e6%9c%8d%e5%8a%a1%e7%ab%af1%e5%88%86%e9%92%9f%e9%99%90%e5%88%b63",
				 			 "%e6%b5%8b%e8%af%95%e5%bc%b9%e5%b9%95%e6%9c%8d%e5%8a%a1%e7%ab%af1%e5%88%86%e9%92%9f%e9%99%90%e5%88%b64",
				 			 "%e6%b5%8b%e8%af%95%e5%bc%b9%e5%b9%95%e6%9c%8d%e5%8a%a1%e7%ab%af1%e5%88%86%e9%92%9f%e9%99%90%e5%88%b65",
				 			 "%e6%b5%8b%e8%af%95%e5%bc%b9%e5%b9%95%e6%9c%8d%e5%8a%a1%e7%ab%af1%e5%88%86%e9%92%9f%e9%99%90%e5%88%b66",
		 					 "%e6%b5%8b%e8%af%95%e5%bc%b9%e5%b9%95%e6%9c%8d%e5%8a%a1%e7%ab%af1%e5%88%86%e9%92%9f%e9%99%90%e5%88%b67",
		 					 "%e6%b5%8b%e8%af%95%e5%bc%b9%e5%b9%95%e6%9c%8d%e5%8a%a1%e7%ab%af1%e5%88%86%e9%92%9f%e9%99%90%e5%88%b68",
		 					 "%e6%b5%8b%e8%af%95%e5%bc%b9%e5%b9%95%e6%9c%8d%e5%8a%a1%e7%ab%af1%e5%88%86%e9%92%9f%e9%99%90%e5%88%b69",
		 					 "%e6%b5%8b%e8%af%95%e5%bc%b9%e5%b9%95%e6%9c%8d%e5%8a%a1%e7%ab%af1%e5%88%86%e9%92%9f%e9%99%90%e5%88%b610",
		 					 "%e6%b5%8b%e8%af%95%e5%bc%b9%e5%b9%95%e6%9c%8d%e5%8a%a1%e7%ab%af1%e5%88%86%e9%92%9f%e9%99%90%e5%88%b611",
		 					 "%e6%b5%8b%e8%af%95%e5%bc%b9%e5%b9%95%e6%9c%8d%e5%8a%a1%e7%ab%af1%e5%88%86%e9%92%9f%e9%99%90%e5%88%b612",
		 						};
		 String key = "album_id=167016&seq=2&color=16724530&start_time=80&emoji_type=0&content=";
		 for(int i=0;i<content.length;i++){;
		 	String sr=HttpRequest.sendPost("http://192.168.90.43/danmaku/commit.php?client_id=duhongbo=", key + content[i]);
		 	System.out.println(sr);
		 	System.out.println(content[i]);
		 	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 	}
	 }
}
