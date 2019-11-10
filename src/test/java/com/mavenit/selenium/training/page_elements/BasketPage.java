package com.mavenit.selenium.training.page_elements;

import com.mavenit.selenium.training.Hooks;
import com.mavenit.selenium.training.driver.DriverManager;
import org.openqa.selenium.By;

public class BasketPage  extends DriverManager {

    public String getProuctsInBasket() {
        return driver.findElement(By.cssSelector("div.productTitle")).getText();
    }
}
