package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import automationCore.LiveBase;
import pages.LoginPage;
import utility.ExcelUtility;

public class LoginTest extends LiveBase{
	
	 
	
		@Test(priority = 1,description = "Verify User can login with valid credentials",groups = {"smoke"})
		public void verifyWhetherUserIsAbleToLoginWithValidCredential() throws IOException {
			String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
			String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
			LoginPage loginPage = new LoginPage(driver);
			loginPage.enterUserNameOnUserNamefield(usernamevalue);
			loginPage.enterPasswordOnPasswordField(passwordvalue);
			loginPage.SigninClick();
			boolean dashboardDisplayed=loginPage.isDashboardDisplayed();
			Assert.assertTrue(dashboardDisplayed, "user was unable to login with valid credentials.");
		}

		@Test
		public void verifyWhetherUserIsAbleToLoginWithValidUserNameandInvalidPassword() throws IOException {
			String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
			String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
			LoginPage loginPage = new LoginPage(driver);
			loginPage.enterUserNameOnUserNamefield(usernamevalue);
			loginPage.enterPasswordOnPasswordField(passwordvalue);
			loginPage.SigninClick();
			String expected="7rmart supermarke";
			String actual=loginPage.getTheTitle();
			Assert.assertEquals(actual, expected,"user was able to login with invalid password.");
		}

		@Test
		public void verifyWhetherUserIsAbleToLoginWithInValidUserNameandValidPassword() throws IOException {
			String usernamevalue = ExcelUtility.getStringData(2, 0, "LoginPage");
			String passwordvalue = ExcelUtility.getStringData(2, 1, "LoginPage");
			LoginPage loginPage = new LoginPage(driver);
			loginPage.enterUserNameOnUserNamefield(usernamevalue);
			loginPage.enterPasswordOnPasswordField(passwordvalue);
			loginPage.SigninClick();
		}

		@Test(priority = 4,description = "Verify user is able to login with invalid credentials",groups = {"smoke"})
		public void verifyWhetherUserIsAbleToLoginWithInValidUserNameandInValidPassword() throws IOException {
			String usernamevalue = ExcelUtility.getStringData(3, 0, "LoginPage");
			String passwordvalue = ExcelUtility.getStringData(3, 1, "LoginPage");
			LoginPage loginPage = new LoginPage(driver);
			loginPage.enterUserNameOnUserNamefield(usernamevalue);
			loginPage.enterPasswordOnPasswordField(passwordvalue);
			loginPage.SigninClick();
		}

	}

