package healthyhome.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import healthyhome.bean.UserMessage;
import healthyhome.util.JDBCUtil;

public class JDBCUserMessageDaoImpl implements JDBCUserMessageDao{

	@Override
	public UserMessage queryUser(UserMessage user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from user_message where cardNo=?";
		
		ResultSet rs = null;
		
		UserMessage userTemp = null;
		
		try{
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,user.getCardNo());
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				userTemp = new UserMessage();
				userTemp.setId(rs.getInt("id"));
//				userTemp.setUsername(rs.getString("username"));
//				userTemp.setUserpass(rs.getString("userpass"));
			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtil.free(conn, pstmt, rs);
		}
		return userTemp;
	}
	
}
