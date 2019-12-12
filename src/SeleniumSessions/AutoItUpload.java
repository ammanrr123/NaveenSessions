package SeleniumSessions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoItUpload {

	public static void main(String[] args) throws IOException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C://Users//ammanrr.CORP//Downloads//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("//ushouhome01//ammanrr//Desktop//fileupload.html");
	
	
	    driver.findElement(By.xpath("//input[@type='file']")).click();
	
	    Runtime.getRuntime().exec("//USHOUHOME01//ammanrr//Desktop//Autoit//FIleupload.exe");
	}
}
