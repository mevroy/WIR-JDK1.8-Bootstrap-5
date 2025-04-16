/**
 * 
 */
package com.mrd.yourwebproject.model.repository.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.mrd.framework.data.BaseHibernateJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupEvents;
import com.mrd.yourwebproject.model.repository.GroupEventsRepository;

/**
 * @author mevan.d.souza
 *
 */
@Repository
public class GroupEventsRepositoryImpl extends
		BaseHibernateJpaRepository<GroupEvents, Long> implements GroupEventsRepository {

	public List<GroupEvents> findByGroupCode(String groupCode) {
		Query q = sessionFactory.getCurrentSession().createQuery("from GroupEvents ge where ge.groupCode = :groupCode and (ge.expiryDate is null or date(ge.expiryDate) >= NOW()) order by ge.eventDate desc").setParameter("groupCode",
        		groupCode);
		List<GroupEvents> groupEvents = q.list();
        return  groupEvents;
	}

	public List<GroupEvents> findByGroupCodeAndMemberCategoryCode(
			String groupCode, String memberCategoryCode) {
		Query q = sessionFactory.getCurrentSession().createQuery("from GroupEvents ge where ge.groupCode = :groupCode and (ge.memberCategoryCode = :memberCategoryCode or ge.memberCategoryCode is null or ge.memberCategoryCode = '') and (ge.expiryDate is null or date(ge.expiryDate) >= NOW())  order by ge.eventDate desc").setParameter("groupCode",
        		groupCode).setParameter("memberCategoryCode", memberCategoryCode);
		List<GroupEvents> groupEvents = q.list();
        return  groupEvents;
	}

	public GroupEvents findByGroupEventCode(String groupEventCode) {
		Query q = sessionFactory.getCurrentSession().createQuery("from GroupEvents ge where ge.eventCode = :eventCode order by ge.eventDate desc").setParameter("eventCode",
				groupEventCode);
		GroupEvents groupEvent = (GroupEvents)q.uniqueResult();
        return  groupEvent;
	}

	public List<GroupEvents> findByGroupCode(String groupCode,
			boolean includeExpired) {
		Query q = sessionFactory.getCurrentSession().createQuery("from GroupEvents ge where ge.groupCode = :groupCode  "+(includeExpired? "":" and (ge.expiryDate is null or date(ge.expiryDate) >= NOW())")+ " order by ge.eventDate desc").setParameter("groupCode",
        		groupCode);
		List<GroupEvents> groupEvents = q.list();
        return  groupEvents;
	}

	public List<GroupEvents> findByGroupCodeAndMemberCategoryCode(
			String groupCode, String memberCategoryCode, boolean includeExpired) {
		Query q = sessionFactory.getCurrentSession().createQuery("from GroupEvents ge where ge.groupCode = :groupCode and (ge.memberCategoryCode = :memberCategoryCode or ge.memberCategoryCode is null or ge.memberCategoryCode = '') "+(includeExpired? "":" and (ge.expiryDate is null or date(ge.expiryDate) >= NOW())")+" order by ge.eventDate desc").setParameter("groupCode",
        		groupCode).setParameter("memberCategoryCode", memberCategoryCode);
		List<GroupEvents> groupEvents = q.list();
        return  groupEvents;
	}

}
