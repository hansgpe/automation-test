import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class TestSelenium {
    WebDriver driver;
    String baseUrl;
    JavascriptExecutor jsExecutor;

    public TestSelenium() {
        System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
//		WebDriver driver=new FirefoxDriver();
        driver = new ChromeDriver();
        jsExecutor = (JavascriptExecutor) driver;
        baseUrl="http://localhost:3000/shows";
    }
    public static void main(String[] args ) {
        test1 t1=new test1();
        t1.navigate();
        t1.css();







    }

    public void search() {
        String search="Batman";
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).sendKeys(search);
        driver.findElement(By.cssSelector(".btn")).click();
    }

    public void navigate() {
        this.search();
        driver.findElement(By.xpath("//div[2]/div/div/div")).click();

        driver.manage().timeouts();
        driver.navigate().back();
    }

    public void css() {
        this.search();
        WebElement div=driver.findElement(By.xpath("//*[contains (text(),'Batman Unlimited')]"));
        WebElement divpadre=div.findElement(By.xpath("parent::div"));
        divpadre.click();
        String script=String.format("%s.style.backgroundColor='#4a148c'", divpadre.getTagName());
        System.out.println(script);
        jsExecutor.executeScript(script);
        driver.findElement(By.tagName("a"));
    }
}
