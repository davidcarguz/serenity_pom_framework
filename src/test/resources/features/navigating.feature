@navigating
  Feature: test feature to test navigation in site

    @successful_login
    Scenario: Successfully login into app
      Given User navigates to launch page
      When User enters username "standard_user" and password "secret_sauce"
      Then User validates correct login

    @wrong_password
    Scenario: wrong password login
      Given User navigates to launch page
      When User enters username "standard_user" and password "asd123"
      Then User validates error message "Epic sadface: Username and password do not match any user in this service"