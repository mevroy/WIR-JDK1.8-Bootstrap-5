/**
 * 
 */
package com.mrd.yourwebproject.model.repository.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.mrd.framework.data.BaseHibernateJpaRepository;
import com.mrd.yourwebproject.model.entity.RegisterInterest;
import com.mrd.yourwebproject.model.repository.RegisterInterestRepository;

/**
 * @author mevan.d.souza
 *
 */
@Repository
public class RegisterInterestRepositoryImpl extends
		BaseHibernateJpaRepository<RegisterInterest, Long> implements RegisterInterestRepository{

	public List<RegisterInterest> findByGroupCode(String groupCode,
			boolean includeAll) {
		Query q = sessionFactory.getCurrentSession().createQuery("from RegisterInterest r where r.groupCode = ?1 "+(includeAll?" or r.groupCode is null or r.groupCode = '' ":"")+" order by r.createdAt desc").setParameter(1,
        		groupCode);
		List<RegisterInterest> registeredInterests = (List<RegisterInterest>)q.list();
        return  registeredInterests;
	}

}
