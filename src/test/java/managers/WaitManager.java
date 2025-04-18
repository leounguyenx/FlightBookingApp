package managers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitManager {
    WebDriver driver;

    public WaitManager(WebDriver driver) {
        this.driver = driver;
    }

    public void setImplicitWait(int duration){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
    }

    public WebDriverWait setExplicitWait(int duration){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        return wait;
    }

    public FluentWait<WebDriver> setFluentWait(int timeout, int pollingTime){
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);
        return wait;
    }

    public WebElement waitTillClickable(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

}
