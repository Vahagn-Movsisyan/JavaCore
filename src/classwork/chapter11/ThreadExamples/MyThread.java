package classwork.chapter11.ThreadExamples;

public class MyThread implements Runnable {
    Thread thread;

    public MyThread() {
        this.thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 5; i > 0; i--) {
            System.out.println(i + "GG");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
