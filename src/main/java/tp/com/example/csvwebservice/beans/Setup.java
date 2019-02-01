package tp.com.example.csvwebservice.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tp.com.example.csvwebservice.data.CsvFunctions;
import tp.com.example.csvwebservice.entities.Person;
import tp.com.example.csvwebservice.services.SetupService;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class Setup {

    CsvFunctions csvFunctions = new CsvFunctions();

    @Autowired
    SetupService setupService;
    private final String FILE_NAME = "/static/MOCK_DATA.csv";

    @PostConstruct
    private void setupData() {
        setupPersons();
    }

    private void setupPersons(){
        List<Person> personsToSetup = getPersons();
        for(Person person : personsToSetup){
            setupService.setupPerson(person);
        }
    }

    public List<Person> getPersons(){
        List<Person> personsList = csvFunctions.loadObjectList(Person.class, FILE_NAME);
        return personsList;
    }
}
