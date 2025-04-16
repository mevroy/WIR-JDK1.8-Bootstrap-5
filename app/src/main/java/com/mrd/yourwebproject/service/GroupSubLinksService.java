/**
 * 
 */
package com.mrd.yourwebproject.service;

import java.util.List;

import com.mrd.framework.data.BaseService;
import com.mrd.yourwebproject.model.entity.GroupMainLink;
import com.mrd.yourwebproject.model.entity.GroupSubLink;

/**
 * @author mevan.d.souza
 *
 */
public interface GroupSubLinksService extends BaseService<GroupSubLink, String> {

	public List<GroupSubLink> findByGroupMainLink(GroupMainLink groupMainLink,
			boolean includeDisabled);
}
