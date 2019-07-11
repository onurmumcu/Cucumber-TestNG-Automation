package com.app.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.app.utilities.ConfigurationReader;

public class JdbcWithLog4j {

	public static final Logger logger=LogManager.getLogger();
	@Test
	public void getRecordsCount() throws SQLException {
		logger.info("Establishing database connection");
		
				
		try(Connection connection=DriverManager.getConnection(ConfigurationReader.getProperty("oracledb.url"),"hr","hr" );
				Statement statement=connection .createStatement();
				ResultSet resultSet=statement.executeQuery("Select * from employees");
				)
		{
			logger.debug("Executing querry");
			logger.info(ConfigurationReader.getProperty("oracledb.url"));
			resultSet.last();
			logger.info("number of records fetched from database:"+resultSet.getRow() );
		}catch (Exception e) {
			logger.error("there is an ERROR with connection");
			logger.error(e.getMessage());
			
		}
	
	}
	
}
