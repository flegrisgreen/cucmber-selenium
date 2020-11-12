Feature: Edit todo item

  Scenario: Allow the user to edit a todo item
    Given list of one or more todo items
    When user enters update in form
    And clicks Update
    Then edited todo should be visible