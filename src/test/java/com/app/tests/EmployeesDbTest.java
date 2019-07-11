package com.app.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.app.utilities.DBType;
import com.app.utilities.DBUtility;

public class EmployeesDbTest {
  
	
	@Test(enabled=true)
  public void countTest() throws SQLException {
		
		//connect to Oracle database and run following sql query
		//select *from employees where job_id='IT_PROG'
		//more then 0 records should be returned
		DBUtility.establishConnection(DBType.ORACLE);
		int rowsCount =DBUtility.getRowsCount("select * from employees where job_id='IT_PROG'");
		assertTrue(rowsCount>0);
		System.out.println(rowsCount);
		DBUtility.closeConnections();
		
  }

@Test(enabled=true)
public void nameTestById() throws SQLException {
	//connect to database
	//employeee`s fullname with employee id 105 should be DavidAustin
	DBUtility.establishConnection(DBType.ORACLE);
	List<Map<String, Object>> empData=DBUtility
			.runSQLQuery("Select first_name, last_name From employees where employee_id=105");
	
	System.out.println(empData.get(0).get("FIRST_NAME"));
	System.out.println(empData.get(0).get("LAST_NAME"));
	
	assertEquals(empData.get(0).get("FIRST_NAME"),"David");
	assertEquals(empData.get(0).get("LAST_NAME"),"Austin");
	
		
	DBUtility.closeConnections();
	




}





}
