package SeleniumSessions;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcepts {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C://Users//ammanrr.CORP//Downloads//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//driver.get("http://usappcwsywd100/logon");
		
		//http://usappcwsywd100/ui/CD/Default/PG/GCCP/Dashboard/SVClientBookProductHistInComplete?AVK=1
		//$x("//*[@id='Row_GroupingForm_1']/td[1]")
		//$x("//*[@id='Row_GroupingForm_4']/td[1]")
		//$x("//*[@id='UserAction']") drop down
		//Upload Commentary
		
		driver.get("https://www.amazon.in/");
	
		//Xpath
		
		//driver.findElement(By.xpath("//input[@id='userid']")).sendKeys("ammanrr");
		//driver.findElement(By.xpath("//input[@id='password']")).sendKeys("ammanrr");
		//driver.findElement(By.xpath("//input[@value='Logon']")).sendKeys(Keys.ENTER);
	
		//Id
		
		//driver.findElement(By.id("userid")).sendKeys("ammanrr");
		//driver.findElement(By.id("password")).sendKeys("ammanrr");
		//driver.findElement(By.className("userAction")).sendKeys(Keys.ENTER);
		
		//By name
		
		//driver.findElement(By.name("userid")).sendKeys("ammanrr");
		//driver.findElement(By.name("password")).sendKeys("ammanrr");
		//driver.findElement(By.className("userAction")).sendKeys(Keys.ENTER);
		
		//By Link
		Thread.sleep(3000);
		//driver.findElement(By.linkText("Amazon Pay")).click();
		
		//By partialtext link
		//Thread.sleep(3000);
		//driver.findElement(By.partialLinkText("View State")).click();
		
		//By Css Selector
		//driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("iphone8");
		
		
		//By className
		driver.findElement(By.className("nav-input")).sendKeys("iphone7");
		
	}

}
