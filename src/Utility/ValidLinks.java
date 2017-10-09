package Utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ValidLinks {
	
public void checkLink(String linkUrl) throws IOException{
	
	  File FC = new File("DeadLinks.txt");//Created object of java File class.
	  String TestFile1 = FC.getAbsolutePath();
	  FC.createNewFile();//Create file.
	  FileWriter fw1 = new FileWriter(TestFile1);
	try{
		URL url = new URL(linkUrl);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		
		conn.setConnectTimeout(5000);
		conn.setRequestMethod("GET");
		conn.connect();
		if (conn.getResponseCode()==200){
			System.out.println("Valid Links" + linkUrl+" -" + conn.getResponseMessage()+ "- "+ conn.getResponseCode());
			
		}else{
			System.err.println("Dead Links" +linkUrl+ " -" + conn.getResponseMessage()+ "- "+ conn.getResponseCode());
			BufferedWriter out = new BufferedWriter(fw1); 
			out.write(linkUrl);
			out.newLine();
			out.flush();
		}
	}
		catch(Exception e){
			e.printStackTrace();
		}

}

}
