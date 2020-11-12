package stepDefs;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.time.Duration;
import java.lang.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

public class persistStep {

    WebDriver driver = null;
    List<String> todos = new ArrayList<String>();

    @Given("^list of todo items in app$")
    public void listOfTodoItemsInApp(){

        //Locate chrome driver
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path+"/src/test/resources/drivers/chromedriver.exe");

        //Create chrome driver and set properties
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        //Open chrome
        driver.get("localhost:8080");

        //Populate todo list with three random items
        for(int i=0; i<3; i++){
            driver.findElement(By.name("newtodo")).sendKeys("Todo number "+ i);
            driver.findElement(By.name("newtodo")).sendKeys(Keys.ENTER);
        }

        //Save todo items to a list
        int list_len = driver.findElements(By.className("edit-todo-form")).size();
        for(int i=0; i<list_len;i++){
            todos.add(driver.findElement(By.id("span-todo-"+i)).getText());
        }
        System.out.print(todos);
    }

    @When("browser is refreshed")
    public void browserIsRefreshed() {
        
        //Refresh browser
        driver.navigate().refresh();
        System.out.println("refresh");
    }

    @Then("list of todo items must be unchanged")
    public void listOfTodoItemsMustBeUnchanged() throws Exception {

        System.out.println("check lists");

        //Save todo list after browser refresh
        List<String> todos_ref = new ArrayList<String>();
        int list_len = driver.findElements(By.className("edit-todo-form")).size();
        for(int i=0; i<list_len;i++){
            todos_ref.add(driver.findElement(By.id("span-todo-"+i)).getText());
        }
        System.out.print(todos);

        // Check that the todo lists are equal; if not throw exception
        if (todos.equals(todos_ref)) {
            System.out.print("Lists are equal");
            }
        else {throw new Exception("Lists not equal");}
        }
    }

