package sit707_week1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Dimension;

/**
 * Ready-to-use SeleniumOperations for SIT333 Task 1-2P
 * Works with Selenium 4 and Mac ChromeDriver
 */
public class SeleniumOperations {

    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Task 1
    public static void open_chrome_and_close() {
        System.setProperty("webdriver.chrome.driver", "/Users/michaelmorks/Desktop/java_projects/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*"); // fix for Mac ARM64
        System.out.println("Fire up chrome browser.");
        WebDriver driver = new ChromeDriver(options);
        System.out.println("Driver info: " + driver);
        sleep(5);
        driver.close();
    }

    // Task 2
    public static void open_chrome_maximize_close() {
        System.setProperty("webdriver.chrome.driver", "/Users/michaelmorks/Desktop/java_projects/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.out.println("Fire up chrome browser.");
        WebDriver driver = new ChromeDriver(options);
        System.out.println("Driver info: " + driver);
        sleep(5);
        driver.manage().window().maximize();
        sleep(5);
        driver.close();
    }

    // Task 3
    public static void load_web_page_close() {
        System.setProperty("webdriver.chrome.driver", "/Users/michaelmorks/Desktop/java_projects/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.out.println("Fire up chrome browser.");
        WebDriver driver = new ChromeDriver(options);
        System.out.println("Driver info: " + driver);
        sleep(5);
        driver.get("https://selenium.dev");
        System.out.println("Loaded Selenium homepage.");
        sleep(5);
        driver.close();
    }

    // Task 4 — Completed and ready to run
    public static void open_chrome_loadpage_resize_close() {
        System.out.println("Hello from 12345678, Michael Morks"); // replace with your student ID

        System.setProperty("webdriver.chrome.driver", "/Users/michaelmorks/Desktop/java_projects/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        System.out.println("Driver info: " + driver);

        sleep(2);

        // Load Google page
        driver.get("https://www.google.com");
        System.out.println("Loaded Google homepage.");

        // Resize to 640x480
        driver.manage().window().setSize(new Dimension(640, 480));
        System.out.println("Resized window to 640x480.");
        sleep(2);

        // Resize to 1280x960
        driver.manage().window().setSize(new Dimension(1280, 960));
        System.out.println("Resized window to 1280x960.");
        sleep(2);

        // Close browser
        driver.close();
        System.out.println("Chrome closed.");
    }
}
