package sep.arbeitspaket.rest.person;

//        Person:
//        1. ID, welche automatisch generiert wird.
//        2. Vornamen
//        3. Nachnamen
//        4. Geburtsjahr
//        5. Adresse, welche über einen Fremdschlüssel gespeichert wird.

import sep.arbeitspaket.rest.address.Address;

import javax.persistence.*;

import java.util.Objects;

import static org.apache.commons.lang3.Validate.notNull;

@Entity
@Table(name = "TAB_PERSON")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERS_ID")
    private Long id;

    @Embedded
    private FirstName firstName;

    @Embedded
    private LastName lastName;

    @Embedded
    private Birthday birthday;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PERS_ADR_ID")
    private Address address;

    protected Person() {
        //JPA
    }

    public Person(FirstName firstName, LastName lastName, Birthday birthday) {
        this.firstName = notNull(firstName, "firstName may not be null");
        this.lastName = notNull(lastName, "lastName may not be null");
        this.birthday = notNull(birthday, "birthday may not be null");
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public FirstName getFirstName() {
        return firstName;
    }

    public LastName getLastName() {
        return lastName;
    }

    public Birthday getBirthday() {
        return birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(birthday, person.birthday) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birthday, address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", birthday=" + birthday +
                ", address=" + address +
                '}';
    }
}
