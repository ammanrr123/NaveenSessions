package SeleniumSessions;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


public class Test {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","C://Users//ammanrr.CORP//Downloads//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//WebDriverWait wait;
		driver.manage().window().maximize();
		
		driver.manage().getCookies();
		//driver.manage().getCookieNamed(arg0);
		//driver.manage().addCookie(arg0);
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.msci.com/end-of-day-data-search");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@id='_accepttermsbuttonsportlet_WAR_cookiemanager_']/button[1]")).click();
		Thread.sleep(5000);
		driver.switchTo().frame("_48_INSTANCE_2rBHjKjrfC0Q_iframe");
		driver.findElement(By.xpath("//*[@id='templateForm:j_id__v_106']")).click();
}
}