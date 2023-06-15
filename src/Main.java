public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter(10);
        Thread thread1 = new Thread(new GreetingTask("Hello,", counter));
        Thread thread2 = new Thread(new GreetingTask("World!", counter));
        thread1.start();
        thread2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.interrupt();
        thread2.interrupt();
    }
}

class Counter {
    private int value;

    public Counter(int value) {
        this.value = value;
    }

    public synchronized void decrement() {
        value--;
    }

    public synchronized boolean isZero() {
        return value == 0;
    }
}

class GreetingTask implements Runnable {
    private String greeting;
    private Counter counter;

    public GreetingTask(String greeting, Counter counter) {
        this.greeting = greeting;
        this.counter = counter;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.print(greeting);
            try {
                counter.decrement();
                Thread.sleep(100);
                if (counter.isZero()) {
                    Thread.currentThread().interrupt();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
