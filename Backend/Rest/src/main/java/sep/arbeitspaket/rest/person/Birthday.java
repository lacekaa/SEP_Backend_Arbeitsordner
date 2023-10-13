package sep.arbeitspaket.rest.person;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class Birthday {

    @Temporal(TemporalType.DATE)
    private Date birthday;

    protected Birthday() {
        //JPA
    }

    public Birthday(Date date) {
        this.birthday = date;
    }

    public Date getBirthday() {
        return birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Birthday birthday1 = (Birthday) o;
        return Objects.equals(birthday, birthday1.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(birthday);
    }

    @Override
    public String toString() {
        return "Birthday{" +
                "birthday=" + birthday +
                '}';
    }


}
