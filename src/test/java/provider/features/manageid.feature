@GetID_AddPaymentMethod

Feature: GetID --> Add New Payment Method
  Here will test the Add new WebSite on the provider Functionality.
  For this we will login with provider credentials and will test the different scenarios including behaviour and functional test of the WebSite List.
  For Testing we will use the test data.

#  @WebSiteList_Add
#  Scenario:Scenario_1: Add Website and verify the added website.
##    Given User log in to provider URL and is already present at the website list page.
##    Then click on the  "Noti Cancel" button.
#    Then click on the  "Manage ID" button.
#    Then click on the  "Add Payment Method" button.
#    Then click on the  "Method Type" dropdown and choice the "UPI" method.
#    Then enter the value "TestAuto" for the field "Method Name".
#    Then click on the "Choose File" and Upload.
#    Then click on the  "Submit" button.
#    Then Verify the add Payment method on list.

  @ManageId_Add_new_PaymentMethod_Without_Fill
  Scenario: Scenario_2: Add New Payment Method without fill the field and Verify the Validation message.
    Then click on the  "Manage ID" button.
    Then click on the  "Add Payment Method" button.
    And click on the "Submit" button and Verify the error message for payment method following field.
      | Method Type                    | Method Name                    | Payment Icon                    |
      | Method type field is required. | Method name field is required. | Payment icon field is required. |
    Then click on the  "Method Type" dropdown and choice the "UPI" method.
    Then click on the  "Submit" button and Verify the error message for payment method following field.
      | Method Name                    | Payment Icon                    |
      | Method name field is required. | Payment icon field is required. |
    Then enter the value "TestAuto" for the field "Method Name".
    Then click on the  "Submit" button and Verify the error message for payment method following field.
      | Payment Icon                    |
      | Payment icon field is required. |
    Then click on the "Choose File" and Upload.
#    Then click on the  "Submit Payment Method" button.
    Then click on the  "Submit" button.
    Then Verify the add Payment method on list.
