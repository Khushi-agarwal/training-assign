//Question

//  Design a class Book containing following members: 
// bookID text 
// title text 
// author text 
// category text 
// price double
// Define Parameterized constructor to initialize Book object. Perform the below validations 
// • Category must be “Science”, “Fiction”, “Technology” or “Others” 
// • Price cannot be negative 
// • bookID must start with ‘B’ and must be of length 4 characters 

// If any of the validations fail, throw an user defined exception InvalidBookException. 
// Design a class called BookStore which contains an appropriate collection object to store Book instances. 
// Implement the below operations. 
// 1. addBook(Book b)     To add a new Book object into the book table 
// 2. searchByTitle(String title)   Search a book from DB based on title and if found, display the details 
// 3. searchByAuthor(String author) Search a book from DB based on author and if found, display the details 
// 4. displayAll()  Print the details of all the books 
// Store both classes in a package com.book. 
// Create a class BookUtil in package com.bookutil which has the main method. 
// • Instantiate the BookStore class 
// • Read data from user for 3 Book objects. 
// • Call the addBook method to add the book objects into the collection 
// • Search the books by title and author 
// • Display all the book details 



//Book.java

package com.book;

public class Book {

    private String bookId;
    private String title;
    private String author;
    private String category;
    private double price;
    public Book(){}
    public Book(String bookId,String title,String author,String category,double price)
    {
        this.bookId=bookId;
        this.title=title;
        this.author=author;
        this.category=category;
        this.price=price;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public void setCategory(String category)
    {
        this.category=category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}

//BookStore.java

package com.book;


import java.sql.*;
import java.util.ArrayList;

public class BookStoredao
{
    private static String url="jdbc:mysql://localhost:3306/gainsight";
   public boolean addBook(Book b) {
       int count = 0;
       try (Connection con = DriverManager.getConnection(url, "root", "Gainsight");
            PreparedStatement pst = con.prepareStatement("insert into book values(?,?,?,?,?)")) {
           if (b.getCategory().equals("Science") || b.getCategory().equals("Fiction") || b.getCategory().equals("Technology") || b.getCategory().equals("Others") && (b.getPrice() > 0) && (b.getBookId().charAt(0) == 'B' && b.getBookId().length() == 4)) {
               pst.setString(1, b.getBookId());
               pst.setString(2, b.getTitle());
               pst.setString(3, b.getAuthor());
               pst.setString(4, b.getCategory());
               pst.setDouble(5, b.getPrice());
               count=pst.executeUpdate();
           }
       } catch (Exception ex) {
           ex.printStackTrace();

       }
       return count==1;

   }
   public Book searchByTitle(String title)
   {
       Book book =null;
       try(Connection con=DriverManager.getConnection(url,"root","Gainsight");
       PreparedStatement pst=con.prepareStatement("select * from book where title=?"))
       {
           pst.setString(1,title);
         ResultSet rs=pst.executeQuery();
         if(rs.next())
             book=new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getDouble(5));


       }
       catch(Exception ex)
       {
           ex.printStackTrace();
       }
       return book;
   }

   public ArrayList<Book> searchByAuthor(String author)
   {
       ArrayList<Book> blist=new ArrayList<>();
       try(Connection con= DriverManager.getConnection(url,"root","Gainsight");
       PreparedStatement pst=con.prepareStatement("select * from book where author=?"))
       {
           pst.setString(1,author);
           ResultSet rs= pst.executeQuery();
           while(rs.next())
           {
               blist.add(new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getDouble(5)));
           }
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
       }
       return blist;
   }

   public ArrayList<Book> displayAll()
   {
       ArrayList<Book> blist=new ArrayList<>();
       try(Connection con=DriverManager.getConnection(url,"root","Gainsight");
       PreparedStatement pst= con.prepareStatement("select * from book"))
       {
           ResultSet rs= pst.executeQuery();
           while(rs.next())
           {
               blist.add(new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getDouble(5)));

           }
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
       }
       return blist;
   }


}


//BookUtil.java

package com.bookutil;

import com.book.BookStoredao;

import com.book.Book;

import java.util.ArrayList;
import java.util.Scanner;

public class BookUtil {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookStoredao bsd=new BookStoredao();


        int ch=3;
        while(ch--!=0) {


            System.out.println("Enter book details to add a book");
            System.out.println("Enter Book's Id");
            String bookId = sc.next();
            System.out.println("Enter Book's Title");
            String title = sc.next();
            System.out.println("Enter Book's Author");
            String author = sc.next();
            System.out.println("Enter Book's Category");
            String category = sc.next();
            System.out.println("Enter Book's Price");
            double price = sc.nextDouble();
            Book b=new Book(bookId,title,author,category,price);
            if(bsd.addBook(b))
                System.out.println("The entry is being added");
            else
                 throw new InvalidBookException();

        }
        System.out.println("Enter the title of the book to be searched");
        String titlesearch=sc.next();
     Book  b= bsd.searchByTitle(titlesearch);
     if(b!=null)
         System.out.println(b.getBookId()+" "+b.getTitle()+" "+b.getAuthor()+" "+b.getCategory()+" "+b.getPrice());
     else
         System.out.println("No entry found");
        System.out.println("Enter the author name for which details need to be found");
        String authorsearch=sc.next();
        ArrayList<Book> blist=bsd.searchByAuthor(authorsearch);
        for(Book b1:blist)
            System.out.println(b1.getBookId()+" "+b1.getTitle()+" "+b1.getAuthor()+" "+b1.getCategory()+" "+b1.getPrice());
        System.out.println("Displaying the details of all the books present");
        ArrayList<Book> all=bsd.displayAll();
        for(Book ba:all)
            System.out.println(ba.getBookId()+" "+ba.getTitle()+" "+ba.getAuthor()+" "+ba.getCategory()+" "+ba.getPrice());

    }
}

//InvalidBookException.java
package com.bookutil;

public class InvalidBookException extends RuntimeException{
    private String message="The entry is not valid";
    InvalidBookException(){}
    public String toString()
    {
        return "InvalidBookException:"+message;
    }

}



