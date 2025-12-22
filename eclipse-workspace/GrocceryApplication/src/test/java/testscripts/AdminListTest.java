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

public class AdminListTest extends LiveBase {
	HomePage home;
	AdminListPage adminuser;

	@Test(priority = 1, description = "verify whether admin can add new user.")
	public void verifyWhetherUserIsAbleToLoginWithValidCredential() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNamefield(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		home = loginPage.SigninClick();
		adminuser = home.clickOnListAdmin();
		adminuser.clickOnClickNew();
		FakerUtility fakerutility = new FakerUtility();
		String newUsername = fakerutility.createRandomUsername();
		String newPassword = fakerutility.createFakePassword();
		// String newUsername = ExcelUtility.getStringData(0, 0, "AdminUsersPage");
		// String newPassword = ExcelUtility.getStringData(0, 1, "AdminUsersPage");
		String userType = ExcelUtility.getStringData(0, 2, "AdminUsersPage");
		adminuser.enterUserNameOnUserNameField(newUsername).enterPasswordOnPasswordField(newPassword)
				.selectTheUserType(userType).saveButtonClick();
		boolean userAddedAlertDisplayed = adminuser.userAddedAlertMessage();
		Assert.assertTrue(userAddedAlertDisplayed, "user not able to add new user.");

	}

	@Test(priority = 2, description = "verify whether admin can search the newly added user.")
	public void verifyWhetherAdminIsAbleToSearchTheNewlyAddedUser() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNamefield(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		home = loginPage.SigninClick();
		adminuser = home.clickOnListAdmin();
		adminuser.searchButtonClick();
		String newUsername = ExcelUtility.getStringData(0, 0, "AdminUsersPage");
		adminuser.enterTheUserNameToSearch(newUsername).searchButtonClickToCheckUserName();
		boolean adminUsersResultTabDisplayed = adminuser.isSearchAdminUsersResultTabDisplayed();
		Assert.assertTrue(adminUsersResultTabDisplayed, "user not able to search for the user.");
	}

	@Test(priority = 3, description = "verify whether admin can reset the users list.")
	public void verifyWhetherAdminIsAbleToResetTheUsersList() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNamefield(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		home = loginPage.SigninClick();
		adminuser = home.clickOnListAdmin();
		adminuser.resetButtonClick();
		boolean adminUsersListDisplayed = adminuser.isAdminUsersListDisplayed();
		Assert.assertTrue(adminUsersListDisplayed, "user list is not reset.");
	}
}
