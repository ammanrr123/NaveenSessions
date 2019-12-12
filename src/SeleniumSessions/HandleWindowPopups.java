package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Lib.ExcelDataConfig;

public class HandleWindowPopups {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C://Users//ammanrr.CORP//Downloads//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//this is the program to upload the commentary  files for sv product communications
		
		driver.get("http://usappcwsywd100/logon");
		
		driver.manage().window().maximize();
		ExcelDataConfig excel=new ExcelDataConfig("C:\\Users\\ammanrr.CORP\\eclipse-workspace\\UploadCommentary.xlsx");
		
		driver.findElement(By.xpath("//*[@id='userid']")).sendKeys(excel.getData(1, 1, 0));
		
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(excel.getData(1, 1, 1));
		
		driver.findElement(By.className("userAction")).sendKeys(Keys.ENTER);
		
		//driver.navigate()""
		
		driver.get("http://usappcwsywd100/ui/CD/Default/PG/GCCP/Dashboard/SVClientBookProductHistInComplete?AVK=1");
		
		driver.findElement(By.xpath("//*[@id='Row_GroupingForm_1']/td[1]")).click();
		
		driver.findElement(By.xpath("//*[@id='Row_GroupingForm_4']/td[1]")).click();
		
		Select select=new Select(driver.findElement(By.xpath("//select[@id='UserAction']")));
		select.selectByVisibleText("Download Commentary");
		
		driver.findElement(By.xpath("//*[@id='gutterDiv']/div[2]/div/form/div/input[1]")).click();
		driver.navigate().refresh();
	
		Select select5=new Select(driver.findElement(By.xpath("//select[@id='UserAction']")));
		select5.selectByVisibleText("Upload Commentary");
		
        
		
        driver.findElement(By.xpath("//*[@id='CompDataWordML']")).sendKeys(excel.getData(0, 1, 1));
		
		//driver.findElement(By.xpath("//*[@id='CompDataWordML']")).sendKeys("//USHOUHOME01//ammanrr//Desktop//All_SV_Fundinserts_Commentary docs//FBRSA655.docx");
		
		driver.findElement(By.xpath("//*[@id='gutterDiv']/div[2]/div/form/div/input[1]")).click();
		
		Select select6=new Select(driver.findElement(By.xpath("//select[@id='UserAction']")));
		select6.selectByVisibleText("Rebuild");
		System.out.println("Upload Commentary for s-000087 as of 31/07/2018 succesfully");
		
		//for(int i=0;i<=3;i++){try {
		//select.selectByVisibleText("Rebuild");break;}catch (Exception e) {System.out.println("exception-element not found");}
		
		driver.findElement(By.xpath("//*[@id='Summary1']")).click();
		
		driver.findElement(By.xpath("//*[@id='Row_GroupingForm_2']/td[1]")).click();
		//sv type $x("//*[@id='Summary1']")
		//SV Quarterly Book prodcut
		
		driver.findElement(By.xpath("//*[@id='Row_GroupingForm_7']/td[1]")).click();
		Thread.sleep(3000);
		
		//S-000077
		
		driver.findElement(By.xpath("//tr[@id='row_ItemForm_41997786']//select[@id='UserAction']"));
		Thread.sleep(3000);
		
		Select select1=new Select(driver.findElement(By.xpath("//tr[@id='row_ItemForm_41997786']//select[@id='UserAction']")));
		select1.selectByVisibleText("Download Commentary");
		
		
		driver.findElement(By.xpath("//*[@id='gutterDiv']/div[2]/div/form/div/input[1]")).click();
		
		Select select7=new Select(driver.findElement(By.xpath("//tr[@id='row_ItemForm_41997786']//select[@id='UserAction']")));
		select7.selectByVisibleText("Upload Commentary");
		
		driver.findElement(By.xpath("//*[@id='CompDataWordML']")).sendKeys(excel.getData(0,2, 1));
		driver.findElement(By.xpath("//*[@id='gutterDiv']/div[2]/div/form/div/input[1]")).click();
		
		Select select8=new Select(driver.findElement(By.xpath("//tr[@id='row_ItemForm_41997786']//select[@id='UserAction']")));
		select8.selectByVisibleText("Rebuild");
		System.out.println("Upload commentary for s-000077 as of 30/09/2018 succesfully");
		//S-000078
		
		Select select2=new Select(driver.findElement(By.xpath("//tr[@id='row_ItemForm_41997788']//select[@id='UserAction']")));
		select2.selectByVisibleText("Download Commentary");
		
		
		driver.findElement(By.xpath("//*[@id='gutterDiv']/div[2]/div/form/div/input[1]")).click();
		
		Select select9=new Select(driver.findElement(By.xpath("//tr[@id='row_ItemForm_41997788']//select[@id='UserAction']")));
		select9.selectByVisibleText("Upload Commentary");
		
		driver.findElement(By.xpath("//*[@id='CompDataWordML']")).sendKeys(excel.getData(0, 3, 1));
		driver.findElement(By.xpath("//*[@id='gutterDiv']/div[2]/div/form/div/input[1]")).click();
		
		Select select10=new Select(driver.findElement(By.xpath("//tr[@id='row_ItemForm_41997788']//select[@id='UserAction']")));
		select10.selectByVisibleText("Rebuild");
		System.out.println("Upload Commentary for s-000078 as of 30/09/2018 succesfully");
		//S-000060
		Select select3=new Select(driver.findElement(By.xpath("//tr[@id='row_ItemForm_41997778']//select[@id='UserAction']")));
		select3.selectByVisibleText("Download Commentary");
		
		
		driver.findElement(By.xpath("//*[@id='gutterDiv']/div[2]/div/form/div/input[1]")).click();
		
		Select select11=new Select(driver.findElement(By.xpath("//tr[@id='row_ItemForm_41997778']//select[@id='UserAction']")));
		select11.selectByVisibleText("Upload Commentary");
		
		
		driver.findElement(By.xpath("//*[@id='CompDataWordML']")).sendKeys(excel.getData(0, 4 ,1));
		driver.findElement(By.xpath("//*[@id='gutterDiv']/div[2]/div/form/div/input[1]")).click();
		
		Select select12=new Select(driver.findElement(By.xpath("//tr[@id='row_ItemForm_41997778']//select[@id='UserAction']")));
		select12.selectByVisibleText("Rebuild");
		System.out.println("Upload Commentary for s-000060 as of 30/09/2018 succesfully");
		//S-000087
		
		Select select4=new Select(driver.findElement(By.xpath("//tr[@id='row_ItemForm_41997773']//select[@id='UserAction']")));
		select4.selectByVisibleText("Download Commentary");
		
		
		driver.findElement(By.xpath("//*[@id='gutterDiv']/div[2]/div/form/div/input[1]")).click();
		
		Select select13=new Select(driver.findElement(By.xpath("//tr[@id='row_ItemForm_41997773']//select[@id='UserAction']")));
		select13.selectByVisibleText("Upload Commentary");
		
		driver.findElement(By.xpath("//*[@id='CompDataWordML']")).sendKeys(excel.getData(0, 5,1));
		
		driver.findElement(By.xpath("//*[@id='gutterDiv']/div[2]/div/form/div/input[1]")).click();
		
		Select select14=new Select(driver.findElement(By.xpath("//tr[@id='row_ItemForm_41997773']//select[@id='UserAction']")));
		select14.selectByVisibleText("Rebuild");
		System.out.println("Upload Commentary for  s-000087 as of 30/09/2018 succesfully");
	}

}
