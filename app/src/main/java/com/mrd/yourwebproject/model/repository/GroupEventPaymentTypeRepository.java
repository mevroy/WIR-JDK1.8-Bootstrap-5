/**
 * 
 */
package com.mrd.yourwebproject.model.repository;

import java.util.List;

import com.mrd.framework.data.BaseJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupEventPaymentType;


/**
 * @author mevan.d.souza
 *
 */
public interface GroupEventPaymentTypeRepository extends BaseJpaRepository<GroupEventPaymentType, Long> {

	public List<GroupEventPaymentType> findByGroup(
			String groupCode, boolean includeExpired);
}
