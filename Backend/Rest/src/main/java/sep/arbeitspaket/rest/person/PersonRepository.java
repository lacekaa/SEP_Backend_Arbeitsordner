package sep.arbeitspaket.rest.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sep.arbeitspaket.rest.address.City;

import java.util.List;
import java.util.Optional;

//Man soll die Möglichkeit haben im Personen nach Geburtsjahr filtern.
//        Man soll Personen nach der Stadt suchen können.
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

  //  List <Optional<Person>> findByCity(City city);

//    List <Optional<Person>> findByBirthday(Birthday birthday);

}
