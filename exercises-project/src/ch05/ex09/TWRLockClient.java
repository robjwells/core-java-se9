package ch05.ex09;

import java.util.concurrent.locks.ReentrantLock;

public class TWRLockClient {
    public static void main(String[] args) throws Exception {
        ReentrantLock lock = new ReentrantLock();
        try (var lockHelper = new ReentrantLockHelper(lock)) {
            System.out.println("Client: Inside the try-with-resources.");
        }
    }
}
