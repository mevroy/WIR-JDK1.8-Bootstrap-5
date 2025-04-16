/**
 * 
 */
package com.mrd.yourwebproject.service;

import java.util.List;

import com.mrd.framework.data.BaseService;
import com.mrd.yourwebproject.model.entity.GroupClient;

/**
 * @author mevan.d.souza
 *
 */
public interface GroupClientService extends BaseService<GroupClient, String> {

	public List<GroupClient> findByGroupCode(String groupCode);
}
