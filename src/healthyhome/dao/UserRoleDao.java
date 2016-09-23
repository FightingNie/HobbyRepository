package healthyhome.dao;

import healthyhome.bean.UserRole;

import java.util.List;

import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("UserRoleDao")
public class UserRoleDao extends BaseDao {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<UserRole> findByExample(UserRole instance) {
		System.out.println("finding an instance by example");
		try {
			List results = getSession().createCriteria(UserRole.class.toString().substring(6))
					.add(Example.create(instance)).list();
			System.out.println("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			System.err.println("find by example failed");
			throw re;
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<UserRole>  findByUid(UserRole instance) {
		System.out.println("finding an instance by Uid");
		try {
			List results = getSession().createCriteria(instance.getClass().getName())
					.add(Restrictions.eq("user_id",instance.getUserId())).list();
			System.out.println("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			System.err.println("find by example failed");
			throw re;
		}
	}
}
