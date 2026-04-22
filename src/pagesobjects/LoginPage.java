package pagesobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import setUp.GenericActions;
import setUp.Main;

public class LoginPage extends Main{
	
public WebDriver driver;	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	String expected ="Results for “chocolates”";

	@FindBy(xpath="//a[@data-testid='open-registration-form-button']")
	public WebElement CreateAccount;
	
	@FindBy(id="email")
	public WebElement emailOrPhoneTextBox;
	
	@FindBy(id="pass")
	public WebElement PasswordTextBox;
	
	@FindBy(name="login")
	public WebElement loginBtn;
	
	@FindBy(xpath="//div[@class='_9ay7']")
	public WebElement LoginErrorErrorMessage;
	
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public void clickCreateAccountBtn() {
		CreateAccount.click();
	}
	
	public void inputEmailOrPhoneTextBox(String value) {
		emailOrPhoneTextBox.sendKeys(value);
	}
	
	public void inputPasswordTextBox(String value) {
		PasswordTextBox.sendKeys(value);
	}
	
	public void clickloginBtn() {
		loginBtn.click();
	}
	
	public String valiadteLoginErrorMessage() {
		return LoginErrorErrorMessage.getText();
	}
	
}
