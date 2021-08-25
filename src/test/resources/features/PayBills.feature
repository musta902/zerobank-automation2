@run
Feature: Pay Bills

    Background:
        When the user enters the valid credentials as "client_username" "client_password"
        Then click on the pay Bills tab
        Then "Pay Bills" Page should have title "Zero - Pay Bills"
        When click on the pay Bills tab
        Then select Payee drop down Bank of America box "Bank of America"
        Then select Account type Saving "Saving"
        Then Fill out Amount



    Scenario Outline:get the result message
        And  Write date box any date
        And Fill out description
        And Click pay button
        And get "<submit message>"
        When date box is blank
        And Fill out description
        And Click pay button
        And get "<error message>"

        Examples:
               | submit message                       | error message                     |
               | The payment was successfully submitted | Please fill out this field message! |


























