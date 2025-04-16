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
import com.mrd.yourwebproject.model.entity.GroupEmail;
import com.mrd.yourwebproject.model.entity.GroupEmailActivity;
import com.mrd.yourwebproject.model.repository.GroupEmailActivityRepository;
import com.mrd.yourwebproject.model.repository.GroupEmailsRepository;
import com.mrd.yourwebproject.service.GroupEmailActivityService;
import com.mrd.yourwebproject.service.GroupEmailsService;

/**
 * @author mevan.d.souza
 *
 */
@Service
@Transactional
public class GroupEmailActivityServiceImpl extends BaseJpaServiceImpl<GroupEmailActivity, Long> implements GroupEmailActivityService {

	private @Autowired GroupEmailActivityRepository groupEmailActivityRepository;

	@PostConstruct
	public void setupService() {
		this.baseJpaRepository = groupEmailActivityRepository;
		this.entityClass = GroupEmailActivity.class;
		this.baseJpaRepository.setupEntityClass(GroupEmailActivity.class);
		
	}

	public List<GroupEmailActivity> findEmailActivitiesByEmailId(
			String groupEmailId) {
		
		return groupEmailActivityRepository.findEmailActivitiesByEmailId(groupEmailId);
	}



}
