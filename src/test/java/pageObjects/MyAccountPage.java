package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BasePage{

    public MyAccountPage(WebDriver driver)
    {
       super(driver);
    }

    @FindBy(xpath = "//a[text()='Logout']//parent:: li[1]")
    WebElement btnLogout;

    @FindBy(xpath = "//a[text()='Edit Account']")
    WebElement lnkEditAccount;

    public void clickOnLogOut()
    {
        btnLogout.click();
    }

    public void clickOnEditAccount()
    {
        lnkEditAccount.click();
    }
}
