package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.SmartBearLoginPage;
import pages.SmartBearWebOrdersPage;
import utils.Driver;
import utils.Waiter;

public class SmartBearSteps {

    WebDriver driver;
    SmartBearLoginPage smartBearLoginPage;
    SmartBearWebOrdersPage smartBearWebOrdersPage;

    @Before
    public void setup() {
        driver = Driver.getDriver();
        smartBearLoginPage = new SmartBearLoginPage();
        smartBearWebOrdersPage = new SmartBearWebOrdersPage();
    }

    @When("user enters username as {string}")
    public void userEntersUsernameAs(String username) {
        smartBearLoginPage.usernameInputBox.sendKeys(username);
    }

    @And("user enters password as {string}")
    public void userEntersPasswordAs(String password) {
        smartBearLoginPage.passwordInputBox.sendKeys(password);
    }

    @And("user clicks on Login button")
    public void userClicksOnLoginButton() {
        Assert.assertTrue(smartBearLoginPage.loginButton.isDisplayed());
        Assert.assertTrue(smartBearLoginPage.loginButton.isEnabled());
        smartBearLoginPage.loginButton.click();
        Waiter.pause(2);
    }

    @Then("user should see {string} Message")
    public void userShouldSeeMessage(String message) {
        Assert.assertTrue(smartBearLoginPage.invalidCredentialsMessage.isDisplayed());
        Assert.assertEquals(message, smartBearLoginPage.invalidCredentialsMessage.getText());
    }

    @Then("user should be routed to {string}")
    public void userShouldBeRoutedTo(String newUrl) {
        Assert.assertEquals(newUrl, driver.getCurrentUrl());
    }

    @And("validate below menu items are displayed")
    public void validateBelowMenuItemsAreDisplayed(DataTable dataTable) {
        for (int i = 0; i < dataTable.asList().size(); i++) {
            Assert.assertEquals(dataTable.asList().get(i), smartBearWebOrdersPage.menuItems.get(i).getText());
        }

    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String buttonText) {
        switch (buttonText) {

            case "Check All":
                Assert.assertTrue(smartBearWebOrdersPage.checkAllButton.isDisplayed());
                Assert.assertTrue(smartBearWebOrdersPage.checkAllButton.isEnabled());
                Assert.assertEquals(buttonText, smartBearWebOrdersPage.checkAllButton.getText());
                smartBearWebOrdersPage.checkAllButton.click();
                Waiter.pause(2);
                break;

            case "Uncheck All":
                Assert.assertTrue(smartBearWebOrdersPage.uncheckAllBoxes.isDisplayed());
                Assert.assertTrue(smartBearWebOrdersPage.uncheckAllBoxes.isEnabled());
                Assert.assertEquals(buttonText, smartBearWebOrdersPage.uncheckAllBoxes.getText());
                smartBearWebOrdersPage.uncheckAllBoxes.click();
                Waiter.pause(2);
                break;

            case "Process":
                Assert.assertTrue(smartBearWebOrdersPage.processButton.isDisplayed());
                Assert.assertTrue(smartBearWebOrdersPage.processButton.isEnabled());
                Assert.assertEquals(buttonText, smartBearWebOrdersPage.processButton.getText());
                smartBearWebOrdersPage.processButton.click();
                break;

            default:
                throw new NotFoundException("The button text is not defined properly in the feature file!!!");
        }

    }


    @Then("all rows should be checked")
    public void allRowsShouldBeChecked() {
        for (WebElement element : smartBearWebOrdersPage.checkedRows) {
            Assert.assertFalse(element.isSelected());
        }
    }

    @Then("all rows should be unchecked")
    public void allRowsShouldBeUnchecked() {
        for (WebElement element : smartBearWebOrdersPage.checkedRows) {
            Assert.assertNull(element.getAttribute("checked"));
        }
    }


    @When("user clicks on {string} menu item")
    public void userClicksOnMenuItem(String arg0) {
    }

    @And("user selects {string} as product")
    public void userSelectsAsProduct(String arg0) {
    }

    @And("user enters {int} as quantity")
    public void userEntersAsQuantity(int arg0) {
    }

    @And("user enters all address information")
    public void userEntersAllAddressInformation() {
    }

    @And("user enters all payment information")
    public void userEntersAllPaymentInformation() {
    }

    @Then("user should see their order displayed in the {string} table")
    public void userShouldSeeTheirOrderDisplayedInTheTable(String arg0) {
    }

    @And("validate all information entered displayed correct with the order")
    public void validateAllInformationEnteredDisplayedCorrectWithTheOrder() {
    }
}
