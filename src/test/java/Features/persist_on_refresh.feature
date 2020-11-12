Feature: Todolist persists when the browser is refreshed

	Scenario: Refresh the browser and see if todo items persist or not
		Given list of todo items in app
		When browser is refreshed
		Then list of todo items must be unchanged