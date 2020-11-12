Feature: Todo item should never be empty

  Scenario: A todo item should not be accepted if empty
    Given empty submission or update
    When submit button is clicked
    Then submission should not be saved or displayed