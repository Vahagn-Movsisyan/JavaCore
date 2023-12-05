package classwork.chapter11;

//public class ThreadArrayExample {
//    static int[] arr = new int[500000000];
//    static int halfArr = arr.length / 2;
//    static int sumFirstThread = 0;
//    static int sumSecondThread = 0;
//
//    public static void main(String[] args) {
//
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = i + 1;
//        }
//
//        Thread firstThread = new Thread(() ->
//        {
//            for (int i = 0; i < halfArr; i++) {
//                sumFirstThread += arr[i];
//            }
//        });
//
//        Thread secondThread = new Thread(() ->
//        {
//            for (int i = halfArr; i < arr.length; i++) {
//                sumSecondThread += arr[i];
//            }
//        });
//
//        firstThread.start();
//        secondThread.start();
//
//        try {
//            firstThread.join();
//            secondThread.join();
//        } catch (InterruptedException e) {
//            System.out.println(e.getMessage());
//        }
//
//        int countAllNumbers = sumFirstThread + sumSecondThread;
//        System.out.println("The sum " + " " + countAllNumbers);
//
//    }
//}

//public class ThreadArrayExample {
//    public static void main(String[] args) {
//        int size = 500000000;
//        int[] arr = new int[size];
//        int halfArr = size / 2;
//        int sumFirstHalf = 0;
//        int sumSecondHalf = 0;
//
//        for (int i = 0; i < size; i++) {
//            arr[i] = i + 1;
//        }
//
//        for (int i = 0; i < halfArr; i++) {
//            sumFirstHalf += arr[i];
//        }
//
//        for (int i = halfArr; i < size; i++) {
//            sumSecondHalf += arr[i];
//        }
//
//        int countAllNumbers = sumFirstHalf + sumSecondHalf;
//        System.out.println("The sum: " + countAllNumbers);
//    }
//}

public class ThreadArrayExample {
    static int[] arr = new int[500000000];
    static int numThreads = 4;
    static int blockSize = arr.length / numThreads;
    static int[] partialSums = new int[numThreads];

    public static void main(String[] args) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            final int threadIndex = i;
            threads[i] = new Thread(() -> {
                int start = threadIndex * blockSize;
                int end = (threadIndex + 1) * blockSize;
                for (int j = start; j < end; j++) {
                    partialSums[threadIndex] += (arr[j] * arr[j]);
                }
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        int countAllNumbers = 0;
        for (int partialSum : partialSums) {
            countAllNumbers += partialSum;
        }

        System.out.println("The sum: " + countAllNumbers);
    }
}
