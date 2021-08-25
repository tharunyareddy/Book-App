package com.bookapp.main;

import java.util.Scanner;

import com.bookapp.dao.BookInter;
import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;
import com.bookapp.bean.Book;
import com.bookapp.dao.BookImpl;


public class Client {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		BookInter bookObject = new BookImpl();
		
		
		int select=0;
		
		System.out.println("Enter Number 1 to Add Book Details\n"
				+ "Enter Number 2 to get book by Author  \n"
				+ "Enter Number 3 to get book by Category \n"
				+ "Enter Number 4 to get book by Price \n"
				+ "Enter Number 5 to get book by Book Id \n"
				+ "Enter Number 6 to get book by Delete Book\n"
				+ "Enter Number 7 to get book by Upadte Book\n"
				+ "Enter Number 8 to get All Books \n");
		 select = sc.nextInt();
		 
		 switch(select) {
		 
		 
			case 1:
				Book book = new Book();
				System.out.println("Enter Title :");
				String title = sc.next();
				book.setTitle(title);
				
				System.out.println("Enter Author : ");
				String author = sc.next();
				book.setAuthor(author);
				
				System.out.println("Enter Category : ");
				String category= sc.next();
				book.setCategory(category);
				
				System.out.println("Enter Price : ");
				int price = sc.nextInt();
				book.setPrice(price);
				
				System.out.println("Enter Bood Id : ");
				int bookId = sc.nextInt();
				book.setBookId(bookId);
		
				bookObject.addBook(book);
				break;
			case 2:
				System.out.println("Enter Author");
				String bookAuthor = sc.next();
				try {
			    System.out.println(bookObject.getBookByAuthor(bookAuthor));
				}catch(AuthorNotFoundException e){
					e.printStackTrace();
				}
				break;
			case 3:
				System.out.println("Enter Category : ");
				String bookCategory = sc.next();
				try {   
					System.out.println(bookObject.getBookByCategory(bookCategory));
				}catch(CategoryNotFoundException e){
					e.printStackTrace();
				}
			   
				break;
			case 4:
				System.out.println("Enter Price : ");
				double bookPrice = sc.nextInt();
				
			try {
				System.out.println(bookObject.getBookByPrice(bookPrice));
			} catch (BookNotFoundException e) {
				e.printStackTrace();
			}
				break;
			case 5:
				System.out.println("Enter Book Id");
				int bookId1 = sc.nextInt();
			  
			try {
				System.out.println(bookObject.getBookById(bookId1));
			} catch (BookNotFoundException e) {
				e.printStackTrace();
			}
				break;
			case 6:
                System.out.println("Enter id to Delete Book");
				
			    int bookId2 = sc.nextInt();
			boolean val;
			try {
				val = bookObject.deleteBook(bookId2);
			     if(val == false) {
				System.out.println("Book Deleted");
			     }
			} catch (BookNotFoundException e) {
				e.printStackTrace();
			}
				break;
			case 7:
                System.out.println("Upadte Book");
                int id1 = sc.nextInt();
			    double bookPrice2 = sc.nextDouble();
				System.out.println(bookObject.updateBook(id1, bookPrice2));
				break;
			case 8:
				System.out.println("All Books");
				System.out.println(bookObject.getAllBooks());
				break;
		 }
		 sc.close();
   }
}