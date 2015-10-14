package com.bluemaple.DataBaseConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;


@ SASI
public class SignUpAction {
	static Connection connection;
	static PreparedStatement p;
	static ResultSet rs;
	
	Date date = new Date();
	String day = date.toString();

	public static void main(String arg[]) throws ClassNotFoundException,
			SQLException {
		
		System.out.println("Enter choice:");
		System.out.println("menu");
		System.out.println("1.login:");
		System.out.println("2.signup:");
		System.out.println("3.list of users");
		System.out.println("4.exit");

		Scanner selectOption = new Scanner(System.in);
		int option = selectOption.nextInt();

		if (option == 1) {
			login();
		} else if (option == 2) {
			signup();
		} else if (option == 3) {
			listOfUsers();
		} else if (option == 4) {
			exit();
		}
	}

	private static void exit() {
		System.out.println("you are Exited BYE ");
	}

	private static void listOfUsers() throws SQLException,
			ClassNotFoundException {
		
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://LocalHost:3306/student";
		Class.forName(JDBC_DRIVER);
		connection = DriverManager.getConnection(DB_URL, "root", "admin");
		String query = "select id, name, password, email, sex, contact, createdate, updatedate from altered";
		PreparedStatement listOfUsers = connection.prepareStatement(query);
		ResultSet count = listOfUsers.executeQuery();
		
		while (count.next()) {
			int s = count.getInt("id");
			System.out.println(s);
			String name = count.getString("name");
			String password = count.getString("password");
			String email = count.getString("email");
			String sex = count.getString("sex");
			String contact = count.getString("contact");
			String createdate = count.getString("createdate");
			String updatedate = count.getString("updatedate");
			System.out.println("List of users:" + s + " " + name + " "
					+ password + " " + email + " " + sex + " " + contact + " "
					+ createdate + " " + updatedate);
		}
	}

	private static void signup() throws ClassNotFoundException {

		Date date = new Date();
		String day = date.toString();

		int id;
		String userName;
		String passWord;
		String emailAddress;
		String sex;
		String contact;
		String createdDate;
		String updatedDate;

		System.out.println("Enter ID : ");
		Scanner a = new Scanner(System.in);
		id = a.nextInt();

		System.out.println("Enter name : ");
		Scanner b = new Scanner(System.in);
		userName = b.nextLine();

		System.out.println("Enter passWord : ");
		Scanner c = new Scanner(System.in);
		passWord = c.nextLine();

		System.out.println("Enter emailAddress : ");
		Scanner d = new Scanner(System.in);
		emailAddress = c.nextLine();

		System.out.println("Enter sex : ");
		Scanner e1 = new Scanner(System.in);
		sex = c.nextLine();

		System.out.println("Enter contact : ");
		Scanner f = new Scanner(System.in);
		contact = c.nextLine();

		/*
		 * System.out.println("Enter createdDate : "); Scanner g = new
		 * Scanner(System.in); createdDate = c.nextLine();
		 * 
		 * System.out.println("Enter updatedDate : "); Scanner h = new
		 * Scanner(System.in); updatedDate = c.nextLine();
		 */

		// a.close();
		// b.close();
		// c.close();
		// d.close();
		// e1.close();
		// f.close();
		// g.close();
		// h.close();

		// Connection connection = null;
		// PreparedStatement p = null;

		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://LocalHost:3306/student";

		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, "root", "admin");
			p = connection
					.prepareStatement("insert into altered values(?,?,?,?,?,?,?,?)");
			p.setInt(1, id);
			p.setString(2, userName);
			p.setString(3, passWord);
			p.setString(4, emailAddress);
			p.setString(5, sex);
			p.setString(6, contact);
			p.setString(7, day);
			p.setString(8, day);
			int i = p.executeUpdate();
			if (i == 1) {
				System.out.println("inserted");
			}
		}

		catch (SQLException e) {
			System.out.println(e);
		}
	}

	private static void login() throws SQLException, ClassNotFoundException {
		Date date = new Date();
		String day = date.toString();

		System.out.println("enter name to check");
		Scanner b1 = new Scanner(System.in);
		String name1 = b1.nextLine();

		System.out.println("enter passwrd to check");
		Scanner c1 = new Scanner(System.in);
		String passwrd1 = c1.nextLine();

		Connection conn = null;
		Statement stmt = null;
		/*
		 * stmt = connection.createStatement(); String sqll; sqll =
		 * "select * from altered"; rs = stmt.executeQuery(sqll);*
		 */
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://LocalHost:3306/student";
		Class.forName(JDBC_DRIVER);
		connection = DriverManager.getConnection(DB_URL, "root", "admin");
		p = connection.prepareStatement("select * from altered");
		rs = p.executeQuery();

		while (rs.next()) {
			System.out.println("In");
			String a = rs.getString("name");
			String b = rs.getString("password");

			if (name1.equals(a) && passwrd1.equals(b)) {
				System.out.println("login sucess:");
			} else {
				System.out.println("login failed");
			}

			// String sql =
			// "select * from altered where name='"+b1+"' and password='"+c1+"'";
			//Scanner get = new Scanner(System.in);
			//System.out.println("Enter id no to update");
			//int id1 = get.nextInt();
			
			
			System.out.println("Enter ID : ");
			Scanner get = new Scanner(System.in);
			int id11 = get.nextInt();

			System.out.println("Enter name : ");
			Scanner get1 = new Scanner(System.in);
			String uName = get1.nextLine();

			System.out.println("Enter passWord : ");
			Scanner get2 = new Scanner(System.in);
			String pWord = get2.nextLine();

			System.out.println("Enter emailAddress : ");
			Scanner get3 = new Scanner(System.in);
			String eAddress = get3.nextLine();

			System.out.println("Enter sex : ");
			Scanner get4 = new Scanner(System.in);
			String sex = get4.nextLine();

			System.out.println("Enter contact : ");
			Scanner get5 = new Scanner(System.in);
			String contact = get5.nextLine();
			
			/*System.out.println("Enter contact : ");
			Scanner get6 = new Scanner(System.in);
			String cdate = get6.nextLine();
			
			System.out.println("Enter contact : ");
			Scanner get7 = new Scanner(System.in);
			String udate = get7.nextLine();*/
			
			//String update = "update altered set name = ?,password=?,email=?,sex=?,contact=?,createdatd='"+day+"',updatedate='"+day+"'  where id =?";

			String update = "update altered set name ='"+uName +"',password='"+pWord +"',email='"+eAddress +"',sex='"+ sex+"',contact='"+contact +"',createdate='"+day+"',updatedate='"+day+"'  where id ="+id11;

			
			p = connection
					.prepareStatement(update);
			
			/*p.setInt(1, id11);
			p.setString(2, "uName");
			p.setString(3, "pword");
			p.setString(4,"eAddress");
			p.setString(5, "sex");
			p.setString(6, "contact");
			//p.setString(6, "cdate");
			//p.setString(7, "udate");*/

			
			
			int i = p.executeUpdate();
			if (i == 1) {
				System.out.println("Datas are updated");
			}

			System.out.println("Deleting datas:");
			Scanner get0 = new Scanner(System.in);
			System.out.println("Enter id no to delete all datas from a row");
			int id = get0.nextInt();
			String sql1 = "DELETE FROM altered " + "WHERE id = id";
			p = connection.prepareStatement(sql1);
			int i1 = p.executeUpdate();
			if (i1 == 1) {
				System.out.println("Datas are deleted");
			}
			System.out.println("you are going to logout");

		}

	}
}
