package stepDefs;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.lang.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

public class addTodoStep {

    WebDriver driver = null;

    @Given("^A todo item is entered into the submission block$")
    public void addItem(){

        //Locate chrome driver
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path+"/src/test/resources/drivers/chromedriver.exe");

        //Create chrome driver and set properties
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        //Open chrome
        driver.get("localhost:8080");

        //Write a todo in the submission block
        driver.findElement(By.name("newtodo")).sendKeys("Newly added todo");
    }

    @When("^submit is clicked$")
    public void clickSubmit(){

        //Click the submit button to add the todo item
        driver.findElement(By.name("newtodo")).sendKeys(Keys.ENTER);
    }

    @Then("^todo item should be added to the list$")
    public void findTodo() throws Exception {

        //Check the length of the todo list. If longer than 0 items were added
        int list_len = driver.findElements(By.className("edit-todo-form")).size();
        if(list_len>0){System.out.print("List is not empty");}
        else {throw new Exception("List is empty");}
    }
}
