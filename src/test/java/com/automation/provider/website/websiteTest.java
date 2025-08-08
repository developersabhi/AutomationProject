package com.automation.provider.website;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.CommonMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class websiteTest extends CommonMethod {

    Website website = new Website();
    CommonMethod commonMethod = new CommonMethod();

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

    @Then("verify the status change from deactive to {string}.")
    public void verify_the_status_change_from_deactive_to(String status) {
        website.varifyStatusValidationMessage(status);
    }
    @Then("verify the status change from active to {string}.")
    public void verify_the_status_change_from_active_to(String status) {
        website.varifyStatusValidationMessage(status);
    }

    @Then("Verify website list have following header field.")
    public void verify_website_list_have_following_header_field(DataTable dataTable) {
        List<String> list = dataTable.row(0);
        for(String data:list){
            website.verifyWebsiteListHeader(data);
        }
    }

    @When("User selects page size {string}")
    public void user_selects_page_size(String size) {
        website.selectPageSize(size);
    }

    @Then("The number of rows displayed should be at most {int}")
    public void verify_rows_displayed(int expectedMax) {
        website.verifyRowCount(expectedMax);
    }

    @Then("verify the {string} button is {string} when user is on {string} page.")
    public void verify_the_button_is_when_user_is_on_page(String btn, String status, String page) {
            website.verifyPageChangeButton(btn,status,page);
    }


}
