package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Lib.Utility3;

public class DeleteCommunicationJobs {

	public static void main(String[] args) throws Exception {
		// launching the browser
		try {
			System.setProperty("webdriver.chrome.driver", "C://Users//ammanrr.CORP//Downloads//chromedriver.exe");
		} catch (Exception e) {
			System.out.println("unable to find the chrome driver");
		}

		WebDriver driver = new ChromeDriver();
		// maximizing the browser
		driver.manage().window().maximize();

		// searching for user data file
		try {
			Utility3.setExcelFile("C:\\Users\\ammanrr.CORP\\eclipse-workspace\\DeleteCommunicationJobs.xlsx", "Sheet1");
		} catch (Exception e) {
			System.out.println("Given Updated user input file is not availble in specified location");
		}
		// Entering the user data from excel file
		try {
			driver.get(Utility3.getCellData(1, 3));

			driver.findElement(By.xpath("//*[@id='userid']")).sendKeys(Utility3.getCellData(1, 4));

			driver.findElement(By.xpath("//*[@id='password']")).sendKeys(Utility3.getCellData(1, 5));

			driver.findElement(By.className("userAction")).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			System.out.println("User is unable to login into aplication");
		}
		// after login mouse overing the views option
		// Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//a[contains(.,'Views»')]"));

		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();

		// this will fetch the all projects
		List<WebElement> links = driver.findElements(By.xpath("//*[@id='NavMenu']/ul[@class='jd_menu']/li[2]/ul[@class='jdm_events']/li/a"));

		// this will give total project
		System.out.println("Total projects are" + links.size());

		// this is will print the projects in order
		for (int i = 0; i < links.size(); i++) {

			WebElement element1 = links.get(i);
			String text = element1.getAttribute("innerHTML");

			// String text=element1.getText();

			System.out.println("View is:" + text);

			if (text.equalsIgnoreCase(Utility3.getCellData(1, 6))) {
				element1.click();

				String s1 = "//a[text()='";
				String s2 = "']//following-sibling::ul//a[text()='";
				String s3 = "']";

				String s4 = Utility3.getCellData(1, 7);
				String s5 = Utility3.getCellData(1, 8);

				WebElement subview = driver.findElement(By.xpath(s1 + s4 + s2 + s5 + s3));
				subview.click();

				// This is navigate to investment center which is mentioned in the excel
				List<WebElement> links2 = driver.findElements(By.xpath(
						"//tr[contains(@id,'Row_GroupingForm')]//following-sibling::td//preceding-sibling::td[@class='']"));

				System.out.println("Projects are" + links2.size());

				for (int j = 0; j < links2.size(); j++) {

					WebElement element2 = links2.get(j);
					String text2 = element2.getAttribute("innerHTML");

					System.out.println("Project name is:" + text2);
					// given in excel sheet to navigate to Active date or historical dates
					if (text2.equalsIgnoreCase(Utility3.getCellData(1, 9))) {

						element2.click();
						break;
					}
				}
				break;
			}

		}
//-------------------------------------------------------------------
		int totalNoOfRows = Utility3.rowcount("Sheet1");
		
		WebElement element4;
		try {
			element4 = driver.findElement(By.xpath(
					"//div[@id='taskListTarget']//table[@id='tasklistTable']/tbody//tr[@mouseoverclass='highlightTaskListRow']/td[1]"));
		} catch (Exception e) {
			element4 = null;
		}
		if (element4 == null) {

			System.out.println("active qtr view");
			

			for (int row = 1; row <= totalNoOfRows; row++)

			{
				try {
					Select Act_Search = new Select(driver.findElement(By.xpath("//select[@id='filter_column']")));
					Act_Search.selectByVisibleText("Acct #");
				} catch (Exception e) {
					System.out.println("Act_Search element not found");
				}

				try {
					Select Condition_Search = new Select(
							driver.findElement(By.xpath("//select[@id='filter_Text_operator']")));
					Condition_Search.selectByVisibleText("equals");
				} catch (Exception e) {
					System.out.println("Condition_Search element not found");
				}

				try {
					WebElement act1 = driver.findElement(By.xpath("//input[@id='filter_Text_value']"));

					act1.clear();
					act1.sendKeys(Utility3.getCellData(row, 0));
				} catch (Exception e) {
					System.out.println("Unable to enter data");
				}

				// second filter
				try {
					WebElement e5 = driver.findElement(By.xpath("//input[@value='Add Condition']"));
					e5.click();
				} catch (Exception e) {
					System.out.println("unable to click the add condition button");
				}

				try {
					Select Note_search = new Select(
							driver.findElement(By.xpath("//select[@id='multifilter_operator2']")));
					Note_search.selectByVisibleText("And");
				} catch (Exception e) {
					System.out.println("And/OR option is not available");
				}

				try {
					Select operator2 = new Select(driver.findElement(By.xpath("//select[@id='filter_column2']")));
					operator2.selectByVisibleText("Notes");
				} catch (Exception e) {
					System.out.println("Notes option is not available");
				}

				try {
					Select operator3 = new Select(
							driver.findElement(By.xpath("//select[@id='filter_Text_operator2']")));
					operator3.selectByVisibleText("contains");
				} catch (Exception e) {
					System.out.println("Contains search option is not able to select");
				}

				try {
					WebElement e4 = driver.findElement(By.xpath("//input[@id='filter_Text_value2']"));
					e4.clear();
					e4.sendKeys(Utility3.getCellData(row, 1));
				} catch (Exception e) {
					System.out.println("unable to enter data from excel on to notes text box");
				}

				try {
					driver.findElement(By.xpath("//input[@value='Go']")).click();
				} catch (Exception e) {
					System.out.println("unable to click Go  button");
				}

				// after act#search,this will search for UserAction drop down
    try {
				WebElement select1 = driver.findElement(By.xpath("//select[@id='UserAction']"));
				if (select1 != null) {
					Select values = new Select(select1);
					// this will collect all the options in dropdown into a list
					List<WebElement> options = values.getOptions();
					int isize = options.size();
					for (int s = 1; s < isize; s++) {
						String sValue = options.get(s).getText();
						System.out.println(sValue);

						if ((sValue.equalsIgnoreCase("Delete"))==true)

						{
							values.selectByVisibleText(sValue);
							driver.findElement(By.xpath("//*[@id='RouteWorkflow']/div/input[@value='No']")).click();
							System.out.println("act# got deleted succesfully"+Utility3.getCellData(row, 1));
							driver.findElement(By.xpath("//input[@value='Reset']")).click();
							
							break;
						}
					}
					// break;
				}}catch(Exception e) {
					System.out.println("act# not present");
					
				}

				
//---------------------------------Historical views-----------------------------------------------------------
			}
		}

		// Historical completed
		else {
			
			WebElement element5;
			try {
			element5=driver.findElement(By.xpath("//*[@id='InvestmentCenter']"));
			}
			catch(Exception e) {
				element5=null;
			}
			if(element5!=null) {
				
				List<WebElement> links4 = driver.findElements(By.xpath(
					"//div[@id='taskListTarget']//table[@id='tasklistTable']/tbody//tr[@mouseoverclass='highlightTaskListRow']/td[1]"));
			System.out.println("Total Summary Investment Centers are" + links4.size());

			for (int k = 0; k < links4.size(); k++) {

				WebElement element6 = links4.get(k);
				String text4 = element6.getAttribute("innerHTML");

				System.out.println("Investment center is:" + text4);

				
				// given in excel sheet to navigate to Active date or historical dates
				if (text4.equalsIgnoreCase(Utility3.getCellData(1, 10))) {
					element6.click();
					//driver.findElement(By.xpath("//div[@id='taskListTarget']//table[@id='tasklistTable']/tbody//tr[@mouseoverclass='highlightTaskListRow']")).click();
					break;
				}

			}
			
			driver.findElement(By.xpath("//div[@id='taskListTarget']//table[@id='tasklistTable']/tbody//tr[@mouseoverclass='highlightTaskListRow']/td[1]")).click();
			List<WebElement> links3 = driver.findElements(By.xpath(
					"//div[@id='taskListTarget']//table[@id='tasklistTable']/tbody//tr[@mouseoverclass='highlightTaskListRow']/td[1]"));
			System.out.println("Total effective dates are" + links3.size());

			for (int k = 0; k < links3.size(); k++) {

				WebElement element3 = links3.get(k);
				String text3 = element3.getAttribute("innerHTML");

				System.out.println("Effective date is:" + text3);

				
				// given in excel sheet to navigate to Active date or historical dates
				if (text3.equalsIgnoreCase(Utility3.getCellData(1, 11))) {
					element3.click();
					break;
				}

			}
			for(int row=1;row<=totalNoOfRows;row++)
				
			 {
				try {
					Select Act_Search = new Select(driver.findElement(By.xpath("//select[@id='filter_column']")));
					Act_Search.selectByVisibleText("Acct #");
				} catch (Exception e) {
					System.out.println("Act_Search element not found");
				}

				try {
					Select Condition_Search = new Select(
							driver.findElement(By.xpath("//select[@id='filter_Text_operator']")));
					Condition_Search.selectByVisibleText("equals");
				} catch (Exception e) {
					System.out.println("Condition_Search element not found");
				}

				try {
					WebElement act1 = driver.findElement(By.xpath("//input[@id='filter_Text_value']"));

					act1.clear();
					act1.sendKeys(Utility3.getCellData(row, 0));
				} catch (Exception e) {
					System.out.println("Unable to enter data");
				}

				// second filter
				try {
					WebElement e5 = driver.findElement(By.xpath("//input[@value='Add Condition']"));
					e5.click();
				} catch (Exception e) {
					System.out.println("unable to click the add condition button");
				}

				try {
					Select Note_search = new Select(
							driver.findElement(By.xpath("//select[@id='multifilter_operator2']")));
					Note_search.selectByVisibleText("And");
				} catch (Exception e) {
					System.out.println("And/OR option is not available");
				}

				try {
					Select operator2 = new Select(driver.findElement(By.xpath("//select[@id='filter_column2']")));
					operator2.selectByVisibleText("Notes");
				} catch (Exception e) {
					System.out.println("Notes option is not available");
				}

				try {
					Select operator3 = new Select(
							driver.findElement(By.xpath("//select[@id='filter_Text_operator2']")));
					operator3.selectByVisibleText("contains");
				} catch (Exception e) {
					System.out.println("Contains search option is not able to select");
				}

				try {
					WebElement e4 = driver.findElement(By.xpath("//input[@id='filter_Text_value2']"));
					e4.clear();
					e4.sendKeys(Utility3.getCellData(row, 1));
				} catch (Exception e) {
					System.out.println("unable to enter data from excel on to notes text box");
				}

				try {
					driver.findElement(By.xpath("//input[@value='Go']")).click();
				} catch (Exception e) {
					System.out.println("unable to click Go  button");
				}

				// after act#search,this will search for UserAction drop down
try {
				WebElement select1 = driver.findElement(By.xpath("//select[@id='UserAction']"));
				if (select1 != null) {
					Select values = new Select(select1);
					// this will collect all the options in dropdown into a list
					List<WebElement> options = values.getOptions();
					int isize = options.size();
					for (int s = 0; s < isize; s++) {
						String sValue = options.get(s).getText();
						System.out.println(sValue);

						if (sValue.equalsIgnoreCase("Delete"))

						{
							values.selectByVisibleText(sValue);
							driver.findElement(By.xpath("//*[@id='RouteWorkflow']/div/input[@value='No']")).click();
							System.out.println("act# got deleted succesfully"+Utility3.getCellData(row, 1));
							driver.findElement(By.xpath("//input[@value='Reset']")).click();
							;
							break;
						}
					}
					//break;
				}

}catch(Exception e) {
	System.out.println("act# not present");
}	
			}}
			
			//------SV------
			else {
			
			System.out.println("historical view");
			List<WebElement> links3 = driver.findElements(By.xpath(
					"//div[@id='taskListTarget']//table[@id='tasklistTable']/tbody//tr[@mouseoverclass='highlightTaskListRow']/td[1]"));
			System.out.println("Total effective dates are" + links3.size());

			for (int k = 0; k < links3.size(); k++) {

				WebElement element3 = links3.get(k);
				String text3 = element3.getAttribute("innerHTML");

				System.out.println("Effective date is:" + text3);

				
				// given in excel sheet to navigate to Active date or historical dates
				if (text3.equalsIgnoreCase(Utility3.getCellData(1, 11))) {
					element3.click();
					break;
					//label;
				}

			}

		

			 for(int row=1;row<=totalNoOfRows;row++)
			
			 {
				try {
					Select Act_Search = new Select(driver.findElement(By.xpath("//select[@id='filter_column']")));
					Act_Search.selectByVisibleText("Acct #");
				} catch (Exception e) {
					System.out.println("Act_Search element not found");
				}

				try {
					Select Condition_Search = new Select(
							driver.findElement(By.xpath("//select[@id='filter_Text_operator']")));
					Condition_Search.selectByVisibleText("equals");
				} catch (Exception e) {
					System.out.println("Condition_Search element not found");
				}

				try {
					WebElement act1 = driver.findElement(By.xpath("//input[@id='filter_Text_value']"));

					act1.clear();
					act1.sendKeys(Utility3.getCellData(row, 0));
				} catch (Exception e) {
					System.out.println("Unable to enter data");
				}

				// second filter
				try {
					WebElement e5 = driver.findElement(By.xpath("//input[@value='Add Condition']"));
					e5.click();
				} catch (Exception e) {
					System.out.println("unable to click the add condition button");
				}

				try {
					Select Note_search = new Select(
							driver.findElement(By.xpath("//select[@id='multifilter_operator2']")));
					Note_search.selectByVisibleText("And");
				} catch (Exception e) {
					System.out.println("And/OR option is not available");
				}

				try {
					Select operator2 = new Select(driver.findElement(By.xpath("//select[@id='filter_column2']")));
					operator2.selectByVisibleText("Notes");
				} catch (Exception e) {
					System.out.println("Notes option is not available");
				}

				try {
					Select operator3 = new Select(
							driver.findElement(By.xpath("//select[@id='filter_Text_operator2']")));
					operator3.selectByVisibleText("contains");
				} catch (Exception e) {
					System.out.println("Contains search option is not able to select");
				}

				try {
					WebElement e4 = driver.findElement(By.xpath("//input[@id='filter_Text_value2']"));
					e4.clear();
					e4.sendKeys(Utility3.getCellData(row, 1));
				} catch (Exception e) {
					System.out.println("unable to enter data from excel on to notes text box");
				}

				try {
					driver.findElement(By.xpath("//input[@value='Go']")).click();
				} catch (Exception e) {
					System.out.println("unable to click Go  button");
				}

				// after act#search,this will search for UserAction drop down
try {
				WebElement select1 = driver.findElement(By.xpath("//select[@id='UserAction']"));
				if (select1 != null) {
					Select values = new Select(select1);
					// this will collect all the options in dropdown into a list
					List<WebElement> options = values.getOptions();
					int isize = options.size();
					for (int s = 0; s < isize; s++) {
						String sValue = options.get(s).getText();
						System.out.println(sValue);

						if (sValue.equalsIgnoreCase("Delete"))

						{
							values.selectByVisibleText(sValue);
							driver.findElement(By.xpath("//*[@id='RouteWorkflow']/div/input[@value='No']")).click();
							System.out.println("act# got deleted succesfully"+Utility3.getCellData(row, 1));
							driver.findElement(By.xpath("//input[@value='Reset']")).click();
							;
							break;
						}
					}
					//break;
				}

}catch(Exception e) {
	System.out.println("act# not present");
}
			}
		}

	}

}}
