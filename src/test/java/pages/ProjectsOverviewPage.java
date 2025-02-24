package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ProjectsOverviewPage extends BasePage{

    private final static String URL = "https://qaa28.testrail.io/index.php?/projects/overview/%s";
    protected static String id;
    private final static By ADD_TESTCASE = By.xpath("//a[@data-testid = 'sidebarCasesAdd']");
    private final static By INPUT_TITLE = By.xpath("//input[@data-testid = 'addEditCaseTitle']");
    private final static By INPUT_PRECONDITIONS = By.xpath("//div[@id = 'custom_preconds_display']");
    private final static By INPUT_STEPS = By.xpath("//div[@id = 'custom_steps_display']");
    private final static By INPUT_EXPECTED_RESULT = By.xpath("//div[@id = 'custom_expected_display']");
    private final static By BUTTON_ACCEPT_TESTCASE = By.xpath("//button[@id = 'accept']");
    private final static By TESTCASE_TITLE = By.xpath("//div[@data-testid = 'testCaseContentHeaderTitle']");
    private final static String INNER_FIELDS = "//span[text() = 'Preconditions']//following::div[@class = 'markdown'][%s]";

    public ProjectsOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Step("Modify url with id {id}")
    public String modifyUrl(String id){
        log.info("Modify url with id: {}",id);
        return String.format(URL,id);
    }

    @Override
    public ProjectsOverviewPage open() {
        log.info("Open ProjectsOverview Page");
        driver.get(modifyUrl(id));
        return this;
    }

    public ProjectsOverviewPage clickAddTestCase(){
        log.info("CLick Add TestCase");
        driver.findElement(ADD_TESTCASE).click();
        return this;
    }

    public ProjectsOverviewPage inputTitle(String title){
        log.info("Input title {}",title);
        driver.findElement(INPUT_TITLE).sendKeys(title);
        return this;
    }

    public ProjectsOverviewPage inputPreconditions(String text){
        log.info("Input preconditions {}",text);
        driver.findElement(INPUT_PRECONDITIONS).sendKeys(text);
        return this;
    }

    public ProjectsOverviewPage inputSteps(String text){
        log.info("Input steps {}",text);
        driver.findElement(INPUT_STEPS).sendKeys(text);
        return this;
    }

    public ProjectsOverviewPage inputExpectedResult(String text){
        log.info("Input ExpectedResult {}",text);
        driver.findElement(INPUT_EXPECTED_RESULT).sendKeys(text);
        return this;
    }

    public ProjectsOverviewPage clickButtonAcceptTestcase(){
        log.info("click Button Accept Testcase");
        driver.findElement(BUTTON_ACCEPT_TESTCASE).click();
        return this;
    }

    public String getTitleTestCase(){
        log.info("Get title of TestCase");
        return driver.findElement(TESTCASE_TITLE).getText();
    }

    public String getInnerFields(String number){
        log.info("Get inner field");
        return driver.findElement(By.xpath(String.format(INNER_FIELDS,number))).getText();
    }
}
