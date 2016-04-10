package controllers;

import com.jayway.restassured.http.ContentType;
import org.junit.Test;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


/**
 * Created by LocMX on 3/20/2016.
 */
public class HomeControllerTest {

    @Test
    public void printHello() throws Exception {
        given()
                .standaloneSetup(new HomeController())
                .when().get("/hello/")
                .then()
                .statusCode(200)
                .assertThat()
                .body(equalTo("home"));
    }

    @Test
    public void printStudent() throws Exception {

    }
}