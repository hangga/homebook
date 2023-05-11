package id.homebook.homebook_app.book;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BookDTO {

    private Long id;

    @Size(max = 255)
    private String title;

    @Size(max = 255)
    private String author;

    private String summary;

}
