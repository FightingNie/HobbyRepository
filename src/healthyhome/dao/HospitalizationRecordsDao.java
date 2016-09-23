package healthyhome.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import healthyhome.bean.HospitalizationRecords;

@Repository("HospitalizationRecordsDao")
public class HospitalizationRecordsDao extends BaseDao {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <E> List<E>  findByUid(HospitalizationRecords instance) {
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
