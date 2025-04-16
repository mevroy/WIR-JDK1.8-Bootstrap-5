/**
 * 
 */
package com.mrd.yourwebproject.service;

import java.util.List;

import com.mrd.framework.data.BaseService;
import com.mrd.yourwebproject.model.entity.ExternalScanner;
import com.mrd.yourwebproject.model.entity.Feedback;
import com.mrd.yourwebproject.model.entity.GroupEventInvite;
import com.mrd.yourwebproject.model.entity.GroupMember;

/**
 * @author mevan.d.souza
 *
 */
public interface ExternalScannerService extends BaseService<ExternalScanner, Long> {

	public ExternalScanner findBydeviceUuid(String groupCode, String deviceUuid);
	public List<ExternalScanner> findByGroupCode(String groupCode);
}
