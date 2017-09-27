/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rtcountthread;

/**
 *
 * @author Yvon Tee
 */
public class RTcountThread extends Thread{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Thread(new RTcountThread()).start();
    }
    
    public void run(){
        try{
            for (int x=0; x <= 10500; x++){
                System.out.print(x + " ");
                sleep(5000);
                
                if((x%50==0)&&(x!=0)){
                System.out.println("---You reached 50th numbers---");
            }
                
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
