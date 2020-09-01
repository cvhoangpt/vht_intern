package com.viettel.demo.javacore;

/**
 * Ex7.2
 * @author hoangcv
 * @version 
 * @since
 */
public class Ex7_2 {
    static String message;
    
    private static class CorrectorThread extends Thread {
        public void run() {
            try {
                sleep(1000); 
            } catch (InterruptedException e) {}
            // Key statement 1:
            message = "Mares do eat oats."; 
        }
    }

    public static void main(String args[]) throws InterruptedException {
        (new CorrectorThread()).start();
        message = "Mares do not eat oats.";
        Thread.sleep(2000);
        // Key statement 2:
        System.out.println(message);
    }
}

/*
 * The application should print out "Mares do eat oats." 
 * Is it guaranteed to always do this? 
 * If not, why not? Would it help to change the parameters of the two invocations of Sleep? 
 * How would you guarantee that all changes to message will be visible in the main thread?
*/

/*
 * The application always print "Mares do eat oats" because Key statement 1 run thread before key statement 2 do it
 * Some solves:
 * - Retain a reference in CorrectorThread and use Thread.join() before print message
 * - Use synchronized method
 */
