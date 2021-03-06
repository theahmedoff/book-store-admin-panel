package book.store.admin.panel.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category {

    private int idCategory;
    private String type;
    private List<Book> list;

    public Category() {
        this.list = new ArrayList<>();
    }

}
