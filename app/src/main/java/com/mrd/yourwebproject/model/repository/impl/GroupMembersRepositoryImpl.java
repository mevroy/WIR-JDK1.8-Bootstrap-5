/**
 * 
 */
package com.mrd.yourwebproject.model.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mrd.framework.data.BaseHibernateJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupMember;
import com.mrd.yourwebproject.model.repository.GroupMembersRepository;

/**
 * @author mevan.d.souza
 *
 */
@Repository
public class GroupMembersRepositoryImpl extends BaseHibernateJpaRepository<GroupMember, String> implements GroupMembersRepository{

    @SuppressWarnings("unchecked")
	public List<GroupMember> findByGroupCodeAndMemberCategoryCode(String groupCode, String membercategoryCode) {
        return (List<GroupMember>) sessionFactory.getCurrentSession().createQuery("from GroupMember g where g.groupCode = ?1 and g.memberCategoryCode=?2").setParameter(1,
                groupCode).setParameter(2, membercategoryCode).list();
    }

    @SuppressWarnings("unchecked")
	public List<GroupMember> findByGroupCode(String groupCode) {
        return (List<GroupMember>) sessionFactory.getCurrentSession().createQuery("from GroupMember g where g.groupCode = ?1").setParameter(1,
                groupCode).list();
    }

	public List<GroupMember> executeGenericQuery(String hibernateQuery) {
		return (List<GroupMember>) sessionFactory.getCurrentSession().createQuery(hibernateQuery).list();
	}

	public List<GroupMember> findByGroupCodeAndMemberCategoryCodeNotExitingInGroupEventInvite(
			String groupCode, String membercategoryCode, String groupEventCode) {
        return (List<GroupMember>) sessionFactory.getCurrentSession().createQuery("from GroupMember g where g.groupCode = ?1 and g.memberCategoryCode=?2 and not exists (select gei.groupEventInviteId from GroupEventInvite gei where gei.groupMember.serialNumber = g.serialNumber and g.groupCode = gei.groupCode and g.memberCategoryCode=gei.memberCategoryCode and gei.groupEventCode = ?3)").setParameter(1,
                groupCode).setParameter(2, membercategoryCode).setParameter(3, groupEventCode).list();

	}
	
	public List<GroupMember> findByGroupCodeNotExitingInGroupEventInvite(
			String groupCode, String groupEventCode) {
        return (List<GroupMember>) sessionFactory.getCurrentSession().createQuery("from GroupMember g where g.groupCode = ?1 and not exists (select gei.groupEventInviteId from GroupEventInvite gei where gei.groupMember.serialNumber = g.serialNumber and g.groupCode = gei.groupCode and g.memberCategoryCode=gei.memberCategoryCode and gei.groupEventCode=?2)").setParameter(1,
                groupCode).setParameter(2, groupEventCode).list();

	}

	public GroupMember findbyMembershipIdentifier(String membershipIdentifier) {

		Criteria c = this.createCriteria();
		c.add(Restrictions.eq("membershipIdentifier", membershipIdentifier));
		//return (GroupMember)sessionFactory.getCurrentSession().createQuery("from GroupMember g where g.membershipIdentifier = ?").setString(0, membershipIdentifier).uniqueResult();
		return (GroupMember)c.uniqueResult();
	}

	public List<GroupMember> findByAssociatedEmailForGroupMember(String emailAddress, String groupCode) {
		return (List<GroupMember>) sessionFactory.getCurrentSession().createQuery("select distinct g from GroupMember g, GroupDependents gd where g.groupCode = ?1 and ((g.primaryEmail like :emailAddress or g.otherEmail like :emailAddress) or (g.serialNumber=gd.groupMember.serialNumber and gd.email like :emailAddress))").setParameter(1,
                groupCode).setString("emailAddress", "%"+emailAddress+"%").list();
	}

}
