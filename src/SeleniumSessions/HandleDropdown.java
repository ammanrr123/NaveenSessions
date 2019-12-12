package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropdown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C://Users//ammanrr.CORP//Downloads//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//driver.get("http://usappcwsywd100/logon");
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		//handle drop box
		Thread.sleep(5000);
		Select select=new Select(driver.findElement(By.xpath("//*[@id='searchDropdownBox']")));
		
		select.selectByVisibleText("Amazon Pantry");
		
		//select.selectByVisibleText(");
		
		//"//*[@id='searchDropdownBox']"
		//Select select=new Select(driver.findElement(By.xpath("//*[@id='nav-link-yourAccount']/span[1]")));
		
		//Select select=new Select(driver.findElement(By.cssSelector("#//*[@id='nav-link-yourAccount']/span[1]")));
		//select.selectByVisibleText("Your Account");
	}

}
