package org.skillbrain.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage extends BasePage {

    private WebDriver driver;

    private static final String URL = "https://demoqa.com/text-box";

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    // %%%%%%%%%%%%%%%%%%%%%%%%%%% WEB ELEMENTS %%%%%%%%%%%%%%%%%%%%%%%%%
// ELEMENTS
    @FindBy(xpath = "//h5[normalize-space()='Elements']/ancestor::div[contains(@class,'top-card')]")
    private WebElement ElementsCard;

    //%%%%%%%%%%%%%%%%%%%%%%%%%%% FUNCTIONS %%%%%%%%%%%%%%%%%%%%%%%%%
    public void wait5Second() {
        try {
            Thread.sleep(5000);  // 5 secunde
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void navigateToHomePage() {
        driver.get(URL);
    }

    public void openElementsPage() {
        ElementsCard.click();
    }




}

