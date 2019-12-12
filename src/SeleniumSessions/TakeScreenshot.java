package SeleniumSessions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenshot {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","C://Users//ammanrr.CORP//Downloads//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("http://www.flipkart.com/");
		
		
		//getScreenshotAs
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//\\USHOUHOME01\ammanrr\Desktop\Australia\IDProofs\AadharCard
		
		FileUtils.copyFile(src, new File("//USHOUHOME01//ammanrr//Desktop//Australia//IDProofs//AadharCard//google.png"));
	}

}
