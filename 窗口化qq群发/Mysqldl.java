package R12;

import java.sql.*;

public class Mysqldl {
	static Connection con;
	static String s2;
	static{
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "7274";
		try {
			//加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			//链接mysql数据库
			con = DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public Mysqldl(String s2){
		this.s2 = s2;
	}
	public static Connection getCon(){
		return con;
	}


	
	public static void Zeng() throws Exception{
		PreparedStatement ps;
		ps = con.prepareStatement("insert into test (xx)"
				+"values(?)");
		ps.setString(1,s2);
	}
	
	public static void Cha() throws Exception{
		Statement statement = con.createStatement();
		String sql = "select * from txst";
		ResultSet rs = statement.executeQuery(sql);
		String xx = null;
		while(rs.next()){
			//获取xx这列数据
			xx = rs.getString("xx");
			//输出结果
			System.out.println(xx);
		}
		
	}
	
}
