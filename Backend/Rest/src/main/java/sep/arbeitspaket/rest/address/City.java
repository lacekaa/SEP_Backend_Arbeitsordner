package sep.arbeitspaket.rest.address;

import static org.apache.commons.lang3.Validate.notNull;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.util.Objects;

@Embeddable
public class City {

    @Embedded
    private CityName name;

    public City(CityName name) {
        this.name = notNull(name, "name may not be null");
    }

    protected City() {
        // for JPA
    }

    public CityName getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "City{" +
                "name=" + name +
                '}';
    }
}

