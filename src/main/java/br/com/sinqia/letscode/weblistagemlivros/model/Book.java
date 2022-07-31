package br.com.sinqia.letscode.weblistagemlivros.model;

import lombok.Data;
import lombok.ToString;
@Data
@ToString(of={"title", "author"})
public class Book {

    private Long id;
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

}
