package classwork.chapter11.synchronizedExamples.waitNotifyExamples;

public class PcFixed {
    public static void main(String[] args) {
        Caller caller = new Caller();
        new Producer(caller);
        new Consumer(caller);
    }
}
