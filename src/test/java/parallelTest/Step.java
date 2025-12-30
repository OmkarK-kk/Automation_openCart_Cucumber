package parallelTest;

import StepDefinitions.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
//import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class Step {

    public Hooks hooks;

    public Step(Hooks hooks)
    {
        this.hooks=hooks;
    }

    /*
    // 🔑 PicoContainer injects Hooks automatically
    public Step(Hooks hooks) {
        this.driver = hooks.driver;
        this.hp = hooks.hp;
        this.lp = hooks.lp;
        this.mp = hooks.mp;
        this.rp = hooks.rp;
        this.ed = hooks.ed;
    }*/

        @Given("User launch chrome browser")
        public void user_launch_chrome_browser() {
            // Browser launched in Hooks
          //  hooks.logger.info("Browser started..");
        }

    @When("User opens URl {string}")
    public void user_opens_u_rl(String url) throws InterruptedException {
        hooks.driver.get(url);
      //  hooks.logger.info("Url opened..");
        Thread.sleep(2000);
    }

    @When("Click on My Account link")
    public void click_on_my_account_link() {
        hooks.hp.clickOnMyAccount();
   //     hooks.logger.info("User clicked on My Account link..");
    }

    @When("Click on Login Button")
    public void click_on_login_button() {
        hooks.hp.clickOnLogin();
     //   hooks.logger.info("User clicked on login button..");
    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String ExpPageTitle) {
        String actPageTitle = hooks.driver.getTitle();

        if (actPageTitle.equals(ExpPageTitle))
        {
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }
    }

    @Then("User enters Username as {string}")
    public void user_enters_username_as(String Username) {
        hooks.lp.setTxtUserName(Username);
    }


    @Then("User enters as Password as {string}")
    public void user_enters_as_password_as(String Password) {
        hooks.lp.setTxtPassword(Password);
    }

    @Then("Click on Login")
    public void click_on_login() {
        hooks.lp.clickOnLogin();
    }

    @When("User click on Logout button")
    public void user_click_on_logout_button() {
        hooks.mp.clickOnLogOut();
    }

    @Then("Close browser")
    public void close_browser() {
       // hooks.driver.close();
        //  driver.quit();
    }

    ///////////////Register//////////////

    @When("Click on Register Button")
    public void click_on_register_button() {
        hooks.hp.clickOnRegister();
    }

   /* @When("User enters all user details")
    public void user_enters_all_user_details(String fname, String lName, String email, String phone, String pass, String confPass) {
    rp.setTxtFirstName(fname);
    rp.setTxtLastName(lName);
    rp.setTxtEmail(email);
    rp.setTxtPhone(phone);
    rp.setTxtPassword(pass);
    rp.setTxtConfirmPassword(confPass);
    rp.selectSubcribe();
    }*/

    @When("User enters all user details")
    public void user_enters_all_user_details(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : data) {

            hooks.rp.setTxtFirstName(row.get("fname"));
            hooks.rp.setTxtLastName(row.get("lName"));
            hooks.rp.setTxtEmail(row.get("email"));
            hooks.rp.setTxtPhone(row.get("phone"));
            hooks.rp.setTxtPassword(row.get("pass"));
            hooks.rp.setTxtConfirmPassword(row.get("confPass"));
            hooks.rp.selectSubcribe();
        }
    }

    @When("Select privacy check Box")
    public void select_privacy_check_box() {
        hooks.rp.clickOnAgrree();
    }

    @When("Click on Continue Button")
    public void click_on_continue_button() {
        hooks.rp.clickOnContinue();
    }

    @When("User click on Edit Account")
    public void user_click_on_edit_account() {
        hooks.mp.clickOnEditAccount();
    }

    @When("User edit lastname")
    public void user_edit_lastname() {
        hooks.ed.editLastName("Ooriiu");
    }

    @Then("Page Title should be displayed {string}")
    public void page_title_should_be_displayed(String expected) {
        String actPageeTitle = hooks.ed.getSuccesssMessage();

        if (actPageeTitle.equals(expected))
        {
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }
    }

    @When("User edit Telephone")
    public void user_edit_telephone() throws InterruptedException {
        Thread.sleep(4000);
        hooks.ed.editTelephone("8918675709");
    }

}
