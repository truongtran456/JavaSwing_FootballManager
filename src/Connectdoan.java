

import java.sql.*;

public class Connectdoan {
	Connection con;
	static Statement stmt;
	
	//ResultSet
	public Connectdoan() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			try {
				this.con = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-H9PTCLCF\\\\SQLEXPRESS:1433;databaseName=DoAnJaVa;user=sa;password=sa");
				this.stmt = con.createStatement();
				System.out.println("Kết nối thành công");
				//stmt.executeUpdate("insert into lop values(\"183\", \"18T3\")");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public static Statement getStmt() {
		return stmt;
	}
	public ResultSet getMadoibongFromDOIBONG() {
		ResultSet rs = null;
		try {
			rs = this.stmt.executeQuery("select madoibong from DOIBONG");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet getAllFromDOIBONG() {
		ResultSet rs = null;
		try {
			rs = this.stmt.executeQuery("select * from DOIBONG");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet getMadoibongFromKETQUA() {
		ResultSet rs1 = null;
		try {
			rs1 = this.stmt.executeQuery("select trandau from KETQUA");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs1;
	}
	public ResultSet getAllFromKETQUA() {
		ResultSet rs1 = null;
		try {
			rs1 = this.stmt.executeQuery("select * from KETQUA");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs1;
	}
	
	public ResultSet getMadoibongFromLICHTHIDAU() {
		ResultSet rs2 = null;
		try {
			rs2 = this.stmt.executeQuery("select trandau from LICHTHIDAU");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs2;
	}
	public ResultSet getAllFromLICHTHIDAU() {
		ResultSet rs2 = null;
		try {
			rs2 = this.stmt.executeQuery("select * from LICHTHIDAU");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs2;
	}
	
	public ResultSet getAllFromBANGXEPHANG() {
		ResultSet rs3 = null;
		try {
			rs3 = this.stmt.executeQuery("select * from BANGXEPHANG");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs3;
	}
	
	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

	
	public static void main1(String args[]) {
	try {
		Connectdoan condb = new Connectdoan();
		ResultSet rs = condb.getStmt().executeQuery("select * from DOIBONG ");
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
	public static Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}
	public void close() {
		// TODO Auto-generated method stub
		
	}
	public PreparedStatement prepareStatement(String query) {
		// TODO Auto-generated method stub
		return null;
	}


}