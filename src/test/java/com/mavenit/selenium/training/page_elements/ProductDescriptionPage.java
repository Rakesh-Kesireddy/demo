package com.mavenit.selenium.training.page_elements;

import com.mavenit.selenium.training.Hooks;
import org.openqa.selenium.By;

public class ProductDescriptionPage extends Hooks {

    public void addProductToBasket() {
        driver.findElement(By.cssSelector("#product-actions .channels .space-b")).click();
    }

}
