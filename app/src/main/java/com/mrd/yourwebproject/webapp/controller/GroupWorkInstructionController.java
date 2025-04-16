/**
 * 
 */
package com.mrd.yourwebproject.webapp.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrd.commons.util.CommonUtils;
import com.mrd.yourwebproject.common.CheckPermission;
import com.mrd.yourwebproject.common.EnableLogging;
import com.mrd.yourwebproject.model.entity.GroupAddress;
import com.mrd.yourwebproject.model.entity.GroupClient;
import com.mrd.yourwebproject.model.entity.GroupClientContact;
import com.mrd.yourwebproject.model.entity.GroupDependents;
import com.mrd.yourwebproject.model.entity.GroupMember;
import com.mrd.yourwebproject.model.entity.GroupWorkInstructionRecord;
import com.mrd.yourwebproject.model.entity.GroupWorkItems;
import com.mrd.yourwebproject.model.entity.Groups;
import com.mrd.yourwebproject.model.entity.embedded.Address;
import com.mrd.yourwebproject.model.entity.enums.Role;
import com.mrd.yourwebproject.service.GroupAddressService;
import com.mrd.yourwebproject.service.GroupClientContactService;
import com.mrd.yourwebproject.service.GroupClientService;
import com.mrd.yourwebproject.service.GroupReferenceDataService;
import com.mrd.yourwebproject.service.GroupWorkInstructionRecordService;
import com.mrd.yourwebproject.service.GroupWorkItemService;
import com.mrd.yourwebproject.service.GroupsService;

/**
 * @author mdsouza
 *
 */
@Controller
@EnableLogging(loggerClass = "GroupWorkInstructionController")
@CheckPermission(allowedRoles = { Role.SUPER_ADMIN, Role.ADMIN, Role.SUPER_USER, Role.USER })
public class GroupWorkInstructionController extends BaseWebAppController {
	/*
	 * @Autowired private GroupEventInviteService groupEventInviteService;
	 */
	private @Autowired GroupsService groupsService;
	private @Autowired GroupWorkInstructionRecordService groupWorkInstructionRecordService;
	private @Autowired GroupWorkItemService groupWorkItemService;
	private @Autowired GroupReferenceDataService groupReferenceDataService;
	private @Autowired GroupClientService groupClientService;
	private @Autowired GroupClientContactService groupClientContactService;
	private @Autowired GroupAddressService groupAddressService;
	private static final String JOB_REF = "JOB_CODE_";
	private static final String QUOTE_REF = "QUOTE_CODE_";
	private static final String ORDER_REF = "ORDER_CODE_";

	private Logger log = LoggerFactory.getLogger(GroupWorkInstructionController.class);

	@RequestMapping(value = "/groupInstructionRecord", method = RequestMethod.GET)
	public String groupInstructionRecord(Model model, @PathVariable String groupCode,
			@RequestParam(required = false) String girId) throws Exception {

		GroupWorkInstructionRecord groupWorkInstructionRecord = new GroupWorkInstructionRecord();
		if (StringUtils.isNotEmpty(girId)) {
			try {
				groupWorkInstructionRecord = groupWorkInstructionRecordService.findById(Long.valueOf(girId));
			} catch (Exception e) {

			}
		} else {
			groupWorkInstructionRecord = new GroupWorkInstructionRecord();
			Groups group = groupsService.findByGroupCode(groupCode);
			groupWorkInstructionRecord.setGroup(group);

		}
		model.addAttribute("groupWorkInstructionRecord", groupWorkInstructionRecord);
		return "groupWorkInstructionRecord";
	}

	@RequestMapping(value = "/viewGroupWorkInstructionRecords", method = RequestMethod.GET)
	public String viewGroupWorkInstructionRecords(Model model, @PathVariable String groupCode) throws Exception {
		model.addAttribute("groupWorkInstructionRecord", new GroupWorkInstructionRecord());
		return "viewGroupWorkInstructionRecords";
	}

	@RequestMapping(value = "/json/viewGroupWorkInstructionRecords", method = RequestMethod.GET)
	public @ResponseBody List<GroupWorkInstructionRecord> viewGroupWorkInstructionRecords(Locale locale, Model model,
			@PathVariable String groupCode) {
		List<GroupWorkInstructionRecord> gwir = new ArrayList<GroupWorkInstructionRecord>();
		gwir = groupWorkInstructionRecordService.findByGroupCode(groupCode);
		return gwir;
	}

	@RequestMapping(value = "/json/viewGroupClients", method = RequestMethod.GET)
	public @ResponseBody List<GroupClient> viewGroupClients(Locale locale, Model model,
			@PathVariable String groupCode) {
		List<GroupClient> gc = new ArrayList<GroupClient>();
		gc = groupClientService.findByGroupCode(groupCode);
		return gc;
	}
	@RequestMapping(value = "/groupClient", method = RequestMethod.POST)
	public String addGroupClients(Model model, Locale locale,
			@ModelAttribute("groupClient") GroupClient groupClient, @PathVariable String groupCode) {
		try {
			GroupClient gc = new GroupClient();
			if (StringUtils.isNotEmpty(groupClient.getClientId())) {
				gc = groupClientService.findById(groupClient.getClientId());
				gc.setClientABN(groupClient.getClientABN());
				gc.setClientName(groupClient.getClientName());
				gc.setComments(groupClient.getComments());
				gc.setEmail(groupClient.getEmail());
				gc.setFax(groupClient.getFax());
				gc.setPhone(groupClient.getPhone());
				gc.setUpdatedAt(Calendar.getInstance().getTime());
				gc.setUpdatedBy(this.getloggedInUser() != null ? this.getloggedInUser().getUserName() : "");
			} else {
				gc = groupClient;
				gc.setGroup(groupsService.findByGroupCode(groupCode));
				gc.setCreatedBy(this.getloggedInUser() != null ? this.getloggedInUser().getUserName() : "");
				gc.setClientId(null);

			}
			groupClient = groupClientService.insertOrUpdate(gc);
		} catch (Exception e) {
			e.printStackTrace();
			return "Error occured: "+e.getLocalizedMessage();

		}
		return this.loadClientData(locale, model, groupCode, groupClient.getClientId());
	}

	
	@RequestMapping(value = "/json/groupClient", method = RequestMethod.POST)
	public @ResponseBody String addUpdateGroupClients(Model model, Locale locale,
			@ModelAttribute("groupClient") GroupClient groupClient, @PathVariable String groupCode) {
		try {
			GroupClient gc = new GroupClient();
			if (StringUtils.isNotEmpty(groupClient.getClientId())) {
				gc = groupClientService.findById(groupClient.getClientId());
				gc.setClientABN(groupClient.getClientABN());
				gc.setClientName(groupClient.getClientName());
				gc.setComments(groupClient.getComments());
				gc.setEmail(groupClient.getEmail());
				gc.setFax(groupClient.getFax());
				gc.setPhone(groupClient.getPhone());
				gc.setUpdatedAt(Calendar.getInstance().getTime());
				gc.setUpdatedBy(this.getloggedInUser() != null ? this.getloggedInUser().getUserName() : "");
			} else {
				gc = groupClient;
				gc.setGroup(groupsService.findByGroupCode(groupCode));
				gc.setCreatedBy(this.getloggedInUser() != null ? this.getloggedInUser().getUserName() : "");
				gc.setClientId(null);

			}
			groupClientService.insertOrUpdate(gc);
		} catch (Exception e) {
			e.printStackTrace();
			return "Error occured: "+e.getLocalizedMessage();

		}
		return "success";
	}

	@RequestMapping(value = "/json/viewGroupClientContacts", method = RequestMethod.GET)
	public @ResponseBody List<GroupClientContact> viewGroupClientContacts(Locale locale, Model model,
			@RequestParam String clientId) {
		List<GroupClientContact> gc = new ArrayList<GroupClientContact>();
		gc = groupClientContactService.findByGroupClient(clientId);
		return gc;
	}

	@RequestMapping(value = "/json/groupClientContact", method = RequestMethod.POST)
	public @ResponseBody String addUpdateGroupClientContact(Model model, Locale locale,
			@ModelAttribute("groupClientContact") GroupClientContact groupClientContact,
			@ModelAttribute("groupClient") GroupClient groupClient, @RequestParam(required = true) String clientId,
			@PathVariable String groupCode) {

		if (groupClient != null && groupClient.getGroupClientContact() != null && groupClient.getGroupClientContact().size()>0) {
			for (GroupClientContact gcc : groupClient.getGroupClientContact()) {
				if (gcc != null && StringUtils.isNotBlank(gcc.getClientContactId())) {
					try {
						GroupClientContact gc = groupClientContactService
								.findById(gcc.getClientContactId());

						gc.setEmail(gcc.getEmail());
						gc.setFax(gcc.getFax());
						gc.setFirstName(gcc.getFirstName());
						gc.setLastName(gcc.getLastName());
						gc.setMobilephone(gcc.getMobilephone());
						gc.setOtherPhone(gcc.getOtherPhone());
						gc.setUpdatedAt(Calendar.getInstance().getTime());
						gc.setUpdatedBy(this.getloggedInUser() != null ? this.getloggedInUser().getUserName() : "");
						groupClientContactService.insertOrUpdate(gc);

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return "Error occured: "+e.getLocalizedMessage();

					}
				}
			}

		} else {
			try {
				GroupClientContact gcc = new GroupClientContact();

				if (StringUtils.isNotEmpty(groupClientContact.getClientContactId())) {
					gcc = groupClientContactService.findById(groupClientContact.getClientContactId());
					gcc.setEmail(groupClientContact.getEmail());
					gcc.setFax(groupClientContact.getFax());
					gcc.setFirstName(groupClientContact.getFirstName());
					gcc.setLastName(groupClientContact.getLastName());
					gcc.setMobilephone(groupClientContact.getMobilephone());
					gcc.setOtherPhone(groupClientContact.getOtherPhone());
					gcc.setUpdatedAt(Calendar.getInstance().getTime());
					gcc.setUpdatedBy(this.getloggedInUser() != null ? this.getloggedInUser().getUserName() : "");
				} else {
					gcc = groupClientContact;
					gcc.setClientId(clientId);
					gcc.setGroup(groupsService.findByGroupCode(groupCode));
					gcc.setCreatedBy(this.getloggedInUser() != null ? this.getloggedInUser().getUserName() : "");
					gcc.setClientContactId(null);

				}

				groupClientContactService.insertOrUpdate(gcc);
			} catch (Exception e) {
				e.printStackTrace();
				return "Error occured: "+e.getLocalizedMessage();

			}
		}
		return "success";
	}

	@RequestMapping(value = "/json/viewGroupAddress", method = RequestMethod.GET)
	public @ResponseBody List<GroupAddress> viewGroupAddress(Locale locale, Model model,
			@RequestParam String clientId) {
		List<GroupAddress> gc = new ArrayList<GroupAddress>();
		gc = groupAddressService.findByGroupClient(clientId);
		return gc;
	}

	@RequestMapping(value = "/json/groupAddress", method = RequestMethod.POST)
	public @ResponseBody String addUpdateGroupAddress(Model model, Locale locale,
			@ModelAttribute("groupAddress") GroupAddress groupAddress, @ModelAttribute("groupClient") GroupClient groupClient, @RequestParam(required = true) String clientId,
			@PathVariable String groupCode) {
		
		if (groupClient != null && groupClient.getGroupAddress() != null && groupClient.getGroupAddress().size()>0) {
			for (GroupAddress gaa : groupClient.getGroupAddress()) {
				if (gaa != null && StringUtils.isNotBlank(gaa.getAddressId())) {
					try {
						GroupAddress ga = groupAddressService
								.findById(gaa.getAddressId());

						ga.setAddressType(gaa.getAddressType());
						ga.setCountry(gaa.getCountry());
						ga.setPoBox(gaa.getPoBox());
						ga.setState(gaa.getState());
						ga.setStreetAddress(gaa.getStreetAddress());
						ga.setSuburb(gaa.getSuburb());
						ga.setZipCode(gaa.getZipCode());
						ga.setUpdatedAt(Calendar.getInstance().getTime());
						ga.setUpdatedBy(this.getloggedInUser() != null ? this.getloggedInUser().getUserName() : "");
						groupAddressService.insertOrUpdate(ga);

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return "Error occured: "+e.getLocalizedMessage();

					}
				}
			}

		}
		
		else {
		try {
			GroupAddress ga = new GroupAddress();

			if (StringUtils.isNotEmpty(groupAddress.getAddressId())) {
				ga = groupAddressService.findById(groupAddress.getAddressId());
				ga.setAddressType(groupAddress.getAddressType());
				ga.setCountry(groupAddress.getCountry());
				ga.setPoBox(groupAddress.getPoBox());
				ga.setState(groupAddress.getState());
				ga.setStreetAddress(groupAddress.getStreetAddress());
				ga.setSuburb(groupAddress.getSuburb());
				ga.setZipCode(groupAddress.getZipCode());
				ga.setUpdatedAt(Calendar.getInstance().getTime());
				ga.setUpdatedBy(this.getloggedInUser() != null ? this.getloggedInUser().getUserName() : "");
			} else {
				ga = groupAddress;
				ga.setClientId(clientId);
				;
				ga.setGroup(groupsService.findByGroupCode(groupCode));
				ga.setCreatedBy(this.getloggedInUser() != null ? this.getloggedInUser().getUserName() : "");
				ga.setAddressId(null);

			}
			groupAddressService.insertOrUpdate(ga);
		} catch (Exception e) {
			e.printStackTrace();
			return "Error occured: "+e.getLocalizedMessage();
		}
		}
		return "success";
	}

	@RequestMapping(value = "/json/updateGroupWorkInstructionRecord", method = RequestMethod.POST)
	public @ResponseBody String updateGroupWorkInstructionRecord(Model model, Locale locale,
			@ModelAttribute("groupWorkInstructionRecord") GroupWorkInstructionRecord groupWorkInstructionRecord) {
		try {
			GroupWorkInstructionRecord gwir = groupWorkInstructionRecordService
					.findById(groupWorkInstructionRecord.getId());
			gwir.setClientName(groupWorkInstructionRecord.getClientName());
			gwir.setAdditionalRequirements(groupWorkInstructionRecord.getAdditionalRequirements());
			gwir.setEmail(groupWorkInstructionRecord.getEmail());
			gwir.setEwpAccessEquipment(groupWorkInstructionRecord.isEwpAccessEquipment());
			gwir.setJobEnd(groupWorkInstructionRecord.getJobEnd());
			gwir.setJobStart(groupWorkInstructionRecord.getJobStart());
			gwir.setTravelStart(groupWorkInstructionRecord.getTravelStart());
			gwir.setTravelEnd(groupWorkInstructionRecord.getTravelEnd());
			gwir.setMaterial(groupWorkInstructionRecord.getMaterial());
			gwir.setMobilePhone(groupWorkInstructionRecord.getMobilePhone());
			gwir.setPower(groupWorkInstructionRecord.isPower());
			gwir.setSuitableAccess(groupWorkInstructionRecord.isSuitableAccess());
			gwir.setUpdatedAt(Calendar.getInstance().getTime());
			gwir.setUpdatedBy(this.getloggedInUser() != null ? this.getloggedInUser().getUserName() : "");
			groupWorkInstructionRecordService.update(gwir);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	@RequestMapping(value = "/json/updateGroupWorkItem", method = RequestMethod.POST)
	public @ResponseBody String updateGroupWorkItem(Model model, Locale locale,
			@ModelAttribute("groupWorkItems") GroupWorkItems groupWorkItems) {
		try {
			GroupWorkItems gwi = groupWorkItemService.findById(groupWorkItems.getId());
			gwi.setAcceptanceCriteria(groupWorkItems.getAcceptanceCriteria());
			gwi.setItemProcedure(groupWorkItems.getItemProcedure());
			gwi.setItrDocument(groupWorkItems.getItrDocument());
			gwi.setNataClassTest(groupWorkItems.getNataClassTest());
			gwi.setTestMethod(groupWorkItems.getTestMethod());
			gwi.setTestStandard(groupWorkItems.getTestStandard());
			gwi.setUpdatedAt(Calendar.getInstance().getTime());
			gwi.setUpdatedBy(this.getloggedInUser() != null ? this.getloggedInUser().getUserName() : "");
			groupWorkItemService.update(gwi);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	@RequestMapping(value = "/json/viewGroupWorkItems", method = RequestMethod.GET)
	public @ResponseBody List<GroupWorkItems> viewGroupWorkInstructionRecords(Locale locale, Model model,
			@PathVariable String groupCode, @RequestParam String parentId) {
		List<GroupWorkItems> gwiitems = new ArrayList<GroupWorkItems>();
		GroupWorkInstructionRecord gwir;
		try {
			gwir = groupWorkInstructionRecordService.findById(Long.valueOf(parentId));
			gwiitems.addAll(gwir.getGroupWorkItems());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gwiitems;
	}

	@CheckPermission(allowedRoles = { Role.SUPER_ADMIN, Role.ADMIN, Role.SUPER_USER , Role.USER})
	@RequestMapping(value = { "/addClientData" }, method = RequestMethod.GET)
	public String addClientData(Locale locale, Model model, @PathVariable String groupCode) {
		GroupClient gc = new GroupClient();
		model.addAttribute("groupClient", gc);
		model.addAttribute("groupClientContacts", new GroupClientContact());
		model.addAttribute("groupAddress", new GroupAddress());
		return "addClientData";
	}

	@CheckPermission(allowedRoles = { Role.SUPER_ADMIN, Role.ADMIN, Role.SUPER_USER, Role.USER })
	@RequestMapping(value = { "/loadClientData" }, method = RequestMethod.GET)
	public String loadClientData(Locale locale, Model model, @PathVariable String groupCode,
			@RequestParam(required = false) String clientId) {
		GroupClient gc = new GroupClient();
		if (StringUtils.isNotBlank(clientId)) {
			try {
				gc = groupClientService.findById(clientId);
			} catch (Exception e) {
				gc.setGroup(groupsService.findByGroupCode(groupCode));
				e.printStackTrace();
			}
		}
		model.addAttribute("groupClient", gc);
		model.addAttribute("groupClientContacts", new GroupClientContact());
		model.addAttribute("groupAddress", new GroupAddress());
		return "loadClientData";
	}
	
	@RequestMapping(value = "/saveGroupWorkInstructionRecord", method = RequestMethod.POST)
	public String saveGroupWorkInstructionRecord(Model model, Locale locale,
			@ModelAttribute("groupWorkInstructionRecord") GroupWorkInstructionRecord groupWorkInstructionRecord) {
		try {
			List<GroupWorkItems> gwi = new ArrayList<GroupWorkItems>();
			for (GroupWorkItems gw : groupWorkInstructionRecord.getGroupWorkItems()) {
				if (StringUtils.isNotBlank(gw.getTestMethod())) {
					gwi.add(gw);
				}
			}
			groupWorkInstructionRecord.setJobNumber(groupReferenceDataService
					.retrieveAndLockReferenceData(JOB_REF + String.valueOf(CommonUtils.currentYear()))
					.getReferenceDataString());
/*			groupWorkInstructionRecord.setQuoteNumber(groupReferenceDataService
					.retrieveAndLockReferenceData(QUOTE_REF + String.valueOf(CommonUtils.currentYear()))
					.getReferenceDataString());
			groupWorkInstructionRecord.setOrderNumber(groupReferenceDataService
					.retrieveAndLockReferenceData(ORDER_REF + String.valueOf(CommonUtils.currentYear()))
					.getReferenceDataString());*/
			groupWorkInstructionRecord.setGroupWorkItems(gwi);
			groupWorkInstructionRecord.setClientName(groupClientService.findById(groupWorkInstructionRecord.getGroupClient().getClientId()).getClientName());
			groupWorkInstructionRecord.setCreatedBy(this.getloggedInUser() != null
					? (StringUtils.isNotBlank(this.getloggedInUser().getName()) ? this.getloggedInUser().getName()
							: this.getloggedInUser().getUserName())
					: "");
			groupWorkInstructionRecordService.insert(groupWorkInstructionRecord);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "viewGroupWorkInstructionRecords";
	}

}
