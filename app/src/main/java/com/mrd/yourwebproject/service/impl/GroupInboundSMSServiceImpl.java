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
import com.mrd.yourwebproject.model.entity.GroupInboundSMS;
import com.mrd.yourwebproject.model.entity.GroupSMS;
import com.mrd.yourwebproject.model.repository.GroupInboundSMSRepository;
import com.mrd.yourwebproject.model.repository.GroupSMSRepository;
import com.mrd.yourwebproject.service.GroupInboundSMSService;
import com.mrd.yourwebproject.service.GroupSMSService;

/**
 * @author mevan.d.souza
 *
 */
@Service
@Transactional
public class GroupInboundSMSServiceImpl extends BaseJpaServiceImpl<GroupInboundSMS, String>
		implements GroupInboundSMSService {
	private @Autowired GroupInboundSMSRepository groupInboundSMSRepository;

	@PostConstruct
	public void setupService() {
		this.baseJpaRepository = groupInboundSMSRepository;
		this.entityClass = GroupInboundSMS.class;
		this.baseJpaRepository.setupEntityClass(GroupInboundSMS.class);
	}

	public List<GroupInboundSMS> findByGroupCode(String groupCode) {
		return groupInboundSMSRepository.findByGroupCode(groupCode);
	}

	public  List<GroupInboundSMS> findByMessageId(String messageId) {
		return groupInboundSMSRepository.findByMessageId(messageId);
	}

	
}
