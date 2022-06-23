package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import com.example.manage.ConnectionProvider;
import com.example.model.Student;

public class StudentDao {

	public static boolean addStudent(Student student) {

		boolean flag = false;
		Connection con = ConnectionProvider.createConnection();

		String query = "insert into student (sname, sphone, scity)  values (?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, student.getStudentName());
			ps.setString(2, student.getStudentPhone());
			ps.setString(3, student.getStudentCity());
			ps.executeUpdate();
			flag = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean deleteStudent(int userId) {
		boolean flag = false;
		Connection con = ConnectionProvider.createConnection();

		String query = "delete from student where sid = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, userId);
			flag = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static void showAllStudent() {
		Connection con = ConnectionProvider.createConnection();

		String query = "select * from student";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String city = rs.getString("scity");

				System.out.println("Id- " + id);
				System.out.println("Name- " + name);
				System.out.println("Phone- " + phone);
				System.out.println("City- " + city);
				System.out.println("--------------------");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static boolean updateStudent(int st_id, String st_name, String st_phone, String st_city) {

		boolean flag = false;

		Connection con = ConnectionProvider.createConnection();
		try {
			String query = "update student set sname=?, sphone=?, scity=? where sid=?";

			PreparedStatement pstm = con.prepareStatement(query);

			pstm.setString(1, st_name);
			pstm.setString(2, st_phone);
			pstm.setString(3, st_city);
			pstm.setInt(4, st_id);

			pstm.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;

	}

}
