package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {
    static  WebDriver driver;
    static String browserName = "chrome";
    static String url = "https://www.phptravels.net/";

    public static WebDriver init() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
    public static WebDriver headlessInit() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless=new"); // modern headless mode
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("window-size=1920,1080");

        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.get(url);
        return driver;
    }
}
