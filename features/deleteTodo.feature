Feature: Delete a todo item

  Scenario: Allow user to delete a todo item
    Given a list of one or more todo items
    When user clicks cross next to todo item
    Then todo item must be removed