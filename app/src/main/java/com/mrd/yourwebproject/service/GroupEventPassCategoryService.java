/**
 * 
 */
package com.mrd.yourwebproject.service;

import java.util.List;

import com.mrd.framework.data.BaseService;
import com.mrd.yourwebproject.model.entity.GroupEventInvite;
import com.mrd.yourwebproject.model.entity.GroupEventPass;
import com.mrd.yourwebproject.model.entity.GroupEventPassCategory;
import com.mrd.yourwebproject.model.entity.GroupMember;

/**
 * @author mevan.d.souza
 *
 */
public interface GroupEventPassCategoryService extends BaseService<GroupEventPassCategory, String> {

	public List<GroupEventPassCategory> findByGroupCodeAndGroupEventCode(String groupCode, String groupEventCode, boolean includeNotAvailableForPurchase);
	public List<GroupEventPassCategory> findByGroupCodeAndGroupEventCodeForMemberType(String groupCode, String groupEventCode, boolean includeInactive, boolean availableForPurchase, String[] isMember);
	
}
