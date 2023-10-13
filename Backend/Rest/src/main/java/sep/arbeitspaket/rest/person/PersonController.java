package sep.arbeitspaket.rest.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sep.arbeitspaket.rest.address.City;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController {


    @Autowired
    private PersonService personService;

    @GetMapping("/all-persons")
    public ResponseEntity<List<Person>> allPersons() {
        return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Person> findByID(@PathVariable("id") Long id) throws Exception {
        personService.findById(id);
        Person person = personService.findById(id).orElseThrow(() -> new Exception("No such Element found"));
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @DeleteMapping("/delete-by-id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        personService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/add-new-person")
    public void addUser(Person person) {
        this.personService.addPerson(person);
    }


    @GetMapping("/find-by-birthday")
    public ResponseEntity<List<Person>> findByBirthday(Birthday birthday) {
        List <Person> personBirthday = personService.findAll()
                .stream()
                .filter(x -> x.getBirthday().equals(birthday))
                .collect(Collectors.toList());
        return new ResponseEntity<>(personBirthday, HttpStatus.OK);
    }

    @GetMapping("/find-by-city")
    public ResponseEntity<List<Person>> findByCity(City city) {
        List <Person> personCity = personService.findAll()
                .stream()
                .filter(x -> x.getAddress().getCity().equals(city))
                .collect(Collectors.toList());
        return new ResponseEntity<>(personCity, HttpStatus.OK);
    }
}
