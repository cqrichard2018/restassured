package richardTest;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class TesterHome {

    @Test
    public void testerHomeJson(){
        given().get("https://testerhome.com/api/v3/topics.json")
                .then()
                .statusCode(200)
                .body("topics.title",hasItems("优质招聘汇总","一步一步教你打造接口测试平台 (1)"))
                ;
    }

    @Test
    public void testerHomeJsonId(){
        given().get("https://testerhome.com/api/v3/topics/10254.json")
                .then()
                .statusCode(200)
                .body("topic.user.id",equalTo(10433));

    }



}
