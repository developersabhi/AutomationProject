package com.automation.provider.loginResources;

import org.apache.log4j.Logger;
import util.CommonMethod;

public class loginResources extends CommonMethod {
    Logger logger = Logger.getLogger(loginResources.class);
    public  void  loginResources(){
        explicitWait(2000);
        getTestBase().login();
    }
}
