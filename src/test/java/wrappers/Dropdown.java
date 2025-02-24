package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
public class Dropdown {

    String labelPattern = "//label[normalize-space(text()) = '%s']";
    String optionPattern = "//option[text() = '%s']";

    WebDriver driver;
    WebDriverWait wait;

    public Dropdown(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public Dropdown select(String label,String option){
        log.info("Select label: {}, with option: {}",label,option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(labelPattern,label))));
        driver.findElement(By.xpath(String.format(labelPattern,label))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(optionPattern,option))));
        driver.findElement(By.xpath(String.format(optionPattern,option))).click();
        return this;
    }
}
