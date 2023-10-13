package sep.arbeitspaket.rest.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sep.arbeitspaket.rest.address.City;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    protected PersonService() {
        //JPA
    }

    public void addPerson(Person person) {
        personRepository.save(person);
    }

    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

  //  public List <Optional<Person>> findByCity(City city){
    //   return personRepository.findByCity(city);
    //}

   // public List <Optional<Person>> findByBirthday(Birthday birthday){
     //   return personRepository.findByBirthday(birthday);
    //}

}
