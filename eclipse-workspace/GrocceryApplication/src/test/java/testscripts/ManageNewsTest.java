package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.LiveBase;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utility.ExcelUtility;

public class ManageNewsTest extends LiveBase{
	HomePage home;
	ManageNewsPage managenews;
	@Test(priority = 1, description = "verify whether new news can be created.")
	public void verifyWhetherNewNewsCanBeCreated() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNamefield(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		home = loginPage.SigninClick();
	
		managenews = home.clickOnMoreInfoManageNewsLink();
		managenews.clickOnNewButton();
		String news = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		managenews.enterTheNewsInformation(news).clickOnSaveButton();
		boolean newsCreatedAlert = managenews.newsCreatedAlert();
		Assert.assertTrue(newsCreatedAlert, "unable to create new news information.");

	}

	@Test(priority = 2, description = "verify whether news can be searched.")
	public void verifyWhetherNewsCanBeSearched() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNamefield(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		home = loginPage.SigninClick();
		managenews = home.clickOnMoreInfoManageNewsLink();
		managenews.clickOnSearchButton();
		String news = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		managenews.enterTheNewsToSearch(news).searchButtonClickToSearchNews();
		String expected = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		String actual = managenews.newsDisplayedList();
		Assert.assertEquals(actual, expected, "Unable to search the news.");
	}

	@Test(priority = 3, description = "verify whether news list can be reset.")
	public void verifyWhetherTheListCanBeReset() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNamefield(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		home = loginPage.SigninClick();
		
		managenews = home.clickOnMoreInfoManageNewsLink();
	
		managenews.resetButtonClick();
		boolean newsResetListDisplayed = managenews.isNewsResetListDisplayed();
		Assert.assertTrue(newsResetListDisplayed, "News list is not reset.");
	}
}
