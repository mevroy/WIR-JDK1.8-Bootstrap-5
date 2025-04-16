
/**
 * 
 */
package com.mrd.yourwebproject.model.repository;
import java.util.List;

import com.mrd.framework.data.BaseJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupEventInvite;
import com.mrd.yourwebproject.model.entity.GroupEventPaymentTransaction;

public interface GroupEventPaymentTransactionRepository extends BaseJpaRepository<GroupEventPaymentTransaction, String> {

	public List<GroupEventPaymentTransaction> findByGroupEventInvite(GroupEventInvite groupEventInvite, boolean includeExpired);
	public List<GroupEventPaymentTransaction> findByUserCode(String userCode);
	public List<GroupEventPaymentTransaction> findByGroupEventCode(String groupEventCode);
	public List<GroupEventPaymentTransaction> findByCategoryCodeAndGroupEventCode(String memberCategoryCode, String groupEventCode);
	
}