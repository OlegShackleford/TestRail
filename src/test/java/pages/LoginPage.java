package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final static String URL = "https://qaa28.testrail.io/index.php?/auth/login";
    private final static By INPUT_EMAIL = By.xpath("//input[@id = 'name']");
    private final static By INPUT_PASSWORD = By.xpath("//input[@id = 'password']");
    private final static By BUTTON_LOGIN = By.xpath("//button[@data-testid = 'loginButtonPrimary']");

    @Step("Open login page")
    @Override
    public LoginPage open() {
        log.info("Open login page");
        driver.get(URL);
        return this;
    }

    @Step("Is Login page opened")
    public LoginPage isPageOpened() {
        log.info("Is login page opened");
        super.isPageOpened("Login", BUTTON_LOGIN);
        return this;
    }

    @Step("Login with credentials: {email} , {password}")
    public LoginPage login(String email, String password) {
        log.info("Login with credentials: {} , {}", email, password);
        driver.findElement(INPUT_EMAIL).sendKeys(email);
        driver.findElement(INPUT_PASSWORD).sendKeys(password);
        driver.findElement(BUTTON_LOGIN).click();
        return this;
    }
}
