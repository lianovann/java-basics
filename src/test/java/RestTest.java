import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pojos.UserRequest;
import pojos.CreateUserResponse;
import pojos.UserPojoFull;
import utils.RestWrapper;
import utils.UserGenerator;

import static io.restassured.RestAssured.given;
//import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

public class RestTest {

    private static RestWrapper api;

    @BeforeAll
    public static void prepareClient() {
        api = RestWrapper.loginAs("eve.holt@reqres.in", "cityslicks");
    }

    @Test
    public void getUsers() {
        assertThat(api.user.getUsers()).extracting(UserPojoFull::getEmail).contains("george.bluth@reqres.in");
    }
        /* Запись всего полученного JSON в строковое поле */

//        String rs = given()
//                .baseUri("http://users.bugred.ru/tasks/rest")
//                .basePath("/getuser")
//                .contentType(ContentType.JSON)
//                .when().get()
//                .then().statusCode(200).extract().asString();
//        System.out.println(rs);

        /* Выбор ключа из JSON и сравнение его с заданным значением */

//        given()
//                .baseUri("http://users.bugred.ru/tasks/rest")
//                .basePath("/getuser")
//                .contentType(ContentType.JSON)
//                .when().get()
//                .then().statusCode(200)
//                .body("message", equalTo("Параметр email является обязательным!"));

        /* Поиск в JSON Data по заданному ключу email и его значению, с фильтрацией по другому ключу type */

//        given()
//                .baseUri("http://users.bugred.ru/tasks/rest")
//                .basePath("/getuser")
//                .contentType(ContentType.JSON)
//                .when().get()
//                .then().statusCode(200)
//                .body("data.find{it.email=='Параметр email является обязательным!'}.type",
//                        equalTo("error"));

        /* Сохранить все email из JSON Data в переменную emails */

//        List<String> emails = given()
//                .baseUri("http://users.bugred.ru/tasks/rest")
//                .basePath("/getuser")
//                .contentType(ContentType.JSON)
//                .when().get()
//                .then().statusCode(200)
//                .extract().jsonPath().getList("data.email");

        /* Работаем с Pojo Class: передаём класс, с помощью которого будет происходить десериализация.
        * Плагин для автогенерации Pojo Class для заданного JSON — RoboPOJOGenerator*/

//        List<UserPojo> emails = given()
//                .baseUri("http://users.bugred.ru/tasks/rest")
//                .basePath("/getuser")
//                .contentType(ContentType.JSON)
//                .when().get()
//                .then().statusCode(200)
//                .extract().jsonPath().getList("data", UserPojo.class);

//        List<UserPojoFull> users = given()
//                .spec(REQ_SPEC)
//                .when().get()
//                .then()
//                .statusCode(200)
//                .extract().jsonPath().getList("data", UserPojoFull.class);

    @Test public void createUser() {
        /* паттерн билдэр! */
//        CreateUserRequest rq =
//                CreateUserRequest.builder()
//                        .name("simple") // без использования сеттеров передаём в класс значения полей
//                        .job("automation")
//                        .build(); // возвращает экземпляр класса с заданными полями

        UserRequest rq = UserGenerator.getSimpleUser();
        CreateUserResponse rs = api.user.createUser(rq);

        assertThat(rs)
                .isNotNull()
                .extracting(CreateUserResponse::getName)
                .isEqualTo(rq.getName());
    }
}
