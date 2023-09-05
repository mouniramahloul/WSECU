package Objects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage (WebDriver driver) {
		this.driver= driver;
		
	}
	@FindBy(xpath="//input[@id='digital-banking-username']") WebElement Username;
	@FindBy(css="input[value='Sign in']")WebElement SignIn;
	
	
	public void enterUsername() {
		
		Username.sendKeys("thisuserwillnotwork");
		}
	
	public void verify_user_is_redirected() {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value='Sign in']")));
		SignIn.click();
		String webPageTitle= driver.getTitle();System.out.println("Title is"+webPageTitle);
		String expectedTitle="Sign in to Online Banking";
		Assert.assertEquals(webPageTitle, expectedTitle);
		
		
	}

}
