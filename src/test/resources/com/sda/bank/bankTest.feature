Feature:
  Scenario: I add new user
    Given I initialize bank
    When  I create user with name: Mat and pesel: 123
    Then I add user to the Bank
    And I assure user is in the bank


  Scenario: I cannot duplicate user in the bank
    Given I initialize bank
    When  I create user with name: Mat and pesel: 123
    And I add user to the Bank
    When  I create user with name: Mat and pesel: 123
    And I add user to the Bank
    Then I assure user is not in the bank

    Scenario: I can create account for existing user
      Given I initialize bank
      And  I create user with name: Mat and pesel: 123
      And I add user to the Bank
      And I create an konto oszczędnościowe account
      When I add account to user
      Then I can see an account was added

      Scenario: I cannot duplicate acccount for user
        Given I initialize bank
        And  I create user with name: Mat and pesel: 123
        And I add user to the Bank
        When I add konto oszczędnościowe account to user
        And I add konto oszczędnościowe account to user
       Then I can see communicate that i cant duplicate an account

  Scenario: I can not create account for not existing user
    Given I initialize bank
    And I create an konto oszczędnościowe account
    When I try to add account to user
    Then I can see an account was not added

  Scenario: I can deposit money for account for existing user
    Given I mock database for this case
    Given I initialize bank
    And  I create user with name: Mat and pesel: 123
    And I add user to the Bank
    And I create an konto oszczędnościowe account
    And I add account to user
    When I deposit 100 usd to an account
    Then I see money was deposited