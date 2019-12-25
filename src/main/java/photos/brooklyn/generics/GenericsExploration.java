package photos.brooklyn.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsExploration {
    public static void main(String[] args) {
        consumer();
        producer();
    }

    private static interface Shape{
        int getArea();
    }

    private static class Square implements Shape{
        private int length;

        public Square(final int length) {
            this.length = length;
        }

        @Override
        public int getArea() {
            return length * length;
        }
    }

    private static void producer() {
        final List<Shape> shapes = new ArrayList<>();
        final List<? super Square> squares = shapes;
        squares.add(new Square(2));
        System.out.printf("Area is %d", shapes.get(0).getArea());
    }

    private static void consumer() {
        final List<Integer> ints = new ArrayList<>();
        ints.add(2);
        ints.add(4);

        final List<? extends Number> numbers = ints;
        Number first = numbers.get(0);
//        numbers.add(first);
        System.out.printf("First %d", first);
    }
}
