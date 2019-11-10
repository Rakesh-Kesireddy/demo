package com.mavenit.selenium.training;


import com.mavenit.selenium.training.page_elements.BasketPage;
import com.mavenit.selenium.training.page_elements.HomePage;
import com.mavenit.selenium.training.page_elements.ProductDescriptionPage;
import com.mavenit.selenium.training.page_elements.ResultsPage;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RegressionSuite  {

    private HomePage homePage = new HomePage();
    private ResultsPage resultsPage = new ResultsPage();
    private ProductDescriptionPage productDescriptionPage=new ProductDescriptionPage();
    private BasketPage basketPage=new BasketPage();

    @Test
    public void searchTest() {


        String searchTerm = "laptops";

        homePage.search(searchTerm);
        String actualTitle = resultsPage.getPageTitle();
        String actualThumNail = resultsPage.getThumbNail();
        String actualCurrentUrl = "";

        assertThat(actualTitle, is(equalToIgnoringCase(searchTerm)));
        assertThat(actualThumNail, is(equalToIgnoringCase(searchTerm)));
        assertThat(actualCurrentUrl, containsString(searchTerm));

    }

    @Test
    public void addProductToBasketTest() {
        homePage.search("cable");
        String expected = resultsPage.selectAnyProduct();
        productDescriptionPage.addProductToBasket();
        String actual = basketPage.getProuctsInBasket();
        assertThat(actual, is(equalToIgnoringCase(expected)));
    }

    @Test
    public void filterPrice() {

        //expted
        String priceRange = "£299.00 - £499.00";
        List<String> expectedList = Arrays.asList(priceRange.replace("£", "").split("-"));
        Double min = Double.parseDouble(expectedList.get(0));
        Double max = Double.parseDouble(expectedList.get(1));


        //actions
        homePage.search("laptop");
        resultsPage.selectPrice(priceRange);
        List<Double> actualPriceList = resultsPage.getAllProductPrices();

        //follow any below one appraoch
        // verify
        assertThat(actualPriceList,
                both(everyItem(is(greaterThanOrEqualTo(min)))).and(everyItem(is(lessThanOrEqualTo(max)))));

//        assertThat(actualPriceList,everyItem(is(greaterThanOrEqualTo(min))));
//        assertThat(actualPriceList,everyItem(is(lessThanOrEqualTo(max))));

    }


    @Test
    public void suggestedDepSearchTest() {
        String searchTerm = "cable";
        homePage.enterSearchItem(searchTerm);
        homePage.selectDepartmentFromSuggestions(searchTerm);

        String actual = resultsPage.getThumbNail();
        assertThat(actual, is(equalToIgnoringCase(searchTerm)));
    }

    @Test
    public void suggestedProductSearchTest() {
        String searchTerm = "cable";
        homePage.enterSearchItem(searchTerm);
        homePage.selectProductsFromSuggestions(searchTerm);

        String actual = resultsPage.getThumbNail();
        assertThat(actual, is(equalToIgnoringCase(searchTerm)));
    }

}
