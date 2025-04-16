/**
 * 
 */
package com.mrd.yourwebproject.model.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mrd.framework.data.BaseHibernateJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupEventPassCategory;
import com.mrd.yourwebproject.model.repository.GroupEventPassCategoryRepository;


/**
 * @author mevan.d.souza
 *
 */
@Repository
public class GroupEventPassCategoryRepositoryImpl extends
		BaseHibernateJpaRepository<GroupEventPassCategory, String> implements GroupEventPassCategoryRepository{

	public List<GroupEventPassCategory> findByGroupCodeAndGroupEventCode(
			String groupCode, String groupEventCode, boolean includeNotAvailableForPurchase) {
		return(List<GroupEventPassCategory>)sessionFactory.getCurrentSession().createQuery("from GroupEventPassCategory gpc where gpc.group.groupCode = ?1 and gpc.groupEvent.eventCode = ?2 "+(includeNotAvailableForPurchase?"":" and (gpc.purchaseStartDateTime is null or gpc.purchaseStartDateTime<=NOW()) and (gpc.purchaseExpiryDateTime is null or gpc.purchaseExpiryDateTime>=NOW())")+" order by gpc.displayOrder asc").setParameter(1,
				groupCode).setParameter(2, groupEventCode).list();
	}


	public List<GroupEventPassCategory> findByGroupCodeAndGroupEventCodeForMemberType(
			String groupCode, String groupEventCode, boolean includeInactive, boolean availableForPurchase, String[] isMember) {
		return(List<GroupEventPassCategory>)sessionFactory.getCurrentSession().createQuery("from GroupEventPassCategory gpc where gpc.group.groupCode = :groupCode and gpc.groupEvent.eventCode = :eventCode and (gpc.memberOnlyPurchase IN (:isMember) or gpc.memberOnlyPurchase is null) and gpc.disablePurchase = :disablePurchase "+(includeInactive?"":" and (gpc.purchaseStartDateTime is null or gpc.purchaseStartDateTime<=NOW()) and (gpc.purchaseExpiryDateTime is null or gpc.purchaseExpiryDateTime>=NOW())") + " order by gpc.displayOrder asc").setBoolean("disablePurchase", !availableForPurchase).setParameter("eventCode", groupEventCode).setParameter("groupCode", groupCode).setParameterList("isMember", isMember).list();
	}


}
