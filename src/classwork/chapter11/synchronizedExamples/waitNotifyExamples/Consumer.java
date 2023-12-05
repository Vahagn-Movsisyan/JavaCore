package classwork.chapter11.synchronizedExamples.waitNotifyExamples;

public class Consumer implements Runnable {
    Caller caller;

    Consumer (Caller caller) {
        this.caller = caller;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                caller.get();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
