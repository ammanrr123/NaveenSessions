package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElemnetVisiblityTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C://Users//ammanrr.CORP//Downloads//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//WebDriver driver=new HtmlUnitDriver();
		
//isDisplayed()/isEnabled()/isSelected program
		

	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://classic.crmpro.com/register/");
	Thread.sleep(2000);
	
	boolean b1=driver.findElement(By.xpath("//*[@class='myButton']")).isDisplayed();
	System.out.println(b1);
	
	boolean b2=driver.findElement(By.xpath("//*[@class='myButton']")).isEnabled();
	System.out.println(b2);
	
	boolean b3=driver.findElement(By.xpath("//input[@name='agreeTerms']")).isSelected();
	System.out.println(b3);
	
	
	driver.findElement(By.xpath("//input[@name='agreeTerms']")).click();
	
	boolean b4=driver.findElement(By.xpath("//input[@name='agreeTerms']")).isSelected();
	System.out.println(b4);
	
	boolean b5=driver.findElement(By.xpath("//*[@id='multipleForm']/div[12]/div")).isEnabled();
	System.out.println(b5);
	
	
	
	}

}
