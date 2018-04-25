package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Publisher;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;
import pl.coderslab.repositories.PublisherDao;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Controller
public class PublisherController {
    @Autowired
    Validator validator;

    @Autowired
    private PublisherDao publisherDao;

    @RequestMapping("/addpublisher")
    @ResponseBody
    public String hello() {
        Publisher publisher = new Publisher();
        publisher.setName("Helions");
        publisherDao.savePublisher(publisher);
        return "Id dodanego wydawcy to: " + publisher.getId();
    }

    @RequestMapping("/updatepublisher")
    @ResponseBody
    public String updateBook() {
        Publisher publisher = publisherDao.findById(1);
        publisher.setName("Inny");
        publisherDao.update(publisher);
        return "Id edytowanego wydawcy to:"
                + publisher.getId();
    }

    @RequestMapping("/getpublisher")
    @ResponseBody
    public String getBook() {
        Publisher publisher = publisherDao.findById(1);
        return publisher.toString();

    }
    @RequestMapping("/deletepublisher")
    @ResponseBody
    public String deleteBook(){
        Publisher publisher = publisherDao.findById(1);
        if (publisher != null){
            publisherDao.delete(publisher);
            return "Publisher with Id "+publisher.getId()+" deleted.";
        }

        return "Nie ma takiego Id";
    }

    /////////////////////////////////////////////////////////////

    @RequestMapping(value = "/addnewp", method = RequestMethod.GET)
    public String showNewForm(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "form/publisher";
    }
    @RequestMapping(value = "/addnewp", method = RequestMethod.POST)
    public String saveNew(@ModelAttribute Publisher publisher, Model model) {
        Set<ConstraintViolation<Publisher>> violations = validator.validate(publisher);
        if (!violations.isEmpty()) {
            model.addAttribute("errors", violations);
            return "validate";
        }else{
            publisherDao.savePublisher(publisher);
            return "redirect:/listp";
        }

    }
    @GetMapping("/listp")
    public String allPublishers(Model model) {
        List<Publisher> publishers = publisherDao.getPublishers();
        model.addAttribute("publishers", publishers);
        return "publisher_list";

    }

}