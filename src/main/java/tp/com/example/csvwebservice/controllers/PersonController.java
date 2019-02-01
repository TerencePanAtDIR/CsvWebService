package tp.com.example.csvwebservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tp.com.example.csvwebservice.entities.Person;
import tp.com.example.csvwebservice.repositories.PersonRepository;

import java.util.List;


@RestController
@RequestMapping("person-rest")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/{id}")
    public Person getPersons(@PathVariable Long id){
        return personRepository.findById(id).get();
    }
    @GetMapping("/findbylastname/{lastName}")
    public List<Person> getPersonsMatchingLastName(@PathVariable String lastName){
        return personRepository.findByLastName(lastName);
    }
}