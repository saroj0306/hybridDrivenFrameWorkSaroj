package com.tc.orangehrm.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.PredefinedActions;
import pages.LoginPage;

public class LoginTest {

	@Test
	public void tc1() {
		System.out.println("Step - Launch the Chrome Browser and Hit the URL");
		PredefinedActions.start("https://skumari-trials77.orangehrmlive.com/");

		System.out.println("Step - Enter valid Login Credentials");
		LoginPage loginPage = new LoginPage();
		loginPage.login("Admin", "M4dB@1nYVd");

		System.out.println("Verify - Home page is displayed");
		String expectedTitle = "Employee Management";
		String actualTitle = loginPage.getPageTitle();
		Assert.assertEquals(actualTitle, expectedTitle,
				"Expected Title was " + expectedTitle + " but actual title was " + actualTitle);

		PredefinedActions.closeBrowser();
	}

}
