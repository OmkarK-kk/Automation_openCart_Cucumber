package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditAccount extends BasePage {

    public EditAccount(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='email']")
    WebElement txtEmail;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btnSubmit;

    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement txtTele;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement succMessage;

    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement lname;

    public void editLastName(String laName)
    {
        lname.clear();
        lname.sendKeys(laName);
    }

    public void editEmail(String em)
    {
        txtEmail.clear();
        txtEmail.sendKeys(em);
    }

    public void editTelephone(String tel)
    {
        txtTele.clear();
        txtTele.sendKeys(tel);
    }

    public void clickOnBtnContinue()
    {
        btnSubmit.click();
    }

    public String getSuccesssMessage()
    {
       return succMessage.getText();
    }
}
