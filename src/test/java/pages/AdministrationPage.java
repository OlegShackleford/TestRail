package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AdministrationPage extends BasePage {

    private final static String URL = "https://qaa28.testrail.io/index.php?/admin/overview";
    private final static By BUTTON_OVERVIEW = By.xpath("//a[@id = 'navigation-sub-overview']");
    private final static By BUTTON_PROJECTS = By.xpath("//a[@id = 'navigation-sub-projects']");
    private final static By BUTTON_USERS_AND_ROLES = By.xpath("//a[@id = 'navigation-sub-users']");

    public AdministrationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Administration page ")
    @Override
    public AdministrationPage open() {
        log.info("Open AdministrationPage");
        driver.get(URL);
        return this;
    }

    @Step("Is Administration page opened")
    public AdministrationPage isPageOpened() {
        log.info("Is Administration page opened");
        super.isPageOpened("Administration", BUTTON_PROJECTS);
        return this;
    }

    @Step("Click button Overview")
    public AdministrationPage clickButtonOverview() {
        log.info("Click button Overview");
        driver.findElement(BUTTON_OVERVIEW).click();
        return this;
    }

    @Step("Click button Projects")
    public AdministrationPage clickButtonProjects() {
        log.info("click button Projects");
        driver.findElement(BUTTON_PROJECTS).click();
        return this;
    }

    @Step("Click button UsersAndRoles")
    public AdministrationPage clickButtonUsersAndRoles() {
        log.info("Click button UsersAndRoles");
        driver.findElement(BUTTON_USERS_AND_ROLES).click();
        return this;
    }
}
