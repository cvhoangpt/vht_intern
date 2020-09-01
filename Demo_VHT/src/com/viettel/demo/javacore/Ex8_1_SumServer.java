/*
* Copyright 2020 VHT, Viettel. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/


package com.viettel.demo.javacore;

import java.io.*;
import java.net.*;

import java.util.Vector;

import com.viettel.demo.common.Constants;

/**
 * Ex 8.1
 * This is the class about Server-Side.
 * You must run SumServer before running SumClient
 * @author hoangcv
 * @version 1.0
 * @since 1.0
 */
public class Ex8_1_SumServer {
	// the SERVER_PORT is default
	//public final static int SERVER_PORT = 9992;
	
	/**
	 * This is main method to create, send and receive from client. 
	 * The server can calculate sum of 2 number which receive from client,
	 * afterthat returning to client result of sum two numbers. 
	 * @param serverSocket is value to init ServerSocket (ServerPort)
	 * @param line as String to read each lines of data from client
	 * @param br is object of BufferedReader to receive message from client to server
	 * @param bw is object of BufferedWriter to send message from server to client
	 * @param vector is object of Vector
	 * @param sumResult is 2 numbers
	 * @param sumResultStr is converted-value of sumResult to String
	 */
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		String line;
		BufferedReader br;
		BufferedWriter bw;
		Socket socketOfServer = null;
		// this Vector 
		Vector<Double> vector = new Vector<Double>();
		
		double sumResult;
		String sumResultStr;
		//int i = 0;
		try {
			System.out.println("Binding to port " + Constants.SERVER_PORT);
			// init Server Port
			serverSocket = new ServerSocket(Constants.SERVER_PORT);
			System.out.println("Server started: " + serverSocket);
		} catch (IOException ioe) {
			System.err.println(ioe);
			System.exit(1);
		}
		
		try {
			System.out.println("Holding on a client ...");
			// allow server accept client
			socketOfServer = serverSocket.accept();
			System.out.println("Accept a client");
			// open thread IO in Socket
			br = new BufferedReader(new InputStreamReader(socketOfServer.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socketOfServer.getOutputStream()));
			
			while (true) {
				// read message from client and add numbers to vector
				line = br.readLine();
				vector.add(Double.parseDouble(line)); 
				//System.out.println("line: " + line);
				sumResult = sum(vector);
				if (vector.size() == 2) {
					sumResultStr = String.valueOf(sumResult);
					//System.out.println("sumRS" + sumResultStr);
					bw.write(sumResultStr);
					bw.newLine();
					bw.flush();
				}
			}			
		} catch (IOException ioe) {
			System.err.println(ioe);
			ioe.printStackTrace();
		} finally {
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("Server stopped.");
	}
	
	/**
	 * This method to calculate sum of 2 numbers send from client
	 * @param sum as num + num
	 * @return sum as double
	 */
	public static double sum(Vector<Double> vector) {
		double sum = 0;
		for (double value : vector) {
			sum += value;
		}
		return sum;
	}
}
