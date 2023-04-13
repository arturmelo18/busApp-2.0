package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DB;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement pst = null;

		try {
			conn = DB.getConnection();

			// account verification
			System.out.println("Do you already have an account? (y/n)");
			char a = sc.nextLine().charAt(0);

			// account creation
			if (a == 'n') {
				pst = conn.prepareStatement("INSERT INTO user" + "(Name, Email, Password) " + "VALUES " + "(?, ?, ?)");
				System.out.println("Speak your name");
				String name = sc.nextLine();
				System.out.println("Speak your email");
				String email = sc.nextLine();
				System.out.println("Speak your password");
				String password = sc.nextLine();
				pst.setString(1, name);
				pst.setString(2, email);
				pst.setString(3, password);

				pst.execute();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeStatement(pst);
			DB.closeResultSet(rs);
			DB.closeConnection();
		}
	}

}
