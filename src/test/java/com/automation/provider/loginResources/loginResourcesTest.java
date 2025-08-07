package com.automation.provider.loginResources;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class loginResourcesTest {
    loginResources resources = new loginResources();

    @Given("User log in to provider URL and is already present at the website list page.")
    public void user_log_in_to_provider_url_and_is_already_present_at_the_website_list_page() {
       resources.loginResources();
    }
    @Then("click on the  {string} button.")
    public void click_on_the_button(String btn) {
        resources.clickOnButtons(btn);
    }
}
