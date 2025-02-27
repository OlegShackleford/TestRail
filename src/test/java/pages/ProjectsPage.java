package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class ProjectsPage extends BasePage {

    private final static String URL = "https://qaa28.testrail.io/index.php?/admin/projects/overview";
    private final static By INPUT_NAME = By.xpath("//input[@data-testid = 'addProjectNameInput']");
    private final static By INPUT_ANNOUNCEMENT = By.xpath("//textarea[@data-testid = " +
            "'addEditProjectAnnouncement']");
    private final static By CHECKBOX_SHOW_ANNOUNCEMENT = By.xpath("//input[@data-testid = " +
            "'addEditProjectShowAnnouncement']");
    private final static By BUTTON_CONFIRM_ADD_PROJECT = By.xpath("//button[@data-testid = " +
            "'addEditProjectAddButton']");
    private final static By ANNOUNCEMENT = By.xpath("//div[@data-testid = " +
            "'projectAnnouncement']//descendant::p");
    private final static String PROJECT_TITLE = "//a[text() = '%s']";
    private final static String BUTTON_DELETE = "//a[text() = '%s']" +
            "//following::div[@data-testid = 'projectDeleteButton'][1]";
    private final static By CHECKBOX_DELETE = By.xpath("//div[@data-testid = 'caseFieldsTabDeleteDialogCheckbox']");
    private final static By BUTTON_OK = By.xpath("//a[@data-testid = 'caseFieldsTabDeleteDialogButtonOk']");
    private final static By MESSAGE_DELETE = By.xpath("//div[@data-testid = 'messageSuccessDivBox']");

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Input name {name}")
    public ProjectsPage inputName(String name) {
        log.info("Input name: {}", name);
        driver.findElement(INPUT_NAME).sendKeys(name);
        return this;
    }

    @Step("Input announcement {text}")
    public ProjectsPage inputAnnouncement(String text) {
        log.info("Input Announcement: {}", text);
        driver.findElement(INPUT_ANNOUNCEMENT).sendKeys(text);
        return this;
    }

    @Step("click to CheckBox show announcement")
    public ProjectsPage clickToCheckBoxShowAnnouncement() {
        log.info("click to CheckBox show announcement");
        driver.findElement(CHECKBOX_SHOW_ANNOUNCEMENT).click();
        return this;
    }

    @Step("Click confirm add project")
    public ProjectsPage clickConfirmAddProject() {
        log.info("click confirm AddProject");
        driver.findElement(BUTTON_CONFIRM_ADD_PROJECT).click();
        return this;
    }

    @Step("Get successes delete message")
    public String getDeleteMessage() {
        log.info("Get delete message");
        return driver.findElement(MESSAGE_DELETE).getText();
    }

    @Step("CLick button delete {projectName}")
    public ProjectsPage clickButtonDelete(String projectName) {
        log.info("CLick button delete: {}", projectName);
        driver.findElement(By.xpath(String.format(BUTTON_DELETE, projectName))).click();
        return this;
    }

    @Step("Click to checkbox OK")
    public ProjectsPage clickCheckboxDelete() {
        log.info("Click to checkbox OK");
        wait.until(ExpectedConditions.elementToBeClickable(CHECKBOX_DELETE)).click();
        return this;
    }

    @Step("CLick button OK")
    public ProjectsPage clickOk() {
        log.info("Click OK");
        driver.findElement(BUTTON_OK).click();
        return this;
    }

    @Step("Open Projects Page")
    @Override
    public ProjectsPage open() {
        log.info("Open Projects Page");
        driver.get(URL);
        return this;
    }
}
