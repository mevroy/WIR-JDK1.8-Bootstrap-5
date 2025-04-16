/**
 * 
 */
package com.mrd.yourwebproject.model.repository;

import java.util.List;

import com.mrd.framework.data.BaseJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupMainLink;
import com.mrd.yourwebproject.model.entity.GroupSubLink;


/**
 * @author mevan.d.souza
 *
 */
public interface GroupSubLinksRepository extends BaseJpaRepository<GroupSubLink, String> {

	public List<GroupSubLink> findByGroupMainLink(GroupMainLink groupMainLink, boolean includeDisabled);
	public List<GroupSubLink> findByURL(String url, boolean includeDisabled);
	
}
