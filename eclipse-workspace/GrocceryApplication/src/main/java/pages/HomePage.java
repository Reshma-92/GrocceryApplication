package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[contains(@src, 'avatar5.png')]")
    WebElement admin;
   

   @FindBy(xpath = "//a[normalize-space()='Logout']")
   WebElement logout;
   
    @FindBy(xpath="//p[text()='Admin Users']/parent::div//following-sibling::a") WebElement listadmin;
    @FindBy(xpath="//p[text()='Manage News']/parent::div//following-sibling::a") WebElement moreInfoManageNewsLink;

    
    
   public HomePage clickOnProfileIcon() {
        admin.click();
        return this;
    }
   
   public LoginPage clickOnLogout() {
       logout.click();
       return new LoginPage(driver);
   }
   
   public AdminListPage clickOnListAdmin() {
	   listadmin.click();
	   return new AdminListPage(driver);
   }

   
   public ManageNewsPage clickOnMoreInfoManageNewsLink() {
		moreInfoManageNewsLink.click();
		return new ManageNewsPage(driver);
	}

}
