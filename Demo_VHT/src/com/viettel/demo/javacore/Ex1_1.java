/*
* Copyright 2020 VHT, Viettel. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/

package com.viettel.demo.javacore;

import java.util.Scanner;
/**
 * Ex1.1
 * @author hoangcv
 * @version 1.0
 * @since established
 */
public class Ex1_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("Input n between 0 and 1000: ");
		n = sc.nextInt();
		while (n < 0 || n > 1000) {
			System.out.println("Try again: ");
			n = sc.nextInt();
		}
		sc.close();
		System.out.println("The sum of all digits in " + n + " is " + sumDigit(n));
	}
	
	/**
	 * This is method which separates one number to each digits
	 * @param sum to get sum of digits
	 * @param temp is template value
	 * @return sum
	 * @throws
	 */
	public static int sumDigit(int n) {
		int sum = 0;
		int temp = 0;
		while (n > 0) {
			temp = n % 10;
			sum += temp;
			n /= 10;
		}
		return sum;
	}
}