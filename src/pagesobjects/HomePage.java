package pagesobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import setUp.GenericActions;
import setUp.Main;


public class HomePage extends Main{
	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(id="firstName")
	public WebElement firstName;
	
	@FindBy(id="lastName")
	public WebElement lastName;
	
	@FindBy(id="userEmail")
	public WebElement userEmail;
	
	@FindBy(xpath = "//input[@id='gender-radio-1']")
	public WebElement genderRadiobtn;
	
	@FindBy(id ="userNumber")
	public WebElement userNumber;
	
	@FindBy(xpath= "//input[@id='dateOfBirthInput']")
	public WebElement dob;
	
	@FindBy(xpath= "//input[@id='dateOfBirthInput']")
	public WebElement continueBtn;
	
	@FindBy(xpath="//div[@class= 'react-datepicker__header']")
	public WebElement datepicker;
	
	@FindBy(xpath="//select[@class='react-datepicker__month-select']")
	public WebElement selectMonthPicker;
	
	@FindBy(xpath="react-datepicker__month")
	public WebElement monthPicker;
	
	@FindBy(xpath="//select[@class='react-datepicker__month-select']//option[text()='October']")
	public WebElement selectMonth;
	
	@FindBy (xpath="//select[@class='react-datepicker__year-select']")
	public WebElement selectYear;
	
	@FindBy (xpath="//div[@class='react-datepicker__day react-datepicker__day--011']")
	public WebElement selectDay;
	
	
	public void fillTheForm() throws InterruptedException
	{
		GenericActions.inputText(firstName, "test");
		GenericActions.inputText(lastName, "sample");
		GenericActions.inputText(userEmail, "crystalball.diamondhead@gmail.com");
		GenericActions.clickElementUsingActionsClass(genderRadiobtn);
		GenericActions.inputText(userNumber, "67457652745");
		GenericActions.clickElementUsingActionsClass(dob);
		GenericActions.selectOptionFromDropDown(selectMonthPicker, "October");
		GenericActions.selectOptionFromDropDown(selectYear, "1991");
		String day = "Thursday, October 3rd, 1991";
		driver.findElement(By.xpath("//div[@aria-label='Choose "+ day +"']")).click();
	}
	
	public void inputUserName() {
		userEmail.sendKeys("");
	}
	
	public void clickContineBtn() {
		continueBtn.click();
	}
	
}
