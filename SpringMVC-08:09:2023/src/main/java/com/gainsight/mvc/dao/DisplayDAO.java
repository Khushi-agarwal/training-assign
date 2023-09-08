package com.gainsight.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.gainsight.mvc.entity.Bookings;
@Repository
public class DisplayDAO {
	private static String url="jdbc:mysql://localhost:3306/gainsight";
	public Bookings display(String bookingId)
	{
		Bookings booking=null;
	
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,"root","Gainsight");
			pst=con.prepareStatement("select * from Bookings where booking_id=?");
			pst.setString(1, bookingId);
			rs=pst.executeQuery();
			if(rs.next())
			{
				booking=new Bookings(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
			}
			
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
		return booking;
	}

}
