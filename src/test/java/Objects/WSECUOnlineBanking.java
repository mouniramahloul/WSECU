package Objects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WSECUOnlineBanking {
	
    WebDriver driver;
	
	public WSECUOnlineBanking (WebDriver driver) {
		this.driver= driver;
		
	}

	@FindBy(css="#widget-wsecu-multichannel-login-ng-3922485-username-password-form-password")WebElement Password;
	@FindBy(xpath="//button[normalize-space()='Sign In']")WebElement SignIn2;
	
	
	public void enter_password() {
		Password.sendKeys("thispasswillfailforsure");
		
		
	}
	public void verify_that_an_error_message_is_received() {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".link-list-item.ng-binding[ng-href='/banking/self-enrollment']")));
		SignIn2.click();
		String actual_error=driver.getTitle();
		String expected_error="Sorry, incorrect username.";
		Assert.assertEquals(actual_error,expected_error);
				
	}
}
