package photos.brooklyn.generics.recursive;

public class Immigrant extends IdentifiablePerson {
    public String getCountry() {
        return country;
    }

    private String country;

    public Immigrant(final String name, final int id, final String country) {
        super(name, id);
        this.country = country;
    }
}
