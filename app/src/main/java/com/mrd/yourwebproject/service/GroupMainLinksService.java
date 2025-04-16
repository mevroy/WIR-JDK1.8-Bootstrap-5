/**
 * 
 */
package com.mrd.yourwebproject.service;

import java.util.List;

import com.mrd.framework.data.BaseService;
import com.mrd.yourwebproject.model.entity.Feedback;
import com.mrd.yourwebproject.model.entity.GroupEventInvite;
import com.mrd.yourwebproject.model.entity.GroupMainLink;
import com.mrd.yourwebproject.model.entity.GroupMember;
import com.mrd.yourwebproject.model.entity.Groups;
import com.mrd.yourwebproject.model.entity.User;
import com.mrd.yourwebproject.model.entity.enums.Role;

/**
 * @author mevan.d.souza
 *
 */
public interface GroupMainLinksService extends BaseService<GroupMainLink, Long> {

	public List<GroupMainLink> findByGroupCodeAndUser(String groupCode, User user, boolean enableFilter);
	public List<GroupMainLink> findByGroupCodeAndRoles(String groupCode, List<Role> roles);
	public List<GroupMainLink> findAll(boolean includeDisabled);
	public List<GroupMainLink> populateNavigationLinksObject(
			List<GroupMainLink> groupMainLinks, Groups group, boolean includeExpired, boolean includeDisabled, Role role);
	public List<GroupMainLink> populateNavigationLinksObject(
			Groups group, boolean includeExpired, boolean includeDisabled, Role role);
}
