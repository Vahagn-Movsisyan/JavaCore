package classwork.chapter11.ThreadExamples;

import classwork.chapter11.ThreadExample;

public class MyThreadDemo {
    public static void main(String[] args) {

        new Thread(() -> {
            for (int i = 5; i > 0; i--) {
                System.out.println("Thread " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }).start();

        for (int i = 5; i > 0; i--) {
            System.out.println("Main " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
