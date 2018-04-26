package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.repositories.AuthorDao;
import pl.coderslab.repositories.AuthorRepository;
import pl.coderslab.repositories.BookDao;

import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    private AuthorDao authorDao;
    @Autowired
    Validator validator;

    @Autowired
    private BookDao bookDao;

    @Autowired
    AuthorRepository authorRepository;


    @RequestMapping("/addauthor")
    @ResponseBody
    public String hello() {
        Author author = new Author();
        author.setFirstName("Jan");
        author.setLastName("Kowalski");
        authorDao.saveAuthor(author);
        return "Id dodanego autora to: " + author.getId();
    }

    @RequestMapping("/updateauthor")
    @ResponseBody
    public String updateBook() {
        Author author = authorDao.findById(1);
        author.setFirstName("Janusz");
        authorDao.update(author);
        return "Id edytowanego autora to:"
                + author.getId();
    }

    @RequestMapping("/getauthor")
    @ResponseBody
    public String getBook() {
        Author author = authorDao.findById(1);
        return author.toString();

    }
    @RequestMapping("/deleteauthor")
    @ResponseBody
    public String deleteBook(){
        Author author = authorDao.findById(1);
        if (author != null){
            authorDao.delete(author);
            return "Author with Id "+author.getId()+" deleted.";
        }

        return "Nie ma takiego Id";
    }
///////////////////////////////////////////////

    @RequestMapping(value = "/addnewa", method = RequestMethod.GET)
    public String showNewForm(Model model) {
        model.addAttribute("author", new Author());
        return "form/author";
    }
    @RequestMapping(value = "/addnewa", method = RequestMethod.POST)
    public String saveNew(@Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "form/author";
        }else{
            authorDao.saveAuthor(author);
            return "redirect:/lista";
        }

    }
    @GetMapping("/lista")
    public String allAuthors(Model model) {
        List<Author> authors = authorDao.getAuthors();
        model.addAttribute("authors", authors);
        return "author_list";

    }

    @ModelAttribute("books")
    public List<Book> getBooks() {
        return bookDao.getBooks();
    }

}