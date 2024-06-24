package org.example.numbattlers.internal.service;

public class ThreadSleeper implements Sleeper{
    @Override
    public void sleep(long millis) throws InterruptedException {
        Thread.sleep(millis);
    }
}
