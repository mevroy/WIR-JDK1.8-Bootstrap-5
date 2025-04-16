/**
 * 
 */
package com.mrd.yourwebproject.model.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mrd.framework.data.BaseHibernateJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupSMS;
import com.mrd.yourwebproject.model.repository.GroupSMSRepository;

/**
 * @author mevan.d.souza
 *
 */
@Repository
public class GroupSMSRepositoryImpl extends BaseHibernateJpaRepository<GroupSMS, String> implements GroupSMSRepository{


	public List<GroupSMS> findByGroupCode(String groupCode) {
		return (List<GroupSMS>)sessionFactory.getCurrentSession().createQuery("from GroupSMS gsms where gsms.groupCode = ?1 ").setParameter(1,
                groupCode).list();
	}

	public GroupSMS findByMessageId(String messageId) {
		return (GroupSMS)sessionFactory.getCurrentSession().createQuery("from GroupSMS gsms where gsms.providerMessageId = ?1 ").setParameter(1,
				messageId).uniqueResult();
	}

	public List<GroupSMS> findSMSByGroupEventCode(String groupEventCode) {
		return (List<GroupSMS>)sessionFactory.getCurrentSession().createQuery("select ge from GroupSMS ge, GroupEventInvite gei where  ge.groupEventInviteId = gei.groupEventInviteId and gei.groupEventCode = ?1").setParameter(1, groupEventCode).list();
	}

	public List<GroupSMS> findSMSByMemberCategoryCodeAndGroupEventCode(
			String memberCategoryCode, String groupEventCode) {
		return (List<GroupSMS>)sessionFactory.getCurrentSession().createQuery("select ge from GroupSMS ge, GroupEventInvite gei where ge.groupMember.memberCategoryCode = ?1 and ge.groupEventInviteId = gei.groupEventInviteId and gei.groupEventCode = ?2 and ge.groupMember.memberCategoryCode = gei.memberCategoryCode").setParameter(1, memberCategoryCode).setParameter(2, groupEventCode).list();
	}

	public List<GroupSMS> findUnassignedSMSByGroupCode(String groupCode) {
		return (List<GroupSMS>)sessionFactory.getCurrentSession().createQuery("from GroupSMS ge where ge.groupCode = ?1  and ( ge.groupEventInviteId = null or ge.groupEventInviteId = '')").setParameter(1, groupCode).list();
	}
	

}
