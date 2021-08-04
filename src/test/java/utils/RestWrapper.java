package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.specification.RequestSpecification;
import pojos.CreateUserResponse;
import pojos.UserLogin;
import pojos.UserPojoFull;
import pojos.UserRequest;
import utils.services.OrderServices;
import utils.services.UserServices;


import java.util.List;

import static io.restassured.RestAssured.given;

public class RestWrapper {
    private static final String BASE_URL = "http://users.bugred.ru/tasks/rest";
    private static RequestSpecification REQ_SPEC;

    private Cookies cookies;

    public UserServices user;
    public OrderServices order;

    private RestWrapper(Cookies cookies) {
        this.cookies = cookies;

        user = new UserServices(cookies);

        REQ_SPEC = new RequestSpecBuilder()
                .setBaseUri("http://users.bugred.ru/tasks/rest")
                .setBasePath("/doregister")
                .setContentType(ContentType.JSON)
                .build();
    }
    public static RestWrapper loginAs(String login, String password) {
        Cookies cookies = given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .basePath("/dologin")
                .body(new UserLogin(login, password))
                .post()
                .getDetailedCookies();

        return new RestWrapper(cookies);
    }

    public CreateUserResponse createUser(UserRequest rq) {
        return given().body(rq).post().as(CreateUserResponse.class);
    }

//    public  List<UserPojoFull> getUsers() {
//        return given().spec(REQ_SPEC)
//                .get()
//                .jsonPath().getList("data", UserPojoFull.class);
//    }
}
