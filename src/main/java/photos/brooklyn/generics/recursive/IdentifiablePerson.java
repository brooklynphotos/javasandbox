package photos.brooklyn.generics.recursive;

public class IdentifiablePerson extends Person {
    public int getId() {
        return id;
    }

    private int id;

    public IdentifiablePerson(final String name, final int id) {
        super(name);
        this.id = id;
    }

    @Override
    public String toString() {
        return "IdentifiablePerson{" +
                "id=" + id +
                '}';
    }
}
