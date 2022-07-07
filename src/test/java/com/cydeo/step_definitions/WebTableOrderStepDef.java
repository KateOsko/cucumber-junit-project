package com.cydeo.step_definitions;

import com.cydeo.pages.AllOrdersPage;
import com.cydeo.pages.BasePage;
import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.pages.WebTableOrderPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class WebTableOrderStepDef {

    WebTableLoginPage webTableLoginPage = new WebTableLoginPage();
    BasePage basePage = new BasePage();
    WebTableOrderPage webTableOrderPage = new WebTableOrderPage();

    AllOrdersPage allOrdersPage =new AllOrdersPage();

    @Given("user is already logged in and on order page")
    public void user_is_already_logged_in_and_on_order_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("web.app.url"));
        webTableLoginPage.login("Test","Tester");
        basePage.orderBtn.click();
    }
    @When("user selects product type {string}")
    public void user_selects_product_type(String productType) {
        Select select = new Select(webTableOrderPage.product);
        select.selectByVisibleText(productType);

    }
    @When("user enters quantity {int}")
    public void user_enters_quantity(int quantity) {
        // webTableOrderPage.quantity.sendKeys(String.valueOf(quantity));
        webTableOrderPage.quantity.clear();
        webTableOrderPage.quantity.sendKeys(quantity+"");


    }
    @When("user enters customer name {string}")
    public void user_enters_customer_name(String customerName) {
        webTableOrderPage.customerName.sendKeys(customerName);
    }
    @When("user enters street {string}")
    public void user_enters_street(String street) {
        webTableOrderPage.street.sendKeys(street);
    }
    @When("user enters city {string}")
    public void user_enters_city(String string) {
        webTableOrderPage.city.sendKeys(string);
    }
    @When("user enters state {string}")
    public void user_enters_state(String string) {
        webTableOrderPage.state.sendKeys(string);
    }
    @When("user enters zipcode {string}")
    public void user_enters_zipcode(String string) {
        webTableOrderPage.zipCode.sendKeys(string);
    }
    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String expectedCardType) {

        List<WebElement> cardTypes = webTableOrderPage.creditCardType;

        for (WebElement each : cardTypes) {
            if(each.getAttribute("value").equalsIgnoreCase(expectedCardType)){
                each.click();
            }

        }


    }
    @When("user enters credit card number {string}")
    public void user_enters_credit_card_number(String string) {
        webTableOrderPage.creditCardNumber.sendKeys(string);

    }
    @When("user enters expiry date {string}")
    public void user_enters_expiry_date(String string) {
        webTableOrderPage.expiryDate.sendKeys(string);

    }
    @When("user enters process order button")
    public void user_enters_process_order_button() {
        webTableOrderPage.processOrderBtn.click();
    }
    @Then("user should see {string} in first row of the web table")
    public void user_should_see_in_first_row_of_the_web_table(String expectedName) {

        String actualName = allOrdersPage.firstRowname.getText();
        Assert.assertEquals(expectedName,actualName);
    }
}