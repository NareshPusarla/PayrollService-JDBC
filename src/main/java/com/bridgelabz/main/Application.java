package com.bridgelabz.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bridgelabz.dbservice.DBOperationUsingPreparedStatement;
import com.bridgelabz.dbservice.DBOperationUsingStatement;
import com.bridgelabz.jdbc.entity.Employee;

public class Application {

	public static void main(String[] args) {

		/*
		 * DBOperationUsingStatement dbOperationStatement = new
		 * DBOperationUsingStatement();
		 * 
		 * dbOperationStatement.createTable();
		 * dbOperationStatement.insertRecordsInTable();
		 * dbOperationStatement.fetchAllRecords();
		 */

		DBOperationUsingPreparedStatement dbOperationPreparedSatement = new DBOperationUsingPreparedStatement();

		dbOperationPreparedSatement.createTable();
		dbOperationPreparedSatement.insertRecordsInTable();
		dbOperationPreparedSatement.fetchAllRecords();

	}

}
