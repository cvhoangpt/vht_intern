/*
* Copyright 2020 VHT, Viettel. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/

package com.viettel.demo.javacore;

public class Ex4_1 {
    public static void main(String[] args) {
        
    	Movable m1 = new MovablePoint(15, 30, 2, 4);
    	System.out.println(m1);
    	m1.moveLeft();
    	System.out.println(m1);
    	
    	Movable m2 = new MovableCircle(20, 40, 2, 5, 8);
    	System.out.println(m2);
    	m2.moveRight();
    	System.out.println(m2);
    }
}

/**
* This interface describles ability of objects
* @author hoangcv
* @version 1.0
* @since established
 */
interface Movable {
    public void moveUp();
    public void moveDown();
    public void moveLeft();
    public void moveRight();
}

/**
* This class is instance of moving coordinates
* @author hoangcv
* @version 1.0
* @since established
 */
class MovablePoint implements Movable {
    int x;
    int y;
    int xSpeed;
    int ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public String toString() {
    	return "(" +x + "," + y +")";
    }
    
    public void moveUp() {
    	y += ySpeed;
    }
    
    public void moveDown() {
    	y -= ySpeed;
    }
    
    public void moveLeft() {
    	x -= xSpeed;
    }
    
    public void moveRight() {
    	x += xSpeed;
    }
}

/**
* This class is instance of moving circle coordinates
* @author hoangcv
* @version 1.0
* @since established
 */
class MovableCircle extends MovablePoint implements Movable {
    private int radius;
    private MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        super(x, y, xSpeed, ySpeed);
        center = new MovablePoint(x, y, xSpeed, ySpeed);
        this.radius = radius;
    }
    
    public String toString() {
    	return "(" +x + "," + y +")" + "," + radius;
    }
    @Override
    public void moveUp() {
    	center.y += center.ySpeed;
    	
    }
    @Override
    public void moveDown() {
    	center.y -= center.ySpeed;
    }
    @Override
    public void moveLeft() {
    	center.x += center.xSpeed;
    }
    @Override
    public void moveRight() {
    	center.x -= center.xSpeed;
    }
}