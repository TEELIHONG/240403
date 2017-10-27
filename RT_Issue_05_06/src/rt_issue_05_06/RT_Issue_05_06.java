package rt_issue_05_06;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class RT_Issue_05_06 extends Thread {

    public static void main(String[] args) throws InterruptedException {

        CountThread countThread = new CountThread();

        Thread t1 = new Thread(countThread, "Thread-1");
        Thread t2 = new Thread(countThread, "Thread-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(t1.getName() + " = " + countThread.CT1());
        System.out.println(t2.getName() + " = " + countThread.CT2());
        
        System.out.println("Total = " + countThread.CTtotal());
       //OR //System.out.println("Total = " + (countThread.CT1() + countThread.CT2()));
    }

    static class CountThread implements Runnable {

        int cT1, cT2, cTtotal;
        AtomicInteger T1 = new AtomicInteger();
        AtomicInteger T2 = new AtomicInteger();
        AtomicInteger Ttotal = new AtomicInteger();
        Random randomNo = new Random();

        public void run() {

            while (cTtotal < 1000) {

                int num = randomNo.nextInt(3000) + 500;
                cTtotal = Ttotal.incrementAndGet();

                if ("Thread-1".equals(Thread.currentThread().getName())) {
                    cT1 = T1.incrementAndGet();

                }
                if ("Thread-2".equals(Thread.currentThread().getName())) {
                    cT2 = T2.incrementAndGet();
                }
            }
        }

        public int CT1() {
            return cT1;
        }

        public int CT2() {
            return cT2;
        }

       public int CTtotal() {
            return cTtotal;
        }
    }

}
