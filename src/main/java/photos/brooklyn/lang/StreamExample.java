package photos.brooklyn.lang;

import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);
        integerStream.map(x -> x * x).forEach(System.out::println);
        Stream<String> stringStream = Stream.generate(() -> "Oh");
        stringStream.limit(4).forEach(System.out::println);
        makePlusMinus().skip(3).limit(9).forEach(System.out::println);
        System.out.println(makePlusMinus().limit(5).anyMatch(s -> s.length()==10));
        System.out.println(Stream.of(1, 2, 3, 4).reduce(0, Integer::sum));

    }

    static final Stream<String> makePlusMinus() {
        return Stream.iterate("+", s -> {
            if (s.charAt(s.length() - 1) == '+') {
                return s + "-";
            } else {
                return s + "+";
            }
        });
    }
}
