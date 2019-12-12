package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTable {

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
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='navmenu']/ul/li[4]/a")).click();
		
		//*[@id="vContactsForm"]/table/tbody/tr[4]/td[2]/a
		//*[@id="vContactsForm"]/table/tbody/tr[5]/td[2]/a
		//*[@id="vContactsForm"]/table/tbody/tr[6]/td[2]/a
		//*[@id="vContactsForm"]/table/tbody/tr[7]/td[2]/a
		
		/*String before_xpath="//*[@id='vContactsForm']/table/tbody/tr[";
				String after_xpath="]/td[2]/a";
				
				for(int i=4;i<=7;i++) {
					String name=driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
					System.out.println(name);
					if(name.contains("test 1")) {
						driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody/tr["+i+"]/td[1]/input")).click();
					}
				}
			*/
		
		//methid2
		
		driver.findElement(By.xpath("//a[contains(text(),'test 1')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
		
	}

}
