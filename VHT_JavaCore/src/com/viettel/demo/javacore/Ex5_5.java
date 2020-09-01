package com.viettel.demo.javacore;

public class Test 
{ 
    public static int y; 
    public static void foo(int x) 
    { 
        System.out.print("foo "); 
        y = x; 
    } 
    public static int bar(int z) 
    { 
        System.out.print("bar "); 
        return y = z; 
    } 
    public static void main(String [] args ) 
    { 
        int t = 0; 
        assert t > 0 : bar(7); 
        assert t > 1 : foo(8); /* Line 18 */ 
        System.out.println("done "); 
    } 
}

/*
Ouput: Error
In line 18, assert do not allow to compare integer with void returning
*/ 