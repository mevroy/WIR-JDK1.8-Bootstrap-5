/**
 * 
 */
package com.mrd.yourwebproject.service;

import java.util.List;

import com.mrd.framework.data.BaseService;
import com.mrd.yourwebproject.model.entity.GroupEventInvite;
import com.mrd.yourwebproject.model.entity.GroupEventPaymentTransaction;
import com.mrd.yourwebproject.model.entity.GroupEventPaymentType;
import com.mrd.yourwebproject.model.entity.GroupEvents;
import com.mrd.yourwebproject.model.repository.GroupEventPaymentTransactionRepository;

/**
 * @author mevan.d.souza
 *
 */
public interface GroupEventPaymentTypeService extends BaseService<GroupEventPaymentType	, Long> {

	public List<GroupEventPaymentType> findByGroup(
			String groupCode, boolean includeExpired);
	
}
