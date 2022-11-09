package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.PredefinedActions;

public class LoginPage extends PredefinedActions {

	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickOnLoginBtn();
	}

	public void enterUsername(String username) {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
	}

	public void clickOnLoginBtn() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	public boolean isUsernameErrorMessageDisplayed() {
		WebElement usernameErrorMessage = driver.findElement(By.cssSelector("span#txtUsername-error"));
		return usernameErrorMessage.isDisplayed();
	}

	public boolean isPasswordErrorMessageDisplayed() {
		WebElement passwordErrorMessage = driver.findElement(By.cssSelector("span#txtPassword-error"));
		return passwordErrorMessage.isDisplayed();
	}

	public boolean isLogoDisplayed() {
		return driver.findElement(By.cssSelector("div.organization-logo.shadow")).isDisplayed();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}
}
