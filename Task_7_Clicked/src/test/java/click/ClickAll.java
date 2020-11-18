package click;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;



public class ClickAll {
    private WebDriver driver;
    private WebDriverWait wait;
    @Before
    public void start(){
        driver = new ChromeDriver();

        wait = new WebDriverWait(driver,1000);
    }
    @Test
    public void myFirstTest() throws InterruptedException {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        Thread.sleep(500);
        List<WebElement> ListElement = driver.findElements(By.id("app-"));
        List<WebElement> subListElement;
        int sizeList = ListElement.size();
        for (int i = 0; i < sizeList; i++) {
            ListElement.get(i).findElement(By.tagName("a")).click();
            ListElement = driver.findElements(By.id("app-"));
            subListElement = ListElement.get(i).findElements(By.cssSelector("[id ^= doc-]"));
            int kk= subListElement.size();
            for (int j = 0; j < kk; j++) {
                subListElement.get(j).click();
                driver.findElement(By.tagName("h1"));
                ListElement = driver.findElements(By.id("app-"));
                subListElement = ListElement.get(i).findElements(By.cssSelector("[id ^= doc-]"));
            }
            ListElement = driver.findElements(By.id("app-"));
        }
    }
    @After
    public void stop(){

        driver.quit();
        driver = null;
    }
}
