package com.mavenit.selenium.training.page_elements;

import com.mavenit.selenium.training.Hooks;
import com.mavenit.selenium.training.driver.DriverManager;
import com.mavenit.selenium.training.utils.RandomNumberHelper;
import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.fail;

public class ResultsPage extends DriverManager {

    @FindBy(className = "pageTitle")
    private WebElement pageTitle;

    @FindBy(className = "current")
    private WebElement thumbNail;

    @FindBy(className = "productTitle")
    private List<WebElement> prdouctTitleWebelements;




    public String getPageTitle() {
        return pageTitle.getText();
    }

    public String getThumbNail() {
        return thumbNail.getText();
    }


    public String selectAnyProduct() {

        if (prdouctTitleWebelements.size() == 0) {
            //throw new RuntimeException("you have 0 product for search term: "+searchitem);
            TestCase.fail("you have 0 product for search term: " + HomePage.searchitem);
        }
        int productCount = prdouctTitleWebelements.size();
        int randomNumber = new RandomNumberHelper().generateRandomNumber(productCount);
        String prouctSelected = prdouctTitleWebelements.get(randomNumber).getText();
        prdouctTitleWebelements.get(randomNumber).click();

        return prouctSelected;
    }


    public void selectPrice(String priceRange) {
        int counter = 0;
        List<WebElement> filters = driver.findElements(By.cssSelector(".dc-filter__option-list li"));
        for (WebElement filter : filters) {
            if (filter.getText().equalsIgnoreCase(priceRange)) {
                counter++;
                filter.click();
                break;
            }
        }

        if (counter == 0) {
            fail("filter choice not available " + priceRange);
        }

        //Webdriver waits
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Double> getAllProductPrices() {
        List<Double> collectedPrices = new ArrayList<Double>();

        List<WebElement> priceWebelements = driver.findElements(By.cssSelector(".price"));
        for (WebElement priceWebelement : priceWebelements) {
            String priceInString = priceWebelement.getText().replace("£", "");
            Double priceInDouble = Double.parseDouble(priceInString);
            collectedPrices.add(priceInDouble);
        }

        if (collectedPrices.size() == 0) {
            fail("Nothing collected, may be product =0");
        }

        return collectedPrices;
    }
}
