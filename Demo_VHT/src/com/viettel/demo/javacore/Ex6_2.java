package com.viettel.demo.javacore;
/*
* Copyright 2020 VHT, Viettel. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/

import java.util.ArrayList;

/**
* This is Ex6.2
* @author hoangcv
* @version 1.0
* @since established
*/
public class Ex6_2 {
    public static void main(String[] args) {
    //ArrayList init
    ArrayList<String> list = new ArrayList<String>();
    //Add element to special position
    list.add("cai");
    list.add("viet");
    list.add("hoang");
    //access one of element
    System.out.println(list.get(2));
    }
}