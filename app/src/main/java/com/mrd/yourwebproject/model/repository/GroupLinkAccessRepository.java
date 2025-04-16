/**
 * 
 */
package com.mrd.yourwebproject.model.repository;

import java.util.List;

import com.mrd.framework.data.BaseJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupLinkAccess;
import com.mrd.yourwebproject.model.entity.GroupMainLink;
import com.mrd.yourwebproject.model.entity.GroupSubLink;
import com.mrd.yourwebproject.model.entity.Groups;
import com.mrd.yourwebproject.model.entity.enums.Role;

/**
 * @author mevan.d.souza
 *
 */
public interface GroupLinkAccessRepository extends BaseJpaRepository<GroupLinkAccess, Long> {

	public List<GroupLinkAccess> findByGroupSubLinkAndGroupAndRole(GroupSubLink groupSubLink, Groups group,
			boolean includeExpired, Role role);
	
	public List<GroupLinkAccess> findByLinkURLAndGroupAndRole(String url, Groups group,
			boolean includeExpired, Role role);
	
	public List<GroupLinkAccess> findByGroupMainLinkAndGroupAndRole(GroupMainLink groupMainLink, Groups group,
			boolean includeExpired, Role role);
	
	public List<GroupLinkAccess> findByGroupSubLinkAndGroup(GroupSubLink groupSubLink, Groups group,
			boolean includeExpired);
}
