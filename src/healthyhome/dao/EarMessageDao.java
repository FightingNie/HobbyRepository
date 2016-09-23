package healthyhome.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import healthyhome.bean.EarMessage;

@Repository("EarMessageDao")
public class EarMessageDao extends BaseDao {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <E> List<E>  findByUidAndId(EarMessage instance) {
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
	public <E> List<E>  findByUid(EarMessage instance) {
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
	public <E> List<E>  findByUidAndDate(EarMessage instance) {
		System.out.println("finding an instance by UidAndDate");
		try {
			List results = getSession().createCriteria(instance.getClass().getName())
					.add(Restrictions.eq("uid",instance.getUid())).add(Restrictions.eq("date",instance.getDate())).list();
			System.out.println("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			System.err.println("find by example failed");
			throw re;
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <E> List<E>  findById(EarMessage instance) {
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
