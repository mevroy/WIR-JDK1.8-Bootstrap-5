package com.mrd.yourwebproject.scheduler.processors;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mrd.commons.util.CommonUtils;
import com.mrd.framework.exception.validation.PhoneNumberValidationException;
import com.mrd.framework.exception.validation.ValidationException;
import com.mrd.yourwebproject.model.entity.GroupEventPaymentTransaction;
import com.mrd.yourwebproject.model.entity.GroupSMS;
import com.mrd.yourwebproject.model.entity.SmsApiResponseEntity;
import com.mrd.yourwebproject.model.entity.enums.PaymentStatus;
import com.mrd.yourwebproject.service.GroupEventPaymentTransactionService;
import com.mrd.yourwebproject.service.GroupEventsService;
import com.mrd.yourwebproject.service.SmsApiService;

/**
 * SMSItemProcessor
 * 
 */
@Component("paymentTransactionProcessor")
@Scope("step")
public class PaymentTransactionItemProcessor implements ItemProcessor<GroupEventPaymentTransaction, GroupEventPaymentTransaction>,
		ItemStream {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(PaymentTransactionItemProcessor.class);

	@Value("#{jobParameters['runId']}")
	private String runId;

	@Value("#{jobParameters['jobCode']}")
	private String jobCode;
	
	@Value("#{jobParameters['templateName']}")
	private String templateName;
	
	@Value("#{jobParameters['groupEventCode']}")
	private String groupEventCode;

	private @Autowired GroupEventPaymentTransactionService groupEventPaymentTransactionService;
	private @Autowired GroupEventsService groupEventsService;


	/**
	 * Process an email message
	 *
	 * @param message
	 *            the message
	 * @return JPA entities map
	 * @throws Exception
	 *             the exception from either being unable to read headers or
	 *             when there is no Sender identified
	 */
	public GroupEventPaymentTransaction process(GroupEventPaymentTransaction groupEventPaymentTransaction) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();



		if(PaymentStatus.AWAITINGPMT.equals(groupEventPaymentTransaction.getPaymentStatus()) && CommonUtils.isValidDates(null, groupEventPaymentTransaction.getTransactionExpiryDateTime()))
		{
			groupEventPaymentTransaction =	groupEventPaymentTransactionService.preProcessExpiringPaymentTransaction(groupEventPaymentTransaction, false, templateName);
		}
		else if(PaymentStatus.AWAITINGPMT.equals(groupEventPaymentTransaction.getPaymentStatus()))
		{
			groupEventPaymentTransaction = 	groupEventPaymentTransactionService.expirePaymentTransaction(groupEventPaymentTransaction, false, null);
		}
		else if(PaymentStatus.APPROVED.equals(groupEventPaymentTransaction.getPaymentStatus()))
		{
			String emailTemplate = groupEventsService.findByGroupEventCode(groupEventPaymentTransaction.getGroupEventCode()).getProcessCompletionTemplate();
			groupEventPaymentTransaction =	groupEventPaymentTransactionService.approvePaymentTransaction(groupEventPaymentTransaction, emailTemplate);
		}
		else if(PaymentStatus.PMTREJECTED.equals(groupEventPaymentTransaction.getPaymentStatus()))
		{
			
		}
		groupEventPaymentTransaction.setUpdatedBy(jobCode);
		map.put(String.valueOf(groupEventPaymentTransaction.getTransactionId()), groupEventPaymentTransaction);
		// return map;
		return groupEventPaymentTransaction;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.batch.item.ItemStream#open(org.springframework.batch
	 * .item.ExecutionContext)
	 */
	public void open(ExecutionContext executionContext)
			throws ItemStreamException {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.batch.item.ItemStream#update(org.springframework.
	 * batch.item.ExecutionContext)
	 */
	public void update(ExecutionContext executionContext)
			throws ItemStreamException {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.batch.item.ItemStream#close()
	 */
	public void close() throws ItemStreamException {
	}
}
