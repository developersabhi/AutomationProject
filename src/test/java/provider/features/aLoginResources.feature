@GetIDLoginResources
Feature:GetId --> Login the ENV.
  Here we want to login the account r using the automation.

  @test @add
  @InitResources
  Scenario: Login  the env.
    Given User log in to provider URL and is already present at the website list page.
    Then click on the  "Noti Cancel" button.