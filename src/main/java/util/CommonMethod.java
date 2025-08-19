package util;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.InputStream;
import java.time.Duration;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CommonMethod {

    private static final Logger logger = Logger.getLogger(CommonMethod.class);
    WebDriverWait wait = new WebDriverWait(TestBase.getWebDriver(), Duration.ofMillis(10000));
    private static final TestBase testBase = TestBase.getInstance();
    BaseUtil baseUtil = new BaseUtil();

    public CommonMethod() {
        PageFactory.initElements(TestBase.getWebDriver(), this);
    }

    //div[@id='zgE6AeerZ']/parent::div[@class='toasted toasted-primary success')]
    //div[@id='zgE6AeerZ']//parent::div[contains(text(),'Website status is active updated successfully')]
    @FindBy(xpath = "//form//button[contains(text(), 'Login')]")
    WebElement loginBtn;
    @FindBy(xpath = "//button[contains(text(), 'Cancel') and @aria-label='Close']")
    WebElement notiCancelBtn;
    @FindBy(xpath = "//button[contains(text(), 'Logout')]")
    WebElement logoutBtn;
    @FindBy(xpath = "(//button[contains(text(),'Submit')])[1]")
    WebElement submitBtn;
    @FindBy(xpath = "//a[contains(text(), ' Add Website')]")
    WebElement addWebSite;
    @FindBy(xpath = "//img[@style='cursor: pointer;']")
    WebElement secretKey;
    @FindBy(xpath = "(//button[contains(text(), 'Cancel')])[2]")
    WebElement cancelBtn;
    @FindBy(xpath = "//button[@class='btn action-btn']")
    WebElement actionBtn;
    @FindBy(xpath = "//button[@type='button']//child::i//child::img[@src ='/user/images/edit-icon.svg']")
    WebElement editBtn;
    @FindBy(xpath = "//i//child::img[@src ='/user/images/delete-icon.svg']")
    WebElement deleteBtn;
    @FindBy(xpath = "//div[@class ='swal2-actions']/child::button[@class='swal2-confirm swal2-styled']")
    WebElement yesBtn;
    @FindBy(xpath = "//div[@class ='swal2-actions']/child::button[@class='swal2-confirm swal2-styled']")
    WebElement okBtn;
    @FindBy(xpath = "//label[@class='switch']")
    WebElement statusBtn;

    @FindBy(xpath = "(//ul[@class='pagination pagination-sm justify-content-center mb-2 mr-4']/child::li)[last()-1]")
    WebElement lastPage;

    @FindBy(xpath = "//a[@href ='/manage-id']")
    WebElement manageId;

    @FindBy(xpath = "//a[@class ='btn btn-primary' and  contains(text(),'Add Payment Method')]")
    WebElement addPaymentBtn;
    @FindBy(xpath = "//select[@class='form-control']")
    WebElement methodType;
    @FindBy(xpath = "//input[@id='paymentIcon']")
    WebElement paymentIcon;
    @FindBy(xpath = "//div[@id='payment-methods-tab-pane']//button[contains(text(),'Submit')]")
    WebElement paymentMethodSubmitBtn;

    @FindBy(xpath = "(//table[@class='table table-hover']//div[@class='btn-group option-dd']/button[@class='btn action-btn'])[1]")
    WebElement paymentActionBtn;
    @FindBy(xpath = "(//i[@class='edit-icon'])[1]")
    WebElement  paymentMethodEditBtn;

    @FindBy(xpath = "//div[@id='add-payment-method-modal']//form//div[@class='modal-footer']//button[@class='btn btn-secondary' and contains(text(),'Cancel')]")
    WebElement paymentMethodCancelBtn;

    @FindBy(xpath = "//button[@id='contact-tab']")
    WebElement banksSectionBtn;
    @FindBy(xpath = "//a[contains(text(),'Add Bank')]")
    WebElement addBankBtn;
    @FindBy(xpath = "//input[@placeholder='Enter Bank Name']")
    WebElement bankNameField;
    @FindBy(xpath = "//select[@name='country']")
    WebElement selectCountry;
    @FindBy(xpath = "//input[@id='isAutomationAllow']")
    WebElement bankCheckBox;
    @FindBy(xpath = "//input[@id='icon']")
    WebElement bankIcon;
    @FindBy(xpath = "//button[contains(text(),'SUBMIT')]")
    WebElement submitBankBtn;
    @FindBy(xpath = "//div[@id='add-bank-modal']//button[contains(text(),'Cancel')]")
    WebElement cancelBankBtn;



    public void explicitWait(long time) {
        try {
            logger.info("Waiting for " + time);
            Thread.sleep(time);
        } catch (Exception e) {
            logger.error("Getting error while doing explicit wait:: " + e.getMessage());
        }
    }

    public static Map<String, String> readProperties() {
        Map<String, String> all = new HashMap<>();
        Properties properties = new Properties();
        try {
            logger.info("Read global properties file.");
            InputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/Global.properties");
            properties.load(inputStream);
            Enumeration<Object> keys = properties.keys();

            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                all.put(key, properties.getProperty(key));
            }
        } catch (Exception e) {
            logger.error("Properties file not access:: " + e.getMessage());
        }
        return all;
    }

    public void getData() {
        try {
            Map<String, String> testData = readProperties();
            String url = testData.get("provider_env_url");
        } catch (Exception e) {
            logger.error("Data not getting from properties files:: " + e.getMessage());
        }
    }

    public void waitForVisibleElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static TestBase getTestBase() {
        return new TestBase();
    }

    public boolean isElementClickable(WebElement element) {
        boolean flag = false;
        try {
            if (element.isEnabled()) flag = true;
        } catch (Exception e) {

        }
        return flag;
    }

    public void clickOnButtons(String button) {
        switch (button.toUpperCase()) {
            case "LOGIN":
                waitForVisibleElement(loginBtn);
                loginBtn.click();
                logger.info("Login button  Clicked");
                break;
            case "NOTI CANCEL":
                logger.info("Notification cancel button:: ");
                explicitWait(2000);
                waitForVisibleElement(notiCancelBtn);
                notiCancelBtn.click();
                logger.info("Notification cancel button  clicked");
                break;
            case "LOGOUT":
                waitForVisibleElement(logoutBtn);
                logoutBtn.click();
                logger.info("Logout button clicked:: ");
                break;
            case "SUBMIT":
                waitForVisibleElement(submitBtn);
                submitBtn.click();
                logger.info("SUBMIT button  clicked");
                break;
            case "ADD WEBSITE":
                waitForVisibleElement(addWebSite);
                addWebSite.click();
                logger.info("ADD WEBSITE button clicked");
                break;
            case "SECRET KEY":
                explicitWait(1000);
                waitForVisibleElement(secretKey);
                secretKey.click();
                logger.info("Secret key button clicked");
                break;
            case "CANCEL":
                waitForVisibleElement(cancelBtn);
                cancelBtn.click();
                logger.info("CANCEL button  Clicked");
                break;
            case "ACTION":
                waitForVisibleElement(actionBtn);
                actionBtn.click();
                logger.info("ACTION button  Clicked");
                break;
            case "EDIT":
                waitForVisibleElement(editBtn);
                editBtn.click();
                logger.info("EDIT button  Clicked");
                break;
            case "DELETE":
                waitForVisibleElement(deleteBtn);
                deleteBtn.click();
                break;
            case "YES":
                waitForVisibleElement(yesBtn);
                yesBtn.click();
                break;
            case "OK":
                explicitWait(2000);
                waitForVisibleElement(okBtn);
                okBtn.click();
                break;
            case "STATUS":
                waitForVisibleElement(statusBtn);
                statusBtn.click();
                break;
            case "LAST PAGE":
                JavascriptExecutor javascriptExecutor = (JavascriptExecutor) TestBase.getWebDriver();
                javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", lastPage);
                waitForVisibleElement(lastPage);
                explicitWait(1000);
                lastPage.click();
                logger.info("Last page button clicked..");
                break;
            case "MANAGE ID":
                waitForVisibleElement(manageId);
                manageId.click();
                break;
            case "ADD PAYMENT METHOD":
                waitForVisibleElement(addPaymentBtn);
                addPaymentBtn.click();
                break;
            case "METHOD TYPE":
                waitForVisibleElement(methodType);
                methodType.click();
                break;
            case "CHOOSE FILE":
                JavascriptExecutor js = (JavascriptExecutor) TestBase.getWebDriver();
                js.executeScript("arguments[0].click()",paymentIcon);
                System.out.println("???");
//            waitForVisibleElement(paymentIcon);
//            paymentIcon.click();
            break;
            case "SUBMIT PAYMENT METHOD":
                waitForVisibleElement(paymentMethodSubmitBtn);
                paymentMethodSubmitBtn.click();
                break;
            case "PAYMENT ACTION":
                waitForVisibleElement(paymentActionBtn);
                paymentActionBtn.click();
                break;
            case "EDIT PAYMENT METHOD":
                waitForVisibleElement(paymentMethodEditBtn);
                paymentMethodEditBtn.click();
                break;
            case "CANCEL PAYMENT":
                waitForVisibleElement(paymentMethodCancelBtn);
                paymentMethodCancelBtn.click();
                break;
            case "BANKS SECTION":
                waitForVisibleElement(banksSectionBtn);
                banksSectionBtn.click();
                break;
            case "ADD BANK":
                waitForVisibleElement(addBankBtn);
                addBankBtn.click();
                break;
            case "SUBMIT BANK":
                waitForVisibleElement(submitBankBtn);
                submitBankBtn.click();
                break;
            case "AUTOMATION CHECK BOX":
                waitForVisibleElement(bankCheckBox);
                bankCheckBox.click();
                break;
            default:
                logger.error("Button not found..");
        }
    }
}
