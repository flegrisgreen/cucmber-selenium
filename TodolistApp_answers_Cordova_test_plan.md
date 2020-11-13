# Todo list app: Cordova test plan

## Test plan for future Cordova requirement

### Assumptions:
1. Node.js is installed and working
2. Apache Cordova is installed and working with Node.js
3. Cordova project has been created and the right platform has been chosen

### High-level test steps
- Here development environment refers to the machine that is being used to develop the software. This is opposed to the remote device which refers to a device that resembles a client device.
1. Launch todo app within the Cordova project
2. Perform manual testing of the todo app for requirements 1-7 according to the scenarios listed in the test plan (available at: "https://github.com/flegrisgreen/cucmber-selenium/blob/master/TodolistApp_answers_test_plan.md"). This manual test is still within the development environment.
3. Perform automated testing, within the development environment, where possible and prioritising key functionality.
4. Perform manual testing using a remote device that uses the platform being developed for. Again, perform tests according to the scenarios listed in the test plan.