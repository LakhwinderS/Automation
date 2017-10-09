package Utility;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author Lakhwinder_Singh
 *
 */
public class BrowserFactory {
	static WebDriver driver;
	
	
	

	public static WebDriver startBrowser(String browserName){
		File file = new File("chromedriver_win32\\chromedriver.exe");
		String absolutePath = file.getAbsolutePath();
		System.out.println("absolutePath"+absolutePath);
		if (browserName.equals("chrome")){
			
			System.setProperty("webdriver.chrome.driver", absolutePath);
			driver = new ChromeDriver();
			
		}
		else if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver","C:\\Users\\lakhwinder_singh\\Downloads\\geckodriver-v0.17.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
			//System.setProperty("webdriver.gecko.driver", "C:\\Users\\lakhwinder_singh\\Downloads\\geckodriver-v0.17.0-win64\\geckodriver.exe");
			//capabilities = DesiredCapabilities.firefox();
			DesiredCapabilities dc=DesiredCapabilities.firefox();
			dc.setCapability("marionette", true);
			driver = new FirefoxDriver(dc);
			
		}
		else if(browserName.equals("InternetExplorer")){
			driver=new InternetExplorerDriver();
		}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(Url.mainUrl);
			return driver;
		
			
	}

}

