package com.viettel.demo.javacore;

import java.lang.Math; 

public class Ex2_2 {
	public static void main(String[] args) {
		CircleA circle = new CircleA();
		System.out.println("Radius of Circle is " + circle.getRadius());
		System.out.println("Area of Circle is " + circle.getArea());
	}
}

class CircleA {
	private double radius = 1.0;
	private String color = "red";
	
	public CircleA() {
		
	}
	
	public CircleA(double r) {
		
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double getArea() {
		return Math.PI * Math.pow(radius,2);
	}
}
