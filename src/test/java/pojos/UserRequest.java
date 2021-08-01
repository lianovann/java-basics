package pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/* По умолчанию @Builder убирает дефолтный конструктор,
* но аннотации @NoArgsConstructor и @AllArgsConstructor позволяют обойти это. */

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class UserRequest {
    private String name;
    private String job;
}
