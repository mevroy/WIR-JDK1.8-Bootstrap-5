/**
 * 
 */
package com.mrd.yourwebproject.model.repository;

import java.util.List;

import com.mrd.framework.data.BaseJpaRepository;
import com.mrd.yourwebproject.model.entity.ExternalScanner;


/**
 * @author mevan.d.souza
 *
 */
public interface ExternalScannerRepository extends BaseJpaRepository<ExternalScanner, Long> {

	public ExternalScanner findBydeviceUuid(String groupCode, String deviceUuid);
	public List<ExternalScanner> findByGroupCode(String groupCode);
}
