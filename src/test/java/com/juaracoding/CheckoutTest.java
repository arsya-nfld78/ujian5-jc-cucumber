package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.CheckoutPage;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.ProductToCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class CheckoutTest {

    private  WebDriver driver;
    private ProductToCartPage productToCartPage;
    private CheckoutPage checkoutPage;
    private LoginPage loginPage;

    public CheckoutTest(){
        driver = Hooks.driver;
    }

    //TCC 0006
    @Given("I proceeds to checkout")
    public void i_proceeds_to_checkout(){
        DriverSingleton.delay(3);
        productToCartPage = new ProductToCartPage();
        checkoutPage = new CheckoutPage();

        productToCartPage.setBtnCheckout();
    }

    @When("I enters users information")
    public void i_enters_users_information(){
        DriverSingleton.delay(3);
        checkoutPage.userInfo("jane","doe","1234");
    }

    @And("I click continue")
    public void i_click_continue(){
        DriverSingleton.delay(3);
        checkoutPage.setBtnContinue();
    }

    @Then("I should be redirected to the overview page and click finish")
    public void i_should_be_redirected_to_the_overview_page_and_click_finish(){
        DriverSingleton.delay(3);
        checkoutPage.setBtnFinish();
    }

    @And("I should see a message THANK YOU FOR YOUR ORDER")
    public void i_should_see_a_message_thank_you_for_your_order(){
        DriverSingleton.delay(3);
        Assert.assertEquals(checkoutPage.getTxtCheckoutComplete(),"Thank you for your order!");
        productToCartPage.logout();
    }


}
