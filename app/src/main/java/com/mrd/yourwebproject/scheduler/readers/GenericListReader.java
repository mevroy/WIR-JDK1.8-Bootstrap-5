package com.mrd.yourwebproject.scheduler.readers;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import com.mrd.yourwebproject.model.entity.GroupMember;
import com.mrd.yourwebproject.service.GroupMembersService;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;

@Component("listReader")
@Scope("step")
public class GenericListReader implements ItemReader<List<GroupMember>>,
		ItemStream {

	/** Logger for this class. */
	private static final Logger logger = LoggerFactory
			.getLogger(GenericListReader.class);

	@Autowired
	private GroupMembersService groupMembersService;

	@Value("#{jobParameters['runId']}")
	private String runId;

	@Value("#{jobParameters['templateName']}")
	private String templateName;
	
	@Value("#{jobParameters['queryString']}")
	private String queryString;

	@Value("#{jobParameters['emailAddress']}")
	private String emailAddress;
	
	private int count = 1;

	/**
	 * Read GroupMember.
	 * 
	 * @return the message
	 * @throws Exception
	 *             the exception
	 * @throws UnexpectedInputException
	 *             the unexpected input exception
	 * @throws ParseException
	 *             the parse exception
	 * @throws NonTransientResourceException
	 *             the non transient resource exception
	 */
	public List<GroupMember> read() throws MessagingException,
			UnexpectedInputException, ParseException,
			NonTransientResourceException, Exception {
		if( StringUtils.isBlank(queryString) ||  StringUtils.isBlank(templateName) || StringUtils.isBlank(emailAddress)){
			throw new Exception(
					"Template Name and Email Address and queryString are required. Please pass it as a job param 'templateName' , 'emailAddress' and 'queryString'"
							);
		}
		List<List<GroupMember>> gms = groupMembersService
				.executeGenericQueryAsList(queryString);
		while (count > 0 && gms != null && !gms.isEmpty()) {
			count--;
			return gms.get(0);

		}
		return null;
	}

	public void open(ExecutionContext executionContext)
			throws ItemStreamException {
		// TODO Auto-generated method stub

	}

	public void update(ExecutionContext executionContext)
			throws ItemStreamException {
		// TODO Auto-generated method stub

	}

	public void close() throws ItemStreamException {
		// TODO Auto-generated method stub

	}

	/*
	 * protected Message getMessage() throws MessagingException {
	 * logger.trace("getMessage() : enter");
	 * 
	 * Message message = null; Message[] messages = null; Folder inbox = null;
	 * Store store = null;
	 * 
	 * try { Properties props = System.getProperties();
	 * props.setProperty(storeProtocol, protocol); if(!strictAuthentication) {
	 * props.put("mail.imaps.auth.plain.disable", "true");
	 * props.put("mail.imaps.auth.ntlm.disable", "true");
	 * props.put("mail.imaps.auth.gssapi.disable", "true"); }
	 * 
	 * // Establishing session with email server Session session =
	 * Session.getDefaultInstance(props, null); store =
	 * session.getStore(protocol); if(!store.isConnected())
	 * store.connect(serverHost, userName, password);
	 * 
	 * // Getting inbox folder inbox = store.getFolder(folder);
	 * inbox.open(Folder.READ_WRITE);
	 * 
	 * //search if(unreadOnly) messages = inbox.search(new FlagTerm(new
	 * Flags(Flags.Flag.SEEN), false)); else messages = inbox.getMessages();
	 * 
	 * if(messages!=null && messages.length>0) { message = messages[0];
	 * message.setFlag(Flag.SEEN, true); } } catch (MessagingException ex) {
	 * String msg = "Cannot process EmailItemReader.getMessage \n " +
	 * ex.getMessage(); logger.error(msg.toString(), ex);
	 * if(store.isConnected()) { try { store.close(); } catch(Exception e) {} }
	 * throw ex; }
	 * 
	 * logger.trace("getMessage() : exit"); return message; }
	 */
}