package com.mavenit.selenium.training.page_elements;

import com.mavenit.selenium.training.Hooks;
import org.openqa.selenium.By;

public class BasketPage  extends Hooks {

    public String getProuctsInBasket() {
        return driver.findElement(By.cssSelector("div.productTitle")).getText();
    }
}
