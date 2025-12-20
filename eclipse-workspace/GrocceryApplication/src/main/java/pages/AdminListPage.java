package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;

import utility.PageUtility;


public class AdminListPage {
	PageUtility pageUtility = new PageUtility();
    public WebDriver driver;

    public AdminListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);     //constructor-initialize page object class and pass webdriver instance to that page.
    }

    @FindBy(xpath="//a[contains(text(),' New')]")
    WebElement clicknew;
    @FindBy(id="username") WebElement userName;
	@FindBy(id="password") WebElement password;
	@FindBy(id="user_type") WebElement userType;
	@FindBy(xpath="//button[@type='submit' and @name='Create']") WebElement buttonSave;
	@FindBy(xpath="//a[contains(text(),' Search')]") WebElement searchLink;
	@FindBy(id="un") WebElement searchUserName;
	@FindBy(name="Search") WebElement searchButton;
	@FindBy(xpath="//a[contains(text(),' Reset')]") WebElement resetLink;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible' or @class='alert alert-danger alert-dismissible']")
	WebElement userAddAlert;
	@FindBy(xpath="//h4[text()='Admin Users']") WebElement searchAdminUsersResultTab;
	@FindBy(xpath="//h4[text()='Admin Users']//ancestor::div[@class='card']") WebElement adminUsersList;
    
   public AdminListPage clickOnClickNew() {
	   clicknew.click();
	   return this;
    }
   public AdminListPage enterUserNameOnUserNameField(String newUserNameValue) {
	   userName.sendKeys(newUserNameValue);
	   return this;
   }
   public AdminListPage enterPasswordOnPasswordField(String newPasswordValue) {
		password.sendKeys(newPasswordValue);
		return this;
	}
	
	public AdminListPage selectTheUserType(String userTypeValue) {
	pageUtility.selectDropDownWithVisibleText(userType, userTypeValue);
		
		//Select select=new Select(userType);
		//select.selectByVisibleText(userTypeValue);
		return this;
	}
	public AdminListPage saveButtonClick() {
		buttonSave.click();
		return this;
	}
	
	public AdminListPage searchButtonClick() {
		searchLink.click();
		return this;
	}
	
	public AdminListPage enterTheUserNameToSearch(String userNameValue) {
		searchUserName.sendKeys(userNameValue);
		return this;
	}
	
	public AdminListPage searchButtonClickToCheckUserName() {
		searchButton.click();
		return this;
	}
	
	public AdminListPage resetButtonClick() {
		resetLink.click();
		return this;
	}
	
	public boolean userAddedAlertMessage() {
		return userAddAlert.isDisplayed();
	}
	
	public boolean isSearchAdminUsersResultTabDisplayed() {
		return searchAdminUsersResultTab.isDisplayed();
	}
	
	public boolean isAdminUsersListDisplayed() {
		return adminUsersList.isDisplayed();
	}
}
