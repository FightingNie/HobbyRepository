package healthyhome.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import healthyhome.bean.BMessage;

@Repository("BMessageDao")
public class BMessageDao extends BaseDao {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <E> List<E>  findByUidAndId(BMessage instance){
		System.out.println("finding an instance by UidAndId");
		try {
			List results = getSession().createCriteria(instance.getClass().getName())
					.add(Restrictions.eq("uid",instance.getUid())).add(Restrictions.eq("id",instance.getId())).list();
			System.out.println("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			System.err.println("find by example failed");
			throw re;
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <E> List<E>  findByUid(BMessage instance){
		System.out.println("finding an instance by Uid");
		try {
			List results = getSession().createCriteria(instance.getClass().getName())
					.add(Restrictions.eq("uid",instance.getUid())).list();
			System.out.println("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			System.err.println("find by example failed");
			throw re;
		}
	}
}
