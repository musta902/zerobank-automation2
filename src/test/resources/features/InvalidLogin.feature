Feature: invalid credentials

   @NgativeLogin
 Scenario Outline: : The user should NOT be able to login with invalid credential
    Then the user should NOT be able to login with invalid credentials "<username>" "<password>"
    Examples:
      | username         | password         |
      | username         | invalid password |
      | invalid username | password         |
      | username         | blank password   |
      | blank username   | password         |