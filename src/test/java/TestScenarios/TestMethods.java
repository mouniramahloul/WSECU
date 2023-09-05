package TestScenarios;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Objects.LoginPage;
import Objects.WSECUOnlineBanking;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMethods {
	WebDriver driver;
	@BeforeTest
	public void beforetest() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://wsecu.org/");
		driver.manage().window().maximize();
	

		
	}
	@Test(priority=0)
	public void enter_incorrect_username()  {
		LoginPage page=new LoginPage(driver);
		page.enterUsername();
		page.verify_user_is_redirected();
		

}
	@Test(priority=1)
	public void enter_incorect_password() {
		
		WSECUOnlineBanking page2 = new WSECUOnlineBanking(driver);
		page2.enter_password();
		page2.verify_that_an_error_message_is_received();
			
	}
	
	@AfterTest
	public void aftertest() {
		driver.close();
		driver.quit();
	}
	

}
