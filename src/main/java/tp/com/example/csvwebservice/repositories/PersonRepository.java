package tp.com.example.csvwebservice.repositories;

import org.springframework.data.repository.CrudRepository;
import tp.com.example.csvwebservice.entities.Person;

import java.util.List;
import java.util.Optional;


public interface PersonRepository extends CrudRepository<Person, Long> {

    Optional<Person> findById(Long id);

    List<Person> findByFirstName(String firstName);

    List<Person> findByLastName(String lastName);

    Long countByFirstName(String firstName);

    Long countById(Long id);
}