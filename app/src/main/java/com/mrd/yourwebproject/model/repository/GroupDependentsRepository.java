/**
 * 
 */
package com.mrd.yourwebproject.model.repository;

import java.util.List;

import com.mrd.framework.data.BaseJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupDependents;
import com.mrd.yourwebproject.model.entity.GroupMember;

/**
 * @author mevan.d.souza
 *
 */
public interface GroupDependentsRepository extends BaseJpaRepository<GroupDependents, String> {

	public List<GroupDependents> findByGroupMember(GroupMember groupMember);
	public List<GroupDependents> findByGroupMemberSerialNumber(String serialNumber);
}
