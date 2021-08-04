import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pojos.UserPojo;
import pojos.UserRequest;
import pojos.CreateUserResponse;
import pojos.UserPojoFull;
import utils.RestWrapper;
import utils.UserGenerator;

import java.util.List;

import static io.restassured.RestAssured.given;
//import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RestTest {

    private static final RequestSpecification REQ_SPEC =
            new RequestSpecBuilder()
                    .setBaseUri("http://users.bugred.ru/tasks/rest")
                    .setBasePath("/doregister")
                    .setContentType(ContentType.JSON)
                    .build();

    private static RestWrapper api;

    @BeforeAll
    public static void prepareClient() {
        api = RestWrapper.loginAs("manager@mail.ru", "1");
    }

//    @Test
//    public void getUsers() {
//        assertThat(api.user.getUsers()).extracting(UserPojoFull::getEmail).contains("george.bluth@reqres.in");
//    }
        /* Запись всего полученного JSON в строковое поле */

//        String rs = given()
//                .baseUri("http://users.bugred.ru/tasks/rest")
//                .basePath("/getuser")
//                .contentType(ContentType.JSON)
//                .when().get()
//                .then().statusCode(200).extract().asString();
//        System.out.println(rs);
//    }

        /* Выбор ключа из JSON и сравнение его с заданным значением */

//         given()
//                .baseUri("http://users.bugred.ru/tasks/rest")
//                .basePath("/getuser")
//                .contentType(ContentType.JSON)
//                .when().get()
//                .then().statusCode(200)
//                .body("message", equalTo("Параметр email является обязательным!"));
//    }

        /* Поиск в JSON Data по заданному ключу email и его значению, с фильтрацией по другому ключу type */

//        given()
//                .baseUri("http://users.bugred.ru/tasks/rest")
//                .basePath("/getuser")
//                .contentType(ContentType.JSON)
//                .when().get()
//                .then().statusCode(200)
//                .body("data.find{it.email=='Параметр email является обязательным!'}.type",
//                        equalTo("error"));
//    }

        /* Сохранить все email из JSON Data в переменную emails */

//        List<UserPojo> emails = given()
//                .baseUri("http://users.bugred.ru/tasks/rest")
//                .basePath("/getuser")
//                .contentType(ContentType.JSON)
//                .when().get()
//                .then()
//                .statusCode(200)
//                .extract().jsonPath().getList("data", UserPojo.class);
//        System.out.println(emails);
//    }

        /* Работаем с Pojo Class: передаём класс, с помощью которого будет происходить десериализация.
         * Плагин для автогенерации Pojo Class для заданного JSON — RoboPOJOGenerator*/

//        List<UserPojo> emails = given()
//                .baseUri("http://users.bugred.ru/tasks/rest")
//                .basePath("/getuser")
//                .contentType(ContentType.JSON)
//                .when().get()
//                .then().statusCode(200)
//                .extract().jsonPath().getList("data", UserPojo.class);
//
//        assertThat(emails).extracting(UserPojoFull::getEmail).contains("that email");
//    }
//    }


//        List<UserPojoFull> users = given()
//                .spec(REQ_SPEC)
//                .when().get()
//                .then()
//                .statusCode(200)
//                .extract().jsonPath().getList("data", UserPojoFull.class);
//    }

    /* ЭТОТ ЗАПРОС РАБОТАЕТ! */

//    @Test public void createUser() {
//
//        UserRequest rq = new UserRequest();
//        rq.setName("name152165132151411");
//        rq.setEmail("nemafdfsajk@gskdfj.rgjk");
//        rq.setPassword("d");
//
//        CreateUserResponse rs = given()
//                .baseUri("http://users.bugred.ru/tasks/rest")
//                .basePath("/doregister")
//                .contentType(ContentType.JSON)
//                .body(rq)
//                .when().post()
//                .then().extract().as(CreateUserResponse.class);
//
//        assertThat(rs)
//                .isNotNull()
//                .extracting(UserRequest::getName)
//                .isEqualTo(rq.getName());
//    }

//    @Test public void createUser() {
//
//        UserRequest rq = UserGenerator.getSimpleUser();
//
//        /* ВЕРХНЕЕ ВМЕСТО НИЖНЕГО!!! */
//
////        UserRequest rq = new UserRequest().builder()
////                .name("name152165132151411")
////                .email("nemafdfsajk@gskdfj.rgjk")
////                .password("d")
////                .build();
//
//        /* ВЕРХНЕЕ ВМЕСТО НИЖНЕГО!!!
//         * Так как указали аннотацию билдэр внутри класса UserRequest, причём сеттеры можно не создавать */
//
////        rq.setName("name152165132151411");
////        rq.setEmail("nemafdfsajk@gskdfj.rgjk");
////        rq.setPassword("d");
//
//        CreateUserResponse rs = given()
//                .spec(REQ_SPEC)
//                .body(rq)
//                .when().post()
//                .then().extract().as(CreateUserResponse.class);
//
//        assertThat(rs)
//                .isNotNull()
//                .extracting(UserRequest::getName)
//                .isEqualTo(rq.getName());
//    }

        @Test public void createUser() {

        /* паттерн билдэр! */
//        UserRequest rq =
//                UserRequest.builder()
//                        .name("name152165132151411") // без использования сеттеров передаём в класс значения полей
//                        .email("nemafdfsajk@gskdfj.rgjk")
//                        .password("d")
//                        .build(); // возвращает экземпляр класса с заданными полями

        UserRequest rq = UserGenerator.getSimpleUser();
        CreateUserResponse rs = api.user.createUser(rq);

        assertThat(rs)
                .isNotNull()
                .extracting(CreateUserResponse::getName)
                .isEqualTo(rq.getName());
    }
}
