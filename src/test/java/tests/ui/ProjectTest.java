package tests.ui;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.base.BaseTest;

public class ProjectTest extends BaseTest {

    String nameOfProject = "ProjectFromIDE";
    String announcementField = "Announcement field from IDE";
    SoftAssert softAssert = new SoftAssert();

    @Test(testName = "Check create project", description = "In this test, a project is created, " +
            "after checks it is deleted and a check for deletion")
    @Description("Check create project, then assertion main fields and after delete project with assertion")
    @Story("The QA engineer checks for create,and delete project")
    @Owner("Oleg")
    @Severity(SeverityLevel.CRITICAL)
    public void checkCreateAndDeleteProject() {
        loginPage.
                open().
                isPageOpened().
                login(user, password);

        dashboardPage
                .open()
                .isPageOpened()
                .clickAddProject()
                .inputName(nameOfProject)
                .inputAnnouncement(announcementField)
                .clickToCheckBoxShowAnnouncement()
                .clickConfirmAddProject();

        softAssert.assertEquals(overviewPage.getTitleTestCase(), nameOfProject, "Incorrect project name");
        softAssert.assertEquals(overviewPage.getAnnouncement(), announcementField, "Incorrect text");

        projectsPage.
                open().
                clickButtonDelete(nameOfProject).
                clickCheckboxDelete().
                clickOk();

        softAssert.assertEquals(projectsPage.getDeleteMessage(), "Successfully deleted the project.",
                "The was not project delete");
        softAssert.assertAll();
    }
}
