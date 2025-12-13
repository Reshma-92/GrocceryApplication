package testscripts;

import java.io.IOException;


import org.testng.annotations.Test;

import automationCore.LiveBase;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtility;

public class HomeTest extends LiveBase{
	@Test(retryAnalyzer = retry.Retry.class)
	 
	
	
	public void verifyWhetherUserIsAbleToLoginWithValidCredential() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNamefield(usernamevalue);
		loginPage.enterPasswordOnPasswordField(passwordvalue);
		loginPage.SigninClick();
		HomePage homepage = new HomePage(driver);
		//homepage.clickOnProfileIcon();
		homepage.clickOnListAdmin();
		//homepage.clickOnLogout();
	
	}
}
