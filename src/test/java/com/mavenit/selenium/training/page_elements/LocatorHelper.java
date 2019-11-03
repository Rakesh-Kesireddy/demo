package com.mavenit.selenium.training.page_elements;

import com.mavenit.selenium.training.Hooks;
import com.mavenit.selenium.training.utils.RandomNumberHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.fail;

public class LocatorHelper extends Hooks {

    private String searchitem;

    public void search(String item) {
        driver.findElement(By.id("search")).clear();
        driver.findElement(By.id("search")).clear();

        this.searchitem = item;
        enterSearchItem(item);
        clickSearch();
    }

    public void enterSearchItem(String item) {
        driver.findElement(By.id("search")).sendKeys(item);
    }

    public void clickSearch() {
        driver.findElement(By.cssSelector(".dc-search-fieldset__submit-button")).click();

    }


    public String getPageTitle() {
        return driver.findElement(By.className("pageTitle")).getText();
    }

    public String getThumbNail() {
        return driver.findElement(By.className("current")).getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String selectAnyProduct() {
        List<WebElement> productWebelements = driver.findElements(By.className("productTitle"));

        if (productWebelements.size() == 0) {
            //throw new RuntimeException("you have 0 product for search term: "+searchitem);
            fail("you have 0 product for search term: " + searchitem);
        }


        int productCount = productWebelements.size();
        int randomNumber = new RandomNumberHelper().generateRandomNumber(productCount);
        String prouctSelected = productWebelements.get(randomNumber).getText();
        productWebelements.get(randomNumber).click();

        return prouctSelected;
    }

    public void addProductToBasket() {
        driver.findElement(By.cssSelector("#product-actions .channels .space-b")).click();
    }

    public String getProuctsInBasket() {
        return driver.findElement(By.cssSelector("div.productTitle")).getText();
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

    public void selectDepartmentFromSuggestions(String item){
        selectFromSuggestions(item,By.cssSelector(".suggestion dc-search-suggestions__suggestion--term"));
    }

    public void selectProductsFromSuggestions(String item){
        selectFromSuggestions(item,By.cssSelector(".suggestion dc-search-suggestions__suggestion--sayt"));
    }

    public void selectFromSuggestions(String item, By by) {
        List<WebElement> suggestionsElemets = driver.findElements(by);
        int listSize = suggestionsElemets.size();
        if (listSize == 0) {
            fail("I dont have any suggestion for u" + item);
        }

        int randomIndex = new RandomNumberHelper().generateRandomNumber(listSize);
        WebElement selectedElement = suggestionsElemets.get(randomIndex);

        String selectedSuggestio = selectedElement.getText();
        selectedElement.click();
    }
}
