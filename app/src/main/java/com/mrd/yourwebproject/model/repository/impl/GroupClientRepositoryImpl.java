/**
 * 
 */
package com.mrd.yourwebproject.model.repository.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.mrd.framework.data.BaseHibernateJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupClient;
import com.mrd.yourwebproject.model.repository.GroupClientRepository;

/**
 * @author mevan.d.souza
 *
 */
@Repository
public class GroupClientRepositoryImpl extends BaseHibernateJpaRepository<GroupClient, String>
		implements GroupClientRepository {

	public List<GroupClient> findByGroupCode(String groupCode) {
		Query q = sessionFactory.getCurrentSession()
				.createQuery("from GroupClient g where g.group.groupCode = :groupCode")
				.setParameter("groupCode", groupCode);
		List<GroupClient> groupClient = q.list();
		return groupClient;
	}

}
