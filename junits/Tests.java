import org.junit.*;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class Tests{

    static WebDriver driver;

    // MAKE SURE TO CHANGE WHEN RUNNING THE TESTS
    static String pathChromeDriver = "/home/ellarekow/Downloads/chromedriver";
    static String loginPage = "file:///home/ellarekow/Documents/SE319/Glass Ceiling/Project/LoginPage.html";
    static String signUpPage = "file:///home/ellarekow/Documents/SE319/Glass Ceiling/Project/SignUpPage.html";
    static String specificPost = "file:///home/ellarekow/Documents/SE319/Glass Ceiling/Project/SpecificPost.html";
    static String profile= "file:///home/ellarekow/Documents/SE319/Glass Ceiling/Project/Profile.html";
    static String newPost= "file:///home/ellarekow/Documents/SE319/Glass Ceiling/Project/NewPost.html";

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

 @Test
    public void thumbs() throws InterruptedException {
        driver.get(specificPost);
        driver.manage().window().maximize();

        //thumbs up should turn green after it's clicked
        driver.findElement(By.id("thumbsup")).click();
        assertEquals("images/green.png", driver.findElement(By.id("thumbsup")).getTagName();
        
        //thumbs down should turn red after it's clicked and thumbs up should go back to gray
        driver.findElement(By.id("thumbsdown")).click();
        assertEquals("images/red.png", driver.findElement(By.id("thumbsdown")).getTagName();
        assertEquals("images/up.png", driver.findElement(By.id("thumbsup")).getTagName();
       
        //thumbs up should turn green after it's clicked and thumbs down should go back to gray
        driver.findElement(By.id("thumbsup")).click();
        assertEquals("images/green.png", driver.findElement(By.id("thumbsup")).getTagName();
        assertEquals("images/down.png", driver.findElement(By.id("thumbsdown")).getTagName();

        //thumbs up should go back to gray after it's clicked
        driver.findElement(By.id("thumbsup")).click();
        assertEquals("images/up.png", driver.findElement(By.id("thumbsup")).getTagName();
    }

@Test
    public void editProfile() throws InterruptedException {
        driver.get(profile);
        driver.manage().window().maximize();

        driver.findElement(By.id("editprof")).click();
        assertEquals("file:///home/ellarekow/Documents/SE319/Glass%20Ceiling/Project/EditProfile.html", driver.getCurrentUrl());
    }

@Test
    public void submitNewPost() throws InterruptedException {
        driver.get(newPost);
        driver.manage().window().maximize();

        driver.findElement(By.id("submit")).click();
        assertEquals("file:///home/ellarekow/Documents/SE319/Glass%20Ceiling/Project/Home.html", driver.getCurrentUrl());
    }

@Test
    public void selectProfilePic() throws InterruptedException {
        driver.get(profile);
        driver.manage().window().maximize();

        Select se = new Select(driver.findElement(By.id("pic")));

        se.selectByValue("plum");
        assertEquals("images/plum.png", driver.findElement(By.id("image")).getTagName();

        se.selectByValue("pear");
        assertEquals("images/pear.png", driver.findElement(By.id("image")).getTagName();

        se.selectByValue("pomegranate");
        assertEquals("images/pomegranate.png", driver.findElement(By.id("image")).getTagName();

        se.selectByValue("kiwi");
        assertEquals("images/kiwi.png", driver.findElement(By.id("image")).getTagName();

        se.selectByValue("blueberry");
        assertEquals("images/blueberry.png", driver.findElement(By.id("image")).getTagName();
    }

    @Test
    public void searchBar() throws InterruptedException {
        driver.get(profile);
        driver.manage().window().maximize();

        driver.findElement(By.id("search-button")).click();
        assertEquals("file:///home/ellarekow/Documents/SE319/Glass%20Ceiling/Project/SearchBar.html", driver.getCurrentUrl());
    }
}

