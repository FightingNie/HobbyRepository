package healthyhome.dao;

import healthyhome.bean.BloodMessage;

public interface JDBCBloodMessageDao {
	public String saveBloodMessage(BloodMessage bloodMessage);
	public int queryCount(int uid);
}
