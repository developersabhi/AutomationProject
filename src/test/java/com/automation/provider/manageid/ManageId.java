package com.automation.provider.manageid;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import util.BaseUtil;
import util.CommonMethod;
import util.TestBase;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

public class ManageId extends CommonMethod {

    static protected String methodNameValue, bankNameFieldValue;

    Map<String,String> uiValidationProp ;


    static  Logger logger = Logger.getLogger(ManageId.class);
    BaseUtil baseUtil = new BaseUtil();
    ManageId(){
        PageFactory.initElements(TestBase.getWebDriver(),this);
        init();
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
    @FindBy(xpath = "(//tbody/tr/td)[3]")
    WebElement methodListName;
    @FindBy(xpath = "//p[contains(text(),'Method type field is required.')]")
    WebElement methodTypeErrorMess;
    @FindBy(xpath = "//p[contains(text(),'Method name field is required.')]")
    WebElement methodNameErrorMess;
    @FindBy(xpath = "//p[contains(text(),'Payment icon field is required.')]")
    WebElement paymentIconErrorMess;

    @FindBy(xpath = "//div[contains(text(),'Payment method inserted successfully.')]")
    WebElement addValidationMess;
    @FindBy(xpath = "//div[contains(text(),'Payment method updated successfully.')]")
    WebElement updateValidationMess;
    @FindBy(xpath = "//p[contains(text(),'The name has already been taken.')]")
    WebElement methodNameAlready;

    @FindBy(xpath = "//div[contains(text(),'Payment method status is active updated successfully.')]")
    WebElement paymentStatusActiveToster;
    @FindBy(xpath = "//div[contains(text(),'Payment method status is inactive updated successfully.')]")
    WebElement paymentStatusDeactiveToster;

    @FindBy(xpath = "//p[contains(text(),'Bank name field is required.')]")
    WebElement bankNameErrorMessage;
    @FindBy(xpath = "//p[contains(text(),'Please select bank country name.')]")
    WebElement countryErrorMessage;
    @FindBy(xpath = "//div[contains(text(),'Bank icon is required')]")
    WebElement bankIconErrorMessage;
    @FindBy(xpath = "//input[@placeholder='Enter Bank Name']")
    WebElement bankNameField;
    @FindBy(xpath = "//select[@name='country']")
    WebElement selectCountry;
    @FindBy(xpath = "//input[@id='icon']")
    WebElement bankIcon;

    public void init(){
        uiValidationProp = readUiProperties();
    }

    public void clickAndSelectMethod(String btn, String method) {
        clickOnButtons(btn);
        waitForVisibleElement(methodType);
        Select select = new Select(methodType);
        select.selectByVisibleText(method);
    }

    public void clickAndSelectCountry(String btn, String country) {
        clickOnButtons(btn);
        waitForVisibleElement(selectCountry);
        Select select = new Select(selectCountry);
        select.selectByVisibleText(country);
    }

    public void enterPaymentMethod(String value, String field){
        switch (field.toUpperCase()){
            case "METHOD NAME":
                waitForVisibleElement(methodName);
                methodName.clear();
                methodNameValue = value + generateRandomString();
                methodName.sendKeys(methodNameValue);
                break;
            case "BANK NAME":
                waitForVisibleElement(bankNameField);
                bankNameField.clear();
                bankNameFieldValue =value+ generateRandomString();
                bankNameField.sendKeys(bankNameFieldValue);
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
        paymentIcon.sendKeys(System.getProperty("user.dir")+"/src/main/resources/QR_code_for_mobile_English_Wikipedia.svg.png");
//        uploadImage("C:/Users/chatu/Downloads/QR_code_for_mobile_English_Wikipedia.svg.png");
        explicitWait(2000);
    }

    public void uploadBankIcon(String btn) {
        bankIcon.sendKeys(System.getProperty("user.dir")+"/src/main/resources/QR_code_for_mobile_English_Wikipedia.svg.png");
        explicitWait(2000);
    }

    public void editPaymentIcon(String btn){
        paymentIcon.sendKeys(System.getProperty("user.dir")+"/src/main/resources/Screenshot_4.png");
        explicitWait(2000);
    }

    public void verifyAddPaymentMethod(){
        explicitWait(2000);
        waitForVisibleElement(searchPayment);
        searchPayment.clear();
        searchPayment.sendKeys(methodNameValue);
//        searchPaymentValue = methodNameValue;
//        searchPayment.sendKeys(methodNameValue);
        searchPayment.sendKeys(Keys.ENTER);
        explicitWait(1000);
        String expected = methodNameValue;
        String actual = methodListName.getText();
        Assert.assertEquals("Payment Method Added :: ",expected,actual);
    }

    public void verifyEditPaymentMethod(){
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
        try{
            for (Map<String, String> map: list){
                for (Map.Entry<String,String> entry : map.entrySet()){
                    String fieldName = entry.getKey();
                    String errorMess = entry.getValue();

                    switch (fieldName.toUpperCase()){
                        case "METHOD TYPE":
                            Assert.assertEquals("Error message for method type not as  expected. Expected :: "
                                            +errorMess + " Actual :: "+methodTypeErrorMess.getText(),
                                    errorMess, methodTypeErrorMess.getText());
                            break;
                        case "METHOD NAME":
                            Assert.assertEquals("Error message for method name not as expected. Expected :: "
                                            +errorMess + " Actual :: "+methodNameErrorMess.getText(),
                                    errorMess , methodNameErrorMess.getText());
                            break;
                        case "PAYMENT ICON":
                            Assert.assertEquals("Error message for payment icon not as expected. Expected :: "
                                            +errorMess + " Actual :: "+paymentIconErrorMess.getText(),
                                    errorMess , paymentIconErrorMess.getText());
                            break;
                        case "BANK NAME":
                            Assert.assertEquals("Error message for payment icon not as expected. Expected :: "
                                            +errorMess + " Actual :: "+bankNameErrorMessage.getText(),
                                    errorMess , bankNameErrorMessage.getText());
                            break;
                        case "COUNTRY":
                            Assert.assertEquals("Error message for country not as expected. Expected :: "
                                            +errorMess + " Actual :: "+countryErrorMessage.getText(),
                                    errorMess , countryErrorMessage.getText());
                            break;
                        case "BANK ICON":
                            Assert.assertEquals("Error message for bank icon not as expected. Expected :: "
                                            +errorMess + " Actual :: "+bankIconErrorMessage.getText(),
                                    errorMess , bankIconErrorMessage.getText());
                            break;
                        default:
                            logger.info("Not getting Error Message");
                    }
                }
            }
        }catch (Exception e){
            try {
                            clickOnButtons("CANCEL");
            }finally {
                logger.error("Error message not match as per expectation :: "+e.getMessage());
            }
        }


    }

    public static Map<String,String> readUiProperties(){
        Map<String,String> all =new HashMap<>();
        Properties properties = new Properties();
        try {
            InputStream inputStream = new FileInputStream(System.getProperty("user.dir")+
                    "/src/main/resources/UiValidation.properties");
            properties.load(inputStream);
            Enumeration<Object> keys = properties.keys();
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                all.put(key, properties.getProperty(key));
            }
        }catch (Exception e){
            logger.error("Ui properties file not read.."+e.getMessage());
        }
        return all;
    }

    public void  varifyPaymentMethodValidationMessage(String action){
        String expectedToster ;
        String actualToster  ;
        switch (action.toUpperCase()){
            case "ADD":
                waitForVisibleElement(addValidationMess);
                expectedToster =uiValidationProp.get("AddPaymentMethod");
                actualToster = addValidationMess.getText();
                Assert.assertEquals("",expectedToster,actualToster);
                System.out.println(actualToster);
                System.out.println(expectedToster);
                break;
            case "EDIT":
                waitForVisibleElement(updateValidationMess);
                expectedToster =  uiValidationProp.get("EditPaymentMethod");
                actualToster = updateValidationMess.getText();
                Assert.assertEquals("", expectedToster,actualToster);
                System.out.println(actualToster);
                System.out.println(expectedToster);
                break;
            default:
                logger.error("Action not found");
        }
    }

//    public void validationForAleardyUsedInPaymentMethod(String field){
//        String expectedResult = null;
//        String actualResult = null;
//        switch (field.toUpperCase()){
//            case "METHOD NAME":
//                waitForVisibleElement(methodName);
//                baseUtil.enterText(methodName,methodNameValue);
//                expectedResult = uiValidationProp.get("MethodNameAlreadyTaken");
//                waitForVisibleElement(methodNameAlready);
//                actualResult = methodNameAlready.getText();
//                Assert.assertEquals("Method name aleady take :: ",expectedResult,actualResult);
//                break;
//            default:
//                logger.info("Data not found..");
//        }
//    }


    public void validationForAleardyUsedInPaymentMethod(String field){
        String  btn = "Choose File";
        String btn2 = "Submit";
        uploadPaymentIcon(btn);
        String expectedResult = null;
        String actualResult = null;
        switch (field.toUpperCase()){
            case "METHOD NAME":
                waitForVisibleElement(methodName);
                baseUtil.enterText(methodName,methodNameValue);
                clickOnButtons(btn2);

                JavascriptExecutor javascriptExecutor = (JavascriptExecutor) TestBase.getWebDriver();

                expectedResult = uiValidationProp.get("MethodNameAlreadyTaken");

                waitForVisibleElement(methodNameAlready);
                explicitWait(1500); // Optional: small wait if needed

                actualResult = (String) javascriptExecutor.executeScript(
                        "return arguments[0].textContent;", methodNameAlready);

                Assert.assertEquals("Validation message mismatch", expectedResult, actualResult);
//                JavascriptExecutor javascriptExecutor = (JavascriptExecutor) TestBase.getWebDriver();
//
//                expectedResult = uiValidationProp.get("MethodNameAlreadyTaken");
//                waitForVisibleElement(methodNameAlready);
//                actualResult = methodNameAlready.getText();
                Assert.assertEquals("Method name aleady take :: ",expectedResult,actualResult);
                break;
            default:
                logger.info("Data not found..");
        }
    }

    public void verifyStatusValidationMessageOnPayment(String status){
        String expectedToster = null;
        String actualToster = null ;
        switch (status.toUpperCase()){
            case "PAYMENT ACTIVE":
                waitForVisibleElement(paymentStatusActiveToster);
                expectedToster = uiValidationProp.get("PaymentMethodStatusActive");
                actualToster = paymentStatusActiveToster.getText();
                Assert.assertEquals("Expected result match with actual result ",expectedToster,actualToster);
                break;
            case "PAYMENT INACTIVE":
                waitForVisibleElement(paymentStatusDeactiveToster);
                expectedToster = uiValidationProp.get("PaymentMethodStatusDeactive");
                actualToster = paymentStatusDeactiveToster.getText();
                Assert.assertEquals("Expected result match with actual result ",expectedToster,actualToster);
                break;
            default:
                logger.info("Status case not match."+ logger.getName());
        }
    }

    public void search(String methodName){
        waitForVisibleElement(searchPayment);
        searchPayment.clear();
        searchPayment.sendKeys(methodNameValue);
        searchPayment.sendKeys(Keys.ENTER);
    }
}
