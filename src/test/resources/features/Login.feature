@Login
Feature:Users login with

@ru
  Scenario:Only authorized users login the application
    Given the user is on the login page
    When the user enters the valid credentials as "client_username" "client_password"
    Then the user should be able to login
    Then the title "Zero - Account Summary"

    Scenario:Users with wrong username or wrong password should not be able to login
      Given  Given the user is on the login page
      When the user enters the invalid credentials as "client_username1" "client_password1"
      Then the user should not be able to login
      Then error message Login and or password are wrong should be displayed.















