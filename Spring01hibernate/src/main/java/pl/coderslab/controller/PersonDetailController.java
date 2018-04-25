package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.DTO.PersonDetailDTO;
import pl.coderslab.model.Person;
import pl.coderslab.model.PersonDetails;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonDetailController {

    @Autowired
    PersonDetailDTO personDetailDTO;

    @RequestMapping(method = RequestMethod.GET, path = "/persondetail")
    public String showForm(Model model){
        PersonDetails personDetails = new PersonDetails();
        personDetails.setLogin("Example");
        personDetails.setPassword("123");
        personDetails.setEmail("aaa@aaa.pl");
        personDetails.setFirstName("Jan");
        personDetails.setLastName("Kowalski");
        model.addAttribute("persondetail", personDetails);
        return "form/persondetail";
    }

    @ModelAttribute("genders")
    public List<String> gender() {
        return personDetailDTO.genders();
    }
    @ModelAttribute("countries")
    public List<String> countries() {
        return personDetailDTO.countries();
    }
    @ModelAttribute("skills")
    public List<String> skills() {
        return personDetailDTO.skills();
    }
    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return personDetailDTO.hobbies();
    }

//    @RequestMapping(method = RequestMethod.POST, path = "/persondetail")
//    public String saveForm(@RequestParam String login,
//                           @RequestParam String password,
//                           @RequestParam String email, Model model)
//    {
//        Person person = new Person();
//        person.setLogin(login);
//        person.setPassword(password);
//        person.setEmail(email);
//
//       // personDao.savePerson(person);
//
//        return "form/success";
//    }
}
