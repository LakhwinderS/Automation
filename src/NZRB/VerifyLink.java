package NZRB;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;

import Utility.BrowserFactory;
import Utility.ValidLinks;

public class VerifyLink {
public static WebDriver driver;
	@BeforeTest
	public void setup(){
		
		driver =BrowserFactory.startBrowser("chrome");
		 PageFactory.initElements(driver, this);
				
	}
	@org.testng.annotations.Test
	public void LinkFinder() throws IOException{
	
		File FC = new File("AllLinks.txt");//Created object of java File class.
		String TestFile = FC.getAbsolutePath();
		FC.createNewFile();//Create file.
		FileWriter fw = new FileWriter(TestFile);
		 
		try{
			ValidLinks vl = new  ValidLinks();
			List <WebElement> validLinks= new ArrayList<WebElement>();
			List<WebElement> allLinks= driver.findElements(By.tagName("a"));
			allLinks.addAll(driver.findElements(By.tagName("img")));
				for(WebElement link:allLinks)
					{
						if (link.getAttribute("href")!=null && !link.getAttribute("href").startsWith("javascript"))
							{
							 System.out.println(link.getAttribute("href"));	
							BufferedWriter out = new BufferedWriter(fw); 
								out.write(link.getAttribute("href"));
								out.newLine();
								out.flush();
								
							validLinks.add(link);
							}
						
					}
				System.out.println("Total Links are"+ allLinks.size());
				System.out.println("JavaScript and NUll link"+ (allLinks.size()- validLinks.size()));
				System.out.println("valid Links are"+ validLinks.size());
				
				for(WebElement ele_link: validLinks){
					String linkUrl= ele_link.getAttribute("href");
					vl.checkLink(linkUrl);
				}

			}
		
		
		catch(Exception e){
			e.printStackTrace();
			fw.close();
		}
	}
	@org.testng.annotations.AfterClass
	public void driverClose(){
	driver.close();
	
	
}
}

