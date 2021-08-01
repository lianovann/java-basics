package utils.services;

import io.restassured.http.Cookies;
import pojos.UserRequest;
import pojos.CreateUserResponse;
import pojos.UserPojoFull;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserServices extends RestServices {

    @Override
    protected String getBasePath() {
        return "/users";
    }

    public UserServices(Cookies cookies) {
        super(cookies);
    }

    public CreateUserResponse createUser(UserRequest rq) {
        return given().body(rq).post().as(CreateUserResponse.class);
    }

    public List<UserPojoFull> getUsers() {
        return given().spec(REQ_SPEC)
                .get()
                .jsonPath().getList("data", UserPojoFull.class);
    }
}
