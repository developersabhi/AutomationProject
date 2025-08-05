package com.automation.provider.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/java/provider/features/webSite.feature",
//                "src/test/java/provider/features/editWebSite.feature"
        },
        glue = {
                "com.automation.provider.website",
                "com.automation.tests.base"
        }
        ,
        dryRun = false
//        tags = "",
//        plugin = {},
//        monochrome = true
)
public class runAll {
}
