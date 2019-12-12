package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import Lib.Utility2;



public class WebTableHandle {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","C://Users//ammanrr.CORP//Downloads//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://usappcwsywd100/logon");
		  try {
				Utility2.setExcelFile("C://Users//ammanrr.CORP//eclipse-workspace//WebElementData.xlsx", "Sheet1");
			} catch (Exception e) {
				System.out.println("Given Updated user input file is not availble in specified location");
			}
		
		//ExcelDataConfig excel=new ExcelDataConfig("C:\\Users\\ammanrr.CORP\\eclipse-workspace\\WebElementData.xlsx");
		
		driver.findElement(By.xpath("//*[@id='userid']")).sendKeys("ammanrr");
		
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("ammanrr");
		
		driver.findElement(By.className("userAction")).sendKeys(Keys.ENTER);
		
		WebElement element=driver.findElement(By.xpath("//ul/li[3]/a[contains(.,'Tools»')]"));
		Actions action=new Actions(driver);
		action.moveToElement(element).click().build().perform();
		
		
       List<WebElement> links=driver.findElements(By.xpath("//*[@id='NavMenu']/ul[@class='jd_menu']/li[3]/ul[@class='jdm_events']/li/a"));
		
		//this will give total project
		System.out.println("Total projects are"+links.size());
		
		//this is will print the projects in order
		for(int i=0;i<links.size();i++) {
		
		WebElement element1=links.get(i);
		String text=element1.getAttribute("innerHTML");
			
		//String text=element1.getText();
		
		System.out.println("View is:"+text);
		
		if(text.equalsIgnoreCase("Admin<span>»</span>")) {
			element1.click();
		
			String s1="//a[text()='";
			String s2="']//following-sibling::ul//a[text()='";
			String s3="']";
			
			
			String s4="Admin";
			String s5="ActiveMQ Status";
			
			WebElement subview=driver.findElement(By.xpath(s1+s4+s2+s5+s3));
			subview.click();
			Select set1=new Select(driver.findElement(By.xpath("//select[@id='UserAction_Metrics']")));
			
			set1.selectByVisibleText("View Messages");
			
			Thread.sleep(40000);
						
			//handle webtable columns
			
			String colbeforeXpath="//*[@id='details_Metrics']/div/table/thead/tr/th[";
			String colAfterXpath="]";
			
			List<WebElement> cols=driver.findElements(By.xpath("//*[@id='details_Metrics']/div/table/thead/tr/th"));
			int colCount=cols.size();
			System.out.println("total number of columns are:"+colCount);
			
			System.out.println("Columns values are:");
			for(int k=1;k<=colCount;k++) {
				WebElement eless=driver.findElement(By.xpath(colbeforeXpath+k+colAfterXpath));
				String eletext=eless.getText();
				System.out.println(eletext);
				Utility2.setCellData(eletext, 0, k-1); 
				Thread.sleep(1000);
			}
			
			//handle rows
			
			String rowbeforexpath="//*[@id='details_Metrics']/div/table/tbody/tr[";
			String rowafterxpath="]/td[";
			String rowendxpath="]";
			
			//rowcount
			
			List<WebElement> rows=driver.findElements(By.xpath("//*[@id='details_Metrics']/div/table/tbody/tr"));
			int rowcount=rows.size();
			System.out.println("total number of rows are:"+rowcount);
			
			for(int p=1;p<=rowcount;p++) {
				for(int m=1;m<=colCount;m++) {
				WebElement eless1=driver.findElement(By.xpath(rowbeforexpath+p+rowafterxpath+m+rowendxpath));
				String elesstext=eless1.getText();
				//System.out.println(elesstext);
				Utility2.setCellData(elesstext, p, m-1);
				
				Thread.sleep(2000);
				
			}System.out.println(+p+"completed");
			}
	break;}
		

}
driver.quit();}}

//driver.findElement(By.xpath("*//div[4]//button[@class='gdpr-allow-cookies cta-btn cta-btn-light-green']")).click();
		//Thread.sleep(3000);



