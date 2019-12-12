package SeleniumSessions;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
//import org.omg.Messaging.SyncScopeHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadProperties {
static WebDriver driver;

	public static void main(String[] args) throws IOException {

		Properties prop=new Properties();
		FileInputStream ip=new FileInputStream("C:\\Users\\ammanrr.CORP\\eclipse-workspace\\NaveenSessionns\\src\\SeleniumSessions\\config.properties");
		prop.load(ip);
		
		System.out.println(prop.getProperty("username"));
		
		System.out.println(prop.getProperty("password"));
		
		String url=prop.getProperty("URL");
		
		String browsername=prop.getProperty("browser");
		
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C://Users//ammanrr.CORP//Downloads//chromedriver.exe");
			 driver=new ChromeDriver();
		}else if (browsername.equals("firefox"))
		{
			System.setProperty("webdriver.chrome.driver","C://Users//ammanrr.CORP//Downloads//chromedriver.exe");
			 driver=new ChromeDriver();
		}else if (browsername.equals("IE")) {
			System.setProperty("webdriver.internetexplorer.driver","C://Users//ammanrr.CORP//Downloads//internetexplorerdriver.exe");
			 driver=new ChromeDriver();
		}
		driver.get(url);
		driver.findElement(By.xpath(prop.getProperty("username_xpath"))).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath(prop.getProperty("password_xpath"))).sendKeys(prop.getProperty("password"));
		driver.findElement(By.className(prop.getProperty("button_xpath"))).sendKeys(Keys.ENTER);
	}

}
