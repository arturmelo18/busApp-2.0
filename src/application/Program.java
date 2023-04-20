package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DB;
import db.DbException;

public class Program {

	public static void main(String[] args) {

		int end = 0;

		do {
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
					pst = conn.prepareStatement(
							"INSERT INTO user" + "(Name, Email, Password) " + "VALUES " + "(?, ?, ?)");
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

					DB.closeStatement(pst);
				} else {
					// enter the account

					System.out.println("Speak your email");
					String email = sc.nextLine();
					System.out.println("Speak your password");
					String password = sc.nextLine();

					st = conn.createStatement();
					rs = st.executeQuery("SELECT * FROM user");
					int l = 0;
					while (rs.next()) {
						if (rs.getString("Email").hashCode() == email.hashCode()
								&& rs.getString("Password").hashCode() == password.hashCode()) {
							l = 1;
						}
					}
					if (l != 1) {
						throw new DbException("Incorrect email or password");
					} else {
						System.out.println("You have successfully connected");
						System.out.println();
					}
					DB.closeStatement(st);
					DB.closeResultSet(rs);
				}

				System.out.println("============================================");
				System.out.println("=====1) Reserve seat =======================");
				System.out.println("=====2) Cancel seat reservation ============");
				System.out.println("=====3) View all occupied seats ============");
				System.out.println("=====4) See all buses ======================");
				System.out.println("=====5) To go out ==========================");
				System.out.println("============================================");

				System.out.println("Choose an option");
				int o = sc.nextInt();

				switch (o) {
				case 1:
					// Reserve seat
				case 2:
					// Cancel seat reservation
				case 3:
					// View all occupied seats
				case 4:
					// See all buses
					st = conn.createStatement();
					rs = st.executeQuery("SELECT * FROM bus");
					while (rs.next()) {
						System.out.println("Bus");
						System.out.println("Exit location: " + rs.getString("ExitLocation"));
						System.out.println("Destination: " + rs.getString("Destination"));
						System.out.println("Ticket price: R$" + rs.getDouble("TicketPrice"));
						System.out.println();
					}
				case 5:
					// To go out
					end = 1;
				}

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				DB.closeStatement(st);
				DB.closeStatement(pst);
				DB.closeResultSet(rs);
				DB.closeConnection();
			}
		} while (end == 1);
	}
}
