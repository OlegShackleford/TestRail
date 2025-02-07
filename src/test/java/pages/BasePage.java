package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.testng.Assert;
import tests.base.BaseTest;

import java.time.Duration;

@Log4j2
public abstract class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public abstract BasePage open();

    public BasePage isPageOpened(String pageName, By by) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (TimeoutException e) {
            log.error(pageName + " page did not open", e);
            Assert.fail(pageName + " page did not open");
        }
        return this;
    }
}
