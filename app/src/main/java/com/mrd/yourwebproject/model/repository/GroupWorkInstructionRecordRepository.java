/**
 * 
 */
package com.mrd.yourwebproject.model.repository;

import java.util.List;

import com.mrd.framework.data.BaseJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupWorkInstructionRecord;
import com.mrd.yourwebproject.model.entity.User;

/**
 * @author mevan.d.souza
 *
 */
public interface GroupWorkInstructionRecordRepository extends BaseJpaRepository<GroupWorkInstructionRecord, Long> {

	public List<GroupWorkInstructionRecord> findByGroupCodeAndUser(String groupCode, User user);
	public List<GroupWorkInstructionRecord> findByGroupCode(String groupCode);
	
}
