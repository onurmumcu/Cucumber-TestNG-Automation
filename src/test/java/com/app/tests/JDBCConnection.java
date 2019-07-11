package com.app.tests;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

public class JDBCConnection {
  
	String oracledbURL="jdbc:oracle:thin:@ec2-18-191-142-156.us-east-2.compute.amazonaws.com:1521:xe";
	String oracleDbPassword="hr";
	String oracleDbUsername="hr";
			
	@Test(enabled=false)
	public void oracleJDBC() throws SQLException {
 
		Connection connection=DriverManager.getConnection(oracledbURL, oracleDbUsername,oracleDbPassword);
	
		//Statement statement=connection.createStatement();with this one I cannot go to the last  I can only use next. and I cannot go back. So i create next statement to go forward and back to walk around the data table
		Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);// 
		ResultSet resultSet=statement.executeQuery("select * from countries");//no ';' here othervise it will not work
		
//		while(resultSet.next()) {//when I receive my data the first row shows me the title 
//			//so I am going down to take the country name. So I can use a loop to see all rows
//		resultSet.next();//everytime I add next(); I am pointing to the next row and reading from that row
//			
//		System.out.println(resultSet.getString(1));//here 1 refers to the column place
//		System.out.println(resultSet.getString("country_name"));
//		System.out.println(resultSet.getInt("region_id"));
//		}
		
		//resultSet.last(); will go to the last row
		
		
		//how to find how many result rows we have in a result set;
		resultSet.last();
		int rowsCount=resultSet.getRow();
		System.out.println("num of rows: "+rowsCount);
		
		
		resultSet.beforeFirst();
		while(resultSet.next()) {
			System.out.print(resultSet.getString(1));//here 1 refers to the column place
			System.out.print(resultSet.getString("country_name"));
			System.out.println(resultSet.getInt("region_id"));
			}
		
		
		resultSet.close();
		statement.close();
		connection.close();
	}

@Test
public void jdbcMetaData() throws Exception{
Connection connection=DriverManager.getConnection(oracledbURL, oracleDbUsername,oracleDbPassword);

//Statement statement=connection.createStatement();with this one I cannot go to the last  I can only use next. and I cannot go back. So i create next statement to go forward and back to walk around the data table
Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);// 


String sql="select * from employees";
ResultSet resultSet=statement.executeQuery(sql);


//Database metadata
DatabaseMetaData dbMetaData=connection.getMetaData();
System.out.println("User:"+dbMetaData.getUserName());
System.out.println("DataBaseType:"+dbMetaData.getDatabaseProductName());

//resultSet metadata
ResultSetMetaData rsMetaData=resultSet.getMetaData();
System.out.println("Column Number:"+rsMetaData.getColumnCount());
//System.out.println(rsMetaData.getColumnName(1));

//print all column names using loop
for (int i=1; i<=rsMetaData.getColumnCount(); i++) {
	System.out.println(i+"-> "+rsMetaData.getColumnName(i));
}

//===================
List<Map<String,Object>> list = new ArrayList<>();
ResultSetMetaData rsMdata = resultSet.getMetaData();

int colCount = rsMdata.getColumnCount();

while(resultSet.next()) {
	  Map<String,Object> rowMap = new HashMap<>();
	  
	  for(int col = 1; col <= colCount; col++) {
		  rowMap.put(rsMdata.getColumnName(col), resultSet.getObject(col));	  
	  }
	  
	  
	  list.add(rowMap);
}

//print all emloyee ids from a list of maps

for (Map<String, Object> emp: list) {
	System.out.println(emp.get("EMPLOYEE_ID"));
//===============

}


resultSet.close();
statement.close();
connection.close();

}














}
