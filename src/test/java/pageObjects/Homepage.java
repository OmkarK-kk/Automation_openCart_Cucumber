package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends BasePage{

    public Homepage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='My Account']")
    WebElement lnkMyAccount;

    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Register']")
    WebElement lnkRegister;

    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Login']")
    WebElement lnkLogin;

    public void clickOnMyAccount()
    {
        lnkMyAccount.click();
    }

    public void clickOnRegister()
    {
        lnkRegister.click();
    }

    public void clickOnLogin()
    {
        lnkLogin.click();
    }

}
