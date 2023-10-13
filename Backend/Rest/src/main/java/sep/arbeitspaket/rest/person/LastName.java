package sep.arbeitspaket.rest.person;

import javax.persistence.Embeddable;

import java.util.Objects;

import static org.apache.commons.lang3.Validate.notNull;

@Embeddable
public class LastName {

    private String lastName;

    protected LastName(){
        //JPA
    }

    public LastName(String lastName){
        this.lastName = notNull(lastName, "lastName may not be null");
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LastName lastName1 = (LastName) o;
        return Objects.equals(lastName, lastName1.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName);
    }

    @Override
    public String toString() {
        return "LastName{" +
                "lastName='" + lastName + '\'' +
                '}';
    }
}
