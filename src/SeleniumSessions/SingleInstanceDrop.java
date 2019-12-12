package SeleniumSessions;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;



public class SingleInstanceDrop {
            
public static void main(String[] args) throws Exception {
{                                       
System.setProperty("webdriver.chrome.driver","C://Users//ammanrr.CORP//Downloads//chromedriver.exe");
WebDriver driver = new ChromeDriver(); 
driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.get("http://usappobiewt100:81/fins_oui/start.swe?SWECmd=Login&SWECM=S&SRN=&SWEHo=usappobiewt100");
Thread.sleep(5000);
driver.findElement(By.xpath("//*[@id='s_swepi_1']")).sendKeys("ammanrr");
driver.findElement(By.xpath("//*[@id='s_swepi_2']")).sendKeys("Nana1siri!1");
driver.findElement(By.xpath("//*[@id='s_swepi_22']")).click();
Thread.sleep(3000);
//click on communication tab
driver.findElement(By.xpath("//*[@id='s_sctrl_tabScreen']/ul/li[11]")).click();
//click on query
driver.findElement(By.xpath("//*[@id='s_1_1_8_0_Ctrl']")).click();
//enter the communication name as inut
driver.findElement(By.xpath("//table[@id='s_1_l']/tbody/tr[2]/td[2]/input")).sendKeys("IPC");
//click on go button
driver.findElement(By.xpath("//*[@id='s_1_1_5_0_Ctrl']")).click();
//click on show active
driver.findElement(By.xpath("//*[@id='s_2_1_2_0_Ctrl']")).click();
//click on query
driver.findElement(By.xpath("//*[@id='s_2_1_11_0_Ctrl']")).click();
//go to account number column
WebElement Element=driver.findElement(By.xpath("//table[@id='s_2_l']/tbody/tr[2]/td[2]/input"));
Element.sendKeys(Keys.TAB);
//enter the act
//Thread.sleep(5000);
WebElement Element1=driver.findElement(By.xpath("//table[@id='s_2_l']/tbody/tr[2]/td[3]/input"));
Element1.sendKeys("N820962");

//Click Go button
driver.findElement(By.xpath("//*[@id='s_2_1_8_0_Ctrl']")).click();

//click on communication instance
driver.findElement(By.xpath("//table[@id='s_2_l']/tbody/tr[2]/td[9]/a")).click();
Thread.sleep(3000);
//click Adhoc submit
WebElement element=driver.findElement(By.xpath("//*[@id='s_3_1_47_0_Ctrl']"));


//'IJavaScriptExecutor' is an 'interface' which is used to run the 'JavaScript code' into the webdriver (Browser)        
			((JavascriptExecutor)driver).executeScript("arguments[0].click()", element);

			// Switch the control of 'driver' to the Alert from main window
			Alert promptAlert = driver.switchTo().alert();
			
		
			promptAlert.sendKeys("03/31/2018");
			promptAlert.accept();
			Thread.sleep(5000);
	        Alert promptAlert1 = driver.switchTo().alert();
			promptAlert1.accept();
			//driver.switchTo().defaultContent();
//((JavascriptExecutor)driver).executeScript("window.confirm=function(msg){return true}");





//Go back to communication
driver.findElement(By.xpath("//*[@id='siebui-threadbar']/li[1]/span/a")).click();
Thread.sleep(3000);
//click query button again
driver.findElement(By.xpath("//*[@id='s_2_1_11_0_Ctrl']")).click();

//Enter second account number
WebElement Element2=driver.findElement(By.xpath("//table[@id='s_2_l']/tbody/tr[2]/td[2]/input"));
Element2.sendKeys(Keys.TAB);
WebElement Element3=driver.findElement(By.xpath("//table[@id='s_2_l']/tbody/tr[2]/td[3]/input"));
Element3.sendKeys("N860445");
//click on go button
driver.findElement(By.xpath("//*[@id='s_2_1_8_0_Ctrl']")).click();
//click on communication instance
driver.findElement(By.xpath("//table[@id='s_2_l']/tbody/tr[2]/td[9]/a")).click();
Thread.sleep(3000);
//click on adhoc submit
driver.findElement(By.xpath("//*[@id='s_3_1_47_0_Ctrl']")).click();

//Enter effective date
Thread.sleep(3000);
Alert promptAlert2 = driver.switchTo().alert();


promptAlert2.sendKeys("03/31/2018");
promptAlert2.accept();
Thread.sleep(5000);
Alert promptAlert3 = driver.switchTo().alert();
promptAlert3.accept();
}}}