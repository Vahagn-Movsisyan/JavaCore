package classwork.chapter11;

public class ThreadExample implements Runnable {
//    public static void main(String[] args) throws InterruptedException {
//
//        for (int i = 100000; i > 0 ; i--) {
//            System.out.print(i + " - " + i +  " _ " + i + " - " + i +  " _ " + i + " - " + i +  " _ " + i + " - " + i +  " _ " + i + " - " + i +  " _ " + i + " - " + i +  " _ " + i + " - " + i +  " _ " + i + " - " + i +  " _ " + i + " - " + i +  " _ " + i + " - " + i +  " _ " + i + " - " + i +  " _ " + i + " - " + i +  " _ ");
//            System.out.println((i + 13 * 54) / 2 + " | ");
//            System.out.println(i + " | " + i +  " || " + i + " | " + i +  " || " + i + " | " + i + " | " + i +  " || " + i + " | " + i +  " || " + i + " | " + i + " | " + i +  " || " + i + " | " + i +  " || " + i + " | " + i + " | " + i +  " || " + i + " | " + i +  " || " + i + " | " + i + " | " + i +  " || " + i + " | " + i +  " || " + i + " | " );
//            Thread.sleep(1);
//        }
//    }


    @Override
    public void run() {
        for (int i = 10; i > 0 ; i--) {
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
