package com.PacificPower.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.PacificPower.generic.BaseTest;

public class DataBaseHelper extends BaseTest {
	
	private String url="jdbc:mysql://localhost/vikas";
	private String username="root";
	private String password="admin@123";
	private static Connection connection;
	private String driverName="com.mysql.jdbc.Driver";
	
	private Connection getConnection() 
	{
		try {
			Class.forName(driverName);
			try {
				connection=DriverManager.getConnection(url, username, password);
				this.setDatabase(connection);
				return connection;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		
		DataBaseHelper dbInstance = new DataBaseHelper();
		connection=dbInstance.getConnection();
		try {
//		int abc = connection.createStatement().executeUpdate("create table john (emp_id int(3))");
		ResultSet resultSet = connection.createStatement().executeQuery("select * from employee where ID<>''");
		for(int i=1;i<=resultSet.getMetaData().getColumnCount();i++) {
		System.out.println(resultSet.getMetaData().getColumnLabel(i));
		}
		for(int i=1;i<=resultSet.getMetaData().getColumnCount();i++) {
			System.out.println(resultSet.getMetaData().getColumnTypeName(i));
		}
		System.out.println(resultSet.getMetaData().getColumnCount());
		while(resultSet.next()) {
		System.out.println(resultSet.getString(3));
		}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
