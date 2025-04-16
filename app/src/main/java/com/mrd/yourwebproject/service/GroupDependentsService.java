/**
 * 
 */
package com.mrd.yourwebproject.service;

import java.util.List;

import com.mrd.framework.data.BaseService;
import com.mrd.yourwebproject.model.entity.GroupDependents;
import com.mrd.yourwebproject.model.entity.GroupMember;

/**
 * @author mevan.d.souza
 *
 */
public interface GroupDependentsService extends BaseService<GroupDependents, String> {

	public List<GroupDependents> findByGroupMember(GroupMember groupMember);
	public List<GroupDependents> findByGroupMemberSerialNumber(String serialNumber);

}
