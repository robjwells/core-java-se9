package ch03.ex09;

public class Greeter implements Runnable {
    private final int n;
    private final String target;

    public Greeter(int n, String target) {
        this.n = n;
        this.target = target;
    }

    @Override
    public void run() {
        for (int x = 0; x < n; x++) {
            System.out.println("Hello, " + target);
        }
    }

    public static void main(String[] args) {
        Greeter alice = new Greeter(5, "Alice");
        Greeter bob = new Greeter(3, "Bob");

        Thread at = new Thread(alice);
        Thread bt = new Thread(bob);
        at.start();
        bt.start();
    }
}
