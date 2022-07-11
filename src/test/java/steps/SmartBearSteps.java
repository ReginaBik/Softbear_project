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
import utils.DropdownHandler;
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
    public void userClicksOnMenuItem(String menuItem) {
        switch (menuItem) {
            case "Order":
                for (int i = 0; i < smartBearWebOrdersPage.menuItems.size(); i++) {
                    smartBearWebOrdersPage.menuItems.get(i).click();
                }case "View all orders":
                    smartBearWebOrdersPage.viewAllOrdersMenuItem.click();
        }

    }

    @And("user selects {string} as product")
    public void userSelectsAsProduct(String product) {
        Waiter.pause(3);
        DropdownHandler.selectOptionByValue(smartBearWebOrdersPage.familyAlbumProduct, product);

    }

    @And("user enters {int} as quantity")
    public void userEntersAsQuantity(int quantity) {
        smartBearWebOrdersPage.quantityInputBox.sendKeys(String.valueOf(quantity));
    }

    @And("user enters all address information")
    public void userEntersAllAddressInformation() {
        smartBearWebOrdersPage.customerNameInputBox.sendKeys("Regina");
        smartBearWebOrdersPage.StreetInputBox.sendKeys("4848 Lawrence Ave");
        smartBearWebOrdersPage.cityInputBox.sendKeys("Chicago");
        smartBearWebOrdersPage.StateInputBox.sendKeys("IL");
        smartBearWebOrdersPage.zipInputBox.sendKeys("60625");
    }

    @And("user enters all payment information")
    public void userEntersAllPaymentInformation() {
        smartBearWebOrdersPage.visaRadioButton.click();
        smartBearWebOrdersPage.cardNrInputBox.sendKeys("1234554321");
        smartBearWebOrdersPage.expireDateInputBox.sendKeys("04/26");
        smartBearWebOrdersPage.processBox.click();
    }

    @Then("user should see their order displayed in the {string} table")
    public void userShouldSeeTheirOrderDisplayedInTheTable(String orderList) {
            for (int i = 1; i < smartBearWebOrdersPage.myOrderFirstRow.size()-1; i++) {
                Assert.assertTrue(smartBearWebOrdersPage.myOrderFirstRow.get(i).isDisplayed());
            }
    }

    @And("validate all information entered displayed correct with the order")
    public void validate_all_information_entered_displayed_correct_with_the_order(DataTable dataTable) {
        for (int i = 1; i <12; i++) {
            Assert.assertEquals(dataTable.asList().get(i), smartBearWebOrdersPage.myOrderFirstRow.get(i).getText());
        }
    }

    @Then("validate all orders are deleted from the {string}")
    public void validateAllOrdersAreDeletedFromThe(String arg0) {
    }

    @And("validate user sees {string} Message")
    public void validateUserSeesMessage(String arg0) {
    }
}
