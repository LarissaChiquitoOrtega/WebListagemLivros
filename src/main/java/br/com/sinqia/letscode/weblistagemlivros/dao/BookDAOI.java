package br.com.sinqia.letscode.weblistagemlivros.dao;

import br.com.sinqia.letscode.weblistagemlivros.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookDAOI {

    Book save(Book book);

    List<Book> findAll();

    void delete(String idBook);

    Optional<Book> getById(String idBook);

    Optional<Book> update(Book book);

}
