package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements
 * and perform registration tests on Officeworks and Selenium Practice Form.
 * 
 * @author Michael
 */
public class SeleniumOperations {

    // Simple sleep method
    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // ------------------------------
    // Officeworks Registration Test
    // ------------------------------
    public static void officeworks_registration_page(String url) {
        System.setProperty("webdriver.chrome.driver", "/Users/michaelmorks/Desktop/java_projects/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(url);
        sleep(2);

        // Fill form
        driver.findElement(By.id("firstname")).sendKeys("Michael");
        driver.findElement(By.id("lastname")).sendKeys("Morks");
        driver.findElement(By.id("email")).sendKeys("test123@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123");       // weak password
        driver.findElement(By.id("confirmPassword")).sendKeys("123"); // confirm weak password

        // Click Create Account
        WebElement createBtn = driver.findElement(By.xpath("//button[contains(text(),'Create account')]"));
        createBtn.click();

        // Sleep so you can take screenshot manually
        sleep(5);

        // Keep browser open for manual screenshot
        // driver.close();
    }

    // ------------------------------
    // Selenium Practice Form Test
    // ------------------------------
    public static void selenium_practice_form(String url) {
        System.setProperty("webdriver.chrome.driver", "/Users/michaelmorks/Desktop/java_projects/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(url);
        sleep(2);

        // Fill in text fields
        driver.findElement(By.name("firstname")).sendKeys("Michael");
        driver.findElement(By.name("lastname")).sendKeys("Morks");
        driver.findElement(By.name("email")).sendKeys("test123@gmail.com");

        // Select gender radio button
        driver.findElement(By.id("sex-0")).click();

        // Select experience radio button
        driver.findElement(By.id("exp-2")).click();

        // Fill date
        driver.findElement(By.id("datepicker")).sendKeys("26/02/2026");

        // Check Profession checkbox
        driver.findElement(By.id("profession-0")).click();

        // Click Submit button
        driver.findElement(By.id("submit")).click();

        // Sleep so you can manually take screenshot
        sleep(5);

        // Keep browser open for manual screenshot
        // driver.close();
    }
}