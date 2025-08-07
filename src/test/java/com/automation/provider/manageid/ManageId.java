package com.automation.provider.manageid;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import util.BaseUtil;
import util.CommonMethod;
import util.TestBase;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ManageId extends CommonMethod {

    static protected String methodNameValue;

    Logger logger = Logger.getLogger(ManageId.class);
    BaseUtil baseUtil = new BaseUtil();
    ManageId(){
        PageFactory.initElements(TestBase.getWebDriver(),this);
    }
    @FindBy(xpath = "//select[@class='form-control']")
    WebElement methodType;
    @FindBy(xpath = "//input[@id='methodName']")
    WebElement methodName;
    @FindBy(xpath = "//input[@id='paymentIcon']")
    WebElement paymentIcon;
    @FindBy(xpath = "(//input[@type='search' and @placeholder='Search'])[1]")
//    @FindBy(xpath = "//div[@id='payment-methods-tab-pane']//input[@type='search']")
    WebElement searchPayment;
    @FindBy(xpath = "//tbody/tr/td[3]")
    WebElement methodListName;
    @FindBy(xpath = "//p[contains(text(),'Method type field is required.')]")
    WebElement methodTypeErrorMess;
    @FindBy(xpath = "//p[contains(text(),'Method name field is required.')]")
    WebElement methodNameErrorMess;
    @FindBy(xpath = "//p[contains(text(),'Payment icon field is required.')]")
    WebElement paymentIconErrorMess;

    public void clickAndSelectMethod(String btn, String method) {
        clickOnButtons(btn);
        waitForVisibleElement(methodType);
        Select select = new Select(methodType);
        select.selectByVisibleText(method);
    }

    public void enterPaymentMethod(String value, String field){
        switch (field.toUpperCase()){
            case "METHOD NAME":
                waitForVisibleElement(methodName);
                methodNameValue = value + generateRandomString();
                methodName.sendKeys(methodNameValue);
                break;
            default:
                logger.info("Field not match :: "+field);
        }
    }

    public String generateRandomString(){
        return UUID.randomUUID().toString().substring(2).replaceAll("[^A-Za-z]","");
    }

    public void uploadPaymentIcon(String btn) {
//        clickOnButtons(btn);
        paymentIcon.sendKeys(System.getProperty("user.dir")+"/src/main/resources//QR_code_for_mobile_English_Wikipedia.svg.png");
//        uploadImage("C:/Users/chatu/Downloads/QR_code_for_mobile_English_Wikipedia.svg.png");
        explicitWait(5000);
    }

    public void verifyAddPaymentMethod(){
        explicitWait(2000);
        waitForVisibleElement(searchPayment);
        searchPayment.clear();
        searchPayment.sendKeys(methodNameValue);
        searchPayment.sendKeys(Keys.ENTER);
        explicitWait(1000);
        String expected = methodNameValue;
        String actual = methodListName.getText();
        Assert.assertEquals("Payment Method Added :: ",expected,actual);
    }

    public void verifyErrorMessage(List<Map<String,String> >list){
        for (Map<String, String> map: list){
            for (Map.Entry<String,String> entry : map.entrySet()){
                String fieldName = entry.getKey();
                String errorMess = entry.getValue();

                switch (fieldName.toUpperCase()){
                    case "METHOD TYPE":
                        Assert.assertEquals("Error message for method type as expected. Expected :: "
                                +errorMess + " Actual :: "+methodTypeErrorMess.getText(),
                                errorMess,methodTypeErrorMess.getText());
                        break;
                    case "METHOD NAME":
                        Assert.assertEquals("Error message for method name as expected. Expcted :: "
                            +errorMess + " Actual :: "+methodNameErrorMess.getText(),
                                errorMess , methodNameErrorMess.getText());
                        break;
                    case "PAYMENT ICON":
                        Assert.assertEquals("Error message for payment icon as expected. Expcted :: "
                                        +errorMess + " Actual :: "+paymentIconErrorMess.getText(),
                                errorMess , paymentIconErrorMess.getText());
                        break;
                    default:
                        logger.info("Not getting Error Message");
                }
            }
        }
    }

}
