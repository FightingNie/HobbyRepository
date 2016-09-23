package healthyhome.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import healthyhome.bean.LiverMessage;
import healthyhome.util.JDBCUtil;

public class JDBCLiverMessageDaoImpl implements JDBCLiverMessageDao {

	@Override
	public String saveLiverMessage(LiverMessage liverMessage) {
		Connection conn = null;
		//conn.setAutoCommit(false);
		PreparedStatement pstmt = null;
		String sql1 = "insert into liver_message(liver,liver_inspector,comment,date,times,uid) values(?,?,?,?,?,?)";
		ResultSet rs = null;
		
		try{
			conn = JDBCUtil.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1,liverMessage.getLiver());
			pstmt.setString(2,liverMessage.getLiverInspector());
			pstmt.setString(3,liverMessage.getComment());
			pstmt.setString(4,liverMessage.getDate());
			pstmt.setInt(5, liverMessage.getTimes());
			pstmt.setInt(6,liverMessage.getUid());
			pstmt.executeUpdate();
  
			conn.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			
			
			JDBCUtil.free(conn, pstmt, rs);
		}
		return "SUCCESS";
	}

	@Override
	public int queryCount(int uid) {
		 Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	         
	        try{
	        	conn = JDBCUtil.getConnection();
		  
	        	pstmt = conn.prepareStatement("select count(*) from liver_message where uid=?");
	        	pstmt.setInt(1,uid);
	        	rs = pstmt.executeQuery();
	        	rs.next();
	        	int totalRecord = rs.getInt(1);
	        	return totalRecord; 
	  
	        }catch(Exception e){
	        	return 0;
	        }finally{
	        	JDBCUtil.free(conn, pstmt, rs);  
	        }
	}

}
