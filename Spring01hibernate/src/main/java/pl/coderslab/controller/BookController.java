package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;
import pl.coderslab.repositories.AuthorDao;
import pl.coderslab.repositories.BookDao;
import pl.coderslab.repositories.PublisherDao;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Controller
public class BookController {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private PublisherDao publisherDao;
    @Autowired
    private AuthorDao authorDao;
    @Autowired
    Validator validator;

    @RequestMapping("/add")
    @ResponseBody
    public String hello() {
        Book book = new Book();
        book.setTitle("Thinking in Java");
        // book.setAuthor("Bruce Eckel");
        bookDao.saveBook(book);
        return "Id dodanej książki to:"
                + book.getId();
    }

    @GetMapping("/update/{id}")
    public String updateBook(@PathVariable long id, Model model) {
        Book book = bookDao.findById(id);

        model.addAttribute("book", book);
        return "form/editBook";
    }

    @PostMapping("/update/{id}")
    public String updateBookSave(@PathVariable long id, Book book, Model model) {
        Set<ConstraintViolation<Book>> violations = validator.validate(book);


        if (!violations.isEmpty()) {
            model.addAttribute("errors", violations);
            return "validate";
        }else{
            bookDao.update(book);
            return "redirect:/list";
        }
    }

    @RequestMapping("/getbook")
    @ResponseBody
    public String getBook() {
        Book book = bookDao.findById(1);
        return book.toString();

    }

    @RequestMapping("/deletebook/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        if (book != null) {
            bookDao.delete(book);
            return "Book with Id " + book.getId() + " deleted.";
        }

        return "Nie ma takiego Id";
    }

    @RequestMapping("/add2")
    @ResponseBody
    public String saveNew() {
        Book book = new Book();
        book.setTitle("Some title");
        Publisher publisher = publisherDao.findById(1);

        publisherDao.update(publisher);
        return "";
    }

    @RequestMapping(value = "/addnew", method = RequestMethod.GET)
    public String showNewForm(Model model) {
        model.addAttribute("book", new Book());
        return "form/book";
    }
    @RequestMapping(value = "/addnew", method = RequestMethod.POST)
    public String saveNew(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "form/book";
        }else{
            bookDao.saveBook(book);
            return "redirect:/list";
        }

    }
    @GetMapping("/list")
    public String allBooks(Model model) {
        List<Book> books = bookDao.getBooks();
        model.addAttribute("books", books);
        return "book_list";

    }

    @ModelAttribute("publishers")
    public List<Publisher> getPublishers() {
        return publisherDao.getPublishers();
    }
    @ModelAttribute("authors")
    public List<Author> getAuthors() {
        return authorDao.getAuthors();
    }


}