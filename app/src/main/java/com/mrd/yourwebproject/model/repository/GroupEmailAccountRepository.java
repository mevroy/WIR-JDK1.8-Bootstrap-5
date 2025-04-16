/**
 * 
 */
package com.mrd.yourwebproject.model.repository;

import java.util.List;

import com.mrd.framework.data.BaseJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupEmailAccount;

/**
 * @author mevan.d.souza
 *
 */
public interface GroupEmailAccountRepository extends BaseJpaRepository<GroupEmailAccount, Long> {

	public GroupEmailAccount findByEmailAccountCode(String emailAccountCode);
	public List<GroupEmailAccount> findByGroupCode(String groupCode);
}
