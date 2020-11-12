Feature: Edit todo item

  Scenario: Allow the user to edit a todo item
    Given a list of one or more todo items
    When user selects a todo item
    Then user should be able to edit the todo item