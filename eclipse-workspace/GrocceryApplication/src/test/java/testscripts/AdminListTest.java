package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.LiveBase;
import pages.AdminListPage;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtility;
import utility.FakerUtility;

public class AdminListTest extends LiveBase{
	@Test
	public void verifyWhetherUserIsAbleToLoginWithValidCredential() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNamefield(usernamevalue);
		loginPage.enterPasswordOnPasswordField(passwordvalue);
		loginPage.SigninClick();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnListAdmin();
		AdminListPage adminlistpage = new AdminListPage(driver);
		adminlistpage.clickOnClickNew();
		FakerUtility fakerutility = new FakerUtility();
		String newUsername = fakerutility.createRandomUsername();
		String newPassword = fakerutility.createFakePassword();
		//String newUsername = ExcelUtility.getStringData(0, 0, "AdminUsersPage");
		//String newPassword = ExcelUtility.getStringData(0, 1, "AdminUsersPage");
		String userType = ExcelUtility.getStringData(0, 2, "AdminUsersPage");
		adminlistpage.enterUserNameOnUserNameField(newUsername);
		adminlistpage.enterPasswordOnPasswordField(newPassword);
		adminlistpage.selectTheUserType(userType);
		adminlistpage.saveButtonClick();
		boolean userAddedAlertDisplayed=adminlistpage.userAddedAlertMessage();
		Assert.assertTrue(userAddedAlertDisplayed,"user not able to add new user.");

	
	}
	
	@Test
	public void verifyWhetherAdminIsAbleToSearchTheNewlyAddedUser() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNamefield(usernamevalue);
		loginPage.enterPasswordOnPasswordField(passwordvalue);
		loginPage.SigninClick();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnListAdmin();
		AdminListPage adminlistpage = new AdminListPage(driver);
		adminlistpage.searchButtonClick();
		String newUsername = ExcelUtility.getStringData(0, 0, "AdminUsersPage");
		adminlistpage.enterTheUserNameToSearch(newUsername);
		adminlistpage.searchButtonClickToCheckUserName();
		boolean adminUsersResultTabDisplayed=adminlistpage.isSearchAdminUsersResultTabDisplayed();
		Assert.assertTrue(adminUsersResultTabDisplayed,"user not able to search for the user.");
	}

	@Test
	public void verifyWhetherAdminIsAbleToResetTheUsersList() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNamefield(usernamevalue);
		loginPage.enterPasswordOnPasswordField(passwordvalue);
		loginPage.SigninClick();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnListAdmin();
		AdminListPage adminlistpage = new AdminListPage(driver);
		adminlistpage.resetButtonClick();
		boolean adminUsersListDisplayed=adminlistpage.isAdminUsersListDisplayed();
		Assert.assertTrue(adminUsersListDisplayed,"user list is not reset.");
	}
}
