/**
 * 
 */
package com.mrd.yourwebproject.model.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mrd.framework.data.BaseHibernateJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupEventInvite;
import com.mrd.yourwebproject.model.entity.GroupEventPaymentTransaction;
import com.mrd.yourwebproject.model.entity.enums.PaymentStatus;
import com.mrd.yourwebproject.model.repository.GroupEventPaymentTransactionRepository;

/**
 * @author mevan.d.souza
 *
 */
@Repository
public class GroupEventPaymentTransactionRepositoryImpl extends BaseHibernateJpaRepository<GroupEventPaymentTransaction, String> implements GroupEventPaymentTransactionRepository{




	public List<GroupEventPaymentTransaction> findByGroupEventInvite(
			GroupEventInvite groupEventInvite, boolean includeExpired) {
		return (List<GroupEventPaymentTransaction>)sessionFactory.getCurrentSession().createQuery("from GroupEventPaymentTransaction gepT where gepT.groupEventInvite.groupEventInviteId = :groupEventInviteId "+(includeExpired?"":(" and gepT.paymentStatus != '"+PaymentStatus.EXPIRED+"'"))+" order by gepT.transactionDateTime desc").setParameter("groupEventInviteId", groupEventInvite.getGroupEventInviteId()).list();
	}

	public List<GroupEventPaymentTransaction> findByUserCode(
			String userCode) {
		return (List<GroupEventPaymentTransaction>)sessionFactory.getCurrentSession().createQuery("from GroupEventPaymentTransaction gepT where gepT.userCode = :userCode").setParameter("userCode", userCode).list();
	}

	public List<GroupEventPaymentTransaction> findByGroupEventCode(
			String groupEventCode) {

		return (List<GroupEventPaymentTransaction>)sessionFactory.getCurrentSession().createQuery("from GroupEventPaymentTransaction gepT where gepT.groupEventCode = :groupEventCode").setParameter("groupEventCode", groupEventCode).list();
	}

	public List<GroupEventPaymentTransaction> findByCategoryCodeAndGroupEventCode(
			String memberCategoryCode, String groupEventCode) {
		return (List<GroupEventPaymentTransaction>)sessionFactory.getCurrentSession().createQuery("from GroupEventPaymentTransaction gepT where gepT.groupEventInvite !=null and gepT.groupEventInvite.memberCategoryCode = :memberCategoryCode and  gepT.groupEventCode = :groupEventCode order by gepT.paymentStatus desc").setParameter("memberCategoryCode", memberCategoryCode).setParameter("groupEventCode", groupEventCode).list();
	}





}
