//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Issue Ex 05_04
//Matrik: #240403
//Name: #Tee Li Hong

package rt_issue_05_04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class RT_Issue_05_04 extends Thread{

private static long endS,endC,startS,startC,elapsedTime;
static int max = Integer.MIN_VALUE;
static ArrayList<Integer> list = new ArrayList<>();


public static void main(String[] args) throws InterruptedException {

    for (int i = 0; i <= 1000000; i++) {
            list.add(i);
        }   
    Collections.shuffle(list);
    
    sequentialP.start();
    sequentialP.join();
    concurrentP.start();
    
}

 static RT_Issue_05_04 sequentialP = new RT_Issue_05_04(){ 

    @Override
    public void run(){
    startS = System.nanoTime();

        for (int x = 0; x < list.size(); x++) {
            if(list.get(x) > max){
                max = list.get(x);
            }
        }
    endS = System.nanoTime();
    elapsedTime = endS - startS;
    double seconds = (double)elapsedTime / 1000000000.0;
    System.out.printf("Sequential Program = %.6f seconds",seconds);
    }
    
};

static RT_Issue_05_04 concurrentP = new RT_Issue_05_04(){      
    @Override
    public void run(){
    startC = System.nanoTime();

    ExecutorService executor = Executors.newFixedThreadPool(list.size());
    
    IntStream.range(1000000,0)
        .forEach(i -> {
            Runnable task = () ->{
                for (int x = 0; x < list.size(); x++) {
                    if(list.get(x) > max){
                        max = list.get(x);
                    }
                }
            };
            executor.submit(task);
        });

    executor.shutdown();

    endC = System.nanoTime();
    elapsedTime = endC - startC;
    double seconds = (double)elapsedTime / 1000000000.0;
    System.out.printf("\nConcurrent Program = %.6f seconds\n",seconds);
    }
    
};
}