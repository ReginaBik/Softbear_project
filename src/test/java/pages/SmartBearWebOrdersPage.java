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

    @FindBy (id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processButton;

    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement familyAlbumProduct;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantityInputBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    public WebElement customerNameInputBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement StreetInputBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement cityInputBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement StateInputBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zipInputBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
    public WebElement visaRadioButton;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNrInputBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement expireDateInputBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processBox;

    @FindBy(linkText = "View all orders")
    public WebElement viewAllOrdersMenuItem;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr[2]//td")
    public List<WebElement> myOrderFirstRow;

    @FindBy(id = "ctl00_MainContent_btnDelete")
    public WebElement deleteButton;

    @FindBy(id = "ctl00_MainContent_orderMessage")
    public WebElement emptyMessage;




}
