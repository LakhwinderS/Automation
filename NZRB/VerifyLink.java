package NZRB;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import Utility.ValidLinks;

public class VerifyLink {
public static WebDriver driver;
	@BeforeTest
	public void setup(){
		
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\developer\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.get("https://www.tab.co.nz/racing/");
		driver.get("https://www.google.co.nz");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	}
	@org.testng.annotations.Test
	public void LinkFinder(){
		
		try{
		ValidLinks vl = new  ValidLinks();
		//driver.get("https://www.google.co.nz/");
		List <WebElement> validLinks= new ArrayList<WebElement>();
		List<WebElement> allLinks= driver.findElements(By.tagName("a"));
		allLinks.addAll(driver.findElements(By.tagName("img")));
		//System.out.println("Total Links are"+ allLinks.size());
		//for (int i=0;i<ele.size();i++){
			for(WebElement link:allLinks)
			{
				if (link.getAttribute("href")!=null && !link.getAttribute("href").startsWith("javascript"))
					{
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
			//WebElement ele = li.get(i);
					//String linkUrl= ele.getAttribute("href");
					//System.out.println("Links are "+ url);
					//VerifyActiveLink(url);
					//driver.close();
			
			}
		
		
		catch(Exception e){
			e.printStackTrace();
		}
	}
@org.testng.annotations.AfterClass
	public void driverClose(){
	driver.close();
}
}

