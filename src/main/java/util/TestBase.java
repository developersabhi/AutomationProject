package util;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class TestBase {
    private static TestBase instance;
    static protected WebDriver driver = null;
    Logger logger = Logger.getLogger(TestBase.class);
    CommonMethod commonMethod = new CommonMethod();
    Map<String,String> globProp = null;

    TestBase(){
        init();
        globProp = commonMethod.readProperties();
    }

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
    }

    public void logout() {
        BaseUtil baseUtil = new BaseUtil();
        commonMethod.waitForVisibleElement(driver.
                findElement(By.xpath(globProp.get("logout_btn_locater"))));
        commonMethod.clickOnButtons("LOGOUT");
    }

}
