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

public class CheckoutFailTest {

    private WebDriver driver;
    private ProductToCartPage productToCartPage;
    private CheckoutPage checkoutPage;
    private LoginPage loginPage;

    public CheckoutFailTest(){
        driver = Hooks.driver;
    }
    //TCC 0007

    @When("I click to the cart and proceeds to checkout")
    public void i_click_to_the_cart_and_proceeds_to_checkout(){
        productToCartPage = new ProductToCartPage();
        checkoutPage = new CheckoutPage();
        loginPage = new LoginPage();

        DriverSingleton.delay(1);
        productToCartPage.setBtnCart();
        productToCartPage.setBtnCheckout();
    }

    @And("I leaves the name field empty")
    public void i_leaves_the_name_field_empty(){
        DriverSingleton.delay(1);
        checkoutPage.userInfo("","","1234");
        checkoutPage.setBtnContinue();
    }
    @Then("an error message First Name is required should be displayed")
    public void an_error_message_first_name_is_required_should_be_displayed(){
        DriverSingleton.delay(3);
        Assert.assertEquals(checkoutPage.getTxtInvalid(),"Error: First Name is required");
    }
}
