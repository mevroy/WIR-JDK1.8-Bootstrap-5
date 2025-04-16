/**
 * 
 */
package com.mrd.yourwebproject.model.repository;

import java.util.List;

import com.mrd.framework.data.BaseJpaRepository;
import com.mrd.yourwebproject.model.entity.AuditLog;
import com.mrd.yourwebproject.model.entity.User;

/**
 * @author mevan.d.souza
 *
 */
public interface LoggerRepository extends BaseJpaRepository<AuditLog, Long> {

	public List<AuditLog> findByGroupCode(String groupCode);
	public List<AuditLog> findByUser(User user,String groupCode);
	public List<AuditLog> findByGroupCodeAndRequestURIAndMethod(String groupCode, String requestURI, String method);
	
}
