package healthyhome.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import healthyhome.bean.BloodMessage;
import healthyhome.util.JDBCUtil;

public class JDBCBloodMessageDaoImpl implements JDBCBloodMessageDao {

	@Override
	public String saveBloodMessage(BloodMessage bloodMessage) {
		Connection conn = null;
		//conn.setAutoCommit(false);
		PreparedStatement pstmt = null;
		String sql1 = "insert into blood_message(blood,blood_inspector,comment,date,uid) values(?,?,?,?,?)";
		ResultSet rs = null;
		
		int orderId = 0 ;
		try{
			conn = JDBCUtil.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1,bloodMessage.getBlood());
			pstmt.setString(2,bloodMessage.getBloodInspector());
			pstmt.setString(3,bloodMessage.getComment());
			pstmt.setString(4,bloodMessage.getDate());
			pstmt.setInt(5,bloodMessage.getUid());
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
	  
        	pstmt = conn.prepareStatement("select count(*) from blood_message where uid=?");
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
