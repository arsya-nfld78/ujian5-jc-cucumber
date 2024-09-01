package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.ProductToCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestAddProduct {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductToCartPage productToCartPage;

    public TestAddProduct(){
        driver = Hooks.driver;
    }

    //TCC 0005
    @Given("I am logged in to the website")
    public void i_am_logged_in_to_the_website(){
        loginPage = new LoginPage();
        productToCartPage = new ProductToCartPage();

        //login website Sauce Demo
        DriverSingleton.delay(3);
        loginPage.login("standard_user","secret_sauce");
        loginPage.setBtnLogin();
    }

    @When("I add two products to the cart")
    public void i_add_two_products_to_the_cart(){
        DriverSingleton.delay(3);
        productToCartPage.addBothProducts();
    }

    @Then("the cart icon should display total product")
    public void the_cart_icon_should_display_total_product(){
        Assert.assertEquals(productToCartPage.getTxtCartBadge(),"2");
    }

    @And("I am on the cart page")
    public void i_am_on_the_cart_page(){
        DriverSingleton.delay(3);
        productToCartPage.setBtnCart();
        Assert.assertEquals(productToCartPage.getTxtCartTitle(),"Your Cart");
    }
    @And("the product should display in the cart")
    public void the_product_should_display_in_the_cart(){
        DriverSingleton.delay(3);
        Assert.assertEquals(productToCartPage.getTxtBikeLight(),"Sauce Labs Bike Light");
        Assert.assertEquals(productToCartPage.getTxtTShirt(),"Sauce Labs Bolt T-Shirt");
    }
}
