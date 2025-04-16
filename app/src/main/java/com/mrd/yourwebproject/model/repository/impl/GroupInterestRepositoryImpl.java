/**
 * 
 */
package com.mrd.yourwebproject.model.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mrd.framework.data.BaseHibernateJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupInterests;
import com.mrd.yourwebproject.model.repository.GroupInterestRepository;

/**
 * @author mevan.d.souza
 *
 */
@Repository
public class GroupInterestRepositoryImpl extends
		BaseHibernateJpaRepository<GroupInterests, Long>  implements GroupInterestRepository{

	public List<GroupInterests> findByGroupCode(String groupCode, boolean includeAll) {
		return(List<GroupInterests>)sessionFactory.getCurrentSession().createQuery("from GroupInterests gi where gi.groupCode = ?1 "+(includeAll?"":" and (gi.startDate is null or gi.startDate<=NOW()) and (gi.expiryDate is null or gi.expiryDate>=NOW())")).setParameter(1,
				groupCode).list();
	}

	public GroupInterests findByInterestType(String groupCode,String interestType, boolean includeAll) {
		return(GroupInterests)sessionFactory.getCurrentSession().createQuery("from GroupInterests gi where gi.groupCode = ?1 and gi.interestType=?2 "+(includeAll?"":" and (gi.startDate is null or gi.startDate<=NOW()) and (gi.expiryDate is null or gi.expiryDate>=NOW())")).setParameter(1,
				groupCode).setParameter(2, interestType).uniqueResult();
	}

	public List<GroupInterests> findAllByInterestType(String groupCode,String interestType, boolean includeAll) {
		return(List<GroupInterests>)sessionFactory.getCurrentSession().createQuery("from GroupInterests gi where gi.groupCode = ?1 and gi.interestType=?2 "+(includeAll?"":" and (gi.startDate is null or gi.startDate<=NOW()) and (gi.expiryDate is null or gi.expiryDate>=NOW())")).setParameter(1,
				groupCode).setParameter(2, interestType).list();
	}
}
