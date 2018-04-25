package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Person;
import pl.coderslab.repositories.PersonDao;

@Controller
public class PersonController {

    @Autowired
    private PersonDao personDao;

    @RequestMapping("/addperson")
    @ResponseBody
    public String hello() {
        Person person = new Person();
        person.setLogin("Jan");
        person.setPassword("123");
        person.setEmail("jan@onet.pl");
        personDao.savePerson(person);
        return "Id dodanego usera to: " + person.getId();
    }

    @RequestMapping("/updateperson")
    @ResponseBody
    public String updatePerson() {
        Person person = personDao.findById(1);
        person.setLogin("Janusz");
        personDao.update(person);
        return "Id edytowanego usera to:"
                + person.getId();
    }

    @RequestMapping("/getperson")
    @ResponseBody
    public String getPerson() {
        Person person = personDao.findById(1);
        return person.toString();

    }
    @RequestMapping("/deleteperson")
    @ResponseBody
    public String deletePerson(){
        Person person = personDao.findById(1);
        if (person != null){
            personDao.delete(person);
            return "Person with Id "+person.getId()+" deleted.";
        }

        return "Nie ma takiego Id";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/person-form")
    public String showForm(Model model){
        Person person = new Person();
        person.setLogin("Example");
        model.addAttribute("person", person);
        return "form/person";
    }
    @RequestMapping(method = RequestMethod.POST, path = "/person-form")
    public String saveForm(@RequestParam String login,
                           @RequestParam String password,
                           @RequestParam String email, Model model)
    {
        Person person = new Person();
        person.setLogin(login);
        person.setPassword(password);
        person.setEmail(email);

        personDao.savePerson(person);

        return "form/success";
    }

}