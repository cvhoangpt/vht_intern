
/*
* Copyright 2020 VHT, Viettel. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.viettel.demo.javacore;

import java.util.HashSet;
import java.util.Set;

/**
* This is Ex6.3
* @author hoangcv
* @version 1.0
* @since established
*/
public class Ex6_3 {
    public static void main(String[] args) {
    //Set (Hash) init
    //SetA
    Set<String> setA = new HashSet<String>();
    //Add elements to hash set
    setA.add("cai");
    setA.add("viet");
    setA.add("hoang");
    //SetB
    Set<String> setB = new HashSet<String>();
    //Add elements to hash set
    setB.add("viet");
    setB.add("dang");
    setB.add("thanh");
    //compare two set and retain the same element
    setA.retainAll(setB);
    System.out.println(setA);
    }
}