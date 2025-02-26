package adapters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.CreateProjectRq;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utils.PropertyReader;

import static io.restassured.RestAssured.given;

public class BaseApi {

    public final static String USER_NAME = System.getProperty("Username", PropertyReader.getProperty("user"));
    public final static String API_KEY = System.getProperty("Password",PropertyReader.getProperty("api_key"));
    public static String URL = System.getProperty("api_url", PropertyReader.getProperty("api_url"));

    public static Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    public static RequestSpecification spec =
            given().log().all()
                    .auth().preemptive()
                    .basic(USER_NAME,API_KEY)
                    .contentType(ContentType.JSON);

}
