/**
 * 
 */
package com.mrd.yourwebproject.model.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mrd.framework.data.BaseHibernateJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupDependents;
import com.mrd.yourwebproject.model.entity.GroupMember;
import com.mrd.yourwebproject.model.repository.GroupDependentsRepository;

/**
 * @author mevan.d.souza
 *
 */
@Repository
public class GroupDependentsRepositoryImpl extends
		BaseHibernateJpaRepository<GroupDependents, String> implements GroupDependentsRepository {

	public List<GroupDependents> findByGroupMember(GroupMember groupMember) {
        return (List<GroupDependents>) sessionFactory.getCurrentSession().createQuery("from GroupDependents g where g.serialNumber = ?1").setParameter(1,
                groupMember.getSerialNumber()).list();
	}

	public List<GroupDependents> findByGroupMemberSerialNumber(
			String serialNumber) {
        return (List<GroupDependents>) sessionFactory.getCurrentSession().createQuery("from GroupDependents g where g.serialNumber = ?1").setParameter(1,
                serialNumber).list();
	}

}
