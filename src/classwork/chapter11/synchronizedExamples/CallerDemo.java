package classwork.chapter11.synchronizedExamples;

public class CallerDemo {
    public static void main(String[] args) {
        Caller caller1 = new Caller("Welcome");
        Caller caller2 = new Caller("to");
        Caller caller3 = new Caller("synchronized");
        Caller caller4 = new Caller("world");

        try {
            caller1.thread.join();
            caller2.thread.join();
            caller3.thread.join();
            caller4.thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End!");
    }
}
