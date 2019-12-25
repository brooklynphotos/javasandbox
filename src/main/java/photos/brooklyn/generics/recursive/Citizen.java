package photos.brooklyn.generics.recursive;

public class Citizen extends IdentifiablePerson implements Comparable<Citizen> {
    private String hospitalName;

    public Citizen(final String name, final int id, final String hospitalName) {
        super(name, id);
        this.hospitalName = hospitalName;
    }

    @Override
    public int compareTo(final Citizen o) {
        return this.hospitalName.length() - o.hospitalName.length();
    }
}
