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
import com.mrd.yourwebproject.model.entity.GroupMemberCategory;
import com.mrd.yourwebproject.model.repository.GroupMemberCategoryRepository;
import com.mrd.yourwebproject.service.GroupMemberCategoryService;

/**
 * @author mevan.d.souza
 *
 */
@Service
@Transactional
public class GroupMemberCategoryServiceImpl extends
		BaseJpaServiceImpl<GroupMemberCategory, Long> implements
		GroupMemberCategoryService {

	private @Autowired GroupMemberCategoryRepository groupMemberCategoryRespository;

	@PostConstruct
	public void setupService() {
		this.baseJpaRepository = groupMemberCategoryRespository;
		this.entityClass = GroupMemberCategory.class;
		this.baseJpaRepository.setupEntityClass(GroupMemberCategory.class);

	}

	public List<GroupMemberCategory> findByGroupCode(String groupCode) {

		return groupMemberCategoryRespository.findByGroupCode(groupCode);
	}

	public GroupMemberCategory findByMemberCategoryCode(
			String memberCategoryCode) {

		return groupMemberCategoryRespository.findByMemberCategoryCode(memberCategoryCode);
	}

}
