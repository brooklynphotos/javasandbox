package photos.brooklyn.generics.recursive;

import java.util.Date;

public class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {
    private Date hireDate;
    EmployeeBuilder withHireDate(Date hireDate) {
        this.hireDate = hireDate;
        return this;
    }

    public Employee build() {
        return new Employee(super.build().getName(),hireDate);
    }

}
