package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class SmartBearWebOrdersPage {
    public SmartBearWebOrdersPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#ctl00_menu>li>a")
    public List<WebElement> menuItems;

    @FindBy(id = "ctl00_MainContent_btnCheckAll")
    public WebElement checkAllButton;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr//td[1]")
    public List<WebElement> checkedRows;

    @FindBy(id = "ctl00_MainContent_btnUncheckAll")
    public WebElement uncheckAllBoxes;







}
