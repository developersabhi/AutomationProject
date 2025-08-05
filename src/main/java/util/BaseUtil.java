package util;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class BaseUtil {
    Logger logger;

    public void enterText(WebElement element, String text){
        try {
            isElementDisplayed(element);
            element.clear();
            element.sendKeys(text);
        }catch (Exception e){
            logger.error("Element not displayed so enter text function not working :: "+e.getMessage());
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        boolean flag= false;
        try {
                if(element.isDisplayed())
                    flag = true;
        }catch (Exception e) {
            logger.error("Element not displayed:: "+e.getMessage());
        }
        return flag;
    }
}
