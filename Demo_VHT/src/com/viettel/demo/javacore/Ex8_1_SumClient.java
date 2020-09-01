/*
* Copyright 2020 VHT, Viettel. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/


package com.viettel.demo.javacore;

import java.net.*;
import java.io.*;
import java.util.Scanner;

import com.viettel.demo.common.Constants;

/**
 * Ex 8.1.
 * 
 * This is the first program about TCP client/server. 
 * You must run SumClient after running SumServer
 * @author hoangcv
 * @version 1.0
 * @since 1.0
 */
public class Ex8_1_SumClient {
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * This main method is client-side
	 * @param socketOfClient 
	 * @param a is the first number
	 * @param b is the second number
	 * @param sum is a+b
	 * @param br
	 * @param bw
	 */
	public static void main(String[] args) {
		Socket socketOfClient = null;
		double a;
		double b;
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			// connect to server with server ip and server port
			socketOfClient = new Socket(Constants.SERVER_HOST, Constants.SERVER_PORT);
			//print connecting status
			System.out.println("Connected: " + socketOfClient);
			
			// with output stream, client can connect to server
			bw = new BufferedWriter(new OutputStreamWriter(socketOfClient.getOutputStream()));
			// with input stream, server can connect to client
			br = new BufferedReader(new InputStreamReader(socketOfClient.getInputStream()));
			
		} catch (UnknownHostException uhe) {
			System.err.println("Do not know host " + Constants.SERVER_HOST);
			return;
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} 
		
		System.out.println("Input first number:");
		a = sc.nextDouble();
		System.out.println("Input second number:");
		b = sc.nextDouble();
		String aStr = String.valueOf(a);
		String bStr = String.valueOf(b);
		try {
			// write output socket client
			bw.write(aStr);
			bw.newLine();
			bw.flush();
			bw.write(bStr);
			bw.newLine();
			bw.flush();
			
			// read Server responding
			String responseLine;
			while ((responseLine = br.readLine()) != null) {
				System.out.println("Server respond >>  " + responseLine);
	            if (responseLine.indexOf("OK") != -1) {
	            	break;
	            }
			}
			bw.close();
			br.close();
			socketOfClient.close();
		} catch (UnknownHostException uhe) {
			uhe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} 
	}
}
