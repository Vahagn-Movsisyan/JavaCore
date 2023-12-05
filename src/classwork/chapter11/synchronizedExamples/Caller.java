package classwork.chapter11.synchronizedExamples;

public class Caller implements Runnable {
    String msg;
    Thread thread;

    public Caller(String msg) {
        this.msg = msg;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public synchronized void run() {
        System.out.print("[ " + msg);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(" ]");
    }
}
