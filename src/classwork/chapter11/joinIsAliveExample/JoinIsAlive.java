package classwork.chapter11.joinIsAliveExample;

public class JoinIsAlive implements Runnable {
    String name;
    Thread thread;
    public JoinIsAlive(String name) {
        this.name = name;
        this.thread = new Thread(this, name);
        thread.start();
    }
    @Override
    public  void run() {
        for (int i = 5; i > 0 ; i--) {
            System.out.println(name + ": " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
