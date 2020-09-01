/*
* Copyright 2020 VHT, Viettel. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
 
package com.viettel.demo.javacore;

/*
 * Using Log4j version 2.13.3
 * Needed-Library: 
 * log4j-1.2-api-2.13.3
 * log4j-api-2.13.3
 * log4j-core-2.13.3
 */
import org.apache.log4j.Logger;

/**
* This class is the first example about Exception
* @author hoangcv
* @version 1.1
* @since 1.0
 */
public class Ex5_1 {
	//Logger init
	static final Logger logger = Logger.getLogger(Ex5_1.class);
	/**
	 * This is main method
	 * @param e is value of Exception
	 * @param args
	 * @throws Exception
	 */
    public static void main(String[] args) {
        try {
        	throw new Exception("New Exception");
        } catch (Exception e) {
        	System.out.println("Something went wrong.");
        } finally {
        	logger.error("Please try again.");
        }
    }
}
