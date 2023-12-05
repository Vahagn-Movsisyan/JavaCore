package classwork.chapter11.synchronizedExamples.waitNotifyExamples;

public class Producer implements Runnable {
    Caller caller;

    Producer (Caller caller) {
        this.caller = caller;
        new Thread(this).start();
    }
    @Override
    public void run() {
        int i = 0;
        while (true) {
            try {
                caller.put(i++);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
