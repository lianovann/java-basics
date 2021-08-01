package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/* Deserialization (десериализация) — превращение JSON в объект — JackSon library.
 * Иерархия классов Java = иерархия внутри JSON.
 * Такой класс называют Моделью данных или PojoClass — класс, описывающий структуру данных и не несущий дополнительной логики. */

/* Аннотация JsonIgnoreProperties позволяет избежать десериализации всего JSON, а ограничиться порой параметров. */

/* Класс должен иметь публичные сеттеры, чтобы десериализатор мог установить значения и геттеры, для обратной операции */

@Data
public class UserPojoFull {
    private int id;
    private String avatar;
    /* Аннотация JsonProperty позволяет задать имя ключа, которому соответствует данная переменная.
     * Сама переменная при этом может иметь любое имя. */
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String email;

}
