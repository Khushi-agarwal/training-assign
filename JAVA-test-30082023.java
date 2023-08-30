package com.assign;

import java.sql.DriverManager;
import java.sql.*;
public class productdao {
    private static String url = "jdbc:mysql://localhost:3306/gainsight";

    public void displayOrderedProductById(int productId) {
        product ps = null;
        ordered od=null;
        try (Connection con = DriverManager.getConnection(url, "root", "Gainsight");
             PreparedStatement pst= con.prepareStatement("select * from product where ?=(select prod_id from ordered_products);")) 
            {
            pst.setInt(1, productId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ps = new product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5));
                os=new ordered(rs.getString(1));
                System.out.println(ps.getProd_id() + " " + ps.getProd_name() + " " + ps.getProd_desc() + " " + ps.getProd_price() + " " + ps.getProd_quantity()+os.getOrdered_date());

            }
          } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void displayOrderedProductsByOrderDate(String orderDate) {
        product ps = null;
        ordered os=null;
        try (Connection con = DriverManager.getConnection(url, "root", "Gainsight");
             PreparedStatement pst = con.prepareStatement("select * from product inner join ordered_products on product.prod_id = ordered_products.prod_id join product_order on ordered_products.order_id = product_order.order_id where order_date=?;");) {
            pst.setString(1,orderDate);
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
                ps = new product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5));
                os=new ordered(rs.getString(1));
                System.out.println(ps.getProd_id() + " " + ps.getProd_name() + " " + ps.getProd_desc() + " " + ps.getProd_price() + " " + ps.getProd_quantity()+os.getOrdered_date());

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
