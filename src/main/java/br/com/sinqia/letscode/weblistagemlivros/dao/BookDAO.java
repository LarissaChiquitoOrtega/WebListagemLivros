package br.com.sinqia.letscode.weblistagemlivros.dao;

import br.com.sinqia.letscode.weblistagemlivros.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDAO implements BookDAOI{

    private static List<Book> listBooks = new ArrayList<>();
    private static long countBook;

    @Override
    public Book save(Book book) {
        countBook++;
        book.setId(countBook);
        listBooks.add(book);
        return book;
    }

    @Override
    public List<Book> findAll() {
        return listBooks;
    }

    @Override
    public void delete(String idBook) {
        for (Book book: listBooks) {
            if (book.getId().equals(Long.valueOf(idBook))){
                listBooks.remove(book);
                break;
            }
        }
    }

    @Override
    public Optional<Book> getById(String idBook) {
        for (Book book: listBooks) {
            if (book.getId().equals(Long.valueOf(idBook))){
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }

    private void updateBook(Book book, Book updateInfoBook) {
        book.setId(updateInfoBook.getId());
        book.setTitle(updateInfoBook.getTitle());
        book.setAuthor(updateInfoBook.getAuthor());
    }

    @Override
    public Optional<Book> update(Book updateInfoBook) {
        for (Book book: listBooks) {
            if (book.getId().equals(updateInfoBook.getId())){
                updateBook(book, updateInfoBook);
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }
}
