Feature: Test that multiple user can use app simultaneously

Scenario: Multiple users can use the app simultaneously or not
	Given: Multiple users in app
	When: One user creates a todo
	Then: Another user should be able to view the todo (after refreshing browser)