package com.bridgelabz.dbservice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bridgelabz.config.DBConfig;

public class DBOperationUsingStatement implements IDBOpeartion {

//	DBConfig dbConfig = new DBConfig();

	Connection connection = DBConfig.getConnection();
	Statement statement = null;

	String CREATE_TABLE_QUERY = "create table IF NOT EXISTS employee_payroll(id int, name varchar(255),salary int)";

	String INSERT_QUERY = "INSERT INTO employee(id, name, salary) VALUES (1, 'UMA', 1000)";

	String SELECT_QUERY = "SELECT * FROM employee";

	@Override
	public void createTable() {
		try {
			statement = connection.createStatement();
			statement.execute(CREATE_TABLE_QUERY);
			System.out.println("Table created successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertRecordsInTable() {
		try {
			statement = connection.createStatement();
			statement.execute(INSERT_QUERY);
//			System.out.println("inserting a record");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void fetchAllRecords() {
		try {
			ResultSet resultSet = statement.executeQuery(SELECT_QUERY);
			while (resultSet.next()) {
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateRecordsInTable() {
		
	}

}
