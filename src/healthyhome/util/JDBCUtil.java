package healthyhome.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCUtil {
	static{
		//1.注册数据库驱动
		//Class.forName(str)会根据str指定的一个类的名字，
		//把这个类从类路径下找到，并把这个类的实例加入到我们的服务器容器中
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConnection(){
		Connection conn  = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthy_home?useUnicode=true&characterEncoding=utf8","root","root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void free(Connection conn,Statement stmt,ResultSet rs ){
		try {
		if(rs!=null){
				rs.close();
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				if(stmt!=null)
					stmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					if(conn!=null)
						conn.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
		
		
	}
}
