Feature:
  Scenario: I can add a valid book to Book Store
    Given I initialize Book Store
    Given I create new Book with valid parameters
    When I add book to the Book Store
    Then I book is present in the Book Store

  Scenario: I can add a valid book to Book Store
    Given I initialize Book Store
    Given I create new Book with valid parameters
    When I add book to the Book Store
    Then I book is present in the Book Store
    And I change Books Title
    Then Title is changed