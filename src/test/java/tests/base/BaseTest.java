package tests.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AdministrationPage;
import pages.DashboardPage;
import pages.LoginPage;
import utils.AllureUtils;
import utils.PropertyReader;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public LoginPage loginPage;
    public DashboardPage dashboardPage;
    public AdministrationPage administrationPage;

    protected final String user = System.getProperty("user", PropertyReader.getProperty("user"));
    protected final String password = System.getProperty("password", PropertyReader.getProperty("password"));

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        administrationPage = new AdministrationPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            AllureUtils.takeScreenshot(driver);
        }
        if (driver != null) {
            driver.quit();
        }
    }
}
