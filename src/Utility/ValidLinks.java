package Utility;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ValidLinks {
	
public void checkLink(String linkUrl) throws IOException{
	try{
		URL url = new URL(linkUrl);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		
		conn.setConnectTimeout(5000);
		conn.setRequestMethod("GET");
		conn.connect();
		if (conn.getResponseCode()==200){
			System.out.println("Valid Links" + " -" + conn.getResponseMessage()+ "- "+ conn.getResponseCode());
		}else{
			System.out.println("Dead Links" + " -" + conn.getResponseMessage()+ "- "+ conn.getResponseCode());
		}
	}
		catch(Exception e){
			e.printStackTrace();
		}

}

}

