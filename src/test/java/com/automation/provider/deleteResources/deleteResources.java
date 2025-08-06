package com.automation.provider.deleteResources;

import org.apache.log4j.Logger;
import util.CommonMethod;

public class deleteResources extends CommonMethod {
    Logger logger = Logger.getLogger(deleteResources.class);
    public void deleteResource(){
        getTestBase().logout();
        getTestBase().quitBrowser();
        logger.info("Browser close..");
    }
}
