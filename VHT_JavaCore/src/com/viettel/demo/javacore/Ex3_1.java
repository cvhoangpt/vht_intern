/*
* Copyright 2020 VHT, Viettel. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
 
package com.viettel.demo.javacore;
 
import java.lang.Math; 
 
/**
 * Ex3.1
 * @author hoangcv
 * @version 1.0
 * @since established
 */ 
public class Ex3_1 {
	public static void main(String[] args) {
		Cylinder cylinder = new Cylinder();
		System.out.println("Volume of Cylnder is " + cylinder.getVolume());
 
	}
}
 
/**
 * This class describle about Circle
 * @author hoangcv
 * @version 1.1
 * @since 1.0
 */ 
class Circle {
	protected double radius = 1.0;
	protected String color = "red";
 
	public Circle() {
 
	}
 
	public Circle(double r) {
 
	}
 
	public Circle(double r, String color) {
		radius = r;
		this.color = color;
	}
	public double getRadius() {
		return radius;
	}
 
	public double getArea() {
		return Math.PI * Math.pow(radius,2);
	}
}
 
/**
 * This subclass inheritance Circle to describle Cyliner
 * @author hoangcv
 * @version 1.0
 * @since established
 */
class Cylinder extends Circle {
    private double height = 1.0;
 
    public Cylinder() {
        super();
    }
    public Cylinder(double radius) {
        super(radius);
    }
    public Cylinder(double radius, double height) {
        super(radius);
    }
    public Cylinder(double radius, double height, String color) {
    	super(radius, color);
    }
 
    public double getHeight() {
        return height;
    } 
    public void setHeight(double height) {
        this.height = height;
    }
    public double getVolume() {
        return Math.PI * Math.pow(radius,2) * height;
    }
}