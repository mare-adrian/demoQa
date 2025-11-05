package org.skillbrain.page;

import org.openqa.selenium.WebDriver;

public class PageObjectFactory {

    private WebDriver driver;
    private HomePage homePage;
    private ElementsPage elementsPage;

//    dependency injection
    public PageObjectFactory(WebDriver driver) {
        this.driver = driver;
    }



    public HomePage getHomePage() {
        homePage = new HomePage(driver);
        return homePage;
    }
    public ElementsPage getElementsPage() {
        elementsPage = new ElementsPage(driver);
        return elementsPage;
    }
}
