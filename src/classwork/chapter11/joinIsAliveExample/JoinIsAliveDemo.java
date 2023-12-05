package classwork.chapter11.joinIsAliveExample;

public class JoinIsAliveDemo {
    public  static void main(String[] args) {
        JoinIsAlive joinIsAlive1 = new JoinIsAlive("One");
        JoinIsAlive joinIsAlive2 = new JoinIsAlive("Two");
        JoinIsAlive joinIsAlive3 = new JoinIsAlive("Three");

        System.out.println(joinIsAlive1.thread.isAlive());
        System.out.println(joinIsAlive2.thread.isAlive());
        System.out.println(joinIsAlive3.thread.isAlive());

        try {
            joinIsAlive1.thread.join();
            joinIsAlive2.thread.join();
            joinIsAlive3.thread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(joinIsAlive1.thread.isAlive());
        System.out.println(joinIsAlive2.thread.isAlive());
        System.out.println(joinIsAlive3.thread.isAlive());

        for (int i = 5; i > 0; i--) {
            System.out.println("Main: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
