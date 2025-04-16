/**
 * 
 */
package com.mrd.yourwebproject.model.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mrd.framework.data.BaseHibernateJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupEventInvite;
import com.mrd.yourwebproject.model.entity.GroupEventInviteRSVP;
import com.mrd.yourwebproject.model.entity.GroupMember;
import com.mrd.yourwebproject.model.repository.GroupEventInviteRSVPRepository;

/**
 * @author mevan.d.souza
 *
 */
@Repository
public class GroupEventInviteRSVPRepositoryImpl extends
		BaseHibernateJpaRepository<GroupEventInviteRSVP, String> implements
		GroupEventInviteRSVPRepository {

	public List<GroupEventInviteRSVP> findByGroupCodeAndEventCode(
			String groupCode, String eventCode) {
		return (List<GroupEventInviteRSVP>) sessionFactory
				.getCurrentSession()
				.createQuery(
						"from GroupEventInviteRSVP gei where gei.groupCode = ?1 and gei.groupEventCode= ?2 order by gei.rsvpDateTime desc")
				.setParameter(1, groupCode).setParameter(2, eventCode).list();
	}

	public List<GroupEventInviteRSVP> findByGroupMemberAndGroupEventInvite(
			GroupMember groupMember, GroupEventInvite groupEventInvite) {
		return (List<GroupEventInviteRSVP>) sessionFactory
				.getCurrentSession()
				.createQuery(
						"from GroupEventInviteRSVP gei where gei.groupMember = :groupMember and gei.groupEventInvite= :groupEventInvite order by gei.rsvpDateTime desc")
				.setParameter("groupMember", groupMember).setParameter("groupEventInvite", groupEventInvite)
				.list();
	}

	public List<GroupEventInviteRSVP> findByGroupEventInvite(GroupEventInvite groupEventInvite){
			return (List<GroupEventInviteRSVP>) sessionFactory
					.getCurrentSession()
					.createQuery(
							"from GroupEventInviteRSVP gei where gei.groupEventInvite= :groupEventInvite order by gei.rsvpDateTime desc")
					.setParameter("groupEventInvite", groupEventInvite)
					.list();
	}

	public List<GroupEventInviteRSVP> findLatestRSVPsByMemberCategoryCodeAndEventCode(
			String groupCode, String memberCategoryCode, String groupEventCode) {
		return (List<GroupEventInviteRSVP>) sessionFactory
				.getCurrentSession()
				.createQuery(
						"select gei from GroupEventInviteRSVP gei inner join (  select groupMember.serialNumber as serialNumber, max(rsvpDateTime) as latest from GroupEventInviteRSVP group by serialNumber) r where  gei.rsvpDateTime = r.latest and gei.groupMember.serialNumber = r.serialNumber and gei.groupCode= ?1 and gei.memberCategoryCode=?2 and gei.groupEventCode=?3 group by gei.rsvpDateTime desc")
				.setParameter(1, groupCode).setParameter(2, memberCategoryCode).setParameter(3, groupEventCode).list();
				
	}
	public List<GroupEventInviteRSVP> findLatestRSVPsByGroupCodeAndEventCode(
			String groupCode, String eventCode) {
		return (List<GroupEventInviteRSVP>) sessionFactory
				.getCurrentSession()
				.createQuery(
						"from GroupEventInviteRSVP gei inner join (select g.groupMember.serialNumber as serialNumber, max(g.rsvpDateTime) as latest from GroupEventInviteRSVP g group by g.groupMember.serialNumber) r where  gei.rsvpDateTime = r.latest and gei.groupMember.serialNumber = r.serialNumber and gei.groupCode = ?1 and gei.groupEventCode= ?2 order by gei.rsvpDateTime desc")
				.setParameter(1, groupCode).setParameter(2, eventCode).list();
	}
}
