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
import com.mrd.yourwebproject.model.entity.GroupAddress;
import com.mrd.yourwebproject.model.repository.GroupAddressRepository;
import com.mrd.yourwebproject.service.GroupAddressService;

/**
 * @author mevan.d.souza
 *
 */
@Service
@Transactional
public class GroupAddressServiceImpl extends BaseJpaServiceImpl<GroupAddress, String> implements GroupAddressService {
	private @Autowired GroupAddressRepository groupAddressRepository;

	@PostConstruct
	public void setupService() {
		this.baseJpaRepository = groupAddressRepository;
		this.entityClass = GroupAddress.class;
		this.baseJpaRepository.setupEntityClass(GroupAddress.class);
	}

	public List<GroupAddress> findByGroupClient(String clientId) {
		return groupAddressRepository.findByGroupClient(clientId);
	}

}
