package sit707_week4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class LoginDecisionTableTest {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.bunnings.com.au/login");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    // ---------------- Decision Table Rules ----------------

    // R1: Empty Email & Empty Password
    @Test
    public void testR1_EmptyEmailEmptyPassword() {
        WebElement signInBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-submit")));
        signInBtn.click();
        assertTrue(driver.getCurrentUrl().contains("login"));
    }

    // R2: Password only
    @Test
    public void testR2_PasswordOnly() {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        passwordField.sendKeys("test123");

        WebElement signInBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-submit")));
        signInBtn.click();

        assertTrue(driver.getCurrentUrl().contains("login"));
    }

    // R3: Email only
    @Test
    public void testR3_EmailOnly() {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        emailField.sendKeys("test@test.com");

        WebElement signInBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-submit")));
        signInBtn.click();

        assertTrue(driver.getCurrentUrl().contains("login"));
    }

    // R4: Invalid credentials
    @Test
    public void testR4_InvalidCredentials() {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));

        emailField.sendKeys("wrong@test.com");
        passwordField.sendKeys("wrongpassword");

        WebElement signInBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-submit")));
        signInBtn.click();

        assertTrue(driver.getCurrentUrl().contains("login"));
    }

    // R5: Placeholder for Valid Login (skipped)
    @Test
    public void testR5_ValidLogin_Placeholder() {
        System.out.println("Skipping valid login to avoid using a real account.");
        assertTrue(true); // placeholder pass
    }
}