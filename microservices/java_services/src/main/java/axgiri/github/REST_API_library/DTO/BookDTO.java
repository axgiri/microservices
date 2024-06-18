package axgiri.github.REST_API_library.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class BookDTO{
    @NotEmpty(message = "name is empty")
    public String name;

    @NotEmpty(message = "author's name is empty")
    public String author;
}