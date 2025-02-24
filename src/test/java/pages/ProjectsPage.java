package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ProjectsPage extends BasePage{

    private final static String URL = "https://qaa28.testrail.io/index.php?/admin/projects/overview";
    private final static By INPUT_NAME = By.xpath("//input[@data-testid = 'addProjectNameInput']");
    private final static By INPUT_ANNOUNCEMENT = By.xpath("//textarea[@data-testid = " +
            "'addEditProjectAnnouncement']");
    private final static By CHECKBOX_SHOW_ANNOUNCEMENT = By.xpath("//input[@data-testid = " +
            "'addEditProjectShowAnnouncement']");
    private final static By BUTTON_CONFIRM_ADD_PROJECT = By.xpath("//button[@data-testid = " +
            "'addEditProjectAddButton']");
    private final static By SUCCESS_MESSAGE = By.xpath("//div[@data-testid = 'messageSuccessDivBox']");
    private final static By PROJECT_TITLE = By.xpath("//div[@data-testid = 'testCaseContentHeaderTitle']");
    private final static By ANNOUNCEMENT = By.xpath("//div[@data-testid = " +
            "'projectAnnouncement']//descendant::p");
    private final static String LINK_TO_PROJECT_NAME = "//a[text() = '%s']";


    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    public ProjectsPage inputName(String name){
        log.info("Input name: {}",name);
        driver.findElement(INPUT_NAME).sendKeys(name);
        return this;
    }

    public ProjectsPage inputAnnouncement(String text){
        log.info("Input Announcement: {}",text);
        driver.findElement(INPUT_ANNOUNCEMENT).sendKeys(text);
        return this;
    }

    public ProjectsPage clickToCheckBox(){
        log.info("click To CheckBox");
        driver.findElement(CHECKBOX_SHOW_ANNOUNCEMENT).click();
        return this;
    }

    public ProjectsPage clickConfirmAddProject(){
        log.info("click confirm AddProject");
        driver.findElement(BUTTON_CONFIRM_ADD_PROJECT).click();
        return this;
    }

    public String getSuccessMessage(){
        log.info("Get success message");
        return driver.findElement(SUCCESS_MESSAGE).getText();
    }

    @Step("Open Projects Page")
    @Override
    public ProjectsPage open() {
        log.info("Open Projects Page");
        driver.get(URL);
        return this;
    }
}
