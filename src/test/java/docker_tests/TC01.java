package docker_tests;
//Objective is to execute sample Selenium Script in Docker Linux-Chrome Container

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC01 
{
	public static String node_url;
	public static WebDriver driver;
	
	
	public static void main(String[] args) throws InterruptedException, MalformedURLException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(BrowserType.CHROME);
		node_url = "http://localhost:5900/wd/hub";
			
		driver = new RemoteWebDriver(new URL(node_url),cap);
		driver.manage().window().maximize();
		
		driver.get("https://www.linkedin.com/in/tejkumargk/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("Page title :: "+driver.getTitle());
		Thread.sleep(5000);
		
		driver.close();
	}
}
