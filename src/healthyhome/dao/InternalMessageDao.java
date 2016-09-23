package healthyhome.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import healthyhome.bean.InternalMessage;

@Repository("InternalMessageDao")
public class InternalMessageDao extends BaseDao {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <E> List<E>  findByUidAndId(InternalMessage instance) {
		System.out.println("finding an instance by Uid");
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
	public <E> List<E>  findByUid(InternalMessage instance) {
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <E> List<E>  findById(InternalMessage instance) {
		System.out.println("finding an instance by id");
		try {
			List results = getSession().createCriteria(instance.getClass().getName())
					.add(Restrictions.eq("id",instance.getId())).list();
			System.out.println("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			System.err.println("find by example failed");
			throw re;
		}
	}
}
