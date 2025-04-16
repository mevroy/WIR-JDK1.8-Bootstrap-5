/**
 * 
 */
package com.mrd.yourwebproject.model.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mrd.framework.data.BaseHibernateJpaRepository;
import com.mrd.yourwebproject.model.entity.Feedback;
import com.mrd.yourwebproject.model.entity.GroupEventInvite;
import com.mrd.yourwebproject.model.entity.GroupMember;
import com.mrd.yourwebproject.model.repository.FeedbackRepository;

/**
 * @author mevan.d.souza
 *
 */
@Repository
public class FeedbackRepositoryImpl extends BaseHibernateJpaRepository<Feedback, Long> implements FeedbackRepository{

	public List<Feedback> findByGroupEventCode(String groupEventCode) {
		return (List<Feedback>)sessionFactory.getCurrentSession().createQuery("from Feedback f where f.groupEventCode = ?1").setParameter(1,
                groupEventCode).list();
	}

	public Feedback findByGroupEventInvite(GroupEventInvite groupEventInvite) {
		return (Feedback)sessionFactory.getCurrentSession().createQuery("from Feedback f where f.groupEventInviteId = :groupEventInviteId").setParameter("groupEventInviteId", groupEventInvite.getGroupEventInviteId()).uniqueResult();
	}

	public List<Feedback> findByGroupMember(GroupMember groupMember) {
		return (List<Feedback>)sessionFactory.getCurrentSession().createQuery("from Feedback f where f.serialNumber = ?1").setParameter(1,
				groupMember.getSerialNumber()).list();
	}

	public List<Feedback> findByMemberCategoryCodeAndGroupEventCode(
			String memberCategoryCode, String groupEventCode) {
		return (List<Feedback>)sessionFactory.getCurrentSession().createQuery("select f from Feedback f, GroupMember gm where f.groupEventCode = ?1 and f.serialNumber=gm.serialNumber and gm.memberCategoryCode = ?2").setParameter(1,
                groupEventCode).setParameter(2, memberCategoryCode).list();
	}

}
