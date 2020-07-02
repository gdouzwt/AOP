package com.ewolff.project.repository;

import java.sql.Connection;
import java.sql.SQLException;

public class Repository {

	@SuppressWarnings("null")
	public void doSomeJDBCstuff() throws SQLException {
		Connection connection = null;
		connection.close();
	}
	
}
