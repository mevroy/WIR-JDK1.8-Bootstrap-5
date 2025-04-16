/**
 * 
 */
package com.mrd.yourwebproject.service;

import java.util.List;

import com.mrd.framework.data.BaseService;
import com.mrd.yourwebproject.model.entity.GroupContent;


/**
 * @author mevan.d.souza
 *
 */
public interface GroupContentService extends BaseService<GroupContent, String> {

	public List<GroupContent> findByGroupCode(String groupCode, boolean includeExpired);
}
