package photos.brooklyn.lang;

import java.util.ArrayList;
import java.util.List;

public class SingletonDC {
    private static volatile SingletonDC instance;

    public static void main(String[] args) throws InterruptedException {
        final int count = 20;
        final List<Thread> threads = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            final Thread t = new Thread(() -> System.out.println(SingletonDC.getInstance()));
            t.start();
            threads.add(t);
        }
        for (Thread t : threads) {
            t.join();
        }
    }

    public static SingletonDC getInstance() {
        if (instance == null) {
            synchronized (SingletonDC.class) {
                if (instance == null) {
                    instance = new SingletonDC();
                }
            }
        }
        return instance;

    }
}
