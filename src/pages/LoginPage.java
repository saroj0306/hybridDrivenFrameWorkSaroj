package pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

import base.PredefinedActions;

public class LoginPage extends PredefinedActions {

	@FindBy(id = "txtUsername")
	private WebElement userNameElement;
	
	@FindBy(id = "txtPassword")
	private WebElement passwordElement;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitBtn;
	
	@FindBy(css = "div.organization-logo.shadow>img")
	private WebElement logo;
	
	@FindBy(css = "#txtUsername-error")
	private WebElement usernameErrorElement;
	
	@FindBy(css = "#txtPassword-error")
	private WebElement pwdErrorElement;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickOnLoginBtn();
	}

	public void enterUsername(String username) {
		//driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
		//driver.findElement(By.id("txtUsername")).sendKeys(username);
		
				//WebElement e = getElement("id", "txtUsername", false);
				//setText(e,username);
				//setText("id", "txtUsername", false,username);
				//userNameElement.sendKeys(username);
				
				setText(userNameElement, username);
	}

	public void enterPassword(String password) {
		//driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
		setText(passwordElement, password);
	}

	public void clickOnLoginBtn() {
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
		clickOnElement(submitBtn, false);
	}

	public boolean isUsernameErrorMessageDisplayed() {
		//WebElement usernameErrorMessage = driver.findElement(By.cssSelector("span#txtUsername-error"));
		//return usernameErrorMessage.isDisplayed();
		return isElementDisplayed(usernameErrorElement);
	}

	public boolean isPasswordErrorMessageDisplayed() {
		//WebElement passwordErrorMessage = driver.findElement(By.cssSelector("span#txtPassword-error"));
		//return passwordErrorMessage.isDisplayed();
		return isElementDisplayed(passwordElement);
	}

	public boolean isLogoDisplayed() {
		//return driver.findElement(By.cssSelector("div.organization-logo.shadow")).isDisplayed();
		return isElementDisplayed(logo);
	}

	/*public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getPageURL() {
		return driver.getCurrentUrl();
	}*/
}
