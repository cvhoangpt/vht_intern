/*
* Copyright 2020 VHT, Viettel. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/

package com.viettel.demo.javacore;
import java.util.Scanner;
/**
* This is the first thread program Ex7.1
* @author hoangcv
* @version 1.0
* @since 1.0
 */
public class Ex7_1 extends Thread {
    private static Scanner sc = new Scanner(System.in);

    /**
    * Main method
    * @param n is value of people input from keyboard 
    */
    public static void main(String[] args) {
        int n;
        do {
        	System.out.println("Enter the level: ");
            n = sc.nextInt();
        } while (n < 0);
        
        sc.close();

        for (int i = 1;i <= n;i++) {
            System.out.println("Processing, this is level #" + i);
            //use thread to pause program 1 second
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}