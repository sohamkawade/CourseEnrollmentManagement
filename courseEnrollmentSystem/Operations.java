package courseEnrollmentSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Operations {

	public static void addEnrollment(int student_id, String firstname, String lastname, String cname, int cduration) {
		try {
			Connection connection = DatabaseConnection.connect();
			String query = "INSERT INTO courseEnrollments(student_id, firstname, lastname,"
					+ "course_name, course_duration)" + "VALUES (?, ?, ?, ?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, student_id);
			preparedStatement.setString(2, firstname);
			preparedStatement.setString(3, lastname);
			preparedStatement.setString(4, cname);
			preparedStatement.setInt(5, cduration);

			int rowNum = preparedStatement.executeUpdate();
			System.out.println(rowNum > 0 ? "data inserted!" : "data not inserted!");

			preparedStatement.close();
			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void viewEnrollment() {
		try {
			Connection connection = DatabaseConnection.connect();
			Statement statement = connection.createStatement();

			String query = "SELECT * FROM courseEnrollments";

			ResultSet rs = statement.executeQuery(query);

			boolean isExist = false;
			while (rs.next()) {
				isExist = true;
				System.out.print(rs.getInt(1) + " | " + rs.getInt(2) + " | " + rs.getString(3) + " | " + rs.getString(4)
						+ " | " + rs.getString(5) + " | " + rs.getDate(6) + " | " + rs.getInt(7) + " | "
						+ rs.getString(8) + "\n");

			}
			if (!isExist) {
				System.out.println("data does not exist!");
			}

			statement.close();
			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void updateEnrollment(int id, String firstname, String lastname, String cname, int cduration) {
		try {
			Connection connection = DatabaseConnection.connect();
			String query = "UPDATE courseEnrollments SET firstname=?, lastname=?,course_name=?,course_duration=? WHERE student_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, firstname);
			preparedStatement.setString(2, lastname);
			preparedStatement.setString(3, cname);
			preparedStatement.setInt(4, cduration);
			preparedStatement.setInt(5, id);

			int rowNum = preparedStatement.executeUpdate();
			System.out.println(rowNum > 0 ? "data updated!" : "data not updated!");
			preparedStatement.close();
			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void deleteEnrollment(int student_id) {
		try {
			Connection connection = DatabaseConnection.connect();
			String query = "DELETE FROM courseEnrollments WHERE student_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, student_id);

			int rowNum = preparedStatement.executeUpdate();
			System.out.println(rowNum > 0 ? "data deleted!" : "data does not exist!");

			preparedStatement.close();
			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("*** Course Enrollment Management ***");
		System.out.println("Add Enrollment:1");
		System.out.println("View Enrollment:2");
		System.out.println("Update Enrollment:3");
		System.out.println("Delete Enrollment:4");
		System.out.println("Exit:5");
		System.out.println("-------------------------------------------------------");

		int ch;

		do {
			System.out.print("Enter number to perform CRUD operation:");
			ch = Integer.parseInt(sc.nextLine());
			switch (ch) {
			case 1:
				System.out.print("Enter student id:");
				int sid = Integer.parseInt(sc.nextLine());
				System.out.print("Enter student firstname:");
				String firstname = sc.nextLine();
				System.out.print("Enter student lastname:");
				String lastname = sc.nextLine();
				System.out.print("Enter course name:");
				String cname = sc.nextLine();
				System.out.print("Enter course duration in months:");
				int coursduration = Integer.parseInt(sc.nextLine());

				Operations.addEnrollment(sid, firstname, lastname, cname, coursduration);
				break;

			case 2:
				Operations.viewEnrollment();
				break;
			case 3:
				System.out.print("Enter student id you want to update:");
				sid = Integer.parseInt(sc.nextLine());
				System.out.print("Enter student firstname:");
				firstname = sc.nextLine();
				System.out.print("Enter student lastname:");
				lastname = sc.nextLine();
				System.out.print("Enter course name:");
				cname = sc.nextLine();
				System.out.print("Enter course duration in months:");
				coursduration = Integer.parseInt(sc.nextLine());
				Operations.updateEnrollment(sid, firstname, lastname, cname, coursduration);
				
				break;

			case 4:
				System.out.print("Enter student id you want to delete:");
				int sid1 = Integer.parseInt(sc.nextLine());
				Operations.deleteEnrollment(sid1);
				break;
			case 5:
				System.out.println("Exited!");
				break;
			default:
				System.out.println("Invalid number!");
			}

		} while (ch != 5);

	}
}
