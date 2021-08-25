


Feature: Account Summary


  Background:
    Given  the user enters successful as "client_username" "client_password"
    Given the user is on the "Account Summary" page

  @aSummary
  Scenario: Account Summary Page should have title Zero - Account Summary
    Then "Account Summary" Page should have title "Zero - Account Summary"


  Scenario: Account summary page should have the following account types: Cash Accounts, Investment Accounts, Credit Accounts, Loan Accounts.
    Then Account summary page should have the following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |


  Scenario: Credit Accounts table should have columns Account, Credit Card and Balance
    Then "Credit Account" table should have the following columns
      | Account     |
      | Credit Card |
      | Balance     |


  Scenario Outline: The user should be able to redirect to the selected account activity page
    When the user clicks on "<Account Type>" link on the Account Summary page
    Then "Account Type" should be selected on the Account Activity page
    Examples:
      | Account Type |
      | Savings      |
      | Brokerage    |
      | Checking     |
      | Credit Card  |
      | Loan         |
