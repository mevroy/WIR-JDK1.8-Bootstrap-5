/**
 * 
 */
package com.mrd.yourwebproject.model.repository.impl;


import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.mrd.framework.data.BaseHibernateJpaRepository;
import com.mrd.yourwebproject.model.entity.Groups;
import com.mrd.yourwebproject.model.repository.GroupsRepository;

/**
 * @author mevan.d.souza
 *
 */
@Repository
public class GroupsRepositoryImpl extends BaseHibernateJpaRepository<Groups, Long> implements GroupsRepository {

	public Groups findByGroupCode(String groupCode) {
		Query q = sessionFactory.getCurrentSession().createQuery("from Groups g where g.groupCode = ?1").setParameter(1,
        		groupCode);
		Groups groups = (Groups)q.uniqueResult();
        return  groups;
	}

	public Groups findByGroupCodeActive(String groupCode)
	{
		Query q = sessionFactory.getCurrentSession().createQuery("from Groups g where g.groupCode = ?1 and g.startDate<=NOW() and g.expiryDate>=NOW()").setParameter(1,
        		groupCode);
		Groups groups = (Groups)q.uniqueResult();
        return  groups;
	}
	public List<Groups> findGroups() {
		Query q = sessionFactory.getCurrentSession().createQuery("from Groups g where g.startDate<=NOW() and g.expiryDate>=NOW()");
		List<Groups> groups = q.list();
        return  groups;
	}

}
