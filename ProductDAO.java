package dao;

import model.Product;

import java.sql.*;

import connectionmanager.ConnectionManager;

public class ProductDAO {
	public void addProduct(Product p) throws ClassNotFoundException, SQLException
	{
		ConnectionManager cm=new ConnectionManager();
		Connection con=cm.establishConnection();
		String que="insert into product(prodId , prodName , sellingQuantity , prodCost , stock) values (?,?,?,?,?)" ;
		PreparedStatement ps = con.prepareStatement(que);
		ps.setString(1, p.getProdId());
		ps.setString(2, p.getProdName());
		ps.setInt(3,p.getSellingQuantity());
		ps.setInt(4,p.getProdCost());
		ps.setInt(5,p.getStock());
		ps.executeLargeUpdate();
		cm.closeConnection();
	}
	public void updateProduct(Product p) throws ClassNotFoundException, SQLException
	{
		ConnectionManager cm = new ConnectionManager();
		Connection con =cm.establishConnection();
		
		String que = "update product set prodName=?,sellingQuantity=?,prodCost=?,stock=? where prodId=?";
		PreparedStatement ps= con.prepareStatement(que);
		ps.setString(1, p.getProdName());
		ps.setInt(2, p.getSellingQuantity());
		ps.setInt(3, p.getProdCost());
		ps.setInt(4, p.getStock());
		ps.setString(5, p.getProdId());
		ps.executeUpdate();
		cm.closeConnection();
	}
	public void deleteProduct(Product p) throws ClassNotFoundException, SQLException
	{
		try {
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.establishConnection();
		String que="delete from product where prodId=?";
		PreparedStatement ps=con.prepareStatement(que);
		ps.setString(1,p.getProdId());
		ps.executeUpdate();
		cm.closeConnection();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void display() throws SQLException, ClassNotFoundException
	{
		//1.jdbc connection
		ConnectionManager cm=new ConnectionManager();
		Connection con = cm.establishConnection();
		
		//2.create statement
		Statement st = con.createStatement();
		
		//3.write and execute the query
		ResultSet rt=st.executeQuery("select * from product");
		
		//4.print
		while(rt.next())
		{
			System.out.println(rt.getString("prodId")+" | "+rt.getString("prodName")+" | "+rt.getInt("sellingQuantity")+" | "+rt.getInt("prodCost")+" | "+rt.getInt("stock"));
				
		}
		
	}

}
