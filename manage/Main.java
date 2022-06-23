package com.example.manage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.example.dao.StudentDao;
import com.example.model.Student;

public class Main {

	public static void main(String[] args) throws IOException {

		System.out.println("Welcome to Student management app...");
		System.out.println("--------------------------------------\n");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("Press 1 to ADD Student");
			System.out.println("Press 2 to DELETE Student");
			System.out.println("Press 3 to DISPLAY Student");
			System.out.println("Press 4 to UPDATE Student");
			System.out.println("Press 5 to EXIT");
			int c = Integer.parseInt(br.readLine());

			if (c == 1) {
				// add student
				System.out.println("Enter user name:- ");
				String name = br.readLine();

				System.out.println("Enter user phone:- ");
				String phone = br.readLine();

				System.out.println("Enter user city:- ");
				String city = br.readLine();

				// create student object to store student
				Student student = new Student(name, phone, city);

				boolean ans = StudentDao.addStudent(student);
				if (ans) {
					System.out.println("Student added successfully...");
				} else {
					System.out.println("Something went wrong...");
				}

			} else if (c == 2) {
				// delete student
				System.out.println("Enter student id to delete:- ");
				int id = Integer.parseInt(br.readLine());
				boolean f = StudentDao.deleteStudent(id);
				if (f) {
					System.out.println("Deleted successfully...");
				} else {
					System.out.println("Something went wrong...");
				}

			} else if (c == 3) {
				// display student
				StudentDao.showAllStudent();

			} else if (c == 4) {
				// update student
				System.out.println("Enter student Id which you want to update");
				int st_id = Integer.parseInt(br.readLine());

				System.out.println("Enter student name :");
				String st_name = br.readLine();

				System.out.println("Enter student phone :");
				String st_phone = br.readLine();

				System.out.println("Enter student city :");
				String st_city = br.readLine();

				boolean f = StudentDao.updateStudent(st_id, st_name, st_phone, st_city);

				if (f) {
					System.out.println("Student updated successfully..\n");
				} else {
					System.out.println("Something went wrong .. please try again..\n");
				}

			} else if (c == 5) {
				// exit
				System.out.println("Exiting....");
			} else {
				System.out.println("Wrong Input!");
			}

		}

	}
}
