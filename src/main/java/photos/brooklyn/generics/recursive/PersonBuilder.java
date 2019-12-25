package photos.brooklyn.generics.recursive;

public class PersonBuilder<T extends PersonBuilder<T>> {
    private String name;
    public T withName(String name) {
        this.name = name;
        return (T)this;
    }
    public Person build() {
        return new Person(name);
    }
}
