package util;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class TestBase {
    private static TestBase instance;
    static protected WebDriver driver = null;
    Logger logger = Logger.getLogger(TestBase.class);
    CommonMethod commonMethod = new CommonMethod();
    Map<String,String> globProp = null;

    TestBase(){
        init();
        PageFactory.initElements(TestBase.getWebDriver(), this);
        globProp = commonMethod.readProperties();
    }

    @FindBy(xpath = "//div[@class='logo-search-bx']//a[@class = 'admin-logo']//child::img[@src ='/user/images/logo-img.svg']")
    WebElement gitIDLogo;

    @FindBy(xpath="//div[@class='add-but']//child::a[contains(text(),'Add Website')]")
    WebElement addWebSite;
    public static TestBase getInstance() {
        if (instance==null){
            instance = new TestBase();
        }
        return instance;
    }

    public void init(){
        try {
            if (driver == null){
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--disable-notification");
                driver = new ChromeDriver(options);
            }
        }catch(Exception e){
            logger.error("Error for web driver initialization:: "+e.getMessage());
        }
    }

    public static WebDriver getWebDriver(){ return  driver;}

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void login() {
        try {
            String currentUrl = getWebDriver().getCurrentUrl();
            logger.info("Current URL:: "+currentUrl);
            if (!"data".equals(currentUrl)){
                BaseUtil baseUtil = new BaseUtil();
                getWebDriver().get(globProp.get("provider_env_url")); //driver.get
                commonMethod.waitForVisibleElement(driver.
                        findElement(By.xpath(globProp.get("provider_username_locater"))));
                baseUtil.enterText(driver.
                        findElement(By.xpath(globProp.get("provider_username_locater"))), globProp.get("provider_username"));
                commonMethod.waitForVisibleElement(driver.
                        findElement(By.xpath(globProp.get("provider_password_locater"))));
                baseUtil.enterText(driver.
                        findElement(By.xpath(globProp.get("provider_password_locater"))), globProp.get("provider_password"));
                commonMethod.clickOnButtons("LOGIN");
                logger.info("Provider login successful..");
            }else {
                gitIDLogo.click();
                getWebDriver().navigate().refresh();
                commonMethod.waitForVisibleElement(addWebSite);
                logger.info("User already present on login page.");
            }
        }catch (Exception e){
            logger.error("User get error :: "+e.getMessage());
        }
    }

    public void logout() {
        BaseUtil baseUtil = new BaseUtil();
        commonMethod.waitForVisibleElement(driver.
                findElement(By.xpath(globProp.get("logout_btn_locater"))));
        commonMethod.clickOnButtons("LOGOUT");
    }

    public  void  quitBrowser(){
        getWebDriver().quit();

    }

}
