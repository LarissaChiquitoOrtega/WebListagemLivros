package br.com.sinqia.letscode.weblistagemlivros.bo;

import br.com.sinqia.letscode.weblistagemlivros.model.Book;

import java.util.List;

public interface BookBusinessObjectI {

    Book save(Book book);

    List<Book> findAll();

    void delete(String idBook);

    Book getById(String idBook);

    Book update(Book book);

}
