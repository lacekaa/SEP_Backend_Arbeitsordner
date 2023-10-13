package sep.arbeitspaket.rest.person;

import javax.persistence.Embeddable;

import java.util.Objects;

import static org.apache.commons.lang3.Validate.notNull;

@Embeddable
public class FirstName {

    private String firstName;

    protected FirstName(){
        //JPA
    }

    public FirstName(String firstName){
        this.firstName = notNull(firstName, "firstName may not be null");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FirstName firstName1 = (FirstName) o;
        return Objects.equals(firstName, firstName1.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName);
    }

    @Override
    public String toString() {
        return "FirstName{" +
                "firstName='" + firstName + '\'' +
                '}';
    }
}
