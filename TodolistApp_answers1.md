# Todo list answers

## Getting started
- The project (available at: https://github.com/flegrisgreen/cucmber-selenium/tree/master) runs a automated frontend test.
- Install Apache Maven (https://maven.apache.org/download.cgi)
- In root folder, run 'mvn install'
- Run the todo app (hosting locally on port 8080)

### Run Maven project
- Navigate to /src/test/java/stepDefs
- Run 'mvn runner.java'
- Cucumber-selenium test report available at /target/report/cucumber.html

## Maven project results
- The lastest report generated on developer machine is available at /cucumber_selenium_test_results.html

## Gherkin feature files explaining the scenarios that test the requirements of the todo app
- All the .feature Gherkin files have been assembled below. The orginal files are located at (\src\test\java\Features)

Feature: All .feature files together in one Gherkin file

	Scenario: Application can or cannot deploy in docker
		Given Docker container image
		When app is launched in docker image
		Then todolist page should be available at localhost:8081


	Scenario: Multiple users can use the app simultaneously or not
		Given Multiple users in app
		When One user creates a todo
		Then Another user should be able to view the todo after refresh


	Scenario: Refresh the browser and see if todo items persist or not
		Given list of todo items in app
		When browser is refreshed
		Then list of todo items must be unchanged


	Scenario: A todo item should not be accepted if empty
	    Given empty submission or update
	    When submit button is clicked
	    Then submission should not be saved or displayed


	Scenario: Allow the user to add a todo item to the list
		Given A todo item is entered into the submission block
		When submit is clicked
		Then todo item should be added to the list


	Scenario: Allow user to delete a todo item
		Given a list of one or more todo items
		When user clicks cross next to todo item
		Then todo item must be removed


	Scenario: Allow the user to edit a todo item
		Given list of one or more todo items
		When user enters update in form
		And clicks Update
		Then edited todo should be visible




