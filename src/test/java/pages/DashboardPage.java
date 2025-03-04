package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class DashboardPage extends BasePage {

    private final static String URL = "https://qaa28.testrail.io/index.php?/dashboard";
    private final static By BUTTON_ADD_PROJECT = By.xpath("//a[@data-testid = 'sidebarProjectsAddButton']");
    private final static By BUTTON_ADMINISTRATION = By.xpath("//a[@id = 'navigation-admin']");
    private final static String LINK_TO_PROJECT = "//a[text() = '%s']";

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Dashboard page")
    @Override
    public DashboardPage open() {
        log.info("Open Dashboard page");
        driver.get(URL);
        return this;
    }

    @Step("Is Dashboard page opened")
    public DashboardPage isPageOpened() {
        log.info("Is Dashboard page opened");
        super.isPageOpened("Dashboard page", BUTTON_ADD_PROJECT);
        return this;
    }

    @Step("CLick AddProject")
    public ProjectsPage clickAddProject() {
        log.info("CLick AddProject");
        driver.findElement(BUTTON_ADD_PROJECT).click();
        return new ProjectsPage(driver);
    }

    @Step("Click Administration")
    public DashboardPage clickAdministration() {
        log.info("Click Administration");
        driver.findElement(BUTTON_ADMINISTRATION).click();
        return this;
    }

    @Step("Click to project")
    public DashboardPage clickToProject(String name){
        log.info("Click to project");
        String path = String.format(LINK_TO_PROJECT,name);
        driver.findElement(By.xpath(path)).click();
        return this;
    }
}
