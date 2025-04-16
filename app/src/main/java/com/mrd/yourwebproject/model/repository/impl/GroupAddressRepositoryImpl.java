/**
 * 
 */
package com.mrd.yourwebproject.model.repository.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.mrd.framework.data.BaseHibernateJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupAddress;
import com.mrd.yourwebproject.model.repository.GroupAddressRepository;

/**
 * @author mevan.d.souza
 *
 */
@Repository
public class GroupAddressRepositoryImpl extends BaseHibernateJpaRepository<GroupAddress, String>
		implements GroupAddressRepository {

	public List<GroupAddress> findByGroupClient(String clientId) {
		Query q = sessionFactory.getCurrentSession()
				.createQuery("from GroupAddress g where g.clientId = :clientId")
				.setParameter("clientId", clientId);
		List<GroupAddress> groupAddress = q.list();
		return groupAddress;
	}

}
