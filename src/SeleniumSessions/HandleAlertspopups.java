package SeleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlertspopups {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C://Users//ammanrr.CORP//Downloads//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='Register']")).click();
		
Alert alert = driver.switchTo().alert();

System.out.println(alert.getText());
//alert.accept();

//alert.sendKeys("raghu");
//alert.dismiss();
//\\USHOUHOME01\ammanrr\Desktop\All_SV_Fundinserts_Commentary docs


String text=alert.getText();

if(text.equals("Your full name cannot be blank.Please enter your firstname and lastname e.g. Sameer Bhagwat")) {
	System.out.println("success");}
	else {
		System.out.println("failed");
	}
}
	}


