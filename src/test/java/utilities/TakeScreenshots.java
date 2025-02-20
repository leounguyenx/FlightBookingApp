package utilities;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class TakeScreenshots {
    WebDriver driver;
    public TakeScreenshots(WebDriver driver) {
        this.driver = driver;
    }

    public void takeScreenshot() throws AWTException, IOException {
        Robot robot = new Robot();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rectangle = new Rectangle(dimension);
        BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
        //String screenshotPath = "./src/test/Screenshots/screenshot2.png";
        ImageIO.write(bufferedImage, "png", new File("./src/test/screenshots/robot.png"));

    }
}
