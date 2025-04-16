/**
 * 
 */
package com.mrd.yourwebproject.model.repository;

import java.util.List;

import com.mrd.framework.data.BaseJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupEventPassCategory;

/**
 * @author mevan.d.souza
 *
 */
public interface GroupEventPassCategoryRepository extends BaseJpaRepository<GroupEventPassCategory, String> {


	public List<GroupEventPassCategory> findByGroupCodeAndGroupEventCode(String groupCode, String groupEventCode, boolean includeNotAvailableForPurchase);
	public List<GroupEventPassCategory> findByGroupCodeAndGroupEventCodeForMemberType(String groupCode, String groupEventCode, boolean includeInactive, boolean availableForPurchase, String[] isMember);
}
