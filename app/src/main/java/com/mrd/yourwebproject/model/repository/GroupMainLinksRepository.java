/**
 * 
 */
package com.mrd.yourwebproject.model.repository;

import java.util.List;

import com.mrd.framework.data.BaseJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupMainLink;
import com.mrd.yourwebproject.model.entity.User;
import com.mrd.yourwebproject.model.entity.enums.Role;

/**
 * @author mevan.d.souza
 *
 */
public interface GroupMainLinksRepository extends BaseJpaRepository<GroupMainLink, Long> {

	public List<GroupMainLink> findByGroupCodeAndUser(String groupCode, User user, boolean enableFilter);
	public List<GroupMainLink> findByGroupCodeAndRoles(String groupCode, List<Role> roles);
	public List<GroupMainLink> findAll(boolean includeDisabled);
	
}
