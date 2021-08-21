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

//	DBConfig dbConfig = new DBConfig();
	Connection connection = DBConfig.getConnection();
	PreparedStatement preparedStatement = null;

	String CREATE_TABLE_QUERY = "create table IF NOT EXISTS employee_payroll(id int, name varchar(255),salary int)";
	String SELECT_QUERY = "SELECT * FROM employee_details";

	@Override
	public void createTable() {
		try {
			preparedStatement = connection.prepareStatement(CREATE_TABLE_QUERY);
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

}
