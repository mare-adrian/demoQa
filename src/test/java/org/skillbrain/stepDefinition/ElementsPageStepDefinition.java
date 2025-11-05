package org.skillbrain.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.pdfbox.pdmodel.interactive.viewerpreferences.PDViewerPreferences;
import org.skillbrain.page.ElementsPage;
import org.skillbrain.page.HomePage;
import org.skillbrain.utilities.TestContextSetup;

public class ElementsPageStepDefinition {

    private final TestContextSetup testContextSetup;
    private HomePage homePage;
    private final ElementsPage elementsPage;

    public ElementsPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        elementsPage = testContextSetup.pageObjectFactory.getElementsPage();
    }


    @And("I fill full name placeholder with {string}")
    public void iFillFullNamePlaceholderWith(String name) {
        elementsPage.fillFullName(name);
    }

    @Given("User navigates to ElementsPage")
    public void userNavigatesToElementsPage() {
        elementsPage.navigateToElementsPage();
    }

    @And("I fill Email placeholder with {string}")
    public void iFillEmailPlaceholderWith(String email) {
        elementsPage.fillEmail(email);
    }

    @And("I fill Current Address textarea with {string}")
    public void iFillCurrentAddressTextareaWith(String address) {
        elementsPage.fillCurrectAddressTextarea(address);
    }

    @And("I fill Permanent Address textarea with {string}")
    public void iFillPermanentAddressTextareaWith(String address) {
        elementsPage.fillPermanentAddressTextarea(address);
    }


    @And("I click Submit and verify outputs with name {string}, email {string}, current {string}, permanent {string}")
    public void iClickSubmitAndVerifyOutputsWithNameEmailCurrentPermanent(String name, String email, String currentAddress, String permanentAddress) {
        elementsPage.submitAndCheckTheOutput(name,email,currentAddress,permanentAddress);
    }

    @Then("I click checkbox button")
    public void iClickCheckboxButton() {
       elementsPage.clickcheckbox();
    }

    @And("I expand the folder, select React and Private, and verify that the displayed message is correct")
    public void iExpandTheFolderSelectReactAndPrivateAndVerifyThatTheDisplayedMessageIsCorrect() {
        elementsPage.SelectFoldersAndCheck();
    }

    @Then("I open the Radio Button Page")
    public void iOpenTheRadioButtonPage() {
        elementsPage.clickRadioButtonPage();
    }

    @And("I click the yes radio button")
    public void iClickTheYesRadioButton() {
        elementsPage.clickYesRadioButton();
    }

    @And("I check if the yes text appeared")
    public void iCheckIfTheYesTextAppeared() {
        elementsPage.verifyIfYesTextAppeared();
    }

    @Then("I click Web Tables page")
    public void iClickWebTablesPage() {
        elementsPage.webTablesPageClick();
    }

    @Then("I click add and register complete the form with following inputs: First name:{string},Last name:{string},Email:{string},Age {int},Salary {int},Department{string}")
    public void iClickAddAndRegisterCompleteTheFormWithFollowingInputsFirstNameLastNameEmailAgeSalaryDepartment(String firstname, String lastname, String email, int age, int salary, String department) {
        elementsPage.AddToTable(firstname,lastname,email,age,salary,department);
    }

    @Then("I click buttons Page")
    public void iClickButtonsPage() {
        elementsPage.gotoButtonsPage();
    }

    @Then("I click the buttons the right way and assert the text")
    public void iClickTheButtonsTheRightWayAndAssertTheText() {
        elementsPage.buttonsPageFill();
    }

    @Then("I click links page")
    public void iClickLinksPage() {
        elementsPage.linksPage();
    }

    @And("I click on the home link and check if it redirected me to the correct page")
    public void iClickOnTheHomeLinkAndCheckIfItRedirectedMeToTheCorrectPage() {
        elementsPage.homeLinkCheck();
    }

    @And("I click not found button and check if the api is correct")
    public void iClickNotFoundButtonAndCheckIfTheApiIsCorrect() {
        elementsPage.notFoundApiCheck();
    }

    @Then("I go to upload and download page")
    public void iGoToUploadAndDownloadPage() {
        elementsPage.gotouploadPage();
    }

    @And("I download and check if the file was download, then i upload a file and check if it was uploaded")
    public void iDownloadAndCheckIfTheFileWasDownloadThenIUploadAFileAndCheckIfItWasUploaded() {
        elementsPage.downloadandupload();
    }

    @Then("I click on dynamic properties")
    public void iClickOnDynamicProperties() {
        elementsPage.gotoDynamicPage();
    }

    @And("Verify that the first element becomes visible and the second element becomes enabled after 5 seconds")
    public void verifyThatTheFirstElementBecomesVisibleAndTheSecondElementBecomesEnabledAfterSeconds() {
        elementsPage.checkbuttons();
    }
}
