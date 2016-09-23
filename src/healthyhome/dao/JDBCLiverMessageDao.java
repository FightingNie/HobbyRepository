package healthyhome.dao;

import healthyhome.bean.LiverMessage;

public interface JDBCLiverMessageDao {
	public String saveLiverMessage(LiverMessage liverMessage);
	public int queryCount(int uid);
}
