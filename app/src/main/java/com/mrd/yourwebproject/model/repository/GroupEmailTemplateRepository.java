/**
 * 
 */
package com.mrd.yourwebproject.model.repository;

import java.util.List;

import com.mrd.framework.data.BaseJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupEmailTemplate;

/**
 * @author mevan.d.souza
 *
 */
public interface GroupEmailTemplateRepository extends BaseJpaRepository<GroupEmailTemplate	,Long> {

	public GroupEmailTemplate findbyTemplateName(String templateName);
	public List<GroupEmailTemplate> findbyGroupCode(String groupCode);
	public List<GroupEmailTemplate> findbyGroupCodeAndGroupEventCode(String groupCode, String groupEventCode);
	
}
