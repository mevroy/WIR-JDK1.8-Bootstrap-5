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
import com.mrd.yourwebproject.model.entity.GroupCronJob;
import com.mrd.yourwebproject.model.repository.GroupCronJobRepository;
import com.mrd.yourwebproject.service.GroupCronJobService;

/**
 * @author mevan.d.souza
 *
 */
@Service
@Transactional
public class GroupCronJobServiceImpl extends
		BaseJpaServiceImpl<GroupCronJob, Long> implements GroupCronJobService {

	private @Autowired GroupCronJobRepository groupCronJobRepository;

	@PostConstruct
	public void setupService() {
		this.baseJpaRepository = groupCronJobRepository;
		this.entityClass = GroupCronJob.class;
		this.baseJpaRepository.setupEntityClass(GroupCronJob.class);

	}

	public List<GroupCronJob> findGroupCronJobsByGroupCode(String groupCode) {
		return groupCronJobRepository.findGroupCronJobsByGroupCode(groupCode);
	}

	public List<GroupCronJob> findGroupCronJobs() {

		return groupCronJobRepository.findGroupCronJobs();
	}

	public GroupCronJob findByJobCode(String jobCode) {
		return groupCronJobRepository.findByJobCode(jobCode);
	}

}
