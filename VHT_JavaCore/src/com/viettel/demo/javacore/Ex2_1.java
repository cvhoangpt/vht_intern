/*
* Copyright 2020 VHT, Viettel. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/

package com.viettel.demo.javacore;

import java.util.Scanner;

/**
 * 
 * @author hoangcv
 * @version 1.0
 * @since established
 */
public class Ex2_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a;
		double b;
		double c;
		System.out.println("Input the first number: ");
		a = sc.nextDouble();
		System.out.println("Input the second number: ");
		b = sc.nextDouble();
		System.out.println("Input the third number: ");
		c = sc.nextDouble();
		sc.close();
		System.out.println("The smallest value is " + minNumber(a, b, c));
	}
	
	public static double minNumber(double a, double b, double c) {
		double min = a;
		if (a > b) {
			min = b;
		}
		else if (a > c) {
			min = c;
		}
		return min;
	}
}
