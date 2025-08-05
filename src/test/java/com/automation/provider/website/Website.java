package com.automation.provider.website;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.BaseUtil;
import util.CommonMethod;
import util.TestBase;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

public class Website extends CommonMethod {
    static protected String webSiteName, loginSlugName, database ,IPs , URLValue, ClientNameValue ;

    static Logger logger = Logger.getLogger(Website.class);
    BaseUtil baseUtil = new BaseUtil();
    CommonMethod commonMethod = new CommonMethod();

    List<String> data = new ArrayList<>();

    Website() {
        PageFactory.initElements(TestBase.getWebDriver(), this);
        init();
    }

    @FindBy(xpath = "//input[@placeholder ='Enter Website Name']")
    WebElement websiteName;

    @FindBy(xpath = "//input[@placeholder ='Enter IP']")
    WebElement ip;

    @FindBy(xpath = "//input[@placeholder ='Enter URL']")
    WebElement url;

    @FindBy(xpath = "//input[@placeholder ='Enter Client Name']")
    WebElement clientName;

    @FindBy(xpath = "//input[@placeholder ='Enter request approve/reject webhook url']")
    WebElement approveRejectHookURL;

    @FindBy(xpath = "//input[@placeholder ='Enter withdraw webhook url']")
    WebElement withdrawHookURL;

    @FindBy(xpath = "//input[@placeholder ='Enter balance webhook url']")
    WebElement balanceHookURL;

    @FindBy(xpath = "//input[@placeholder ='Enter agent login URL']")
    WebElement agentLoginHookURL;

    @FindBy(xpath = "//input[@placeholder ='Enter manually transaction hook url']")
    WebElement manuallyTransactionHookURL;

    @FindBy(xpath = "//input[@placeholder ='Enter user registraction hook url']")
    WebElement userRegistractionHookURL;

    @FindBy(xpath = "//input[@placeholder ='Enter user bet status hook url']")
    WebElement userBetStatusHookURL;

    @FindBy(xpath = "//input[@placeholder ='Enter employee login URL']")
    WebElement loginSlug;

    @FindBy(xpath = "//input[@placeholder ='Enter database name']")
    WebElement databaseName;

    @FindBy(xpath = "//input[@placeholder ='Enter secret name']")
    WebElement secretKey;

    @FindBy(xpath = "//input[@type ='search']")
    WebElement search;

    @FindBy(xpath = "//p[@class='text-danger validation_msg websiteName']")
    WebElement websiteErrorMessage;

    @FindBy(xpath = "//p[@class='text-danger validation_msg ip']")
    WebElement ipErrorMessage;

    @FindBy(xpath = "//p[@class='text-danger validation_msg url']")
    WebElement urlErrorMessage;

    @FindBy(xpath = "//p[@class='text-danger validation_msg clientName']")
    WebElement clientNameErrorMessage;

    @FindBy(xpath = "//p[@class='text-danger validation_msg login_slug']")
    WebElement loginSlugErrorMessage;

    @FindBy(xpath = "//p[@class='text-danger validation_msg database_name']")
    WebElement databaseNameErrorMessage;

    @FindBy(xpath = "//p[@class='text-danger validation_msg secret_key']")
    WebElement secretKeyErrorMessage;

    @FindBy(xpath = "//p[@class='text-danger validation_msg websiteName']")
    WebElement websiteAlready;

    @FindBy(xpath = "//p[@class='text-danger validation_msg login_slug']")
    WebElement loginslugAlready;

    @FindBy(xpath = "//p[@class='text-danger validation_msg database_name']")
    WebElement databaseAlready;

    @FindBy(xpath = "//tbody/tr[last()]")
    WebElement lastIndex;

    public void verifyErrorMessage(List<Map<String, String>> list) {
        for (Map<String, String> map : list) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String fieldName = entry.getKey();
                String errorMess = entry.getValue();

                switch (fieldName.toUpperCase()) {
                    case "WEBSITE NAME":
                        Assert.assertEquals("Error message for website name not as expected. Expected :: "
                                        + errorMess + " Actual :: " + websiteErrorMessage.getText(),
                                errorMess, websiteErrorMessage.getText());
                        break;
                    case "IP":
                        Assert.assertEquals("Error message for IP  not as expected.Expected :: "
                                        + errorMess + " Actual :: " + ipErrorMessage.getText(),
                                errorMess, ipErrorMessage.getText());
                        break;
                    case "URL":
                        Assert.assertEquals("Error message for URL  not as expected.Expected :: "
                                        + errorMess + " Actual :: " + urlErrorMessage.getText() ,
                                errorMess, urlErrorMessage.getText());
                        break;
                    case "CLIENT NAME":
                        Assert.assertEquals("Error message for client name not as expected.Expected :: "
                                        + errorMess + " Actual :: " + clientNameErrorMessage.getText() ,
                                errorMess, clientNameErrorMessage.getText());
                        break;
                    case "LOGIN SLUG":
                        Assert.assertEquals("Error message for login slug not as expected.Expected :: "
                                        + errorMess + " Actual :: " + loginSlugErrorMessage.getText() ,
                                errorMess, loginSlugErrorMessage.getText());
                        break;
                    case "DATABASE NAME":
                        Assert.assertEquals("Error message for database name not as expected.Expected :: "
                                        +errorMess + " Actual :: " + databaseNameErrorMessage.getText() ,
                                errorMess, databaseNameErrorMessage.getText());
                        break;
                    case "SECRET KEY":
                        Assert.assertEquals("Error message for secret key not as expected.Expected :: "
                                        +errorMess + " Actual :: " + secretKeyErrorMessage.getText() ,
                                errorMess, secretKeyErrorMessage.getText());
                        break;
                    default:
                        logger.info("Not getting Error Message");
                }
            }
        }

    }

    public void enterAddWebsiteFieldValue(String value, String field){
        switch (field.toUpperCase()){
            case "WEBSITE NAME":
                waitForVisibleElement(websiteName);
                webSiteName = value + randomString();
                baseUtil.enterText(websiteName, webSiteName);
                data.add(webSiteName);
                break;
            case "IP":
                waitForVisibleElement(ip);
                IPs = value;
                baseUtil.enterText(ip, value);
                data.add(value);
                break;
            case "URL":
                waitForVisibleElement(url);
                URLValue = value;
                baseUtil.enterText(url, value);
                data.add(value);
                break;
            case "CLIENT NAME":
                waitForVisibleElement(clientName);
                ClientNameValue = value;
                baseUtil.enterText(clientName, value);
                data.add(value);
                break;
            case "APPROVE/REJECT HOOK URL":
                waitForVisibleElement(agentLoginHookURL);
                baseUtil.enterText(approveRejectHookURL, value);
                break;
            case "WITHDRAW HOOK URL":
                waitForVisibleElement(withdrawHookURL);
                baseUtil.enterText(withdrawHookURL, value);
                break;
            case "BALANCE HOOK URL":
                waitForVisibleElement(balanceHookURL);
                baseUtil.enterText(balanceHookURL, value);
                break;
            case "AGENT LOGIN HOOK URL":
                waitForVisibleElement(agentLoginHookURL);
                baseUtil.enterText(agentLoginHookURL, value);
                break;
            case "MANUALLY TRANSACTION HOOK URL":
                waitForVisibleElement(manuallyTransactionHookURL);
                baseUtil.enterText(manuallyTransactionHookURL, value);
                break;
            case "USER REGISTRACTION HOOK URL":
                waitForVisibleElement(userRegistractionHookURL);
                baseUtil.enterText(userRegistractionHookURL, value);
                break;
            case "USER BET STATUS HOOK URL":
                waitForVisibleElement(userBetStatusHookURL);
                baseUtil.enterText(userBetStatusHookURL, value);
                break;
            case "LOGIN SLUG":
                waitForVisibleElement(loginSlug);
                loginSlugName = value + randomString();
                baseUtil.enterText(loginSlug, loginSlugName);
                data.add(loginSlugName);
                break;
            case "DATABASE NAME":
                waitForVisibleElement(databaseName);
                database = value + randomString();
                baseUtil.enterText(databaseName, database);
                break;

            default:
                System.out.println("Not Match Data");
        }
    }

    public String randomString(){
        return UUID.randomUUID().toString().substring(4).replaceAll("[^A-Za-z]","");
    }

    public void searchAddedWebSite(){
        commonMethod.explicitWait(2000);
        waitForVisibleElement(search);
        search.clear();
        search.sendKeys(webSiteName);
        search.sendKeys(Keys.ENTER);
        commonMethod.explicitWait(1000);
        if(!baseUtil.isElementDisplayed(websiteName)){
            Assert.assertNotNull("Site not deleted successfully.", websiteName);
        }
    }

    public void verifyAddedSite(){
        try {
            commonMethod.explicitWait(2000);
            List<String> UIData = new ArrayList<>();
            String xpath = "//tbody/tr/td[#index#]";
            for (int i = 2; i <= 6 ; i++) {
                String byIndex ="";
                byIndex = xpath.replaceAll("#index#", String.valueOf(i));
                UIData.add(TestBase.getWebDriver().findElement(By.xpath(byIndex)).getText());
            }Collections.sort(UIData);
            Collections.sort(data);
            Assert.assertEquals("Expexted data ::"+ data + " Actual data :: "+ UIData + " are not matched ",UIData,data);
        }catch (Exception e){
            logger.error("Added website not found. ::"+e.getMessage());
        }
    }

    public void verifyAlreadyExistValidation( String field){
        String expectedResult = null;
        String actualResult = null;
        switch (field.toUpperCase()){
            case "WEBSITE NAME":
                waitForVisibleElement(websiteName);
                baseUtil.enterText(websiteName, webSiteName);
                commonMethod.clickOnButtons("SUBMIT");
                expectedResult =uiValidationProp.get("WebsiteNameAlreadyTaken");
                 waitForVisibleElement(websiteAlready);
                 actualResult = websiteAlready.getText();
                Assert.assertEquals("Website already  ",expectedResult,actualResult);
                break;
            case "IP":
                waitForVisibleElement(ip);
                baseUtil.enterText(ip,IPs);
                break;
            case "URL":
                waitForVisibleElement(url);
                baseUtil.enterText(url, URLValue);
                break;
            case "CLIENT NAME":
                waitForVisibleElement(clientName);
                baseUtil.enterText(clientName,ClientNameValue);
                break;
            case "LOGIN SLUG":
                waitForVisibleElement(loginSlug);
                baseUtil.enterText(loginSlug,loginSlugName);
                commonMethod.clickOnButtons("SUBMIT");
                explicitWait(1000);
                expectedResult = uiValidationProp.get("LoginSlugAlreadyTaken");
                waitForVisibleElement(loginslugAlready);
                actualResult = loginslugAlready.getText();
                Assert.assertEquals("Login slug already",expectedResult,actualResult);
                break;
            case "DATABASE NAME":
                waitForVisibleElement(databaseName);
                baseUtil.enterText(databaseName,database);
                commonMethod.clickOnButtons("SUBMIT");
                explicitWait(1000);
                expectedResult = uiValidationProp.get("DatabaseNameAlreadyTaken");
                waitForVisibleElement(databaseAlready);
                actualResult= databaseAlready.getText();
                Assert.assertEquals("Database already",expectedResult,actualResult);
                break;
            default:
                logger.info("Data not found..");
        }
    }

    public void verifyAddWebsiteDeleted(){
        waitForVisibleElement(search);
        search.clear();
        search.sendKeys(webSiteName);
        search.sendKeys(Keys.ENTER);
        if (baseUtil.isElementDisplayed(lastIndex)) Assert.fail("Website still visible after delete...");
        else logger.info("Website deleted successfully."+logger.getName());
    }

    public static Map<String,String> readUiProperties(){
        Map<String,String> all =new HashMap<>();
        Properties properties = new Properties();
        try {
            InputStream inputStream = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/UiValidation.properties");
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

    public void VerifyUiValidationMessage(){
        try {
            Map<String,String>UiTest = readUiProperties();
//            String WebsiteNameAlreadyTaken = UiTest.get("WebsiteNameAlreadyTaken");
        }catch (Exception e){
            logger.error("Ui properties file not read.."+e.getMessage());
        }
    }
    Map<String,String> uiValidationProp = null;
    public void init(){
        uiValidationProp =readUiProperties();
    }

}
