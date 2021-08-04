package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/* Deserialization (десериализация) — превращение JSON в объект — JackSon library.
* Иерархия классов Java = иерархия внутри JSON.
* Такой класс называют Моделью данных или PojoClass — класс, описывающий структуру данных и не несущий дополнительной логики. */

/* Класс должен иметь публичные сеттеры, чтобы десериализатор мог установить значения и геттеры, для обратной операции */

/* Аннотация JsonIgnoreProperties позволяет избежать десериализации всего JSON, а ограничиться порой параметров. */

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPojo {
    private int id;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    /* Аннотация JsonProperty позволяет задать имя ключа, которому соответствует данная переменная.
    * Сама переменная при этом может иметь любое имя. */
    @JsonProperty("email")
    private String user_email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return user_email;
    }

    public void setEmail(String email) {
        this.user_email = email;
    }
}
