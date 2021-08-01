package pojos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import lombok.Data;
import utils.DateDeserializer;

import java.time.LocalDateTime;

@Data
public class CreateUserResponse extends UserRequest {
    private int id;
    /* Для корректной десериализации даты из ключа createdAt создали аннотацию, которая указывает, что дата,
    * содержащаяся в этой переменной должна быть типа STRING и указываем паттерн форматирования */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'hh:mm:ss.SSSZ")
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime createdAt;
}
