package br.com.sinqia.letscode.weblistagemlivros;

import br.com.sinqia.letscode.weblistagemlivros.bo.BookBusinessObjectI;
import br.com.sinqia.letscode.weblistagemlivros.model.Book;

import java.io.*;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

//Inclui os diferentes caminhos relacionados a esta raiz
@WebServlet(value = "/book-servlet/*")
public class BookServlet extends HttpServlet {

    private BookBusinessObjectI bookBusinessObjectI;

    @Inject
    public BookServlet(BookBusinessObjectI bookBusinessObjectI){

        this.bookBusinessObjectI = bookBusinessObjectI;
    }

    @Override
    public void init() {
        System.out.println("Hello Servlet!");
    }


    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("Hello SERVICE!");

        //caminhos seguintes /*
        String path = req.getPathInfo();

        switch (path) {
            case "/register-book":
                doPost(req, res);
                break;
            case "/read-to-edit":
                readToEdit(req, res);
                break;
            case "/update-book":
                doPut(req, res);
                break;
            case "/delete":
                doDelete(req, res);
                break;
            default:
                super.service(req, res);
        }

    }
    private Book createBook(HttpServletRequest req) {
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        return new Book(title, author);
    }

    private void readToEdit(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String idBook = req.getParameter("id");

        Book book = bookBusinessObjectI.getById(idBook);

        req.setAttribute("book", book);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/edit-book.jsp");
        dispatcher.forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        System.out.println("Hello POST!");
        Book book = createBook(req);

        Book savedBook = bookBusinessObjectI.save(book);

        req.setAttribute("idBookSaved", savedBook.getId());

        List<Book> books = bookBusinessObjectI.findAll();

        req.setAttribute("books", books);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/list-books.jsp");
        dispatcher.forward(req,res);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("Hello GET!");

        List<Book> books = bookBusinessObjectI.findAll();

        req.setAttribute("books", books);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/list-books.jsp");
        dispatcher.forward(req,res);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Hello PUT!");

        String id = request.getParameter("id");

        Book book = createBook(request);

        book.setId(Long.parseLong(id));

        Book updatedBook = bookBusinessObjectI.update(book);

        request.setAttribute("idUpdatedBook", updatedBook.getId());

        List<Book> books = bookBusinessObjectI.findAll();

        request.setAttribute("books", books);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-books.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idBook = request.getParameter("id");
        bookBusinessObjectI.delete(idBook);

        List<Book> books = bookBusinessObjectI.findAll();
        request.setAttribute("books", books);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-books.jsp");
        dispatcher.forward(request,response);
    }

    public void destroy() {
        System.out.println("Bye bye Servlet!");
    }
}