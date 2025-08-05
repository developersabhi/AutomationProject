package com.automation.provider.website;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import util.CommonMethod;

import java.util.List;
import java.util.Map;

public class websiteTest extends CommonMethod {

    Website website = new Website();
    CommonMethod commonMethod = new CommonMethod();
    @Given("User log in to provider URL and is already present at the website list page.")
    public void user_log_in_to_provider_url_and_is_already_present_at_the_website_list_page() {
        explicitWait(2000);
        getTestBase().login();

    }
    @Then("click on the  {string} button.")
    public void click_on_the_button(String button) {
        clickOnButtons(button);
    }
    @Then("click on the {string} button and Verify the error message for following field.")
    public void click_on_the_button_and_verify_the_error_message_for_following_field(String button, DataTable dataTable) {
        clickOnButtons(button);
        List<Map<String,String>> data = dataTable.asMaps(String.class, String.class);
        explicitWait(1000);
        website.verifyErrorMessage(data);
    }
    @Then("user enter the data {string} for {string} field.")
    public void user_enter_the_data_for_field(String value, String field) {
            website.enterAddWebsiteFieldValue( value ,field);
    }
    @Then("user enter the data on the Search.")
    public void user_enter_the_data_on_the_search() {
            website.searchAddedWebSite();
    }
    @Then("User Verify the Add Website on list")
    public void user_verify_the_add_website_on_list() {
            website.verifyAddedSite();
    }
    @Then("User will logout.")
    public void user_will_logout() {
        explicitWait(2000);
        getTestBase().logout();
    }


    @Then("user the already use value for {string} field.")
    public void user_the_already_use_value_for_field(String field) {
        explicitWait(1000);
        website.verifyAlreadyExistValidation(field);
    }

    @Then("enter the data value for search.")
    public void enter_the_data_value_for_search() {
        website.searchAddedWebSite();
    }

    @Then("User Verify the Edited Website on list.")
    public void user_verify_the_edited_website_on_list() {
        explicitWait(1000);
        website.verifyAddedSite();
    }

    @Then("verifying the deleted site.")
    public void verifying_the_deleted_site() {
        explicitWait(3000);
        website.verifyAddWebsiteDeleted();
    }

    @Then("User Close the Browser;")
    public void user_close_the_browser() {
        getTestBase().quitBrowser();
    }

}
