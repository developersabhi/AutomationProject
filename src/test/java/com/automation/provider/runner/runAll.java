package com.automation.provider.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/java/provider/features/aLoginResources.feature",
//                "src/test/java/provider/features/webSite.feature",
                "src/test/java/provider/features/manageid.feature",
                "src/test/java/provider/features/zDeleteResources.feature"
        },
        glue = {
                "com.automation.provider.loginResources",
//                "com.automation.provider.website",
                "com.automation.provider.manageid",
                "com.automation.provider.deleteResources"
        }
        ,
        dryRun = false
//        tags = "",
//        plugin = {},
//        monochrome = true
)
public class runAll {
}
