/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rttwothread;

/**
 *
 * @author Yvon Tee
 */
public class RTtwothread extends Thread {

    /**
     * @param args the command line arguments
     */
 
public static void main(String[] args) {
     new Thread(new RTtwothread()).start();
}

public void printA(int a){
    if (a==5){
        for (int i=0;i<10;i++){
            System.out.print("A");
        }
        System.out.print(" ");
    }
}

@Override
public void run() {
    try {
        for (int x = 0; x < 10; x++) {
            System.out.print((x+1) + " ");
            sleep(1000);
            printA(x+1);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}