package tests.api;

import dto.CreateProjectRq;
import dto.CreateProjectRs;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static adapters.ProjectApi.*;

public class ProjectTestApi {

    public String name = "Test Api from IDE";
    public String announcement = "Test description from api";
    public boolean showAnnouncement = true;
    public int suiteMode = 2;
    SoftAssert softAssert = new SoftAssert();

    @Test(testName = "Сheck сreate, get, delete project", description = "This test contains the logic of the CRUD test")
    @Description("Test create project, get and delete")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Oleg")
    @Story("The QA engineer checks for create,read and delete project")
    public void checkСreateGetDeleteProject() {
        CreateProjectRq projectRq = CreateProjectRq.builder().
                name(name).
                announcement(announcement).
                showAnnouncement(showAnnouncement).
                suiteMode(suiteMode).
                build();

        CreateProjectRs createResponse = createProjectWithApi(projectRq);

        getProjectWithApi(createResponse.getId());

        softAssert.assertEquals(createResponse.getName(), name, "Incorrect project name");
        softAssert.assertEquals(createResponse.getAnnouncement(), announcement, "Incorrect announcement");
        softAssert.assertAll();

        deleteProjectWithApi(createResponse.getId());
    }
}
