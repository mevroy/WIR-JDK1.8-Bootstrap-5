/**
 * 
 */
package com.mrd.yourwebproject.service;

import java.util.List;

import com.mrd.framework.data.BaseService;
import com.mrd.yourwebproject.model.entity.GroupEmail;
import com.mrd.yourwebproject.model.entity.GroupEmailActivity;

/**
 * @author mevan.d.souza
 *
 */
public interface GroupEmailActivityService extends BaseService<GroupEmailActivity, Long> {

	public List<GroupEmailActivity> findEmailActivitiesByEmailId(String groupEmailId);

}
