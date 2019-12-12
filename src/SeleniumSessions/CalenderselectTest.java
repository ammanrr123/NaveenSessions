package SeleniumSessions;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalenderselectTest {

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
		
		String date="31-September-2020";
		
		String dateArr[]=date.split("-");
		
		String day=dateArr[0];
		String month=dateArr[1];
		String year=dateArr[2];
		
		Select select=new Select(driver.findElement(By.name("slctMonth")));
		
		select.selectByVisibleText(month);
		
		Select select1=new Select(driver.findElement(By.name("slctYear")));
		
		select1.selectByVisibleText(year);
		
		
		final int totalweekdays=7;
		
		String beforexpath="//*[@id=\"crmcalendar\"]/table/tbody/tr[2]/td/table/tbody/tr[";
				
		String afterxpath="]/td[";
		
		boolean flag=false;
		String dayVal=null;
		    for(int row=2;row<=7;row++) {
			
			for(int col=1;col<=totalweekdays;col++) {
				try{
				 dayVal=driver.findElement(By.xpath(beforexpath+row+afterxpath+col+"]")).getText();
				 }
				 catch(NoSuchElementException e) {
				 System.out.println("please enter correct date value");
				 flag=false;
				 break;
				}
				System.out.println(dayVal);
				if(dayVal.equals(day)) {
				driver.findElement(By.xpath(beforexpath+row+afterxpath+col+"]")).click();
			    flag=true;
				break;
				}
		
			}
			if(flag) {
				break;
			}
		}
	}}


