package SeleniumSessions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserpopupWindow {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","C://Users//ammanrr.CORP//Downloads//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.popuptest.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='popuptest1.html']")).click();
		
		Set<String >str=driver.getWindowHandles();
		
		Iterator<String> it=str.iterator();
		
		
		 String parentwindow=it.next();
		System.out.println(parentwindow);
		
		String childwindow=it.next();
		
		System.out.println(childwindow);
		
		driver.getTitle();
		
		driver.close();
		
		driver.getTitle();
		
		driver.close();
		
		
	}

}
