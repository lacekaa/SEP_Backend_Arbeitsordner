package sep.arbeitspaket.rest.address;

//Aufgabe 1
//        In diesem Arbeitspaket bekommt ihr einen Springboot Server mit H2-Datenbank und eine Angular
//        Frontend zu Verfügung gestellt.
//        Beginnt damit im Backend die Klassen Person.java und Adress.java zu bearbeiten, damit diese in der
//       Datenbank gespeichert werden und folgende Eigenschaften besitzen:
//        Person:
//        1. ID, welche automatisch generiert wird.
//        2. Vornamen
//        3. Nachnamen
//        4. Geburtsjahr
//        5. Adresse, welche über einen Fremdschlüssel gespeichert wird.
//        Adresse:
//        1. ID, welche automatisch gespeichert wird
//        2. Stadt
//        3. Straße
//        Man soll die Möglichkeit haben im Personen nach Geburtsjahr filtern.
//        Man soll Personen nach der Stadt suchen können.
//        Bearbeitet dazu im Backend die Klassen Person, Adress, PersonController und PersonRepository.
//        Bearbeitet im Client die Dateien: Person.service.ts, Person-Table.component.ts,
//        Person-Form.component.ts.

import javax.persistence.*;

import java.util.Objects;

import static org.apache.commons.lang3.Validate.notNull;

@Entity
@Table(name = "TAB_ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Embedded
    private City city;

    @Embedded
    private Street street;

    protected Address() {
        //JPA
    }

    public Address (City city, Street street) {
        this.city = notNull(city, "city may not be null");
        this.street = notNull(street, "street may not be null");
    }

    public Long getId() {
        return id;
    }

    public City getCity() {
        return city;
    }

    public Street getStreet() {
        return street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) && Objects.equals(city, address.city) && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, street);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city=" + city +
                ", street=" + street +
                '}';
    }
}
