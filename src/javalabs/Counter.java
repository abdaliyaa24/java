package javalabs;

import java.util.Scanner;
class UnsynchronizedCounterTest {

    static class Counter {
        int count;
        void inc() {
            count = count+1;
        }
        int getCount() {
            return count;
        }
    }

    static Counter counter;
    static int numberOfIncrements;

    static class IncrementerThread extends Thread {
        public void run() {
            for (int i = 0; i < numberOfIncrements; i++) {
                counter.inc();
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {

            System.out.println();
            System.out.print("Number of threads: ");
            int numberOfThreads = in.nextInt();
            if (numberOfThreads <= 0)
                break;

            do {
                System.out.println();
                System.out.println("Number of increments: ");
                numberOfIncrements = in.nextInt();
                if (numberOfIncrements < 1) {
                    System.out.println("Number of increments must be positive.");
                    numberOfIncrements = 1;
                }
            } while (numberOfIncrements <= 0);


            IncrementerThread[] workers = new IncrementerThread[numberOfThreads];
            counter = new Counter();
            for (int i = 0; i < numberOfThreads; i++)
                workers[i] = new IncrementerThread();
            for (int i = 0; i < numberOfThreads; i++)
                workers[i].start();



            for (int i = 0; i < numberOfThreads; i++) {
                try {
                    workers[i].join();
                }
                catch (InterruptedException e) {
                }
            }

            System.out.println("Value of counter is: " + counter.getCount());


        }

    }


}

