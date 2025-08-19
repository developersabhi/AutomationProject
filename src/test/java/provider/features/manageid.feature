@GetID_AddPaymentMethod

Feature: GetID --> Add New Payment Method
  Here will test the Add new WebSite on the provider Functionality.
  For this we will login with provider credentials and will test the different scenarios including behaviour and functional test of the WebSite List.
  For Testing we will use the test data.

  @test
  @ManageId_Add
  Scenario:Scenario_1: Add Payment Method and verify the added Payment Method.
#    Given User log in to provider URL and is already present at the website list page.
#    Then click on the  "Noti Cancel" button.
    Then click on the  "Manage ID" button.
    Then click on the  "Add Payment Method" button.
    Then click on the  "Method Type" dropdown and choice the "UPI" method.
    Then enter the value "TestAuto" for the field "Method Name".
    Then click on the "Choose File" and Upload.
    Then click on the  "Submit" button.
    Then Verify the add Payment method on list.
    Then Verify the "ADD" Payment method validation message on screen.

  @test
  @ManageId_Add_new_PaymentMethod_Without_Fill
  Scenario: Scenario_2: Add New Payment Method without fill the field and Verify the Validation message.
    Then click on the  "Manage ID" button.
    Then click on the  "Add Payment Method" button.
    And click on the  "Submit" button and Verify the error message for payment method following field.
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
    Then Verify the "ADD" Payment method validation message on screen.
#
  @ManageId_Edit_PaymentMethod_varify_Validation
  Scenario:Scenario_3: Add new payment method after that edit the Payment method.
    Then click on the  "Manage ID" button.
    Then click on the  "Add Payment Method" button.
    Then click on the  "Method Type" dropdown and choice the "UPI" method.
    Then enter the value "TestAuto" for the field "Method Name".
    Then click on the "Choose File" and Upload.
    Then click on the  "Submit" button.
    Then Verify the add Payment method on list.
    Then click on the  "Payment Action" button.
    Then click on the  "Edit Payment Method" button.
    Then click on the  "Method Type" dropdown and choice the "Bank" method.
    Then enter the value "TestAuto" for the field "Method Name".
    Then click on the "Choose File" and Upload edit.
    Then click on the  "Submit" button.
    Then Verify the edit Payment method on list.
    Then Verify the "Edit" Payment method validation message on screen.

  @ManageId_Verify_aldeady_used_data
  Scenario:Scenario_4: Add new payment method after use same data to verify the validation.
    Then click on the  "Manage ID" button.
    Then click on the  "Add Payment Method" button.
    Then click on the  "Method Type" dropdown and choice the "UPI" method.
    Then enter the value "TestAuto" for the field "Method Name".
    Then click on the "Choose File" and Upload.
    Then click on the  "Submit" button.
    Then Verify the add Payment method on list.
    Then click on the  "Add Payment Method" button.
    Then click on the  "Method Type" dropdown and choice the "UPI" method.
    Then use the already use value for Method "Method Name" field.
#      Then click on the "Choose File" and Upload.
#      Then click on the  "Submit" button.
    Then click on the  "Cancel Payment" button.
    Then Verify the add Payment method on list.

  @ManageId_Verify_Status_Validation_Message
  Scenario:Scenario_4: Add new payment method after verify the status validation.
    Then click on the  "Manage ID" button.
    Then click on the  "Add Payment Method" button.
    Then click on the  "Method Type" dropdown and choice the "UPI" method.
    Then enter the value "TestAuto" for the field "Method Name".
    Then click on the "Choose File" and Upload.
    Then click on the  "Submit" button.
    Then Verify the "ADD" Payment method validation message on screen.
    Then search the "Payment Name".
    Then Verify the add Payment method on list.
    Then click on the  "Status" button.
    Then verify the payment status change from active to "payment deactive".
    Then click on the  "Status" button.
    Then verify the payment status change from deactive to "payment active".

  @ManageId__Add_new_PaymentMethod_Without_Fill @add
  Scenario: Scenario_5: Add New Payment Method without fill the field and Verify the Validation message.
    Then click on the  "Manage ID" button.
    Then click on the  "Banks section" button.
    Then click on the  "Add Bank" button.
    And click on the  "Submit Bank" button and Verify the error message for banks add following field.
      | Bank Name                    |
      | Bank name field is required. |
    Then enter the value "AutoBank" for the field "Bank Name".
    And click on the  "Submit Bank" button and Verify the error message for banks add following field.
      | Country                          |
      | Please select bank country name. |
    Then click on the  "Country" dropdown and choice the county "Nepal" method.
    Then click on the  "Automation check box" button.
    And click on the  "Submit Bank" button and Verify the error message for banks add following field.
    |Bank Icon                    |
    | Bank icon is required |
    Then click on the "Choose File" and bank icon Upload.
    Then click on the  "Submit Bank" button.
#    Then Then search the "". // how can verify the added bank when we crease same name but different country
#    Then Verify the add Payment method on list.

  @ManageId_Edit_Bank_varify_Validation
  Scenario:Scenario_3: Add new bank after that edit the bank.
  hen click on the  "Manage ID" button.
    Then click on the  "Banks section" button.
    Then click on the  "Bank Edit Action" button.
    Then enter the value "AutoBank" for the field "Bank Name".
    Then click on the  "Country" dropdown and choice the county "Oman" method.
    Then click on the  "Automation check box" button.
