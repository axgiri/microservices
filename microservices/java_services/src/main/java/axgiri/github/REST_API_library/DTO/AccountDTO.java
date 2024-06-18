package axgiri.github.REST_API_library.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AccountDTO {
    @NotEmpty(message = "login is empty")
    public String login;

    @NotEmpty(message = "password is empty")
    public String password;
}
