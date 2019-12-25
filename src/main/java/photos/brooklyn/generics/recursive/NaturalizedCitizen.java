package photos.brooklyn.generics.recursive;

public class NaturalizedCitizen extends Citizen {
    private String country;

    public NaturalizedCitizen(final String name, final int id, final String hospitalName, final String country) {
        super(name, id, hospitalName);
        this.country = country;
    }
}
