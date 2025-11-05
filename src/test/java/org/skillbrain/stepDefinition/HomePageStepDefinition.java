package org.skillbrain.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.skillbrain.page.HomePage;
import org.skillbrain.utilities.TestContextSetup;

public class HomePageStepDefinition {

    private TestContextSetup testContextSetup;
    private HomePage homePage;

    public HomePageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        homePage = testContextSetup.pageObjectFactory.getHomePage();
    }


    @Given("User navigates to main page")
    public void userNavigatesToMainPage() {
        homePage.navigateToHomePage();
    }

    @And("wait for 5 second")
    public void waitForSecond() {
        homePage.wait5Second();
    }

    @And("I open Elements page")
    public void iOpenElementsPage() {
        homePage.openElementsPage();
    }

}
