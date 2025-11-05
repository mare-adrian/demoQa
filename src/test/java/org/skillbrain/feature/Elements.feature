@gui @login
Feature: DemoQa

  @qa
  Scenario: Fully automate demoQa Elements page
    Given User navigates to ElementsPage
    And I fill full name placeholder with "Mare Adrian"
    And I fill Email placeholder with "mareadrian@email.com"
    And I fill Current Address textarea with "Cluj Napoca"
    And I fill Permanent Address textarea with "Satu Mare"
    And I click Submit and verify outputs with name "Mare Adrian", email "mareadrian@email.com", current "Cluj Napoca", permanent "Satu Mare"
    Then I click checkbox button
    And I expand the folder, select React and Private, and verify that the displayed message is correct
    Then I open the Radio Button Page
    And I click the yes radio button
    And I check if the yes text appeared
    Then I click Web Tables page
    And I click add and register complete the form with following inputs: First name:"Adrian",Last name:"Mare",Email:"email@gmail.com",Age 22,Salary 5000,Department"IT"
    Then I click buttons Page
    And I click the buttons the right way and assert the text
    Then I click links page
    And I click on the home link and check if it redirected me to the correct page
    And I click not found button and check if the api is correct
    Then I go to upload and download page
    And I download and check if the file was download, then i upload a file and check if it was uploaded
    Then I click on dynamic properties
    And Verify that the first element becomes visible and the second element becomes enabled after 5 seconds
    Then wait for 5 second
