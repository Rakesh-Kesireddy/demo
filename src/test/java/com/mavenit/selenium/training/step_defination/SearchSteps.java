package com.mavenit.selenium.training.step_defination;

import com.mavenit.selenium.training.page_elements.HomePage;
import com.mavenit.selenium.training.page_elements.ResultsPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SearchSteps {

    private HomePage homePage = new HomePage();
    private ResultsPage resultsPage=new ResultsPage();

    @Given("^I am on homepages$")
    public void onHomePage() {
        String actual = homePage.getCurrentUrl();
        assertThat(actual, is(endsWith("/gbuk/index.html")));
    }


    @Then("^I should be able to see respective products$")
    public void releatedProducts() {
        String actualTitle = resultsPage.getPageTitle();
        String actualThumNail = resultsPage.getThumbNail();

        assertThat(actualTitle, is(equalToIgnoringCase(HomePage.searchitem)));
        assertThat(actualThumNail, is(equalToIgnoringCase(HomePage.searchitem)));

    }

    @When("^I search for a \"([^\"]*)\"$")
    public void iSearchForA(String searchItem){
        homePage.search(searchItem);

    }
}
