package healthyhome.dao;

import healthyhome.bean.UserMessage;

public interface JDBCUserMessageDao {
	public UserMessage queryUser(UserMessage user);
}
