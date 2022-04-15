import org.junit.*;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class Tests{

    static WebDriver driver;

    // MAKE SURE TO CHANGE WHEN RUNNING THE TESTS
    static String pathChromeDriver = "/home/ellarekow/Downloads/chromedriver";
    static String loginPage = "file:///home/ellarekow/Documents/SE319/Glass Ceiling/Project/LoginPage.html";
    static String signUpPage = "file:///home/ellarekow/Documents/SE319/Glass Ceiling/Project/SignUpPage.html";

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
        driver.get(loginPage);
        driver.manage().window().maximize();

        driver.findElement(By.name("username")).sendKeys("aUserName");
        driver.findElement(By.name("password")).sendKeys("aPassWord1234");

        driver.findElement(By.id("submit")).click();

        assertEquals("file:///home/ellarekow/Documents/SE319/Glass%20Ceiling/Project/Home.html", driver.getCurrentUrl());

    }

    @Test
    public void loginFails() throws InterruptedException {
        driver.get(loginPage);
        driver.manage().window().maximize();

        driver.findElement(By.name("username")).sendKeys("");
        driver.findElement(By.name("password")).sendKeys("");

        driver.findElement(By.id("submit")).click();

        assertEquals("Please enter valid credentials", driver.findElement(By.id("labelNotifyuname")).getText());
        assertEquals("Please enter valid credentials", driver.findElement(By.id("labelNotifypword")).getText());

    }

    @Test
    public void signUpSuccess() throws InterruptedException {
        driver.get(signUpPage);
        driver.manage().window().maximize();

        driver.findElement(By.name("username")).sendKeys("aUserName");
        driver.findElement(By.name("email")).sendKeys("aEmail@email.com");
        driver.findElement(By.name("password")).sendKeys("aPassWord1234");
        driver.findElement(By.name("confirm_password")).sendKeys("aPassWord1234");

        driver.findElement(By.id("submit")).click();

        assertEquals("file:///home/ellarekow/Documents/SE319/Glass%20Ceiling/Project/Home.html", driver.getCurrentUrl());
    }

    @Test
    public void signUpFails() throws InterruptedException {
        driver.get(signUpPage);
        driver.manage().window().maximize();

        driver.findElement(By.name("username")).sendKeys("");
        driver.findElement(By.name("email")).sendKeys("");
        driver.findElement(By.name("password")).sendKeys("");
        driver.findElement(By.name("confirm_password")).sendKeys("");

        driver.findElement(By.id("submit")).click();

        assertEquals("Please enter valid credentials", driver.findElement(By.id("labelNotifyuname")).getText());
        assertEquals("Please enter valid credentials", driver.findElement(By.id("labelNotifyeml")).getText());
        assertEquals("Please enter valid credentials", driver.findElement(By.id("labelNotifypword")).getText());
        assertEquals("Please enter valid credentials", driver.findElement(By.id("labelNotifypwordc")).getText());
    }

}