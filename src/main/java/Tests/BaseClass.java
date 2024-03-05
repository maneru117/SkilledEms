package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseClass {

    WebDriver driver;
    public Logger logger;
    public Properties p;

    @BeforeClass(groups = {"regression", "sanity", "master"})
    @Parameters({"browser"})
    public void setup(String br) throws IOException {
        /*FileReader file=new FileReader("C:\\Users\\DELL\\Downloads\\SkilledEms\\resources\\ Config.Properties");
        p = new Properties();
        p.load(file);
        if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {

            DesiredCapabilities capabilities = new DesiredCapabilities();

            //os
            if (os.equalsIgnoreCase("windows")) {
                capabilities.setPlatform(Platform.WIN11);
            } else if (os.equalsIgnoreCase("mac")) {
                capabilities.setPlatform(Platform.MAC);
            } else {
                System.out.println("No matching os..");
                return;
            }

            logger = LogManager.getLogger(this.getClass());
            if (br.equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (br.equals("edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

        } else if (p.getProperty("execution_env").equalsIgnoreCase("local")) {

            switch (br.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                default:
                    System.out.println("No matching browser..");
                    return;
            }
        }*/
        logger = LogManager.getLogger(this.getClass());
        if (br.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (br.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://minidemo.skilledems.com/login");
    }


    @AfterClass(groups = {"regression", "sanity", "master"})
    public void close() {
        driver.quit();
    }

    public String randomsString() {
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        return generatedString;
    }

    public String randomsNumber() {
        String generatedString = RandomStringUtils.randomNumeric(10);
        return generatedString;
    }

    public String randomsAlphabeticNumber() {
        String str = RandomStringUtils.randomAlphabetic(5);
        String strn = RandomStringUtils.randomAlphanumeric(3);
        return str + "@" + strn;
    }

    public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;
    }
}
