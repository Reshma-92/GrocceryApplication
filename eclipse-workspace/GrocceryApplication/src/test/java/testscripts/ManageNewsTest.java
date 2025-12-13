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
	@Test
	public void verifyWhetherNewNewsCanBeCreated() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNamefield(usernamevalue);
		loginPage.enterPasswordOnPasswordField(passwordvalue);
		loginPage.SigninClick();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMoreInfoManageNewsLink();
		ManageNewsPage newsPage = new ManageNewsPage(driver);
		newsPage.clickOnNewButton();
		String news = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		newsPage.enterTheNewsInformation(news);
		newsPage.clickOnSaveButton();
		boolean newsCreatedAlert = newsPage.newsCreatedAlert();
		Assert.assertTrue(newsCreatedAlert, "unable to create new news information.");

	}

	@Test
	public void verifyWhetherNewsCanBeSearched() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNamefield(usernamevalue);
		loginPage.enterPasswordOnPasswordField(passwordvalue);
		loginPage.SigninClick();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMoreInfoManageNewsLink();
		ManageNewsPage newsPage = new ManageNewsPage(driver);
		newsPage.clickOnSearchButton();
		String news = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		newsPage.enterTheNewsToSearch(news);
		newsPage.searchButtonClickToSearchNews();
		String expected = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		String actual = newsPage.newsDisplayedList();
		Assert.assertEquals(actual, expected, "Unable to search the news.");
	}

	@Test
	public void verifyWhetherTheListCanBeReset() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNamefield(usernamevalue);
		loginPage.enterPasswordOnPasswordField(passwordvalue);
		loginPage.SigninClick();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMoreInfoManageNewsLink();
		ManageNewsPage newsPage = new ManageNewsPage(driver);
		newsPage.resetButtonClick();
		boolean newsResetListDisplayed = newsPage.isNewsResetListDisplayed();
		Assert.assertTrue(newsResetListDisplayed, "News list is not reset.");
	}
}
