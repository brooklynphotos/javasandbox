package photos.brooklyn.generics.recursive;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparisonUse {
    public static void main(String[] args) {
        comparable();
        comparator();
    }

    static void comparator() {
        List<Immigrant> ids = Arrays.asList(new Immigrant("abjjj", 1, "India"), new Immigrant("xqu", 2, "China"));
        Comparator<Person> cmp = (a, b) -> a.getName().length() - b.getName().length();
        // ids is a list of Immigrant, which is a subclass of IdentifiablePerson
        // cmp is a comparator for Person, whichi s a superclass of Identifiable person
        IdentifiablePerson maxElement = ComparisonUse.<IdentifiablePerson>max(ids, cmp);
        System.out.printf("Max is %s%n",maxElement);
    }

    static void comparable() {
        List<NaturalizedCitizen> ids = Arrays.asList(new NaturalizedCitizen("abjjj", 1, "Brooklyn", "India"), new NaturalizedCitizen("xqu", 2, "Methodist", "China"));
        // ids is a list of Immigrant, which is a subclass of IdentifiablePerson
        // cmp is a comparator for Person, whichi s a superclass of Identifiable person
        IdentifiablePerson maxElement = ComparisonUse.<Citizen>max(ids);
        System.out.printf("Max is %s%n",maxElement);
    }

    static <T extends Comparable<? super T>> T max(List<? extends T> list) {
        T currentMax = null;
        for (T i : list) { // produces an instance of T or any of its subclasses
            if (currentMax==null || currentMax.compareTo(i) > 0) {
                currentMax = i;
            }
        }
        return currentMax;
    }

    /**
     *
     * @param list a list of T or of any of its subclasses
     * @param cmp comparator for T or any of its super classes
     * @param <T>
     * @return
     */
    static <T> T max(List<? extends T> list, Comparator<? super T> cmp) {
        T currentMax = null;
        for (T i : list) { // produces an instance of T or any of its subclasses
            // comparator consumes an instance of T or a super class
            if (currentMax==null || cmp.compare(i, currentMax) > 0) {
                currentMax = i;
            }
        }
        return currentMax;
    }
}
