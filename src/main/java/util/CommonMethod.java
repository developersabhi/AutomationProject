package util;

import org.apache.log4j.Logger;
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

    public CommonMethod(){
        PageFactory.initElements(TestBase.getWebDriver(),this);
    }

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

            while (keys.hasMoreElements()){
                String key=  (String) keys.nextElement();
                all.put(key , properties.getProperty(key));
            }
        } catch (Exception e) {
            logger.error("Properties file not access:: "+ e.getMessage());
        }
        return all;
    }

    public void getData(){
        try {
            Map<String,String> testData =readProperties();
            String url =testData.get("provider_env_url");
        }catch (Exception e){
            logger.error("Data not getting from properties files:: "+e.getMessage());
        }
    }

    public void waitForVisibleElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static TestBase getTestBase(){
        return new TestBase();
    }

    public void clickOnButtons(String button) {
        switch (button.toUpperCase()){
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
                logger.info("Notification cancel button  Clicked");
                break;
            case "LOGOUT":
                waitForVisibleElement(logoutBtn);
                logger.info("Logout button clicked:: ");
                logoutBtn.click();
                break;
            case "SUBMIT":
                waitForVisibleElement(submitBtn);
                submitBtn.click();
                break;
            case "ADD WEBSITE":
                waitForVisibleElement(addWebSite);
                addWebSite.click();
                logger.info("ADD WEBSITE button Clicked");
                break;
            case "SECRET KEY":
                explicitWait(1000);
                waitForVisibleElement(secretKey);
                secretKey.click();
                logger.info("ADD WEBSITE button Clicked");
                break;
            case "CANCEL":
                waitForVisibleElement(cancelBtn);
                cancelBtn.click();
            default:
                logger.error("Button not found..");
        }
    }
}
