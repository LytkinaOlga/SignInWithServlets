package by.bntu.fitr.poisit.lytkina.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    Integer id;
    String login;
    String password;
    Role role;
}
