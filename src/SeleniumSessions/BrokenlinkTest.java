package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenlinkTest {

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
		
		//links---//a
		//imgaes---//img
		
		List<WebElement>linkslist=driver.findElements(By.tagName("a"));
		
		linkslist.addAll(driver.findElements(By.tagName("img")));
		System.out.println("size of full links and images"+linkslist.size());
		List<WebElement> activeLinks=new ArrayList<WebElement>();
		
		
		for(int i=0;i<linkslist.size();i++) {
			if(linkslist.get(i).getAttribute("href")!=null) {
				activeLinks.add(linkslist.get(i));
			}
		}
		
		System.out.println("size of active links and images:"+activeLinks.size());
	}

}
