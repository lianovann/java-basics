package utils;

import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import pojos.UserLogin;
import utils.services.OrderServices;
import utils.services.UserServices;


import static io.restassured.RestAssured.given;

public class RestWrapper {
    private static final String BASE_URL = "https://reqres.in/api";
    private Cookies cookies;

    public UserServices user;
    public OrderServices order;

    private RestWrapper(Cookies cookies) {
        this.cookies = cookies;

        user = new UserServices(cookies);
        order = new OrderServices(cookies);
    }
    public static RestWrapper loginAs(String login, String password) {
        Cookies cookies = given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .basePath("/login")
                .body(new UserLogin(login, password))
                .post()
                .getDetailedCookies();

        return new RestWrapper(cookies);
    }
}
