/**
 * 
 */
package com.mrd.yourwebproject.model.repository;

import java.util.List;

import com.mrd.framework.data.BaseJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupCronJob;

/**
 * @author mevan.d.souza
 *
 */
public interface GroupCronJobRepository extends BaseJpaRepository<GroupCronJob, Long> {

	public List<GroupCronJob> findGroupCronJobsByGroupCode(String groupCode);
	public List<GroupCronJob> findGroupCronJobs();
	public GroupCronJob findByJobCode(String jobCode);
}
