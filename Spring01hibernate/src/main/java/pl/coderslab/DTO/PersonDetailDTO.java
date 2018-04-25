package pl.coderslab.DTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDetailDTO {

    public List<String> genders(){
        List<String> list = new ArrayList<String>();
        list.add("male");
        list.add("female");
        return list;
    }

    public List<String> countries(){
        List<String> list = new ArrayList<String>();
        list.add("Poland");
        list.add("Germany");
        list.add("Slovakia");
        list.add("Russia");
        list.add("USA");
        return list;
    }
    public List<String> skills(){
        List<String> list = new ArrayList<String>();
        list.add("Java");
        list.add("JavaScript");
        list.add("Python");
        list.add("C");
        list.add("Kotlin");
        return list;
    }
    public List<String> hobbies(){
        List<String> list = new ArrayList<String>();
        list.add("Fishing");
        list.add("Sleeping");
        list.add("Eating");
        list.add("Drinking");
        list.add("Fighting (while drinking)");
        return list;
    }
}
