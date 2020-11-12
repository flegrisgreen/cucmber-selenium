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

public class neverEmptyStep {
    WebDriver driver = null;

    @Given("^empty submission or update$")
    public void tryEmpty(){
        //Locate chrome driver
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path+"/src/test/resources/drivers/chromedriver.exe");

        //Create chrome driver and set properties
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        //Open chrome
        driver.get("localhost:8080");
    }

    @When("^submit button is clicked$")
    public void clickSubmit(){
        //click submit while todo item is empty
        driver.findElement(By.name("newtodo")).sendKeys(Keys.ENTER);

        //Update the first todo item to be empty
        driver.findElement(By.id("edit-submit-0")).sendKeys((Keys.ENTER));
    }

    @Then("^submission should not be saved or displayed$")
    public void checkForEmpty() throws Exception {

        //Check list for empty entries
        List<String> todos = new ArrayList<String>();
        int list_len = driver.findElements(By.className("edit-todo-form")).size();
        for(int i=0; i<list_len;i++){
            todos.add(driver.findElement(By.id("span-todo-"+i)).getText());
        }
        System.out.print(todos);

        //If none empty pass, if empty entry exists throw exception
        String empty = "";
        for (String todoitem: todos) {
            if(todoitem.equals(empty)){throw new Exception("Empty todo item exists");}
        }
    }
}
