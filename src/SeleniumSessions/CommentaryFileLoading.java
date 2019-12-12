package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Lib.ExcelDataConfig;

public class CommentaryFileLoading {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C://Users//ammanrr.CORP//Downloads//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://usappcwsywd100/logon");
		
		
		ExcelDataConfig excel=new ExcelDataConfig("C:\\Users\\ammanrr.CORP\\eclipse-workspace\\UploadCommentary.xlsx");
		
		driver.findElement(By.xpath("//*[@id='userid']")).sendKeys(excel.getData(1, 1, 0));
		
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(excel.getData(1, 1, 1));
		
		driver.findElement(By.className("userAction")).sendKeys(Keys.ENTER);
		
		
		WebElement element=driver.findElement(By.xpath("//a[contains(.,'Views»')]"));
		
		
		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();
		
		
	
	
	//a[text()='Client Book - Product - SV']//following-sibling::ul//a[text()='Active Qtr']
		
		
		
		
		String s1="a[text()='";
		
		String s2="']//following-sibling::ul//a[text()='";
		
		String s3="']";
		
		
		String s4=excel.getData(3, 1,0);
		
		String s5=excel.getData(3, 1,1);
		
		
		
		
		driver.findElement(By.xpath(s1+s4+s2+s5+s3)).click();
		
		
		
		
		
	}

}
