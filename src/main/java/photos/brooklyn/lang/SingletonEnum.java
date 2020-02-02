package photos.brooklyn.lang;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonEnum {
    public enum Singleton {
        INSTANCE;
    }

    public static void main(String[] args) throws InterruptedException {
        final int size = 10;
        CountDownLatch cl = new CountDownLatch(size);
        ExecutorService svc = Executors.newFixedThreadPool(size);
        for (int i = 0; i < 10; i++) {
            svc.submit(() -> System.out.println(Singleton.INSTANCE));
            cl.countDown();
        }
        cl.await();
        svc.shutdown();
    }
}
