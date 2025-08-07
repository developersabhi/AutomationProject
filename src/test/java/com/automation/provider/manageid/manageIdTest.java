package com.automation.provider.manageid;

import io.cucumber.java.en.Then;

public class manageIdTest {

    ManageId manageId = new ManageId();
    @Then("click on the  {string} dropdown and choice the {string} method.")
    public void click_on_the_dropdown_and_choice_the_method(String btn, String method) {
        manageId.clickAndSelectMethod(btn,method );
    }

    @Then("enter the value {string} for the field {string}.")
    public void enter_the_value_for_the_field(String value, String field) {
        manageId.enterPaymentMethod(value,field);
    }
    @Then("click on the {string} and Upload.")
    public void click_on_the_and_upload(String btn) {
        manageId.uploadPaymentIcon(btn);
    }
    @Then("Verify the add Payment method on list.")
    public void verify_the_add_payment_method_on_list() {
        manageId.verifyAddPaymentMethod();
    }

}
