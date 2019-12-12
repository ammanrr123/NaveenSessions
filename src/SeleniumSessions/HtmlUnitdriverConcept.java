package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitdriverConcept {
	
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","C://Users//ammanrr.CORP//Downloads//chromedriver.exe");
	//WebDriver driver=new ChromeDriver();
	
	WebDriver driver=new HtmlUnitDriver();
	

	//Lanuncing FF browser
	//geckodriver
	
	//System.setProperty("wendriver.gecko.driver", "C://Users//ammanrr.CORP//Downloads//geckodriver.exe");
//WebDriver driver1= new FirefoxDriver();

driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.get("https://classic.crmpro.com/index.html?e=1");
Thread.sleep(2000);
System.out.println(driver.getTitle());

driver.findElement(By.xpath("//*[@id='loginForm']/div/input[1]")).sendKeys("raghuraoa");
driver.findElement(By.xpath("//*[@id='loginForm']/div/input[2]")).sendKeys("Test@123");
driver.findElement(By.xpath("//*[@id='loginForm']/div/div/input")).click();
Thread.sleep(2000);
System.out.println(driver.getTitle());
}
}
