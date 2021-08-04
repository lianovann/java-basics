package utils;

import pojos.UserRequest;

public class UserGenerator {

    public static UserRequest getSimpleUser() {
        String randomNumber = String.valueOf(System.currentTimeMillis());
        System.out.println(randomNumber + "@mail.ru");
        return UserRequest.builder()
                .name(randomNumber)
                .email(randomNumber + "@mail.ru")
                .password(randomNumber)
                .build();
    }
}
