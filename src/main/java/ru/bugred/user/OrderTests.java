package ru.bugred.user;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@Smoke
public class OrderTests {

    @BeforeAll
    public static void createOrder() {
        System.out.println("create order");
    }

    @Test
    public void testCreateOrder() {
        System.out.println("check that order was created");
    }

    /* Параметризуемый метод, данные хранятся в аннотации @ValueSource в виде строк. */

//    @ParameterizedTest
//    @ValueSource(strings =  {"manager", "manager of managers", "manager of managers of managers"})
//    public void testListOrdersAsManager(String role) {
//        System.out.println("list orders as " + role);
//        System.out.println("check that order is displayed");
//    }

    /* Параметризуемый метод, данные берутся аннотацией @EnumSource из поля Roles, объявленного ниже.
    * По умолчанию тест будет повторён для каждого значения из Enum */

//    @ParameterizedTest
//    @EnumSource
//    public void testListOrdersAsManager(Roles role) {
//        System.out.println("list orders as " + role);
//        System.out.println("check that order is displayed");
//    }
//
//    enum Roles {
//        MANAGER("manager"),
//        SENIOR_MANAGER("manager of managers"),
//        LEAD_MANAGER("manager of managers of managers");
//
//        Roles(String description) {
//            this.description = description;
//        }
//
//        private String description;
//        public String getDescription() {
//            return description;
//        }
//    }

    /* Параметризуемый метод, данные берутся аннотацией @EnumSource из поля Roles, объявленного ниже.
     * В параметрах аннотаций можно указать, чтобы тесты выполнялись для конкретных значений из Enum */

//    @ParameterizedTest
//    @EnumSource(names = {"MANAGER"})
//    public void testListOrdersAsManager(Roles role) {
//        System.out.println("list orders as " + role);
//        System.out.println("check that order is displayed");
//    }
//
//    enum Roles {
//        MANAGER("manager"),
//        SENIOR_MANAGER("manager of managers"),
//        LEAD_MANAGER("manager of managers of managers");
//
//        Roles(String description) {
//            this.description = description;
//        }
//
//        private String description;
//        public String getDescription() {
//            return description;
//        }
//    }
//
//    @AfterAll
//    public static void deleteOrder() {
//        System.out.println("delete order");
//    }

    /* Параметризуемый метод, данные берутся аннотацией @EnumSource из поля Roles, объявленного ниже.
     * При добавлении стратегии EXCLUDE тест для указанного значения выполнен не будет, а остальные да. */

//    @ParameterizedTest
//    @EnumSource(mode = EnumSource.Mode.EXCLUDE, names = {"MANAGER"})
//    public void testListOrdersAsManager(Roles role) {
//        System.out.println("list orders as " + role);
//        System.out.println("check that order is displayed");
//    }
//
//    enum Roles {
//        MANAGER("manager"),
//        SENIOR_MANAGER("manager of managers"),
//        LEAD_MANAGER("manager of managers of managers");
//
//        Roles(String description) {
//            this.description = description;
//        }
//
//        private String description;
//        public String getDescription() {
//            return description;
//        }
//    }
//
//    @AfterAll
//    public static void deleteOrder() {
//        System.out.println("delete order");
//    }

    /* Параметризуемый метод, данные берутся аннотацией @EnumSource из поля Roles, объявленного ниже.
     * Фильтруем элементы по шаблону имени — все элементы, имя которых заканчивается на MANAGER */

//    @ParameterizedTest
//    @EnumSource(mode = EnumSource.Mode.MATCH_ALL, names = {".*MANAGER"})
//    public void testListOrdersAsManager(Roles role) {
//        System.out.println("list orders as " + role);
//        System.out.println("check that order is displayed");
//    }
//
//    enum Roles {
//        MANAGER("manager"),
//        SENIOR_MANAGER("manager of managers"),
//        LEAD_MANAGER("manager of managers of managers");
//
//        Roles(String description) {
//            this.description = description;
//        }
//
//        private String description;
//        public String getDescription() {
//            return description;
//        }
//    }
//
//    @AfterAll
//    public static void deleteOrder() {
//        System.out.println("delete order");
//    }

    /* Параметризуемый метод, данные берутся аннотацией @MethodSource из метода-источника и статичного параметра Roles, объявленного ниже.
     * Фильтруем элементы по шаблону имени — все элементы, имя которых заканчивается на MANAGER.
     * Имя метода-источника можно не указывать, но тогда оно должно совпадать с именем тестового метода */

//    @ParameterizedTest
//    @MethodSource("getRoles")
//    public void testListOrdersAsManager(Roles role) {
//        System.out.println("list orders as " + role);
//        System.out.println("check that order is displayed");
//    }
//
//    static Stream<Roles> getRoles() {
//        return Stream.of(Roles.MANAGER, Roles.SENIOR_MANAGER);
//    }
//
//    enum Roles {
//        MANAGER("manager"),
//        SENIOR_MANAGER("manager of managers"),
//        LEAD_MANAGER("manager of managers of managers");
//
//        Roles(String description) {
//            this.description = description;
//        }
//
//        private String description;
//        public String getDescription() {
//            return description;
//        }
//    }
//
//    @AfterAll
//    public static void deleteOrder() {
//        System.out.println("delete order");
//    }

    /* Параметризуемый метод, данные берутся аннотацией @MethodSource из метода-источника и статичного параметра Roles, объявленного ниже.
     * Фильтруем элементы по шаблону имени — все элементы, имя которых заканчивается на MANAGER.
     * Имя метода-источника можно не указывать, но тогда оно должно совпадать с именем тестового метода */

    @ParameterizedTest
    @MethodSource
    public void testListOrdersAsManager(Roles role, String orderType) {
        System.out.println("list orders as " + role.getDescription());
        System.out.println("check that is displayed orders for " + orderType);
    }

    static Stream<Arguments> testListOrdersAsManager() {
        return Stream.of(
                arguments(Roles.MANAGER, "orders for manager"),
                arguments(Roles.SENIOR_MANAGER, "orders for senior")
        );
    }

    enum Roles {
        MANAGER("manager"),
        SENIOR_MANAGER("manager of managers"),
        LEAD_MANAGER("manager of managers of managers");

        Roles(String description) {
            this.description = description;
        }

        private String description;
        public String getDescription() {
            return description;
        }
    }

    @AfterAll
    public static void deleteOrder() {
        System.out.println("delete order");
    }
}
