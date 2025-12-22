package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.LiveBase;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtility;
import constant.Constants;

public class LoginTest extends LiveBase{
	
	   HomePage home;
	
		@Test(priority = 1,description = "Verify User can login with valid credentials",groups = {"smoke"})
		public void verifyWhetherUserIsAbleToLoginWithValidCredential() throws IOException {
			String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
			String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
			LoginPage loginPage = new LoginPage(driver);
			loginPage.enterUserNameOnUserNamefield(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
			home = loginPage.SigninClick();
			boolean dashboardDisplayed=loginPage.isDashboardDisplayed();
			Assert.assertTrue(dashboardDisplayed, "user was unable to login with valid credentials.");
		}

		@Test(priority = 2, description = "verify user login with valid username and invalid passwords.")
		public void verifyWhetherUserIsAbleToLoginWithValidUserNameandInvalidPassword() throws IOException {
			String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
			String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
			LoginPage loginPage = new LoginPage(driver);
			loginPage.enterUserNameOnUserNamefield(usernamevalue).enterPasswordOnPasswordField(passwordvalue).SigninClick();
			String expected="7rmart supermarke";
			String actual=loginPage.getTheTitle();
			Assert.assertEquals(actual, expected,"user was able to login with invalid password.");
		}

		@Test(priority = 3, description = "verify user login with invalid username and valid password.")
		public void verifyWhetherUserIsAbleToLoginWithInValidUserNameandValidPassword() throws IOException {
			String usernamevalue = ExcelUtility.getStringData(2, 0, "LoginPage");
			String passwordvalue = ExcelUtility.getStringData(2, 1, "LoginPage");
			LoginPage loginPage = new LoginPage(driver);
			loginPage.enterUserNameOnUserNamefield(usernamevalue).enterPasswordOnPasswordField(passwordvalue).SigninClick();
		}

		@Test(priority = 4,description = "Verify user is able to login with invalid credentials",groups = {"smoke"})
		public void verifyWhetherUserIsAbleToLoginWithInValidUserNameandInValidPassword(String usernamevalue,String passwordvalue) throws IOException {
			//String usernamevalue = ExcelUtility.getStringData(3, 0, "LoginPage");
			//String passwordvalue = ExcelUtility.getStringData(3, 1, "LoginPage");
			LoginPage loginPage = new LoginPage(driver);
			loginPage.enterUserNameOnUserNamefield(usernamevalue).enterPasswordOnPasswordField(passwordvalue).SigninClick();
			boolean dashboardDisplayed=loginPage.isDashboardDisplayed();
			Assert.assertTrue(dashboardDisplayed, Constants.INVALIDCREDENTIALSERROR);
		}
		
		@DataProvider(name = "loginProvider")
		public Object[][] getDataFromDataProvider() throws IOException {

			return new Object[][] { new Object[] { "admin", "admin" }
					// new Object[] {ExcelUtility.getStringData(3,
					// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
			};
		}

	}

