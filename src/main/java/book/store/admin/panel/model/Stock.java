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
public class Stock {

    private int idStock;
    private int quantity;
    private double price;
    private int discount;
    private int ageRange;
    private LocalDateTime lastAddedDate;
    private Book book;

}
