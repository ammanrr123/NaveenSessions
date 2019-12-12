package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamicxpath {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C://Users//ammanrr.CORP//Downloads//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
	//driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://classic.crmpro.com/index.html?e=1");
		
		driver.findElement(By.xpath("//*[@id='loginForm']/div/input[1]")).sendKeys("raghuraoa");
		driver.findElement(By.xpath("//*[@id='loginForm']/div/input[2]")).sendKeys("Test@123");
		driver.findElement(By.xpath("//*[@id='loginForm']/div/div/input")).click();
		
		Thread.sleep(3000);
		
		driver.switchTo().frame("mainpanel");
	 driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	 driver.findElement(By.xpath("//a[text()='test2 test']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	 
	}

}
