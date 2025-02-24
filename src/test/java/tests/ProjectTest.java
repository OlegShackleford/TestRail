package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class ProjectTest extends BaseTest {

    String nameOfProject = "ProjectFromIDE";
    String announcementField = "Announcement field from IDE";

    @Test
    public void checkCreateProject(){
        loginPage.open().isPageOpened().login(user,password);

        dashboardPage
                .open()
                .isPageOpened()
                .clickAddProject()
                .inputName(nameOfProject)
                .inputAnnouncement(announcementField)
                .clickToCheckBox()
                .clickConfirmAddProject();

        Assert.assertEquals(projectsPage.getSuccessMessage(),"Successfully added the new project.");
    }
}
