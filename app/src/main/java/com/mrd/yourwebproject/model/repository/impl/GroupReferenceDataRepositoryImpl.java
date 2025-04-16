/**
 * 
 */
package com.mrd.yourwebproject.model.repository.impl;


import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.mrd.framework.data.BaseHibernateJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupReferenceData;
import com.mrd.yourwebproject.model.repository.GroupReferenceDataRepository;

/**
 * @author mevan.d.souza
 *
 */
@Repository
public class GroupReferenceDataRepositoryImpl extends BaseHibernateJpaRepository<GroupReferenceData, Long> implements GroupReferenceDataRepository {

	public GroupReferenceData findByReferenceDataType(String referenceDataType) {
		Query q = sessionFactory.getCurrentSession().createQuery("from GroupReferenceData g where g.referenceDataType = :referenceDataType").setParameter("referenceDataType", referenceDataType);
		GroupReferenceData groupReferenceData = (GroupReferenceData)q.uniqueResult();
        return  groupReferenceData;
	}


	public List<GroupReferenceData> findByGroupCode(String groupCode) {
		Query q = sessionFactory.getCurrentSession().createQuery("from GroupReferenceData g where g.group.groupCode = :groupCode").setParameter("groupCode", groupCode);
		List<GroupReferenceData> GroupReferenceData = q.list();
        return  GroupReferenceData;
	}

}
