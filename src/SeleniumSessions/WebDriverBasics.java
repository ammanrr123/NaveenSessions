package SeleniumSessions;
import java.util.concurrent.TimeUnit;

//import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
   System.setProperty("webdriver.chrome.driver","C://Users//ammanrr.CORP//Downloads//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	
		//Lanuncing FF browser
		//geckodriver
		
		//System.setProperty("wendriver.gecko.driver", "C://Users//ammanrr.CORP//Downloads//geckodriver.exe");
	//WebDriver driver1= new FirefoxDriver();
	driver.get("http://www.google.com");
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	System.out.println(driver.getTitle());
	
	if(driver.getTitle().equals("Google")) {
		System.out.println("success");
	}else {
		System.out.println("failed");
	}
		
	System.out.println(driver.getCurrentUrl());
	
	System.out.println(driver.getPageSource());
	
	System.out.println(driver.getWindowHandle());
	
	System.out.println(driver.hashCode());
	
	driver.quit();
		//WebDriver driver=new SafariDriver();
	
	//driver.get("hhtp://www.google.com")
	//syso(driver.geTitle();
	//download one extension //safari extension for selenium
	//Apple safari driver latest version
		
		
	}

}
