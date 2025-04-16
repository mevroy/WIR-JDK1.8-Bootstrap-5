/**
 * 
 */
package com.mrd.yourwebproject.service;

import java.util.List;

import com.mrd.framework.data.BaseService;
import com.mrd.yourwebproject.model.entity.GroupClientContact;

/**
 * @author mevan.d.souza
 *
 */
public interface GroupClientContactService extends BaseService<GroupClientContact, String> {

	public List<GroupClientContact> findByGroupClient(String clientId);
}
