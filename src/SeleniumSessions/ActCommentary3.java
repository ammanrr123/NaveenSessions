package SeleniumSessions;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import Lib.Utility;

public class ActCommentary3 {

		
	public static void main(String[] args) throws Exception {
		//System.setProperty("webdriver.chrome.driver","R:\\GCCP QA Team\\SeleniumTrainings\\SeleniumTraining\\softwares\\chromeDriver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver","C://Users//ammanrr.CORP//Downloads//chromedriver.exe");
		//System.setProperty("webdriver.ie.driver","C://Users//ammanrr.CORP//Downloads//IEDriverServer.exe");
		
		WebDriver driver=new ChromeDriver();
		//WebDriver driver=new InternetExplorerDriver();
		driver.manage().window().maximize();
		//Utility.setExcelFile("C:\\Users\\kolace\\Downloads\\UploadCommentary2p.xlsx", "Sheet1");
		Utility.setExcelFile("C:\\Users\\ammanrr.CORP\\eclipse-workspace\\UploadCommentary2p.xlsx", "Sheet1");
		
		driver.get(Utility.getCellData(1, 4));
		
		driver.findElement(By.xpath("//*[@id='userid']")).sendKeys(Utility.getCellData(1, 5));
		
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(Utility.getCellData(1, 6));
		
		driver.findElement(By.className("userAction")).sendKeys(Keys.ENTER);
		
		 //Thread.sleep(2000);
		WebElement element=driver.findElement(By.xpath("//a[contains(.,'Views»')]"));
	
		//WebElement element=driver.findElement(By.xpath("//*[text()='Views']"));
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
		
		if(text.equalsIgnoreCase(Utility.getCellData(1, 7))) {
			element1.click();
		
			String s1="//a[text()='";
			String s2="']//following-sibling::ul//a[text()='";
			String s3="']";
			
			
			String s4=Utility.getCellData(1, 8);
			String s5=Utility.getCellData(1, 9);
			
			WebElement subview=driver.findElement(By.xpath(s1+s4+s2+s5+s3));
			subview.click();
			
			//This is navigate to investment center which is mentioned in the excel
			List<WebElement> links2=driver.findElements(By.xpath("//tr[contains(@id,'Row_GroupingForm')]//following-sibling::td//preceding-sibling::td[@class='']"));
			
			System.out.println("Projects are"+links2.size());
			
			for(int j=0;j<links2.size();j++) {
				
			WebElement element2=links2.get(j);
			String text2=element2.getAttribute("innerHTML");
			
			
			System.out.println("Project name is:"+text2);
			
			if(text2.equalsIgnoreCase(Utility.getCellData(1, 10))){
			
			element2.click();
			
			WebElement e1=driver.findElement(By.xpath("//tr[contains(@id,'Row_GroupingForm')]//td[@class='']"));
			String text5=e1.getAttribute("innerHTML");
			
			System.out.println("product name is:"+text5);
			
			if(text5.equalsIgnoreCase(Utility.getCellData(1, 11)))
			{
				e1.click();
			
			
			int totalNoOfRows=Utility.rowcount("Sheet1");
					
			for(int row=1;row<=totalNoOfRows;row++) 
			
			{
			Select Act_Search=new Select(driver.findElement(By.xpath("//select[@id='filter_column']")));
			Act_Search.selectByVisibleText("Acct #");
			
			Select Condition_Search=new Select(driver.findElement(By.xpath("//select[@id='filter_Text_operator']")));
			Condition_Search.selectByVisibleText("equals");
			
			WebElement act1=driver.findElement(By.xpath("//input[@id='filter_Text_value']"));
			
			
			act1.clear();
			act1.sendKeys(Utility.getCellData(row, 0));
			
			
			//second filter
			
			WebElement e5=driver.findElement(By.xpath("//input[@value='Add Condition']"));
			e5.click();
			
			Select Note_search=new Select(driver.findElement(By.xpath("//select[@id='multifilter_operator2']")));
			Note_search.selectByVisibleText("And");
			
			Select operator2=new Select(driver.findElement(By.xpath("//select[@id='filter_column2']")));
			operator2.selectByVisibleText("Notes");
			
			
			Select operator3=new Select(driver.findElement(By.xpath("//select[@id='filter_Text_operator2']")));
			operator3.selectByVisibleText("contains");
			
			WebElement e4=driver.findElement(By.xpath("//input[@id='filter_Text_value2']"));
			e4.clear();
			e4.sendKeys(Utility.getCellData(row, 1));
			
			
			driver.findElement(By.xpath("//input[@value='Go']")).click();
			
			Select user_action=new Select(driver.findElement(By.xpath("//select[@id='UserAction']")));
			user_action.selectByVisibleText("Download Commentary");
            driver.findElement(By.xpath("//input[@value='Return to Dashboard']")).click();
            
            Select user_action1=new Select(driver.findElement(By.xpath("//select[@id='UserAction']")));
            user_action1.selectByVisibleText("Upload Commentary");
			
              
            driver.findElement(By.xpath("//*[@id='CompDataWordML']")).sendKeys(Utility.getCellData(1,3 ));
            driver.findElement(By.xpath("//input[@value='Upload Document']")).click();
            
            Select user_action2=new Select(driver.findElement(By.xpath("//select[@id='UserAction']")));
            user_action2.selectByVisibleText("Rebuild");
            
            System.out.println(Utility.getCellData(row, 0)+"successfully upload the commentary file");
            WebElement e6=driver.findElement(By.xpath("//input[@value='Reset']"));
            
            e6.click();
            Thread.sleep(2000);
            
            
    		Utility.setCellData("File Uploaded", row, 2); 
			}
            
			System.out.println("All Commentary files uploaded successfully:");
			
		}
		
				
		}
		}
						
		}	
			
		}driver.quit();
		}}


		
		
		
	


