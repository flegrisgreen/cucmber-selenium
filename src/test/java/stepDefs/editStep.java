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

public class editStep {
    WebDriver driver = null;
    int listLen = 0;

    @Given("^list of one or more todo items$")
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
        if(listLen>0){System.out.println("List is not empty");}
        else {
            driver.findElement(By.name("newtodo")).sendKeys("Newly added todo");
            driver.findElement(By.name("newtodo")).sendKeys(Keys.ENTER);
        }
    }

    @When("^user enters update in form$")
    public void enterEdit(){
        //enter updated todo item in first todo item's form
        driver.findElement(By.id("edittodo-0")).sendKeys("Newly edited todo");
    }

    @And("^clicks Update$")
    public void clickUpdate(){
        //enter updated todo item in first todo item's form
        driver.findElement(By.id("edittodo-0")).sendKeys(Keys.ENTER);
    }

    @Then("^edited todo should be visible$")
    public void checkEdit() throws Exception {

        // Check that first item in list was edited
        String editContent = driver.findElement(By.id("span-todo-0")).getText();
        System.out.println(editContent);
        if(editContent=="Newly edited todo"){System.out.print("Item was edit");}
        else {throw new Exception("Item wasn't edited right");}
    }
}
