package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.PersonDetails;
import pl.coderslab.repositories.PersonDetailsDao;

@Controller
public class PersonDetailsController {

    @Autowired
    private PersonDetailsDao personDetailsDao;

    @RequestMapping("/addpersondetails")
    @ResponseBody
    public String hello() {
        PersonDetails personDetails = new PersonDetails();
        personDetails.setFirstName("Jan");
        personDetails.setLastName("Kowalski");
        personDetails.setCity("Poznań");
        personDetailsDao.savePersonDetails(personDetails);
        return "Id dodantych danych to: " + personDetails.getId();
    }

    @RequestMapping("/updatepersondetails")
    @ResponseBody
    public String updatePersonDetails() {
        PersonDetails personDetails = personDetailsDao.findById(1);
        personDetails.setFirstName("Janusz");
        personDetailsDao.update(personDetails);
        return "Id edytowanego autora to:"
                + personDetails.getId();
    }

    @RequestMapping("/getpersondetails")
    @ResponseBody
    public String getBook() {
        PersonDetails personDetails = personDetailsDao.findById(1);
        return personDetails.toString();

    }
    @RequestMapping("/deletepersondetails")
    @ResponseBody
    public String deleteBook(){
        PersonDetails personDetails = personDetailsDao.findById(1);
        if (personDetails != null){
            personDetailsDao.delete(personDetails);
            return "PersonDetails with Id "+personDetails.getId()+" deleted.";
        }

        return "Nie ma takiego Id";
    }

}