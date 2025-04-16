/**
 * 
 */
package com.mrd.yourwebproject.model.repository;

import java.util.List;

import com.mrd.framework.data.BaseJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupEmailActivity;

/**
 * @author mevan.d.souza
 *
 */
public interface GroupEmailActivityRepository extends BaseJpaRepository<GroupEmailActivity, Long> {

	public List<GroupEmailActivity> findEmailActivitiesByEmailId(String groupEmailId);

}
