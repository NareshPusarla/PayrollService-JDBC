package com.bridgelabz.dbservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.bridgelabz.config.DBConfig;
import com.bridgelabz.jdbc.entity.Employee;

public class DBOperationUsingPreparedStatement implements IDBOpeartion {

	Connection connection = DBConfig.getConnection();
	PreparedStatement preparedStatement = null;
	
	Scanner scanner = new Scanner(System.in);

//	String CREATE_TABLE_QUERY = "create table IF NOT EXISTS employee_payroll(id int, name varchar(255),salary int)";
	String UPDATE_QUERY = "UPDATE employee SET salary = ? WHERE id=?";
	String SELECT_QUERY = "SELECT * FROM employee_details";

	@Override
	public void createTable() {
		try {
//			preparedStatement = connection.prepareStatement(CREATE_TABLE_QUERY);
			preparedStatement.execute();
			System.out.println("Table created succefully");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void insertRecordsInTable() {

	}

	@Override
	public void fetchAllRecords() {
		int[] updateRow = null;
		try {
			updateRow = preparedStatement.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Number of updated rows: " + updateRow);
	}

	@Override
	public void updateRecordsInTable() {

		System.out.println("Enter the value for salary: ");
		int salary = scanner.nextInt();

		System.out.println("Enter the value for id: ");
		int id = scanner.nextInt();
		try {
			preparedStatement = connection.prepareStatement(UPDATE_QUERY);
			preparedStatement.setInt(1, salary);
			preparedStatement.setInt(2, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}
