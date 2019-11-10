package com.mavenit.selenium.training.page_elements;

import com.mavenit.selenium.training.Hooks;
import com.mavenit.selenium.training.driver.DriverManager;
import com.mavenit.selenium.training.utils.RandomNumberHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static junit.framework.TestCase.fail;

public class HomePage extends DriverManager {

    public static String searchitem;

    public void search(String item) {
        driver.findElement(By.id("search")).clear();
        driver.findElement(By.id("search")).clear();

        searchitem = item;
        enterSearchItem(item);
        clickSearch();
    }

    public void enterSearchItem(String item) {
        driver.findElement(By.id("search")).sendKeys(item);
    }

    private void clickSearch() {
        driver.findElement(By.cssSelector(".dc-search-fieldset__submit-button")).click();

    }

    public void selectDepartmentFromSuggestions(String item) {
        selectFromSuggestions(item, By.cssSelector(".suggestion dc-search-suggestions__suggestion--term"));
    }

    public void selectProductsFromSuggestions(String item) {
        selectFromSuggestions(item, By.cssSelector(".suggestion dc-search-suggestions__suggestion--sayt"));
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
