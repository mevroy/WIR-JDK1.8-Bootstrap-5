/**
 * 
 */
package com.mrd.yourwebproject.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrd.framework.data.BaseJpaServiceImpl;
import com.mrd.yourwebproject.model.entity.ExternalScanner;
import com.mrd.yourwebproject.model.repository.ExternalScannerRepository;
import com.mrd.yourwebproject.service.ExternalScannerService;

/**
 * @author mevan.d.souza
 *
 */
@Service
@Transactional
public class ExternalScannerServiceImpl extends BaseJpaServiceImpl<ExternalScanner, Long>
		implements ExternalScannerService {

	private @Autowired ExternalScannerRepository externalScannerRepository;

	@PostConstruct
	public void setupService() {
		this.baseJpaRepository = externalScannerRepository;
		this.entityClass = ExternalScanner.class;
		this.baseJpaRepository.setupEntityClass(ExternalScanner.class);

	}

	public ExternalScanner findBydeviceUuid(String groupCode, String deviceUuid) {
		return externalScannerRepository.findBydeviceUuid(groupCode, deviceUuid);
	}

	public List<ExternalScanner> findByGroupCode(String groupCode) {
		return externalScannerRepository.findByGroupCode(groupCode);
	}


}
