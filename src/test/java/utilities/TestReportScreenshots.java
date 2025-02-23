package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class TestReportScreenshots {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Generate timestamp for uniqueness
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String testStepName = "test_report_";

        // Define the screenshot name
        String screenshotName = testStepName + timestamp + ".png";

        try {
            // Path to local HTML file
            //Ensure the file is existed
            File file = new File("target/report/html-report.html");
            //Convert local path to URL format with absolute path
            String reportPath = "file:///" + file.getAbsolutePath();
            driver.get(reportPath);
            driver.manage().window().maximize();

            // Take a screenshot
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            System.out.println("Took screenshot!");
            File destinationFile = new File("./src/test/screenshots/" + screenshotName);
            FileHandler.copy(screenshot, destinationFile);
            System.out.println("Saved a sreenshot: " + screenshotName + " to screenshot folder");

            //String screenshotPath = "test-report.png";
            //File destination = new File(screenshotPath);
            //screenshot.renameTo(destination);

            // Upload to AWS S3
            //uploadToS3(destination);

            System.out.println("Screenshot captured and uploaded successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

}
