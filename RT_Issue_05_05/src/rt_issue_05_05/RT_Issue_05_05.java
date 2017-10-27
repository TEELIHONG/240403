package rt_issue_05_05;

import java.util.Collections;
import java.util.LinkedList;

public class RT_Issue_05_05 extends Thread {

    static LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {

        RT_Issue_05_05 find = new RT_Issue_05_05();
        for (int i = 0; i < 1000000; i++) {
            int a = (int) (Math.random() * 1000000);
            list.add(a);
        }

        //Delete comment to show the list of number in ascending order
        /*Collections.sort(list);
        System.out.println("Number list:");
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));    
        }*/

        Min.start();
        Min.join();
        Mod.start();
        Mod.join();
        Median.start();
        Median.join();

    }

    static RT_Issue_05_05 Min = new RT_Issue_05_05() {
        public void run() {
            double sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i);
            }
            double mean = sum / (list.size());
            System.out.println("MIN = " + mean);

            }
    };

    static RT_Issue_05_05 Mod = new RT_Issue_05_05() {
        public void run() {
            int[] count = new int[1000000];

            for (int i = 0; i < list.size(); i++) {
                count[list.get(i)]++;
            }

            int index = count.length - 1;
            for (int i = count.length - 2; i >= 0; i--) {
                if (count[i] >= count[index]) {
                    index = i;
                }
            }
            System.out.println("MOD = " + index);
        }
    };

    static RT_Issue_05_05 Median = new RT_Issue_05_05() {
        public void run() {
            Collections.sort(list);
            int middle = list.size() / 2;
            double median;
            if (list.size() % 2 == 1) {
                median = (int) list.get(middle);
            } else {
                median = (int) ((int) (list.get(middle - 1) + list.get(middle)) / 2.0);
            }
            System.out.println("MEDIAN = " + (double) median);
        }
    };
}
