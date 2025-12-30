package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txtUserName;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement btnLogin;

    public void setTxtUserName(String Username)
    {
        txtUserName.clear();
        txtUserName.sendKeys(Username);
    }

    public void setTxtPassword(String Password)
    {
        txtPassword.clear();
        txtPassword.sendKeys(Password);
    }

    public void clickOnLogin()
    {
        btnLogin.click();
    }
}