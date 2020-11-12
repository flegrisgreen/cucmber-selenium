Feature: Test if application deploys in docker

Scenario: Application can or cannot deploy in docker
	Given: Docker container image
	When: I Launch program in docker image
	Then: Program should run successfully (render Todolist page)