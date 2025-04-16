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
import com.mrd.yourwebproject.model.entity.Feedback;
import com.mrd.yourwebproject.model.entity.GroupEventInvite;
import com.mrd.yourwebproject.model.entity.GroupMainLink;
import com.mrd.yourwebproject.model.entity.GroupMember;
import com.mrd.yourwebproject.model.entity.GroupSubLink;
import com.mrd.yourwebproject.model.entity.User;
import com.mrd.yourwebproject.model.entity.enums.Role;
import com.mrd.yourwebproject.model.repository.FeedbackRepository;
import com.mrd.yourwebproject.model.repository.GroupMainLinksRepository;
import com.mrd.yourwebproject.model.repository.GroupSubLinksRepository;
import com.mrd.yourwebproject.service.FeedbackService;
import com.mrd.yourwebproject.service.GroupMainLinksService;
import com.mrd.yourwebproject.service.GroupSubLinksService;

/**
 * @author mevan.d.souza
 *
 */
@Service
@Transactional
public class GroupSubLinksServiceImpl extends BaseJpaServiceImpl<GroupSubLink, String>
		implements GroupSubLinksService {

	private @Autowired GroupSubLinksRepository groupSubLinksRepository;

	@PostConstruct
	public void setupService() {
		this.baseJpaRepository = groupSubLinksRepository;
		this.entityClass = GroupSubLink.class;
		this.baseJpaRepository.setupEntityClass(GroupSubLink.class);

	}

	public List<GroupSubLink> findByGroupMainLink(GroupMainLink groupMainLink,
			boolean includeDisabled) {

		return groupSubLinksRepository.findByGroupMainLink(groupMainLink, includeDisabled);
	}





}
