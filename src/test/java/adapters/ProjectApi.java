package adapters;

import dto.CreateProjectRq;
import dto.CreateProjectRs;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static io.restassured.RestAssured.given;

@Log4j2
public class ProjectApi extends BaseApi {

    @Step("Create project with API")
    public static CreateProjectRs createProjectWithApi(CreateProjectRq projectRq) {
        log.info("Create project with api , {}, {}", projectRq.getName(), projectRq.getId());
        return
                given()
                        .spec(spec)
                        .body(gson.toJson(projectRq))
                        .when()
                        .post(URL + "add_project")
                        .then().statusCode(200)
                        .log()
                        .body()
                        .extract().as(CreateProjectRs.class);
    }

    @Step("Get project with id {id}. API test")
    public static CreateProjectRs getProjectWithApi(int id) {
        log.info("Get Project With Api ,{}", id);
        return
                given()
                        .spec(spec)
                        .when()
                        .get(URL + "get_project/" + id)
                        .then()
                        .log()
                        .body()
                        .extract().as(CreateProjectRs.class);
    }

    @Step("Delete project with id:{id}. API test")
    public static void deleteProjectWithApi(int id) {
        log.info("Delete Project With Api ,{}", id);
        given()
                .spec(spec)
                .when()
                .post(URL + "delete_project/" + id)
                .then()
                .statusCode(200)
                .log();
    }
}
