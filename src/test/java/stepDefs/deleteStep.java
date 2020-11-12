package stepDefs;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.lang.*;
import java.util.concurrent.TimeUnit;

public class deleteStep {
    WebDriver driver = null;
    int listLen = 0;

    @Given("^a list of one or more todo items$")
    public void checkList(){
        //Locate chrome driver
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path+"/src/test/resources/drivers/chromedriver.exe");

        //Create chrome driver and set properties
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        //Open chrome
        driver.get("localhost:8080");

        //Check that list has todo items. If not add a todo
        listLen = driver.findElements(By.className("edit-todo-form")).size();
        if(listLen>0){System.out.print("List is not empty");}
        else {driver.findElement(By.name("newtodo")).sendKeys("Newly added todo");
              driver.findElement(By.name("newtodo")).sendKeys(Keys.ENTER);
        }
    }

    @When("^user clicks cross next to todo item$")
    public void clickCross(){
        //delete first item in the list
        driver.findElement(By.xpath("/html/body/ul/li[1]/form/a")).sendKeys(Keys.ENTER);
    }

    @Then("^todo item must be removed$")
    public void confirmDelete() throws Exception {

        // Check list length again. Must be 1 item shorter
        int list_len = driver.findElements(By.className("edit-todo-form")).size();
        if(list_len<listLen){System.out.print("Item was deleted");}
        else {throw new Exception("Item wasn't deleted");}
    }
}
