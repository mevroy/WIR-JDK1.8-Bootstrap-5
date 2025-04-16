/**
 * 
 */
package com.mrd.yourwebproject.service;

import java.util.List;

import com.mrd.framework.data.BaseService;
import com.mrd.yourwebproject.model.entity.AuditLog;
import com.mrd.yourwebproject.model.entity.User;

/**
 * @author mevan.d.souza
 *
 */
public interface LoggerService extends BaseService<AuditLog, Long> {

	public List<AuditLog> findByGroupCode(String groupCode);
	public List<AuditLog> findByUser(User user, String groupCode);
	public List<AuditLog> findByGroupCodeAndRequestURIAndMethod(String groupCode, String requestURI, String method);
}
