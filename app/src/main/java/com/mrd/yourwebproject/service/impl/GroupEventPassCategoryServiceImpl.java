/**
 * 
 */
package com.mrd.yourwebproject.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrd.framework.data.BaseJpaServiceImpl;
import com.mrd.yourwebproject.model.entity.GroupEventInvite;
import com.mrd.yourwebproject.model.entity.GroupEventPass;
import com.mrd.yourwebproject.model.entity.GroupEventPassCategory;
import com.mrd.yourwebproject.model.entity.GroupMember;
import com.mrd.yourwebproject.model.repository.GroupEventPassCategoryRepository;
import com.mrd.yourwebproject.model.repository.GroupEventPassesRepository;
import com.mrd.yourwebproject.service.GroupEventPassCategoryService;
import com.mrd.yourwebproject.service.GroupEventPassesService;

/**
 * @author mevan.d.souza
 *
 */
@Service
@Transactional
public class GroupEventPassCategoryServiceImpl extends BaseJpaServiceImpl<GroupEventPassCategory, String> implements GroupEventPassCategoryService{

	@Autowired
	private GroupEventPassCategoryRepository groupEventPassCategoryRepository;
	
	@PostConstruct
	public void setupService() {
		this.baseJpaRepository = groupEventPassCategoryRepository;
		this.entityClass = GroupEventPassCategory.class;
		this.baseJpaRepository.setupEntityClass(GroupEventPassCategory.class);

	}

	public List<GroupEventPassCategory> findByGroupCodeAndGroupEventCode(
			String groupCode, String groupEventCode,
			boolean includeNotAvailableForPurchase) {

		return groupEventPassCategoryRepository.findByGroupCodeAndGroupEventCode(groupCode, groupEventCode, includeNotAvailableForPurchase);
	}

	public List<GroupEventPassCategory> findByGroupCodeAndGroupEventCodeForMemberType(
			String groupCode, String groupEventCode,
			boolean includeInactive, boolean availableForPurchase, String[] isMember) {

		return groupEventPassCategoryRepository.findByGroupCodeAndGroupEventCodeForMemberType(groupCode, groupEventCode, includeInactive, availableForPurchase,  isMember);
	}
	
}
