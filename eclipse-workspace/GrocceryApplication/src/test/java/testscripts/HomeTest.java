package testscripts;

import java.io.IOException;


import org.testng.annotations.Test;

import automationCore.LiveBase;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtility;
import constant.Constants;
import org.testng.annotations.DataProvider;

public class HomeTest extends LiveBase{
	HomePage home;
	
	@Test(description="verify user logs out successfully.")
	 
	
	
	public void verifyWhetherUserIsAbleToLoginWithValidCredential() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNamefield(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		home = loginPage.SigninClick();
		home.clickOnListAdmin();
	     home.clickOnProfileIcon();
		
		loginPage = home.clickOnLogout();
	
	}
}
