package setUp;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import pagesobjects.HomePage;
import pagesobjects.LoginPage;


public class Main {
	public static WebDriver driver;
	
	public static LoginPage loginPage;
	public static HomePage homePage;
	
	ITestResult result;
	
	@BeforeSuite
	@Parameters({"broswerName", "URL"})
	public void setUp(String broswerName, String URL) throws InterruptedException, IOException {
		try {
			System.out.println(System.getProperty("user.dir"));
			openBrowser(broswerName, URL);
			getPageFactoryInstances();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterSuite
	public void tearDown() throws IOException {
		driver.quit();
	}
	
	public void openBrowser(String broswerParameter, String testURL) throws InterruptedException {
		System.out.println(broswerParameter);
		System.out.println(testURL);
		if(broswerParameter.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\munik\\eclipse-workspace\\IndraniSeleniumTraing\\drivers\\chromedriver.exe");
		    driver = new ChromeDriver();
		}
		
		if(broswerParameter.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Training\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		if(broswerParameter.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Training\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.get(testURL);
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
	}
	
	public static void getPageFactoryInstances() {
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		
	}
}
