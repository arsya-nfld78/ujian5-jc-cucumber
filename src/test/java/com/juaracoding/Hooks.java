package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.utils.Constans;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setUp(){
        DriverSingleton.getInstance(Constans.CHROME);
        driver = DriverSingleton.getDriver();
    }

    @AfterAll
    public static void finish(){
        DriverSingleton.delay(4);
        DriverSingleton.closeObjectInstance();
    }
}
