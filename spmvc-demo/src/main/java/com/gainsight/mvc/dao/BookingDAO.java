package com.gainsight.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Repository;

@Repository
public class BookingDAO {
	
	private static String url="jdbc:mysql://localhost:3306/gainsight";
	public boolean addBookingDetails(String bookingId,String flightId,String passengerId,String travelDate)
	{
		
	int count=0;
		Connection con=null;
		PreparedStatement pst=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,"root","Gainsight");
			pst=con.prepareStatement("insert into Bookings values(?,?,?,?)");
			pst.setString(1, bookingId);
			pst.setString(2, flightId);
			pst.setString(3, passengerId);
			pst.setString(4, travelDate);
			count=pst.executeUpdate();
	}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				if(pst!=null) pst.close();
				if(con!=null) con.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		return count==1;
	}

}
