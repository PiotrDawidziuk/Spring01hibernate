package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
public class ValidationController {
    @Autowired
    Validator validator;

    @RequestMapping("/validate")
    public String validateTest(Model model) {
        Book book = new Book();
        book.setTitle("as");
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        if (!violations.isEmpty()) {
            model.addAttribute("errors", violations);
        }
        return "validate";
    }
}
