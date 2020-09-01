/*
* Copyright 2020 VHT, Viettel. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/

package com.viettel.demo.javacore;

import java.util.Scanner;
/**
 * Ex1.2
 * @author hoangcv
 * @version 1.0
 * @since established
 */
public class Ex1_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int minute;
		System.out.println("Input minute: ");
		minute = sc.nextInt();
		sc.close();
		System.out.println(minute + " minutes is approximately " + intoYear(minute) + " years and " + intoDay(minute) + " days");
	}
	// minute/60 = hour/24 = day/365
	/**
	 * This method which converts minutes to years
	 * @param year
	 * @return year
	 * @throws
	 */
	public static int intoYear(int min) {
		int year;
		year = min / 525600;
		return year;
	}
	
	/**
	 * This method which converts minutes to days
	 * @param day
	 * @return day
	 * @throws
	 */
	public static int intoDay(int min) {
		int day;
		day = min / 1440 - intoYear(min) * 365 ;
		return day;
	}
}
