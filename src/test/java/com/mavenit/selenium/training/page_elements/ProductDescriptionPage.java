package com.mavenit.selenium.training.page_elements;

import com.mavenit.selenium.training.Hooks;
import com.mavenit.selenium.training.driver.DriverManager;
import org.openqa.selenium.By;

public class ProductDescriptionPage extends DriverManager {

    public void addProductToBasket() {
        driver.findElement(By.cssSelector("#product-actions .channels .space-b")).click();
    }

}
