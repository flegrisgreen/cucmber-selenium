Feature: Add a todo item

  Scenario: Allow the user to add a todo item to the list
    Given A todo item is entered into the submission block
    When submit is clicked
    Then todo item should be added to the list