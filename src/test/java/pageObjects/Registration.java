package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration extends BasePage{

    public Registration(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='firstname']")
    WebElement txtFirstName;

    @FindBy(xpath = "//input[@name='lastname']")
    WebElement txtLastName;

    @FindBy(xpath = "//input[@name='email']")
    WebElement txtEmail;

    @FindBy(xpath = "//input[@name='telephone']")
    WebElement txtPhone;

    @FindBy(xpath = "//input[@name='password']")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@name='confirm']")
    WebElement txtConfirmPassword;

    @FindBy(xpath = "//input[@type='radio' and @value='0']")
    WebElement btnRadioSubscribe;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement checkBoxAgree;

    @FindBy(xpath = "//input[@class='btn btn-primary']")
    WebElement btnContinue;

    public void setTxtFirstName(String firstname)
    {
        txtFirstName.clear();
        txtFirstName.sendKeys(firstname);
    }

    public void setTxtLastName(String lastName)
    {
        txtLastName.clear();
        txtLastName.sendKeys(lastName);
    }

    public void setTxtEmail(String email)
    {
        txtEmail.clear();
        txtEmail.sendKeys(email);
    }

    public void setTxtPhone(String phone)
    {
        txtPhone.clear();
        txtPhone.sendKeys(phone);
    }

    public void setTxtPassword(String pass)
    {
        txtPassword.clear();
        txtPassword.sendKeys(pass);
    }

    public void setTxtConfirmPassword(String cfmpass)
    {
        txtConfirmPassword.clear();
        txtConfirmPassword.sendKeys(cfmpass);
    }

    public void selectSubcribe()
    {
        btnRadioSubscribe.click();
    }

    public void clickOnAgrree()
    {
        checkBoxAgree.click();
    }

    public void clickOnContinue()
    {
        btnContinue.click();
    }
}
