package br.com.sinqia.letscode.weblistagemlivros.bo;

import br.com.sinqia.letscode.weblistagemlivros.dao.BookDAOI;
import br.com.sinqia.letscode.weblistagemlivros.model.Book;

import javax.inject.Inject;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class BookBusinessObject implements BookBusinessObjectI{

    private BookDAOI bookDAO;

    @Inject
    public BookBusinessObject(BookDAOI bookDAOI){
        this.bookDAO = bookDAOI;
    }

    private void validate(Book book) {
        if(Objects.isNull(book.getTitle())){
            throw new IllegalArgumentException("Book title is required!");
        }
    }

    @Override
    public Book save(Book book) {
        validate(book);
        return bookDAO.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookDAO.findAll();
    }

    @Override
    public void delete(String idBook) {
        bookDAO.delete(idBook);
    }

    @Override
    public Book getById(String idBook) {
        Optional<Book> optionalBook = bookDAO.getById(idBook);
        if (optionalBook.isPresent()){
            return optionalBook.get();
        } else {
            throw new IllegalArgumentException("The book is not found for this id: ".concat(idBook));
        }
    }

    @Override
    public Book update(Book book) {
        Optional<Book> optionalBook = bookDAO.update(book);
        return optionalBook.get();
    }
}
