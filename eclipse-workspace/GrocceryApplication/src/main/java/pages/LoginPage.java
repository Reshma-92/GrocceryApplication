package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
		public WebDriver driver;

		public LoginPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

		@FindBy(xpath="//input[@name='username']") WebElement userName;
		@FindBy(xpath="//input[@name='password']") WebElement password;
		@FindBy(xpath = "//button[@type='submit']")WebElement signInBtn;
		@FindBy(xpath="//p[text()='Dashboard']") WebElement dashboard;
		@FindBy(xpath="//b[text()='7rmart supermarket']") WebElement title;

		public void enterUserNameOnUserNamefield(String usernamevalue) {
			userName.sendKeys( usernamevalue);
		}

		public void enterPasswordOnPasswordField(String passwordvalue) {
			password.sendKeys(passwordvalue);
		}

		public void SigninClick() {
			signInBtn.click();
		}
		
		public boolean isDashboardDisplayed() {
			return dashboard.isDisplayed();
		}
		
		public String getTheTitle() {
			return title.getText();
		}

	}

