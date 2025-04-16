/**
 * 
 */
package com.mrd.yourwebproject.service;

import java.util.List;

import com.mrd.framework.data.BaseService;
import com.mrd.yourwebproject.model.entity.Groups;

/**
 * @author mevan.d.souza
 *
 */
public interface GroupsService extends BaseService<Groups, Long> {

	public Groups findByGroupCode(String groupCode);
	public Groups findByGroupCodeActive(String groupCode);
	public List<Groups> findGroups();
}
