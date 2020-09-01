/*
* Copyright 2020 VHT, Viettel. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/

package com.viettel.demo.javacore;

import java.util.TreeSet;

//import java.util.Set;
/**
* This is Ex6.4
* @author hoangcv
* @version 1.0
* @since established
*/
public class Ex6_4 {
    public static void main(String[] args) {
    //Set (Tree) init
    //SetA
    TreeSet<Integer> treeSet = new TreeSet<Integer>();
    //Add elements to tree set
    treeSet.add(3);
    treeSet.add(16);
    treeSet.add(24);
    treeSet.add(30);
    treeSet.add(60);
    //Compare and get element greater or equal
    System.out.println("Which >= 15 is " + treeSet.ceiling(15));
    }
}