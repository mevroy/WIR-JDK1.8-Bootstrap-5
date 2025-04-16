/**
 * 
 */
package com.mrd.yourwebproject.model.repository;

import java.util.List;

import com.mrd.framework.data.BaseJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupSMSTemplate;

/**
 * @author mevan.d.souza
 *
 */
public interface GroupSMSTemplateRepository extends BaseJpaRepository<GroupSMSTemplate	,Long> {

	public GroupSMSTemplate findbyTemplateName(String templateName);
	public List<GroupSMSTemplate> findbyGroupCode(String groupCode);
	public List<GroupSMSTemplate> findbyGroupCodeAndGroupEventCode(String groupCode, String groupEventCode);
	
}
