package com.viettel.demo.javacore;
/*
* Copyright 2020 VHT, Viettel. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/

import java.util.LinkedList;

/**
* This is Ex6.1
* @author hoangcv
* @version 1.0
* @since established
*/
public class Ex6_1 {
    public static void main(String[] args) {
    //LinkedList init
    LinkedList<Integer> list = new LinkedList<Integer>();
    //Add element to special position
    list.add(3,6);
    list.add(2,7);
    //Print list
    System.out.println(list);
    }
}