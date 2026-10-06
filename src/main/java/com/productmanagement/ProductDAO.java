package com.productmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductDAO {
	
	//add
	public void addProduct(Product p) {
		
		try {
		   Connection con = DBConnection.getConnection();
			
			PreparedStatement ps = con.prepareStatement(
					"insert into products(name, category, price) values(?,?,?)"
					);
			ps.setString(1, p.getName());
			ps.setString(2, p.getCategory());
			ps.setInt(3, p.getPrice());
			
			ps.executeUpdate();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//delete
	public void deleteProduct(int id) {
		
		try {
		   Connection con = DBConnection.getConnection();
			
			PreparedStatement ps = con.prepareStatement(
					"delete from products where id=?"
					);
		
			ps.setInt(1, id);
			ps.executeUpdate();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//update
	public void updateProduct(Product p) {
		
		try {
		   Connection con = DBConnection.getConnection();
			
			PreparedStatement ps = con.prepareStatement(
					"update products set name=?,category=?,price=? where id=?"
					);
		
			ps.setString(1, p.getName());
			ps.setString(2, p.getCategory());
			ps.setInt(3, p.getPrice());
			ps.setInt(4, p.getId());
			ps.executeUpdate();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
  //view
	public ResultSet getAllProducts() {
		
		try {
		   Connection con = DBConnection.getConnection();
			
			PreparedStatement ps = con.prepareStatement(
					"select * from products"
					);
		
			return ps.executeQuery();
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
