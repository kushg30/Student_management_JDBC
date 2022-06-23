package com.example.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	static Connection con;

	public static Connection createConnection() {

		try {
			// load the driver
			Class.forName("com.mysql.jdbc.Driver");

			// create the connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_manage?characterEncoding=latin1&useConfigs=maxPerformance", "root", "kush");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;

	}

}
