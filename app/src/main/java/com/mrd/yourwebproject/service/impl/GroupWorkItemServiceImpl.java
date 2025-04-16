/**
 * 
 */
package com.mrd.yourwebproject.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrd.framework.data.BaseJpaServiceImpl;
import com.mrd.yourwebproject.common.Props;
import com.mrd.yourwebproject.model.entity.GroupWorkItems;
import com.mrd.yourwebproject.model.repository.GroupWorkItemRepository;
import com.mrd.yourwebproject.service.GroupWorkItemService;

/**
 * @author dsouzam5
 *
 */
@Service
@Transactional
public class GroupWorkItemServiceImpl extends BaseJpaServiceImpl<GroupWorkItems, Long>
		implements GroupWorkItemService {

	private @Autowired GroupWorkItemRepository groupWorkItemRepository;
	protected @Autowired Props props;

	@PostConstruct
	public void setupService() {
		this.baseJpaRepository = groupWorkItemRepository;
		this.entityClass = GroupWorkItems.class;
		this.baseJpaRepository.setupEntityClass(GroupWorkItems.class);
	}


}
