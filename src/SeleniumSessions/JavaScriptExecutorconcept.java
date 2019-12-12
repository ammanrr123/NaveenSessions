package SeleniumSessions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class JavaScriptExecutorconcept {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","C://Users//ammanrr.CORP//Downloads//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//WebDriver driver=new HtmlUnitDriver();
		

		

	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://classic.crmpro.com/index.html?e=1");
	Thread.sleep(2000);
	System.out.println(driver.getTitle());

	driver.findElement(By.xpath("//*[@id='loginForm']/div/input[1]")).sendKeys("raghuraoa");
	driver.findElement(By.xpath("//*[@id='loginForm']/div/input[2]")).sendKeys("Test@123");
	//driver.findElement(By.xpath("//*[@id='loginForm']/div/div/input")).click();
	
	
	WebElement loginbtn=driver.findElement(By.xpath("//*[@id='loginForm']/div/div/input"));
	
	   //highlight the element using the java script executor
	flash(loginbtn,driver);
	
	drawborder(loginbtn,driver);
	
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
	FileUtils.copyFile(src, new File("//USHOUHOME01//ammanrr//Desktop//Australia//IDProofs//AadharCard//google4.png"));
		
		driver.navigate().refresh();
		
		refershbyjs(driver);
//	generatealert(driver,"Scrresnshottaken successulfy");
		
	JavascriptExecutor js=((JavascriptExecutor)driver);
	String sText=js.executeScript("return document.title;").toString();
	System.out.println(sText);
	
	String STest1=js.executeScript("return document.URL;").toString();
	System.out.println(STest1);
	
	js.executeScript("window.scrollBy(0,500)");
	
	
	}
	public static void flash(WebElement element,WebDriver driver) {
		
		//JavascriptExecutor js=((JavascriptExecutor)driver);
		String bgcolor=element.getCssValue("backgroundColor");
		for(int i=0;i<100;i++) {
			changeColor("rgb(0,200,0)",element,driver);
			changeColor(bgcolor,element,driver);
		}
	}
	
	public static void changeColor(String color,WebElement element,WebDriver driver) {
			
			JavascriptExecutor js=((JavascriptExecutor)driver);
			js.executeScript("arguments[0].style.backgroundColor= '"+color+"'", element);
			
			try {
				Thread.sleep(20);
			}catch(InterruptedException e) {
				
					}
		}
		
	
	public static void drawborder(WebElement element,WebDriver driver) {
			JavascriptExecutor js=((JavascriptExecutor)driver);
			js.executeScript("arguments[0].style.border='3px solid red'",element );
		}
	
	
	
    public static void generatealert(WebDriver driver,String message) {
	
	JavascriptExecutor js=((JavascriptExecutor)driver);
	js.executeScript(("alert('" +message+ "')"));
}
    
    
    public static void refershbyjs(WebDriver driver) {
    	
    	JavascriptExecutor js=((JavascriptExecutor)driver);
    	js.executeScript("history.go(0)");
    }
}
