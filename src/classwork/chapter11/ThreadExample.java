package classwork.chapter11;

public class ThreadExample implements Runnable {
    Thread thread;

    public ThreadExample() {
        this.thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 5; i > 0 ; i--) {
            System.out.print(i + " - " + i +  " _ " + i + " - " + i +  " _ " + i + " - " + i +  " _ " + i + " - " + i +  " _ " + i + " - " + i +  " _ " + i + " - " + i +  " _ " + i + " - " + i +  " _ " + i + " - " + i +  " _ " + i + " - " + i +  " _ " + i + " - " + i +  " _ " + i + " - " + i +  " _ " + i + " - " + i +  " _ ");
            System.out.println((i + 13 * 54) / 2 + " | ");
            System.out.println(i + " | " + i +  " || " + i + " | " + i +  " || " + i + " | " + i + " | " + i +  " || " + i + " | " + i +  " || " + i + " | " + i + " | " + i +  " || " + i + " | " + i +  " || " + i + " | " + i + " | " + i +  " || " + i + " | " + i +  " || " + i + " | " + i + " | " + i +  " || " + i + " | " + i +  " || " + i + " | " );
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getLocalizedMessage());
            }
        }
    }
}
