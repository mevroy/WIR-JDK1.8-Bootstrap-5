/**
 * 
 */
package com.mrd.yourwebproject.service;

import java.util.List;

import com.mrd.framework.data.BaseService;
import com.mrd.yourwebproject.model.entity.GroupEmailAccount;

/**
 * @author mevan.d.souza
 *
 */
public interface GroupEmailAccountService extends BaseService<GroupEmailAccount, Long> {

	public GroupEmailAccount findByEmailAccountCode(String emailAccountCode);
	public List<GroupEmailAccount> findByGroupCode(String groupCode);

}
