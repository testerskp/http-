package com.http.post;

public class ArrayList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] content = {"%e6%b5%8b%e8%af%95%e5%bc%b9%e5%b9%95%e6%9c%8d%e5%8a%a1%e7%ab%af1%e5%88%86%e9%92%9f%e9%99%90%e5%88%b61",
 							"%e6%b5%8b%e8%af%95%e5%bc%b9%e5%b9%95%e6%9c%8d%e5%8a%a1%e7%ab%af1%e5%88%86%e9%92%9f%e9%99%90%e5%88%b62",
 							"%e6%b5%8b%e8%af%95%e5%bc%b9%e5%b9%95%e6%9c%8d%e5%8a%a1%e7%ab%af1%e5%88%86%e9%92%9f%e9%99%90%e5%88%b63",
 							"%e6%b5%8b%e8%af%95%e5%bc%b9%e5%b9%95%e6%9c%8d%e5%8a%a1%e7%ab%af1%e5%88%86%e9%92%9f%e9%99%90%e5%88%b64",
 							"%e6%b5%8b%e8%af%95%e5%bc%b9%e5%b9%95%e6%9c%8d%e5%8a%a1%e7%ab%af1%e5%88%86%e9%92%9f%e9%99%90%e5%88%b65",};
		String key = "album_id=167016&seq=2&color=16724530&start_time=80&emoji_type=0&content=";
		System.out.println(content.length);
		for(int i=0;i<content.length;i++){;	
			int j=0;
			String sr = ("http://192.168.90.43/danmaku/commit.php?client_id=QUM6Mzg6NzA6Nzk6NDM6NDk=" + key + content[j]);
			System.out.println(sr);
			j++;
			}
			
	}

}


