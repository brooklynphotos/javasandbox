package photos.brooklyn.generics.recursive;

public interface Funktion<T, R> {
    R apply(T x);
}
