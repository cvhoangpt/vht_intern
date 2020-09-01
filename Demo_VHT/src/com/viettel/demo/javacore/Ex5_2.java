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
 * Ex5_2
 * @author hoangcv
 * @version 1.0 
 * @since established
 */
public class Ex5_2 {
	//Logger init
	static final Logger logger = Logger.getLogger(Ex5_2.class);
	/**
	 * This is main method
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) {
		Person p = null;
		
		try {
			p.moveAround();
		} catch (Exception e) {
			logger.error("Null Reference Exception");
		}
	}
}

/**
 * This interface for testing
 * @author hoangcv
 * @version 1.0
 * @since established
 */
interface canMove {
	public void moveAround();
}
/**
 * This class is abstract for testing
 * @author hoangcv
 * @version 1.0
 * @since established
 */
class Person implements canMove {

	public void moveAround() {
		System.out.println("Person is moving around ...");
	}
	
}

