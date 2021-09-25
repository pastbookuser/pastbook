package Base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SingletonBrowser {
    private  static WebDriver driver;
    private  static String browser;
    private  static Properties prop = new Properties();
    private  static SingletonBrowser obj = null;
    private  static String env;

    private SingletonBrowser() {}

    public   static final SingletonBrowser getInstance() {
        if (obj == null) {
            obj = new SingletonBrowser();
        }
        return obj;
    }

    public WebDriver setDriver() {
        try{
            setEnv();
            loadProp();
            setBrowser();
            if (driver == null) {
                System.out.println("Selected Browser is "+browser);
                if (browser.equals("Firefox")) {
                    driver = new FirefoxDriver();
                } else if (browser.equals("Chrome")) {

                    //New method to create Chrome driver to avoid browser pop up
                    ChromeOptions chOption = new ChromeOptions();
                    chOption.addArguments("--disable-extensions");
                    chOption.addArguments("test-type");
                    Map<String, Object> prefs = new HashMap<String, Object>();
                    prefs.put("credentials_enable_service", false);
                    prefs.put("profile.password_manager_enabled", false);
                    chOption.setExperimentalOption("prefs", prefs);
                    System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
                    driver = new ChromeDriver(chOption);
                    System.out.println("diver open");

                }
                else if (browser.equals("IE")) {
                    System.setProperty("webdriver.ie.driver",
                            "src/test/resources/Driver/IEDriverServer.exe");
                    driver = new InternetExplorerDriver();
                } else if (browser.equals("IE11")) {
                    System.setProperty("webdriver.ie.driver",
                            "src/test/resources/Driver/IEDriverServer11.exe");
                    driver = new InternetExplorerDriver();
                }
            } else {
            }
            driver.manage().window().maximize();

        }catch(Exception e)
        {
            System.out.println("Unable to Execute SetDriver"+e.toString());
        }
        return driver;
    }

    public WebDriver getDriver() {
        return setDriver();
    }

    public void loadProp() {
        try {
            if (getEnv().equals("Prod")) {
                getProp().load(new FileInputStream("src/test/resources/TestData/testData.properties"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties getProp() {
        return prop;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv() {
        env = "Prod";
    }

    public void setBrowser() {
        browser="Chrome";
    }

}