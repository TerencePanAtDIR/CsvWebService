package tp.com.example.csvwebservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tp.com.example.csvwebservice.entities.Person;
import tp.com.example.csvwebservice.repositories.PersonRepository;

@Service
public class SetupService {

    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public void setupPerson(Person person) {
        try{
            setupPersonInternal(person);
        } catch(Exception e){
            System.out.println("Error occurred while saving person " + person.toString());
            e.printStackTrace();
        }
    }

    private void setupPersonInternal(Person person){
        personRepository.save(person);
    }

}
