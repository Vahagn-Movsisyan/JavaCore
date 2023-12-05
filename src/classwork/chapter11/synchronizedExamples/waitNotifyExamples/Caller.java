package classwork.chapter11.synchronizedExamples.waitNotifyExamples;

public class Caller {
    int number;
    boolean isSetValue = false;

    public synchronized int get() throws InterruptedException {
        while (!isSetValue) {
            wait();
        }
        System.out.println("Given " + number);
        isSetValue = false;
        notify();
        return number;
    }

    public synchronized void put(int number) throws InterruptedException {
        while (isSetValue) {
            wait();
        }
        this.number = number;
        isSetValue = true;
        System.out.println("Sended " + number);
        notify();
    }
}
