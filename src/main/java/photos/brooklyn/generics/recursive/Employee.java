package photos.brooklyn.generics.recursive;

import java.util.Date;

public class Employee extends Person {
    public Employee(final String name, final Date hiringDate) {
        super(name);
        this.hiringDate = hiringDate;
    }

    public Date getHiringDate() {
        return hiringDate;
    }

    private Date hiringDate;
}
