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

public class multiUserStep {
    WebDriver driver = null;
    WebDriver driver2 = null;

    List<String> todosUser1 = new ArrayList<String>();

    @Given("^Multiple users in app$")
    public void multiUsers(){
        //Locate chrome driver
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path+"/src/test/resources/drivers/chromedriver.exe");

        //Create chrome driver and set properties for user 1
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        //Create chrome driver and set properties for user
        driver2 = new ChromeDriver();
        driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver2.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        //Open chrome for user 1 and user 2
        driver.get("localhost:8080");
        driver2.get("localhost:8080");
    }

    @When("^One user creates a todo")
    public void createTodo(){

        //user 1 creates a new todo
        driver.findElement(By.name("newtodo")).sendKeys("User 1 Todo item");
        driver.findElement(By.name("newtodo")).sendKeys(Keys.ENTER);

        //Save user 1's todo list
        int list_len = driver.findElements(By.className("edit-todo-form")).size();
        for(int i=0; i<list_len;i++){
            todosUser1.add(driver.findElement(By.id("span-todo-"+i)).getText());
        }

    }

    @Then("^Another user should be able to view the todo after refresh$")
    public void checkSimilarity() throws Exception {

        //Refresh user 2's browser
        driver2.navigate().refresh();

        //Save user 2's todo list
        List<String> todosUser2 = new ArrayList<String>();
        int list_len = driver2.findElements(By.className("edit-todo-form")).size();
        for(int i=0; i<list_len;i++){
            todosUser2.add(driver2.findElement(By.id("span-todo-"+i)).getText());
        }

        //If user 1 is the same as user 2, then pass, otherwise throw exception
        if(todosUser1.equals(todosUser2)){System.out.println("Todo lists are the same");}
        else{ throw new Exception("Todo lists not the same");}
    }
}
