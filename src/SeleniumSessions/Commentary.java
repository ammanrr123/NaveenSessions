package SeleniumSessions;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Lib.ExcelDataConfig;

public class Commentary {

		
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C://Users//ammanrr.CORP//Downloads//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://ushoucwsys01vt/logon");
		
		
		ExcelDataConfig excel=new ExcelDataConfig("C:\\Users\\ammanrr.CORP\\eclipse-workspace\\UploadCommentary1.xlsx");
		
		driver.findElement(By.xpath("//*[@id='userid']")).sendKeys(excel.getData(1, 1, 0));
		
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(excel.getData(1, 1, 1));
		
		driver.findElement(By.className("userAction")).sendKeys(Keys.ENTER);
		
		
		WebElement element=driver.findElement(By.xpath("//a[contains(.,'Views»')]"));
	
		//WebElement element1=driver.findElement(By.xpath("//a[contains(.,'Views»')]"));
		
		Actions action=new Actions(driver);
		action.moveToElement(element).click().build().perform();
		
		//this will fetch the all projects
		List<WebElement> links=driver.findElements(By.xpath("//*[@id='NavMenu']/ul[@class='jd_menu']/li[2]/ul[@class='jdm_events']/li/a"));
		
		//this will give total project
		System.out.println("Total projects are"+links.size());
		
		//this is will print the projects in order
		for(int i=0;i<links.size();i++) {
		
		WebElement element1=links.get(i);
		String text=element1.getAttribute("innerHTML");
			
		//String text=element1.getText();
		
		System.out.println("View is:"+text);
		
		if(text.equalsIgnoreCase(excel.getData(3, 1, 0))) {
			element1.click();
		
			String s1="//a[text()='";
			String s2="']//following-sibling::ul//a[text()='";
			String s3="']";
			
			
			String s4=excel.getData(3, 1,1);
			String s5=excel.getData(3, 1,2);
			
			driver.findElement(By.xpath(s1+s4+s2+s5+s3)).click();
			
			//This is navigate to project which is mentioned in the excel
			List<WebElement> links2=driver.findElements(By.xpath("//tr[contains(@id,'Row_GroupingForm')]//following-sibling::td//preceding-sibling::td[@class='']"));
			
			System.out.println("Prjects are"+links2.size());
			
			for(int j=0;j<links2.size();j++) {
				
			WebElement element2=links2.get(j);
			String text2=element2.getAttribute("innerHTML");
			
			
			System.out.println("Project name is:"+text2);
			
			if(text2.equalsIgnoreCase(excel.getData(3, 1, 3))){
			
			element2.click();
			
			//This is navigate to specified effective date given by user in excel
			
			List<WebElement> links3=driver.findElements(By.xpath("//*[@id='tasklistTable']//tr//td[@class='']"));
			
			System.out.println("Total products  are:"+links3.size());
			
			for(int k=0;k<links3.size();k++) {
				
				WebElement element3=links3.get(k);
				
				String text3=element3.getText();
				
				System.out.println("Product Name is:"+text3);
				
				if(text3.equalsIgnoreCase(excel.getData(3, 1, 4))) {
					
					element3.click();
					
			//This code will search for specific acct# and upload specific file given by user in excel
					//this will iterate the all accounts row wise by getting data from excel.
				
			int rowcount=excel.rowcount(0);
					
			for(int row=1;row<rowcount;row++) 
			
			{
			Select Act_Search=new Select(driver.findElement(By.xpath("//select[@id='filter_column']")));
			Act_Search.selectByVisibleText("Acct #");
			
			Select Condition_Search=new Select(driver.findElement(By.xpath("//select[@id='filter_Text_operator']")));
			Condition_Search.selectByVisibleText("equals");
			
			WebElement act1=driver.findElement(By.xpath("//input[@id='filter_Text_value']"));
			//act1.sendKeys(excel.getData(0, 1, 0));//row count should increment
			act1.clear();
			act1.sendKeys(excel.getData(0, row, 0));
			
			driver.findElement(By.xpath("//input[@value='Go']")).click();
			
			Select user_action=new Select(driver.findElement(By.xpath("//select[@id='UserAction']")));
			user_action.selectByVisibleText("Download Commentary");
			
            driver.findElement(By.xpath("//input[@value='Return to Dashboard']")).click();
            
            Select user_action1=new Select(driver.findElement(By.xpath("//select[@id='UserAction']")));
            user_action1.selectByVisibleText("Upload Commentary");
			
          //  driver.findElement(By.xpath("//*[@id='CompDataWordML']")).sendKeys(excel.getData(0, 1, 1));//column count should incremnet
           driver.findElement(By.xpath("//*[@id='CompDataWordML']")).sendKeys(excel.getData(0, row, 1));
            
            driver.findElement(By.xpath("//input[@value='Upload Document']")).click();
            
            Select user_action2=new Select(driver.findElement(By.xpath("//select[@id='UserAction']")));
            user_action2.selectByVisibleText("Rebuild");}
            
			System.out.println("All Commentary files uploaded successfully:");
			
		}
		
				
		}
		}
						
		}	
			
		}
		}}}
		

		
		
		
	


