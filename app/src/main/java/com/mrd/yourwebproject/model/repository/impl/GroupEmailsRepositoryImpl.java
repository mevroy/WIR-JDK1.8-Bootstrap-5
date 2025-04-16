/**
 * 
 */
package com.mrd.yourwebproject.model.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mrd.framework.data.BaseHibernateJpaRepository;
import com.mrd.yourwebproject.common.Props;
import com.mrd.yourwebproject.model.entity.GroupEmail;
import com.mrd.yourwebproject.model.repository.GroupEmailsRepository;

/**
 * @author mevan.d.souza
 *
 */
@Repository
public class GroupEmailsRepositoryImpl extends BaseHibernateJpaRepository<GroupEmail, String> implements GroupEmailsRepository{

	protected @Autowired Props props;
	public List<GroupEmail> findEmailsToBeSent(String conversionToTimeZone) {
		return (List<GroupEmail>)sessionFactory.getCurrentSession().createQuery("from GroupEmail ge where ge.emailedDate = null and (ge.emailingDate = null or ge.emailingDate>=CONVERT_TZ(now(),'"+props.dbServerTimeZone+"','"+conversionToTimeZone+"' )) and (ge.emailExpirydate = null or ge.emailExpirydate<=CONVERT_TZ(now(),'"+props.dbServerTimeZone+"','"+conversionToTimeZone+"' ))").list();

	}

	public List<GroupEmail> findEmailsByGroupCode(String groupCode) {
		
		return (List<GroupEmail>)sessionFactory.getCurrentSession().createQuery("from GroupEmail ge where ge.groupMember.groupCode = ?1").setParameter(1, groupCode).list();
	}

	public List<GroupEmail> findEmailsByMemberCategoryCodeAndGroupEventCode(
			String memberCategoryCode, String groupEventCode) {
		return (List<GroupEmail>)sessionFactory.getCurrentSession().createQuery("select ge from GroupEmail ge, GroupEventInvite gei where ge.groupMember.memberCategoryCode = ?1 and ge.groupEventInviteId = gei.groupEventInviteId and gei.groupEventCode = ?2 and ge.groupMember.memberCategoryCode = gei.memberCategoryCode").setParameter(1, memberCategoryCode).setParameter(2, groupEventCode).list();
	}
	public List<GroupEmail> findEmailsByGroupEventCode(String groupEventCode) {
		// TODO Auto-generated method stub
		return (List<GroupEmail>)sessionFactory.getCurrentSession().createQuery("select ge from GroupEmail ge, GroupEventInvite gei where  ge.groupEventInviteId = gei.groupEventInviteId and gei.groupEventCode = ?1").setParameter(1, groupEventCode).list();
	}

	public List<GroupEmail> findUnassignedEmailsByGroupCode(String groupCode) {
		return (List<GroupEmail>)sessionFactory.getCurrentSession().createQuery("from GroupEmail ge where ge.emailAccountCode in (select gea.emailAccountCode from GroupEmailAccount gea where gea.groupCode = ?1 ) and ( ge.groupEventInviteId = null or ge.groupEventInviteId = '')").setParameter(1, groupCode).list();
	}

	public List<GroupEmail> findEmailsByGroupEventCodeAndSerialNumber(
			String groupEventCode, String serialNumber) {
		return (List<GroupEmail>)sessionFactory.getCurrentSession().createQuery("select ge from GroupEmail ge, GroupEventInvite gei where  ge.groupEventInviteId = gei.groupEventInviteId and gei.groupEventCode = ?1 and gei.groupMember.serialNumber = ?2").setParameter(1, groupEventCode).setParameter(2, serialNumber).list();
	}

}
