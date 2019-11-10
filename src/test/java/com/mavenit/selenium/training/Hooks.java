package com.mavenit.selenium.training;

import com.mavenit.selenium.training.driver.DriverManager;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    private DriverManager driverManager=new DriverManager();


    @Before
    public void setUp() {
      driverManager.openBrowser();
    }

    @After
    public void tearDown() {
        driverManager.closeBrowser();
    }



}
