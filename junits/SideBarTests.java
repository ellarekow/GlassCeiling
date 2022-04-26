import org.junit.*;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class SideBarTests{

    static WebDriver driver;

    // TESTING SIDE BAR FUNCTIONALITY 
    // About Us
    // Home 
    // New Post
    // Profile
    // Search Bar
    // Search Results
    // Specific Post
    static String pathChromeDriver = "/Users/mccle/Downloads/driver/chromedriver.exe";
    static String aboutUs = "file:///C:/Users/mccle/Desktop/glassceiling/AboutUs.html";

    @BeforeClass
    public static void openBrowser() {
        System.setProperty("webdriver.chrome.driver", pathChromeDriver);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterClass
    public static void closeBrowser() {
        driver.quit();
    }

    @Test
    public void loginSuccess() throws InterruptedException {
        driver.get(aboutUs);
        driver.manage().window().maximize();

        // side bar profile button click 
        // should lead to Profile page
        // TODO: get button click test

        assertEquals("file:///C:/Users/mccle/Desktop/glassceiling/Profile.html", driver.getCurrentUrl());

    }


}