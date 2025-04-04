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
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.get(url);
        return driver;

    }
}
