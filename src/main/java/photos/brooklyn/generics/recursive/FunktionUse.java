package photos.brooklyn.generics.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class FunktionUse {
    public static void main(String[] args) {
        // The function takes an object and converts it to an Employee
        Funktion<Object, Employee> f = x -> new EmployeeBuilder().withHireDate(new Date()).withName(x.toString()).build();
        // the input is a list of Strings, the mapper is OK with a function that takes a string or a super class
        List<String> strs = Arrays.asList("m","q","t");
        // the output is a list of Person, the mapper is OK with a function that returns a Person or a subclass
        List<Person> ems = map(strs, f);
        System.out.printf("length: %d", ems.size());
    }

    public static <T,R> List<R> map(List<T> list, Funktion<? super T, ? extends R> f) {
        List<R> newlist = new ArrayList<>();
        for (T e : list) {
            newlist.add(f.apply(e));
        }
        return newlist;
    }
}
