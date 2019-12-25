package photos.brooklyn.generics.recursive;

import java.util.Date;

public class Runner {
    public static void main(String[] args) {
        Person p = new PersonBuilder().withName("hi").build();
        System.out.printf("PersonL %s%n",p.getName());
        Employee e = new EmployeeBuilder().withName("hi").withHireDate(new Date()).build();
        System.out.printf("Employee: %s%n", e.getHiringDate());
    }
}
