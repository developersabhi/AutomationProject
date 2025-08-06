package com.automation.provider.deleteResources;

import io.cucumber.java.en.Then;
import util.CommonMethod;

public class deleteResourcesTest {
    deleteResources resources = new deleteResources();
    @Then("User will logout and close the browser.")
    public void user_will_logout_and_close_the_browser() {
        resources.deleteResource();
    }
}
