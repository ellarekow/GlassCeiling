import org.junit.*;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class SideBarTests{

    static WebDriver driver;

    static String pathChromeDriver = "/Users/mccle/Downloads/driver/chromedriver.exe";
    static String aboutUs = "file:///C:/Users/mccle/Desktop/glassceiling/AboutUs.html";
    static String home = "file:///C:/Users/mccle/Desktop/glassceiling/Home.html";
    static String newPost = "file:///C:/Users/mccle/Desktop/glassceiling/NewPost.html";
    static String profile = "file:///C:/Users/mccle/Desktop/glassceiling/Profile.html";
    static String search = "file:///C:/Users/mccle/Desktop/glassceiling/SearchBar.html";
    static String searchRes = "file:///C:/Users/mccle/Desktop/glassceiling/SearchResults.html";
    static String specPost = "file:///C:/Users/mccle/Desktop/glassceiling/SpecificPost.html";

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
    public void aboutToProfile() {
        driver.get(aboutUs);
        driver.manage().window().maximize();

        driver.findElement(By.id("mySidenav")).click();

        assertEquals("file:///C:/Users/mccle/Desktop/glassceiling/Profile.html", driver.getCurrentUrl());

    }

    @Test
    public void aboutToNewPost() {
        driver.get(aboutUs);
        driver.manage().window().maximize();

        driver.findElement(By.id("mySidenav")).click();

        assertEquals("file:///C:/Users/mccle/Desktop/glassceiling/NewPost.html", driver.getCurrentUrl());

    }

    @Test 
    public void homeToProfile() {
        driver.get(home);
        driver.manage().window().maximize();

        driver.findElement(By.id("mySidenav")).click();

        assertEquals("file:///C:/Users/mccle/Desktop/glassceiling/Profile.html", driver.getCurrentUrl());
    }

    @Test
    public void homeToNewPost() {
        driver.get(home);
        driver.manage().window().maximize();

        driver.findElement(By.id("mySidenav")).click();

        assertEquals("file:///C:/Users/mccle/Desktop/glassceiling/NewPost.html", driver.getCurrentUrl());
    }

    @Test
    public void homeToAbout() {
        driver.get(home);
        driver.manage().window().maximize();

        driver.findElement(By.id("mySidenav")).click();

        assertEquals("file:///C:/Users/mccle/Desktop/glassceiling/AboutUs.html", driver.getCurrentUrl());
    }

    @Test 
    public void newpostToProfile() {
        driver.get(newPost);
        driver.manage().window().maximize();

        driver.findElement(By.id("mySidenav")).click();

        assertEquals("file:///C:/Users/mccle/Desktop/glassceiling/Profile.html", driver.getCurrentUrl());
    }

    @Test
    public void newpostToAbout() {
        driver.get(newPost);
        driver.manage().window().maximize();

        driver.findElement(By.id("mySidenav")).click();

        assertEquals("file:///C:/Users/mccle/Desktop/glassceiling/AboutUs.html", driver.getCurrentUrl());
    }

    @Test 
    public void profileToNewPost() {
        driver.get(profile);
        driver.manage().window().maximize();

        driver.findElement(By.id("mySidenav")).click();

        assertEquals("file:///C:/Users/mccle/Desktop/glassceiling/NewPost.html", driver.getCurrentUrl());
    }

    @Test
    public void searchToAbout() {
        driver.get(search);
        driver.manage().window().maximize();

        driver.findElement(By.id("mySidenav")).click();

        assertEquals("file:///C:/Users/mccle/Desktop/glassceiling/AboutUs.html", driver.getCurrentUrl());

    }
    
    @Test
    public void searchToProfile() {
        driver.get(search);
        driver.manage().window().maximize();

        driver.findElement(By.id("mySidenav")).click();

        assertEquals("file:///C:/Users/mccle/Desktop/glassceiling/Profile.html", driver.getCurrentUrl());

    }

    @Test
    public void searchToNewPost() {
        driver.get(search);
        driver.manage().window().maximize();

        driver.findElement(By.id("mySidenav")).click();

        assertEquals("file:///C:/Users/mccle/Desktop/glassceiling/NewPost.html", driver.getCurrentUrl());

    }

    @Test
    public void searchResToAbout() {
        driver.get(searchRes);
        driver.manage().window().maximize();

        driver.findElement(By.id("mySidenav")).click();

        assertEquals("file:///C:/Users/mccle/Desktop/glassceiling/AboutUs.html", driver.getCurrentUrl());

    }

    @Test
    public void searchResToProfile() {
        driver.get(searchRes);
        driver.manage().window().maximize();

        driver.findElement(By.id("mySidenav")).click();

        assertEquals("file:///C:/Users/mccle/Desktop/glassceiling/Profile.html", driver.getCurrentUrl());

    }

    @Test
    public void searchResToNewPost() {
        driver.get(searchRes);
        driver.manage().window().maximize();

        driver.findElement(By.id("mySidenav")).click();

        assertEquals("file:///C:/Users/mccle/Desktop/glassceiling/NewPost.html", driver.getCurrentUrl());

    }

    @Test
    public void specPostToAbout() {
        driver.get(specPost);
        driver.manage().window().maximize();

        driver.findElement(By.id("mySidenav")).click();

        assertEquals("file:///C:/Users/mccle/Desktop/glassceiling/AboutUs.html", driver.getCurrentUrl());

    }

    @Test
    public void specPostToProfile() {
        driver.get(specPost);
        driver.manage().window().maximize();

        driver.findElement(By.id("mySidenav")).click();

        assertEquals("file:///C:/Users/mccle/Desktop/glassceiling/Profile.html", driver.getCurrentUrl());

    }

    @Test
    public void specPostToNewPost() {
        driver.get(specPost);
        driver.manage().window().maximize();

        driver.findElement(By.id("mySidenav")).click();

        assertEquals("file:///C:/Users/mccle/Desktop/glassceiling/NewPost.html", driver.getCurrentUrl());

    }



}