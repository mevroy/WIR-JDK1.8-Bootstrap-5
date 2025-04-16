/**
 * 
 */
package com.mrd.yourwebproject.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import com.mrd.framework.data.BaseService;
import com.mrd.yourwebproject.model.entity.GroupWorkInstructionRecord;
import com.mrd.yourwebproject.model.entity.User;

/**
 * @author dsouzam5
 *
 */
public interface GroupWorkInstructionRecordService extends BaseService<GroupWorkInstructionRecord, Long>{

	public List<GroupWorkInstructionRecord> findByGroupCodeAndUser(String groupCode, User user);
	public List<GroupWorkInstructionRecord> findByGroupCode(String groupCode);
	public ByteArrayOutputStream prefillPDF(GroupWorkInstructionRecord groupWorkInstructionRecord) throws IOException;
	public ByteArrayOutputStream prefillPDFTest(GroupWorkInstructionRecord groupWorkInstructionRecord) throws IOException;

}
