package photos.brooklyn.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalExample {
    final static Logger logger = LoggerFactory.getLogger(ThreadLocalExample.class);
    final static ThreadLocal<Integer> id = ThreadLocal.withInitial(()->1);
    final static int LOOPS = 10;

    public static void main(String[] args) {
        final int threadCount = Integer.parseInt(args[0]);
        for (int i = 0; i < threadCount; i++) {
            Thread t = new Thread(()->{
                for (int s = 0; s < LOOPS; s++) {
                    final int sleepTime = ThreadLocalRandom.current().nextInt(100, 1000);
                    id.set(sleepTime);
                    logger.info("{}: Sleeping {} ms", s, id.get());
                }
            });
            t.start();
        }
    }
}
