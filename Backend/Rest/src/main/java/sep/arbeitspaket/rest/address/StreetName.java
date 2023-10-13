package sep.arbeitspaket.rest.address;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class StreetName {

    private String name;

    protected StreetName() {
        //JPA
    }

    public StreetName(String streetName) {
        this.name = streetName;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StreetName that = (StreetName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
