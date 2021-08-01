package ru.bugred.user;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    private static final User EXISTED_USER = new User("existed", "");
    public static final User NOT_EXISTED_USER = new User("wrong", "");

    public static void main(String[] args) {
//        new AuthorizationTests().testLogin();
//        OrderTests orderTests = new OrderTests();
//        orderTests.testCreateOrder();
//        orderTests.testListOrders();

        List<String> strings = Arrays.asList("one", "three", "two");

        Map<String, Integer> digesMap = new HashMap<>();
        digesMap.put("one", 1);
        digesMap.put("two", 2);
        digesMap.put("three", 3);

        strings.forEach(str -> System.out.println(digesMap.get(str)));

        strings.stream().filter(el -> el.length() == 3).collect(Collectors.toList());


//        User[] users = {EXISTED_USER, NOT_EXISTED_USER};
//
//	    Main instance = new Main();
//
//	    for (int i = 0; i < users.length; i++) {
//	        User user = users[i];
//            System.out.println("Login as " + user);
//            System.out.println(instance.loginAs(user));
//        }
//
//	    for (User user : users) {
//            System.out.println("Login as " + user.getLogin());
//            System.out.println(instance.loginAs(user));
//        }
//
//	    int i = 0;
//	    while (1 < users.length) {
//            System.out.println("Login as " + users[i]);
//            System.out.println(instance.loginAs(users[i]));
//            i++;
//        }
//    }
//
//    private boolean loginAs(User user) {
//        if (user.equals(EXISTED_USER)) {
//            return true;
//        }
//
//        return false;
    }

    private <T> String objectToString(T object){
        return String.valueOf(object);
    }


}
