package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;
    public static Properties prop = new Properties();
    public static FileReader fr;

    @BeforeTest
    public void setUp() throws IOException {
        if(driver == null){
            FileReader fr = new FileReader("src/test/java/ConfigFiles/config.properties");
            prop.load(fr);
        }
        if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(prop.getProperty("url"));
        }

        if(prop.getProperty("browser").equalsIgnoreCase("firefox")){
            WebDriverManager.chromedriver().setup();
            driver = new FirefoxDriver();
            driver.get(prop.getProperty("url"));
        }
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
