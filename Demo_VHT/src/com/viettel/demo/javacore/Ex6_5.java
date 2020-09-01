/*
* Copyright 2020 VHT, Viettel. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/

package com.viettel.demo.javacore;

import java.util.HashMap; 
//import java.util.Set;

/**
* This is Ex6.5
* @author hoangcv
* @version 1.0
* @since established
*/
public class Ex6_5 {  
    public static void main(String[] args) {
    //hashmap init
    HashMap<Integer,String> hm = new HashMap<Integer,String> (); //hm ~ hashmap
    hm.put(1, "Red");
    hm.put(2, "Green");
    hm.put(3, "Black");
    hm.put(4, "White");
    hm.put(5, "Blue");
    //check if map is empty
    boolean result = hm.isEmpty();
    //print result
    System.out.println("Is hash map empty: " + result);
    //remove all element
    hm.clear();
    //check if map is empty
    result = hm.isEmpty();
    //print result
    System.out.println("Is hash map empty: " + result);
    }
}