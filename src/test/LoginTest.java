package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import setUp.GenericActions;
import setUp.Main;
import setUp.Utility;

public class LoginTest extends Main{
	
	@Test
	public void test_1() throws IOException {
		System.out.println("test_1");
		String actPageTitle = loginPage.validatePageTitle();
		System.out.println("test_1" + actPageTitle);
		Assert.assertEquals(actPageTitle, System.getProperty("PageTitle"));
	}
	
	@Test
	public void test_2() throws IOException {
		Utility.readDataFRomExcel("test_2");
		System.out.println("test_2");
		//Step-1
		loginPage.inputEmailOrPhoneTextBox("Ashwini");
		//Step-2
		loginPage.inputPasswordTextBox("abcd123");
		//step-3
		loginPage.clickloginBtn();
		
		// validation
		String errorMessage = loginPage.valiadteLoginErrorMessage();
		System.out.println(errorMessage);
		Assert.assertEquals(errorMessage, 
				"The email address or mobile number you entered isn't connected to an account. Find your account and log in.",
				"test_2");
	}
	
	@Test
	public void test_3() {
		
	}
	
}
