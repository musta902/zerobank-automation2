
Feature: Account Activity


  Background:
    Given  the user enters successful as "client_username" "client_password"
    Given the user is on the "Account Summary" page


  Scenario: Account Summary Page should have title Zero - Account activity
    When User click on "Account Activity"
    Then "Account Activity" Page should have title "Zero - Account Activity"



    Scenario: In the Account drop down default option should be Savings.
    When User click on "Account Activity"
    Then Account drop down  should have the following options
      |Savings|
      |Checking|
      |Savings |
      |Loan|
      |Credit Card|
      |Brokerage|
  @Activity
  Scenario: Transactions table should have columns Date, Description, Deposit,
    When User click on "Account Activity"
    Then "Transactions" table should have the following columns
      | Date|
      | Description|
      |Deposit|
      |Withdrawal|




