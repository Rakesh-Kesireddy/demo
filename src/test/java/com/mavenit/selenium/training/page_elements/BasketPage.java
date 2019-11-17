package com.mavenit.selenium.training.page_elements;

import com.mavenit.selenium.training.Hooks;
import com.mavenit.selenium.training.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage  extends DriverManager {

    @FindBy(css = "div.productTitle")
    private WebElement basketTitle;

    public String getProuctsInBasket() {
        return basketTitle.getText();
    }
}
