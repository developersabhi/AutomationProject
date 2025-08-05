@GetID_AddWebSite

Feature: GetID --> Add new WebSite
  Here will test the Add new WebSite on the provider Functionality.
  For this we will login with provider credentials and will test the different scenarios including behaviour and functional test of the WebSite List.
  For Testing we will use the test data.

    @WebSiteList_Add
    Scenario:Scenario_1: Add Website and verify the added website.
      Given User log in to provider URL and is already present at the website list page.
      Then click on the  "Noti Cancel" button.
      Then click on the  "Add Website" button.
      And click on the "Submit" button and Verify the error message for following field.
        | Website Name                        | IP                        | URL                        | Client Name                        | Login Slug                        | Database Name                        | Secret Key                        |
        | The website name field is required. | The ip field is required. | The url field is required. | The client name field is required. | The login slug field is required. | The database name field is required. | The secret key field is required. |
      Then user enter the data "Game" for "Website Name" field.
      And click on the "Submit" button and Verify the error message for following field.
        | IP | URL | Client Name | Login Slug | Database Name | Secret Key |
      Then user enter the data "102.120.52.25" for "IP" field.
      And click on the "Submit" button and Verify the error message for following field.
        | URL | Client Name | Login Slug | Database Name | Secret Key |
      Then user enter the data "https://GameRunner.com" for "URL" field.
      And click on the "Submit" button and Verify the error message for following field.
        | Client Name | Login Slug | Database Name | Secret Key |
      Then user enter the data "Edu master" for "Client name" field.
      And click on the "Submit" button and Verify the error message for following field.
        | Login Slug | Database Name | Secret Key |
      Then user enter the data "https://tp.yesno.in/get-id/approve-reject" for "Approve/Reject Hook URL" field.
      Then user enter the data "https://tp.yesno2.in/get-id/approve-reject" for "Withdraw Hook URL" field.
      Then user enter the data "https://tp.yesno2.in/get-id/user-balance" for "Balance Hook URL" field.
      Then user enter the data "https://tp.yesno2.in/get-id/agent-login" for "Agent Login Hook URL" field.
      Then user enter the data "https://tp.yesno.in/get-id/agent-login" for "Manually Transaction Hook URL" field.
      Then user enter the data "https://tp.yesno42.in/get-id/agent-login" for "User Registraction Hook URL" field.
      Then user enter the data "https://tp.yesno2475.in/get-id/user-bet-status" for "User Bet Status Hook URL" field.
      Then user enter the data "slug" for "Login Slug" field.
      And click on the "Submit" button and Verify the error message for following field.
        | Login Slug | Database Name | Secret Key |
      Then user enter the data "db" for "Database Name" field.
      And click on the "Submit" button and Verify the error message for following field.
        | Secret Key |
      Then click on the  "SECRET KEY" button.
      Then click on the  "Submit" button.
      Then user enter the data on the Search.
      Then User Verify the Add Website on list
      And User will logout.

  @WebSiteList_Add_with_mandatory_field
  Scenario:Scenario_2: Add Website and verify the added website.
    Given User log in to provider URL and is already present at the website list page.
    Then click on the  "Noti Cancel" button.
    Then click on the  "Add Website" button.
    Then user enter the data "Game" for "Website Name" field.
    Then user enter the data "102.120.52.25" for "IP" field.
    Then user enter the data "https://GameRunner.com" for "URL" field.
    Then user enter the data "Edu master" for "Client name" field.
    Then user enter the data "slug" for "Login Slug" field.
    Then user enter the data "db" for "Database Name" field.
    Then click on the  "SECRET KEY" button.
    Then click on the  "Submit" button.
    Then user enter the data on the Search.
    Then User Verify the Add Website on list
    And User will logout.

  @WebsiteList_Add_using_already_used_data
  Scenario:Scenario_3: Add Website and verify the field added website.
    Given User log in to provider URL and is already present at the website list page.
    Then click on the  "Noti Cancel" button.
    Then click on the  "Add Website" button.
    Then user enter the data "Game" for "Website Name" field.
    Then user enter the data "102.120.52.25" for "IP" field.
    Then user enter the data "https://GameRunner.com" for "URL" field.
    Then user enter the data "Edu master" for "Client name" field.
    Then user enter the data "slug" for "Login Slug" field.
    Then user enter the data "db" for "Database Name" field.
    Then click on the  "SECRET KEY" button.
    Then click on the  "Submit" button.
    Then user enter the data on the Search.
    Then User Verify the Add Website on list
    Then click on the  "Add Website" button.
    Then user the already use value for "Website Name" field.
    Then click on the  "Submit" button.
    Then user the already use value for "IP" field.
    Then click on the  "Submit" button.
    Then user the already use value for "URL" field.
    Then click on the  "Submit" button.
    Then user the already use value for "Client name" field.
    Then click on the  "Submit" button.
    Then user the already use value for "Login Slug" field.
    Then click on the  "Submit" button.
    Then user the already use value for "Database Name" field.
    Then click on the  "Submit" button.
    Then click on the  "Cancel" button.
    And User will logout.

  @WebsiteList_Edit
  Scenario:Scenario_4: Edit website and verify the edited website.
    Given User log in to provider URL and is already present at the website list page.
    Then click on the  "Noti Cancel" button.
    Then enter the data value for search.
    Then click on the  "Action" button.
    Then click on the  "Edit" button.
    Then user enter the data "Game" for "Website Name" field.
    Then user enter the data "102.120.52.25" for "IP" field.
    Then user enter the data "https://GameRunner.com" for "URL" field.
    Then user enter the data "Edu master" for "Client name" field.
    Then user enter the data "https://tp.yesno.in/get-id/approve-reject" for "Approve/Reject Hook URL" field.
    Then user enter the data "https://tp.yesno2.in/get-id/approve-reject" for "Withdraw Hook URL" field.
    Then user enter the data "https://tp.yesno2.in/get-id/user-balance" for "Balance Hook URL" field.
    Then user enter the data "https://tp.yesno2.in/get-id/agent-login" for "Agent Login Hook URL" field.
    Then user enter the data "https://tp.yesno.in/get-id/agent-login" for "Manually Transaction Hook URL" field.
    Then user enter the data "https://tp.yesno42.in/get-id/agent-login" for "User Registraction Hook URL" field.
    Then user enter the data "https://tp.yesno2475.in/get-id/user-bet-status" for "User Bet Status Hook URL" field.
    Then user enter the data "slug" for "Login Slug" field.
    Then user enter the data "db" for "Database Name" field.
    Then click on the  "SECRET KEY" button.
    Then click on the  "Submit" button.
#    Then user enter the data on the Search.
    Then User Verify the Edited Website on list.
    And User will logout.

  @WebSiteDelete
  Scenario: Scenario_5:Delete website on the list.
    Given User log in to provider URL and is already present at the website list page.
    Then click on the  "Noti Cancel" button.
    Then enter the data value for search.
    Then click on the  "Action" button.
    Then click on the  "Delete" button.
    Then click on the  "Yes" button.
    Then click on the  "Ok" button.
    Then verifying the deleted site.
    Then User will logout.
    And User Close the Browser;

    @Website_Status_Change
    Scenario: Scenario_6: Change the status and varify on the list.
      Given User log in to provider URL and is already present at the website list page.
      Then click on the  "Noti Cancel" button.
      Then click on the  "Add Website" button.
      Then user enter the data "Game" for "Website Name" field.
      Then user enter the data "102.120.52.25" for "IP" field.
      Then user enter the data "https://GameRunner.com" for "URL" field.
      Then user enter the data "Edu master" for "Client name" field.
      Then user enter the data "slug" for "Login Slug" field.
      Then user enter the data "db" for "Database Name" field.
      Then click on the  "SECRET KEY" button.
      Then click on the  "Submit" button.
      Then user enter the data on the Search.
      Then User Verify the Add Website on list
      Then click on the  "Status" button.
      Then verify the status change from deactive to "active".
      Then click on the  "Status" button.
      Then verify the status change from active to "deactive".
      And User will logout.
