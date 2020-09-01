/*
* Copyright 2020 VHT, Viettel. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.viettel.demo.javacore; 

import java.sql.*;
import java.util.Scanner;

import com.viettel.demo.common.Constants;
 
public class Ex9_1 {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		//Connector c = new Connector();
		int n;
		EBookShop ebs = new EBookShop();
		Book book = new Book();
		int id;
		String title;
		String author;
		Double price;
		int quantity;
		
		try {
			Connector.getInstance();
			System.out.println("Connection Successful...");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Something went wrong");
		}
		
		
		System.out.println("Please choose function:");
		System.out.println("(1)Create DB EBookShop (2)Create table Book\n"
				+ "(3)Add book (4)Update book\n"
				+ "(5)Delete book (6)Select book");
		n = sc.nextInt();
		sc.nextLine();
		
		switch (n) {
		case 1: 
			ebs.createEBookShop();
			break;
		case 2:
			book.createBook();
			break;
		case 3:
			System.out.println("Input title:");
	        title = sc.nextLine();
	        sc.nextLine();
	        System.out.println("Input author:");
	        author = sc.nextLine();
	        System.out.println("Input price:");
	        price = sc.nextDouble();
	        System.out.println("Input quantity:");
	        quantity = sc.nextInt();
			book.addBook(title, author, price, quantity);
			break;
		case 4:
			System.out.println("Input book ID to update: ");
			id = sc.nextInt();
			System.out.println("Input title:");
	        title = sc.nextLine();
	        sc.nextLine();
	        System.out.println("Input author:");
	        author = sc.nextLine();
	        System.out.println("Input price:");
	        price = sc.nextDouble();
	        System.out.println("Input quantity:");
	        quantity = sc.nextInt();
	        book.updateBook(id, title, author, price, quantity);
			break;
		case 5:
			System.out.println("Input book ID to delete: ");
			id = sc.nextInt();
			book.deleteBook(id);
			break;
		case 6:
			System.out.println("Input book ID: ");
			id = sc.nextInt();
			book.selectBook(id);
			break;
		default:
			System.out.println("Nothing happened.");
		}
	}
}


/**
 * Use Java Database Connectivity API.
 * Use Lazy initialization (single thread) as Singleton pattern.
 * This code using some representative values
 * @author hoangcv
 * @version 1.0
 * @since 1.0
 */
class Connector {
	protected Connection conn = null;
	private static Connector instance = null;
 
	/**
	 * Constructor 
	 */
	protected Connector() {
		try {   
			Class.forName(Constants.DRIVER);
	        this.conn = DriverManager.getConnection(Constants.DB_URL, Constants.USERNAME, Constants.PASSWORD);
	        //System.out.println("Connector notice: Connection successfully ...");
        } catch (ClassNotFoundException e) {
        	System.err.println(e);
		} catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
		}
	}
 
	private Connection getConnection() {
		return conn;
	}
 
	/**
	 * Lazy initialization
	 * @return instance
	 * @throws SQLException
	 */
	public static Connector getInstance() throws SQLException {
		if (instance == null) {
			instance = new Connector();
		}
		else if (instance.getConnection().isClosed()) {
			instance = new Connector();
		}
		return instance;
	}
}
 
/**
 * This class use for create database named "EBookShop"
 * @author hoangcv
 * @version 1.0
 * @since 1.0
 */
class EBookShop extends Connector {
    public void createEBookShop() {
        String createEBS = "CREATE DATABASE ebookshop";
        try {
            PreparedStatement ps = conn.prepareStatement(createEBS);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
    }
}
 
/**
 * This class use for create and process Book
 * @author hoangcv
 * @version 1.0
 * @since 1.0
 */
class Book extends Connector {
 
	static Scanner sc = new Scanner(System.in);
	
    /**
    * This method to create table Book
    * @param createB is query to create book table 
    */
    public void createBook() {
        String createB = 
        "CREATE TABLE book " +
        "( id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, " +
        "title VARCHAR(50), " +
        "author VARCHAR(50), " +
        "price FLOAT, " +
        "qty INT )";
 
        try {
            PreparedStatement pst = conn.prepareStatement(createB);
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
    * This method is an example of insert Book's value
    * @param insertB is insert clause applied to Book
    */
    public void addBook(String title, String author, double price, int quantity) {
        String insertB = "INSERT INTO book VALUES (?,?,?,?,?)";
        
        try {
            PreparedStatement pst = conn.prepareStatement(insertB);
            
            pst.setString(1, null);
            pst.setNString(2, title);
            pst.setNString(3, author);
            pst.setDouble(4, price);
            pst.setInt(5, quantity);
            
            pst.executeUpdate();
            pst.close();
            System.out.println("Add book successful.");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    /**
    * This method is an example of update Book's value 
    * @param updateB is update clause applied to Book
    */
    public void updateBook(int id, String title, String author, double price, int quantity) {
        String updateB = "UPDATE book " + 
        "SET title =?, author =?, price =?, quantity =? WHERE id =?";
        try {
            PreparedStatement pst = conn.prepareStatement(updateB);
            
            pst.setNString(1, title);
            pst.setNString(2, author);
            pst.setDouble(3, price);
            pst.setInt(4, quantity);
            pst.setString(5, null);
            
            pst.executeUpdate();
            pst.close();
            System.out.println("Update bookid= "+ id + " successful.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    /**
    * This method is an example of delete Book's value
    * @param delB is delete clause applied to Book
    */
    public void deleteBook(int id) {
        String delB = "DELETE FROM book WHERE id =?";
        try {
            PreparedStatement pst = conn.prepareStatement(delB);
            pst.setInt(1, id);
            pst.executeUpdate();
            pst.close();
            System.out.println("Delete bookid= "+ id + " successful.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    /**
    * This method is an example of select Book's value 
    * @param selB is select clause applied to Book
    */
    public void selectBook(int id) {
         String selB = "SELECT * FROM book WHERE id=?";
         try {
            PreparedStatement pst = conn.prepareStatement(selB);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
            	System.out.println("Info of bookid = " + id);
            	System.out.println("Id | Title | Author | Price | Quantity");
            	System.out.println(rs.getInt("id") + " | " +
            			rs.getNString("title") + " | " +
            			rs.getNString("author") + " | " + 
            			rs.getDouble("price") + " | " + 
            			rs.getInt("qty"));
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}