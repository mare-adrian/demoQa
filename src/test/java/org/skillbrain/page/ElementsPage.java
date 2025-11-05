package org.skillbrain.page;

import org.bouncycastle.voms.VOMSAttribute;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v137.network.Network;
import org.openqa.selenium.devtools.v137.network.model.Response;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Optional;

public class ElementsPage extends BasePage {

    private static final String URLElements = "https://demoqa.com/text-box";
    private final WebDriver driver;
    @FindBy(css = "input[placeholder=\"Full Name\"]")
    private WebElement fullNamePlaceholder;

    // %%%%%%%%%%%%%%%%%%%%%%%%%%% WEB ELEMENTS %%%%%%%%%%%%%%%%%%%%%%%%%
    @FindBy(css = "input[type=\"email\"]")
    private WebElement emailPlaceholder;
    @FindBy(css = "textarea[placeholder=\"Current Address\"]")
    private WebElement currentAddressTextarea;
    @FindBy(css = "textarea[id=\"permanentAddress\"]")
    private WebElement permanentAddressTextarea;
    @FindBy(xpath = "//button[normalize-space()='Submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//div[@id='output']//p[@id='name']")
    private WebElement outputName;
    @FindBy(xpath = "//div[@id='output']//p[@id='email']")
    private WebElement outputEmail;
    @FindBy(xpath = "//div[@id='output']//p[@id='currentAddress']")
    private WebElement outputCurrentAddress;
    @FindBy(xpath = "//div[@id='output']//p[@id='permanentAddress']")
    private WebElement outputPermanentAddress;
    //CHECK BOX
    @FindBy(xpath = "//li//*[text()='Check Box']/ancestor::li")
    private WebElement checkBoxbutton;
    @FindBy(xpath = "(//button[@class='rct-collapse rct-collapse-btn'])[1]")
    private WebElement firstCollapseButtonFolder;
    @FindBy(xpath = "//span[text()='React']/ancestor::label/span[@class='rct-checkbox']")
    private WebElement reactCheckBox;
    @FindBy(xpath = "//span[text()='Private']/ancestor::label/span[@class='rct-checkbox']")
    private WebElement privateCheckBox;
    @FindBy(xpath = "//span[text()='react']")
    private WebElement reactText;
    @FindBy(xpath = "//span[text()='private']")
    private WebElement privateText;
    @FindBy(xpath = "(//button[@class='rct-collapse rct-collapse-btn'])[3]")
    private WebElement collapseButton3;
    @FindBy(xpath = "(//button[@class='rct-collapse rct-collapse-btn'])[4]")
    private WebElement collapseButton4;
    @FindBy(xpath = "(//button[@class='rct-collapse rct-collapse-btn'])[5]")
    private WebElement collapseButton5;
    //RADIO BUTTON
    @FindBy(xpath = "//li//*[text()='Radio Button']/ancestor::li")
    private WebElement radioButtonPage;
    @FindBy(css = "label[for='yesRadio']")
    private WebElement yesRadioLabel;
    @FindBy(css = "span[class=\"text-success\"]")
    private WebElement succesText;
    //Web Tables
    @FindBy(xpath = "//li//*[text()='Web Tables']/ancestor::li")
    private WebElement webTablesPage;
    @FindBy(css = "button[id=\"addNewRecordButton\"]")
    private WebElement addButton;
    @FindBy(css = "input[placeholder=\"First Name\"]")
    private WebElement firstnameField;
    @FindBy(css = "input[placeholder=\"Last Name\"]")
    private WebElement lastNameField;
    @FindBy(css = "input[placeholder=\"name@example.com\"]")
    private WebElement emailField;
    @FindBy(css = "input[placeholder=\"Age\"]")
    private WebElement ageField;
    @FindBy(css = "input[placeholder=\"Salary\"]")
    private WebElement salaryField;
    @FindBy(css = "input[id=\"department\"]")
    private WebElement departmentField;
    @FindBy(css = "button[id=\"submit\"]")
    private WebElement submitButtonWebTables;
    //Buttons
    @FindBy(xpath = "//li//*[text()='Buttons']/ancestor::li")
    private WebElement buttonsPage;
    @FindBy(css = "button[id=\"doubleClickBtn\"]")
    private WebElement doubleClickButton;
    @FindBy(css = "button[id=\"rightClickBtn\"]")
    private WebElement rightClickButton;
    @FindBy(id = "dynamicClickMessage")
    private WebElement dynamicClickMessage;
    @FindBy(css = "p[id=\"doubleClickMessage\"]")
    private WebElement doubleClickMessage;
    @FindBy(css = "p[id=\"rightClickMessage\"]")
    private WebElement rightClickMessage;
    @FindBy(xpath = "//button[normalize-space()='Click Me']")
    private WebElement clickMeButton;
    //Links
    @FindBy(xpath = "//li//*[text()='Links']/ancestor::li")
    private WebElement linksPage;
    @FindBy(css = "a[id=\"simpleLink\"]")
    private WebElement homeLimk;
    @FindBy(css = "a[id=\"invalid-url\"]")
    private WebElement notFoundButton;
    public ElementsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    //broken limks - imagines


    //upload and download
    @FindBy(xpath = "//li//*[text()='Upload and Download']/ancestor::li")
    private WebElement uploadanddownloadPage;
    @FindBy(css="a[id=\"downloadButton\"]")
    private WebElement downloadButton;
    @FindBy(css="input[id=\"uploadFile\"]")
    private WebElement uploadFileButton;
    @FindBy(css="p[id=\"uploadedFilePath\"]")
    private WebElement uploadMessage;
    //dynamic properties
    @FindBy(xpath = "//li//*[text()='Dynamic Properties']/ancestor::li")
    private WebElement dynamicProperties;
    @FindBy(css="button[id=\"visibleAfter\"]")
    private WebElement visibleAfter5sec;
    @FindBy(css="button[id=\"enableAfter\"]")
    private WebElement enableAfter;

    //%%%%%%%%%%%%%%%%%%%%%%%%%%% FUNCTIONS %%%%%%%%%%%%%%%%%%%%%%%%%
    public void assertSomethingDownloaded() {
        String downloadDir = "C:\\Users\\User\\Downloads";

        File folder = new File(downloadDir);
        int filesBefore = folder.listFiles().length;

        // aici apeși tu pe butonul de download
        downloadButton.click();

        // Wait până apare un fișier nou
        int timeout = 10;
        int elapsed = 0;

        while (elapsed < timeout) {
            int filesAfter = folder.listFiles().length;
            if (filesAfter > filesBefore) {
                Assert.assertTrue(true, "✅");
                return;
            }
            try { Thread.sleep(500); } catch (Exception ignored) {}
            elapsed++;
        }

        Assert.fail("❌ ");
    }


    public void wait5Second() {
        try {
            Thread.sleep(2500);  // 5 secunde
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //for trimming after :
    private String extractValue(WebElement element) {
        String text = element.getText();
        if (text == null) text = "";
        int idx = text.indexOf(':');
        return (idx >= 0) ? text.substring(idx + 1).trim() : text.trim();
    }

    public void navigateToElementsPage() {
        driver.get(URLElements);
    }


    public void fillFullName(String name) {
        fullNamePlaceholder.sendKeys(name);
    }


    public void fillEmail(String email) {
        emailPlaceholder.sendKeys(email);
    }

    public void fillCurrectAddressTextarea(String address) {
        currentAddressTextarea.sendKeys(address);
    }

    public void fillPermanentAddressTextarea(String address) {
        permanentAddressTextarea.sendKeys(address);
    }

    public void submitAndCheckTheOutput(String name, String email, String currentAddress, String permanentAddress) {

        submitButton.click();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(outputEmail));

        Assert.assertEquals(extractValue(outputName), name, "Name output mismatch!");
        Assert.assertEquals(extractValue(outputEmail), email, "Email output mismatch!");
        Assert.assertEquals(extractValue(outputCurrentAddress), currentAddress, "Current address mismatch!");
        Assert.assertEquals(extractValue(outputPermanentAddress), permanentAddress, "Permanent address mismatch!");
    }

    public void clickcheckbox() {
        checkBoxbutton.click();
    }

    public void SelectFoldersAndCheck() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(firstCollapseButtonFolder)).click();

        wait.until(ExpectedConditions.elementToBeClickable(collapseButton3)).click();

        wait.until(ExpectedConditions.elementToBeClickable(collapseButton4)).click();

        wait.until(ExpectedConditions.elementToBeClickable(collapseButton5)).click();

        wait.until(ExpectedConditions.elementToBeClickable(privateCheckBox)).click();

        wait.until(ExpectedConditions.elementToBeClickable(reactCheckBox)).click();

        wait.until(ExpectedConditions.visibilityOf(reactText));
        Assert.assertTrue(reactText.isDisplayed(), "React text NOT displayed!");

        wait.until(ExpectedConditions.visibilityOf(privateText));
        Assert.assertTrue(privateText.isDisplayed(), "Private text NOT displayed!");
    }

    public void clickRadioButtonPage() {
        radioButtonPage.click();
    }

    public void clickYesRadioButton() {
        yesRadioLabel.click();
    }

    public void verifyIfYesTextAppeared() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(succesText));
        Assert.assertTrue(succesText.isDisplayed(), "not good");
    }

    public void webTablesPageClick() {
        webTablesPage.click();
    }

    public void AddToTable(String firstName, String lastName, String email, int age, int salary, String department) {
        addButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(ageField));
        firstnameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        ageField.sendKeys(String.valueOf(age));
        salaryField.sendKeys(String.valueOf(salary));
        departmentField.sendKeys(department);
        submitButtonWebTables.click();
    }

    public void gotoButtonsPage() {
        buttonsPage.click();
    }

    public void buttonsPageFill() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);


        wait.until(ExpectedConditions.elementToBeClickable(doubleClickButton));
        actions.doubleClick(doubleClickButton).perform();

        wait.until(ExpectedConditions.elementToBeClickable(rightClickButton));
        actions.contextClick(rightClickButton).perform();

        wait.until(ExpectedConditions.elementToBeClickable(clickMeButton)).click();


        wait.until(ExpectedConditions.visibilityOf(doubleClickMessage));
        Assert.assertEquals(doubleClickMessage.getText().trim(), "You have done a double click", "Double click message incorrect!");

        wait.until(ExpectedConditions.visibilityOf(rightClickMessage));
        Assert.assertEquals(rightClickMessage.getText().trim(), "You have done a right click", "Right click message incorrect!");

        wait.until(ExpectedConditions.visibilityOf(dynamicClickMessage)); // (ai variabila scrisă 'simeple...')
        Assert.assertEquals(dynamicClickMessage.getText().trim(), "You have done a dynamic click", "Dynamic click message incorrect!");
    }

    public void linksPage() {
        linksPage.click();
    }

    public void homeLinkCheck() {
        homeLimk.click();
        String mainWindow = driver.getWindowHandle();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> driver.getWindowHandles().size() > 1);


        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        String expectedUrl = "https://demoqa.com/";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "URL-ul nu este corect!");

        driver.close();

        driver.switchTo().window(mainWindow);
    }

    public void notFoundApiCheck() {
        notFoundButton.click();
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        devTools.addListener(Network.responseReceived(), response -> {
            Response res = response.getResponse();
            String url = res.getUrl();
            int status = res.getStatus();

            if (url.contains("invalid-url")) {
                System.out.println("API FOUND: " + url + " | STATUS = " + status);
                Assert.assertEquals(status, 404,
                        "Expected 404 for invalid URL, but found: " + status);
            }
        });
    }

    public void gotouploadPage()
    {
        uploadanddownloadPage.click();
    }

    public void downloadandupload()
    {
        downloadButton.click();
        assertSomethingDownloaded();
        String fullPath = Paths.get("src/test/resources/photo.jpg")
                .toAbsolutePath()
                .toString();

        uploadFileButton.sendKeys(fullPath);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(uploadMessage));

        Assert.assertTrue(uploadMessage.isDisplayed(),
                "❌");
    }
    public void gotoDynamicPage()
    {
        dynamicProperties.click();
    }
    public void checkbuttons()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        wait.until(ExpectedConditions.visibilityOf(visibleAfter5sec));
        Assert.assertTrue(visibleAfter5sec.isDisplayed(),
                "1❌");


        wait.until(ExpectedConditions.elementToBeClickable(enableAfter));
        Assert.assertTrue(enableAfter.isEnabled(),
                "2❌!");
    }
}

