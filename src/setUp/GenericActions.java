package setUp;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GenericActions extends Main{
	
	public static void clickElement(WebElement ele) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			log("Succusfully clicked on element");
		}catch(NoSuchElementException e) {
			Assert.fail("Not able to click element: " + e.getMessage());
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}
	
	public static void clickElementUsingActionsClass(WebElement ele) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(ele).click().build().perform();
			log("Succusfully clicked on element");
		}catch(NoSuchElementException e) {
			Assert.fail("Not able to click element: " + e.getMessage());
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}
	
	public static void inputText(WebElement ele, String text) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(ele));
			ele.sendKeys(text);
			log("Succusfully entered text");
		}catch(NoSuchElementException e) {
			Assert.fail("Not able to input text: " + e.getMessage());
		}catch(TimeoutException exc) {
			exc.printStackTrace();
		}
	}
	
	public static void log(Object str) {
		
		SimpleDateFormat parserSDF = new SimpleDateFormat("EEE, MMM dd yyyy; KK:mm:ss aa", Locale.ENGLISH);
		str = parserSDF.format(new Date()) + " - " + str;
		System.out.println(str.toString());
	}
	
	public static void selectOptionFromDropDown(WebElement dropdown, String option) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(dropdown));
			Select dd = new Select(dropdown);
			dd.selectByVisibleText(option);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
public static void takeScreenShot(String fileName) throws IOException {
	System.out.println("Taking screenshot....");
	
//	Saving the screenshot in the form of file
	TakesScreenshot scrShot =((TakesScreenshot)driver);
	File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
	// Now you can do whatever you need to do with it, for example copy somewhere
	FileUtils.copyFile(scrFile, new File(System. getProperty("user.dir") +"\\screenshot\\"+fileName+".png"));
	}

public static void takeScreenShotOnFailure() throws IOException {
	System.out.println("Taking screenshot....");
	
//	Saving the screenshot in the form of file
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	SimpleDateFormat parserSDF = new SimpleDateFormat("MMM dd yyyy KK:mm:ss aa", Locale.ENGLISH);
	System.out.println(parserSDF.toString());
	String fileName = "Failed_Screenshot.png";
	// Now you can do whatever you need to do with it, for example copy somewhere
	FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") +"\\screenshot\\Failed\\"+fileName+".png"));
	}
	
	// this method will get the text from web element
	public static String getTextFromWebELement(WebElement ele) {
	String text = null;
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
		text = ele.getText();
	}catch(NoSuchElementException e) {
		Assert.fail("Not able to input text: " + e.getMessage());
	}catch(TimeoutException exc) {
		exc.printStackTrace();
	}
	return text;
}
	
}
