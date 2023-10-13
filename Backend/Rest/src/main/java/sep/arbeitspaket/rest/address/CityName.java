package sep.arbeitspaket.rest.address;

import javax.persistence.Embeddable;
import java.util.Objects;

import static org.apache.commons.lang3.Validate.notNull;

@Embeddable
public class CityName {

    private String name;

    protected CityName(){
        //JPA
    }

    public CityName(String cityName){
        this.name = notNull(cityName, "cityname may not be null");
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityName cityName = (CityName) o;
        return Objects.equals(name, cityName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "CityName{" +
                "name='" + name + '\'' +
                '}';
    }
}
