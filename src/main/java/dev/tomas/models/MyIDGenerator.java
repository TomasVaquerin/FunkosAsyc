package dev.tomas.models;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.atomic.AtomicLong;

public class MyIDGenerator {
    private static final Lock lock = new ReentrantLock();
    private static MyIDGenerator instance;
    private final AtomicLong myId = new AtomicLong(1);

    private MyIDGenerator() {}

    public synchronized static MyIDGenerator getInstance() {
        if (instance == null) {
            lock.lock();
            if (instance == null) {
                instance = new MyIDGenerator();
            }
            lock.unlock();
        }
        return instance;
    }

    public Long getAndIncrement() {
        return myId.getAndIncrement();
    }
}
