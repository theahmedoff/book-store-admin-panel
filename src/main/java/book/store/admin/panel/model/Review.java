package book.store.admin.panel.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Review {

    private int idReview;
    private String desc;
    private LocalDateTime writeDate;
    private double rating;
    private User user;
    private Book book;

}
