Feature: Todo item should never be empty

  Scenario: No todo item should be displayed if it is empty
    Given empty submission
    When submit button is clicked
    Then submission should not be saved and displayed