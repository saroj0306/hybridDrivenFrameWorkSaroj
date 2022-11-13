package com.tc.orangehrm.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.PredefinedActions;
import pages.LoginPage;
import utility.ExcelOperations;

public class LoginTest {

	@Test(dataProvider = "LoginDataProvider")
	public void tc1(String url, String uname, String password, boolean isLoginSuccessful) {
		System.out.println("Step - Launch the Chrome Browser and Hit the URL");
		PredefinedActions.start(url);

		System.out.println("Step - Enter valid Login Credentials");
		LoginPage loginPage = new LoginPage();
		loginPage.login(uname, password);

		if (isLoginSuccessful) {
			System.out.println("VERIFY - home page is displayed");
			String expetedTitle = "Employee Management";
			String actualTitle = loginPage.getPageTitle();
			Assert.assertEquals(actualTitle, expetedTitle,
					"Expected title was " + expetedTitle + " but actual title was " + actualTitle);
		} else {
			System.out.println("Verify - Home page is displayed");
			String expectedTitle = "OrangeHRM";
			String actualTitle = loginPage.getPageTitle();
			Assert.assertEquals(actualTitle, expectedTitle,
					"Expected Title was " + expectedTitle + " but actual title was " + actualTitle);

			System.out.println("VERIFY - Retry login page is loaded");
			String expectedUrlContent = "retryLogin";
			String actualCurrentURL = loginPage.getPageURL();
			Assert.assertTrue(actualCurrentURL.endsWith(expectedUrlContent));
		}

		System.out.println("Clean up - Close browser");
		PredefinedActions.closeBrowser();
	}

	@DataProvider(name = "LoginDataProvider")
	public Object[][] getLoginData() throws IOException {
		Object[][] data;
		String fileName = ".//testdata//LoginData.xlsx";
		try {
			data = ExcelOperations.readExcelData(fileName, "Data");
		} catch (IOException e) {
			data = ExcelOperations.readExcelData(".//testdata1//LoginData.xlsx", "Data");
		}
		return data;
	}

	@DataProvider(name = "LoginDataProvider1")
	public Object[][] getLoginData1() {

		Object[][] data = new Object[2][4];
		data[0][0] = "https://skumari-trials77.orangehrmlive.com/";
		data[0][1] = "Admin";
		data[0][2] = "M4dB@1nYVd";
		data[0][3] = true;

		data[1][0] = "https://harshaug2022-trials76.orangehrmlive.com";
		data[1][1] = "admin";
		data[1][2] = "MPCs0K@ce1234";
		data[1][3] = false;

		return data;
	}

	@Test
	public void tc1_Negative() {
		System.out.println("Step - Launch the Chrome Browser and Hit the URL");
		PredefinedActions.start("https://skumari-trials77.orangehrmlive.com/");

		System.out.println("Step - Enter valid Login Credentials");
		LoginPage loginPage = new LoginPage();
		loginPage.login("Admin", "M4dB@1nYVd");

		System.out.println("Verify - Home page is displayed");
		String expectedTitle = "OrangeHRM";
		String actualTitle = loginPage.getPageTitle();
		Assert.assertEquals(actualTitle, expectedTitle,
				"Expected Title was " + expectedTitle + " but actual title was " + actualTitle);

		System.out.println("VERIFY - Retry login page is loaded");
		String expectedUrlContent = "retryLogin";
		String actualCurrentURL = loginPage.getPageURL();
		Assert.assertTrue(actualCurrentURL.endsWith(expectedUrlContent));

		System.out.println("Clean up - Close browser");
		PredefinedActions.closeBrowser();
	}
}
