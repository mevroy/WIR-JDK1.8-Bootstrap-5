/**
 * 
 */
package com.mrd.yourwebproject.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrd.commons.util.CommonUtils;
import com.mrd.framework.data.BaseJpaServiceImpl;
import com.mrd.yourwebproject.common.Props;
import com.mrd.yourwebproject.model.entity.GroupWorkInstructionRecord;
import com.mrd.yourwebproject.model.entity.GroupWorkItems;
import com.mrd.yourwebproject.model.entity.User;
import com.mrd.yourwebproject.model.repository.GroupWorkInstructionRecordRepository;
import com.mrd.yourwebproject.service.GroupWorkInstructionRecordService;

import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.Row;

/**
 * @author dsouzam5
 *
 */
@Service
@Transactional
public class GroupWorkInstructionRecordServiceImpl extends BaseJpaServiceImpl<GroupWorkInstructionRecord, Long>
		implements GroupWorkInstructionRecordService {

	private @Autowired GroupWorkInstructionRecordRepository groupWorkInstructionRecordRepository;
	protected @Autowired Props props;
	private Logger log = LoggerFactory.getLogger(GroupWorkInstructionRecordRepository.class);

	@PostConstruct
	public void setupService() {
		this.baseJpaRepository = groupWorkInstructionRecordRepository;
		this.entityClass = GroupWorkInstructionRecord.class;
		this.baseJpaRepository.setupEntityClass(GroupWorkInstructionRecord.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mrd.yourwebproject.service.GroupWorkInstructionRecordService#
	 * findByGroupCodeAndUser(java.lang.String,
	 * com.mrd.yourwebproject.model.entity.User)
	 */
	public List<GroupWorkInstructionRecord> findByGroupCodeAndUser(String groupCode, User user) {
		return groupWorkInstructionRecordRepository.findByGroupCodeAndUser(groupCode, user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mrd.yourwebproject.service.GroupWorkInstructionRecordService#
	 * findByGroupCode(java.lang.String)
	 */
	public List<GroupWorkInstructionRecord> findByGroupCode(String groupCode) {
		return groupWorkInstructionRecordRepository.findByGroupCode(groupCode);
	}

	public ByteArrayOutputStream prefillPDFTest(GroupWorkInstructionRecord groupWorkInstructionRecord) throws IOException {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		if (groupWorkInstructionRecord == null)
			return output;
		// Creating Document

		URL url = new URL(props.membershipFilePath);
		File f = new File(System.getProperty("java.io.tmpdir", "/tmp"), "batch/files");
		File des = new File(f, "WIR.pdf");
		if (!des.exists())
			FileUtils.copyURLToFile(url, des);
		// load the document
		PDDocument pdfDocument = PDDocument.load(des);
		PDAcroForm acroForm = pdfDocument.getDocumentCatalog().getAcroForm();

		// as there might not be an AcroForm entry a null check is necessary
		if (acroForm != null) {
			// Retrieve an individual field and set its value.
			CommonUtils.setAcroFormField(acroForm, "jobNumber", groupWorkInstructionRecord.getJobNumber());
			CommonUtils.setAcroFormField(acroForm, "orderNumber", groupWorkInstructionRecord.getOrderNumber());
			CommonUtils.setAcroFormField(acroForm, "createdAt", groupWorkInstructionRecord.getCreatedAt().toString());
			CommonUtils.setAcroFormField(acroForm, "jobStart", groupWorkInstructionRecord.getJobStart().toString());
			CommonUtils.setAcroFormField(acroForm, "jobEnd", groupWorkInstructionRecord.getJobEnd().toString());

			CommonUtils.setAcroFormField(acroForm, "clientName", groupWorkInstructionRecord.getClientName());
			CommonUtils.setAcroFormField(acroForm, "quoteNumber", groupWorkInstructionRecord.getQuoteNumber());
			CommonUtils.setAcroFormField(acroForm, "material", groupWorkInstructionRecord.getMaterial());


			CommonUtils.setAcroFormField(acroForm, "power", Boolean.toString(groupWorkInstructionRecord.isPower()));
			CommonUtils.setAcroFormField(acroForm, "suitableAccess",
					Boolean.toString(groupWorkInstructionRecord.isSuitableAccess()));
			CommonUtils.setAcroFormField(acroForm, "email", groupWorkInstructionRecord.getEmail());
			CommonUtils.setAcroFormField(acroForm, "mobilePhone", groupWorkInstructionRecord.getMobilePhone());
			CommonUtils.setAcroFormField(acroForm, "ewpAccessEquipment",
					Boolean.toString(groupWorkInstructionRecord.isEwpAccessEquipment()));
			CommonUtils.setAcroFormField(acroForm, "additionalRequirements",
					groupWorkInstructionRecord.getAdditionalRequirements());

			if (!CollectionUtils.isEmpty(groupWorkInstructionRecord.getGroupWorkItems())) {
				int i = 0;
				for (GroupWorkItems gw : groupWorkInstructionRecord.getGroupWorkItems()) {
					log.info("Acceptace criteria:" + gw.getAcceptanceCriteria());

					CommonUtils.setAcroFormField(acroForm, "testMethod" + i, gw.getTestMethod());
					CommonUtils.setAcroFormField(acroForm, "itrDocument" + i, gw.getItrDocument());
					CommonUtils.setAcroFormField(acroForm, "testStandard" + i, gw.getTestStandard());
					CommonUtils.setAcroFormField(acroForm, "acceptanceCriteria" + i,
							gw.getAcceptanceCriteria().replaceAll("(\\r\\n|\\n)", "<br />"));
					CommonUtils.setAcroFormField(acroForm, "itemProcedure" + i, gw.getItemProcedure());
					CommonUtils.setAcroFormField(acroForm, "nataClassTest" + i, gw.getNataClassTest());
					i++;
				}
			}

		}

		pdfDocument.save(output);
		pdfDocument.close();
		return output;
	}

	public ByteArrayOutputStream prefillPDF(GroupWorkInstructionRecord groupWorkInstructionRecord)
			throws IOException {
		float fontSize = 10;
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		if (groupWorkInstructionRecord == null)
			return output;
		// Creating Document
		URL url = new URL(props.membershipFilePath);
		File f = new File(System.getProperty("java.io.tmpdir", "/tmp"), "batch/files");
		File des = new File(f, "WIR.pdf");
		//if (!des.exists())
			FileUtils.copyURLToFile(url, des);
		// load the document
		PDDocument pdfDocument = PDDocument.load(des);
		PDAcroForm acroForm = pdfDocument.getDocumentCatalog().getAcroForm();
		//PDPage page = pdfDocument.getPage(1);

		float margin = 30;
		//final PDPageContentStream contentStream = new PDPageContentStream(pdfDocument, page, AppendMode.APPEND, false);
		//float yStartNewPage = page.getMediaBox().getHeight() - (150);
		// Initialize table
		//float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
		//System.out.println("yStartNewPage:" + yStartNewPage + "-- tableWidth:" + tableWidth);
		boolean drawContent = true;
		//float yStart = yStartNewPage;
		// float bottomMargin = 70;
		float bottomMargin = 0;
		//BaseTable table = new BaseTable(yStart, yStartNewPage, bottomMargin, tableWidth, margin, pdfDocument, page,
		//		true, drawContent);

		// Create Header row
		//Row<PDPage> headerRow = table.createRow(15f);
		//headerRow.createCell(14, "Test Method").setFontSize(fontSize);
		//headerRow.createCell(15, "ITR Document").setFontSize(fontSize);
		//headerRow.createCell(25, "Test Standard").setFontSize(fontSize);
		//headerRow.createCell(30, "Acceptance Criteria").setFontSize(fontSize);
		//headerRow.createCell(16, "Nata Class Test").setFontSize(fontSize);
		//table.addHeaderRow(headerRow);
		String datePatternWithAMPM = "dd-MM-yyyy hh:mm a";
		String date = "dd-MM-yyyy";
		// as there might not be an AcroForm entry a null check is necessary
		if (acroForm != null) {
			
			CommonUtils.setAcroFormField(acroForm, "currentDateTime", CommonUtils.printDateInPattern(Calendar.getInstance().getTime(),datePatternWithAMPM));
			// Retrieve an individual field and set its value.
			CommonUtils.setAcroFormField(acroForm, "jobNumber", groupWorkInstructionRecord.getJobNumber());
			CommonUtils.setAcroFormField(acroForm, "orderNumber", groupWorkInstructionRecord.getOrderNumber());
			CommonUtils.setAcroFormField(acroForm, "createdAt", CommonUtils.printDateInPattern(groupWorkInstructionRecord.getCreatedAt(),date));
			CommonUtils.setAcroFormField(acroForm, "jobStart", CommonUtils.printDateInPattern(groupWorkInstructionRecord.getJobStart(),datePatternWithAMPM));
			CommonUtils.setAcroFormField(acroForm, "jobEnd", CommonUtils.printDateInPattern(groupWorkInstructionRecord.getJobEnd(),datePatternWithAMPM));
			CommonUtils.setAcroFormField(acroForm, "travelStart", CommonUtils.printDateInPattern(groupWorkInstructionRecord.getTravelStart(),datePatternWithAMPM));
			CommonUtils.setAcroFormField(acroForm, "travelEnd", CommonUtils.printDateInPattern(groupWorkInstructionRecord.getTravelEnd(),datePatternWithAMPM));

			CommonUtils.setAcroFormField(acroForm, "clientName", groupWorkInstructionRecord.getClientName());
			CommonUtils.setAcroFormField(acroForm, "quoteNumber", groupWorkInstructionRecord.getQuoteNumber());
			CommonUtils.setAcroFormField(acroForm, "material", groupWorkInstructionRecord.getMaterial());
			CommonUtils.setAcroFormField(acroForm, "clientName", groupWorkInstructionRecord.getClientName());
			CommonUtils.setAcroFormField(acroForm, "postalAddress", groupWorkInstructionRecord.getGroupAddress().getStreetAddress()+ ", "+groupWorkInstructionRecord.getGroupAddress().getSuburb()+" - "+groupWorkInstructionRecord.getGroupAddress().getState()+", "+groupWorkInstructionRecord.getGroupAddress().getZipCode());
			CommonUtils.setAcroFormField(acroForm, "siteContact", groupWorkInstructionRecord.getGroupClientContact().getFirstName()+" "+groupWorkInstructionRecord.getGroupClientContact().getLastName());
			CommonUtils.setAcroFormField(acroForm, "siteAddress", groupWorkInstructionRecord.getGroupAddress().getStreetAddress()+ ", "+groupWorkInstructionRecord.getGroupAddress().getSuburb()+" - "+groupWorkInstructionRecord.getGroupAddress().getState()+", "+groupWorkInstructionRecord.getGroupAddress().getZipCode());
			CommonUtils.setAcroFormField(acroForm, "contactMobile", groupWorkInstructionRecord.getGroupClientContact().getMobilephone());
			CommonUtils.setAcroFormField(acroForm, "contactEmail", groupWorkInstructionRecord.getGroupClientContact().getEmail());
			CommonUtils.setAcroFormField(acroForm, "contactFax", groupWorkInstructionRecord.getGroupClientContact().getFax());
			CommonUtils.setAcroFormField(acroForm, "clientEmail", groupWorkInstructionRecord.getGroupClient().getEmail());


//TODO
//contactHO
//contactSite

			CommonUtils.setAcroFormField(acroForm, "power", groupWorkInstructionRecord.isPower() ? "YES" : "NO");
			CommonUtils.setAcroFormField(acroForm, "lighting", groupWorkInstructionRecord.isLighting() ? "YES" : "NO");

			CommonUtils.setAcroFormField(acroForm, "suitableAccess",
					(groupWorkInstructionRecord.isSuitableAccess() ? "YES" : "NO"));
			CommonUtils.setAcroFormField(acroForm, "material", CommonUtils.replacePattern("(\\r\\n|\\n|,)", ", ", groupWorkInstructionRecord.getMaterial()));
			CommonUtils.setAcroFormField(acroForm, "surfacePreparation", CommonUtils.replacePattern("(\\r\\n|\\n|,)", ", ", groupWorkInstructionRecord.getSurfacePrepartion()));
			CommonUtils.setAcroFormField(acroForm, "ewpAccessEquipment",
					(groupWorkInstructionRecord.isEwpAccessEquipment()) ? "YES" : "NO");
			CommonUtils.setAcroFormField(acroForm, "additionalRequirements",
					CommonUtils.replacePattern("(\\r\\n|\\n|,)", ", ", groupWorkInstructionRecord.getAdditionalRequirements()));

			if (!CollectionUtils.isEmpty(groupWorkInstructionRecord.getGroupWorkItems())) {
				for (GroupWorkItems gw : groupWorkInstructionRecord.getGroupWorkItems()) {
					CommonUtils.setAcroFormField(acroForm, "testMethod",
							CommonUtils.replacePattern("(\\r\\n|\\n|,)", "\n", gw.getTestMethod()));

					CommonUtils.setAcroFormField(acroForm, "itrDocuments",
							CommonUtils.replacePattern("(\\r\\n|\\n|,)", "\n", gw.getItrDocument()));

					CommonUtils.setAcroFormField(acroForm, "testStandard",
							CommonUtils.replacePattern("(\\r\\n|\\n|,)", "\n", gw.getTestStandard()));

					CommonUtils.setAcroFormField(acroForm, "acceptanceCriteria",
							CommonUtils.replacePattern("(\\r\\n|\\n|,)", "\n", gw.getAcceptanceCriteria()));
					CommonUtils.setAcroFormField(acroForm, "procedure",
							CommonUtils.replacePattern("(\\r\\n|\\n|,)", "\n", gw.getItemProcedure()));

					CommonUtils.setAcroFormField(acroForm, "nataClassTest",
							CommonUtils.replacePattern("(\\r\\n|\\n|,)", "\n", gw.getNataClassTest()));

					
/*					CommonUtils.setAcroFormField(acroForm, "testMethod" , gw.getTestMethod());
					CommonUtils.setAcroFormField(acroForm, "itrDocument" , gw.getItrDocument());
					CommonUtils.setAcroFormField(acroForm, "testStandard" , gw.getTestStandard());
					CommonUtils.setAcroFormField(acroForm, "acceptanceCriteria" ,
							gw.getAcceptanceCriteria().replaceAll("(\\r\\n|\\n|,)", "\n"));
					CommonUtils.setAcroFormField(acroForm, "procedure" , gw.getItemProcedure());
					CommonUtils.setAcroFormField(acroForm, "nataClassTest" , gw.getNataClassTest());
*/
					break;
					
/*					Row<PDPage> row = table.createRow(15f);
					row.createCell(14, CommonUtils.replacePattern("(\\r\\n|\\n|,|//|/)", "/<br />", gw.getTestMethod())).setFontSize(fontSize);
					row.createCell(15, gw.getItrDocument()).setFontSize(fontSize);
					row.createCell( CommonUtils.replacePattern("(\\r\\n|\\n|,)", "<br />", gw.getTestStandard()))
							.setFontSize(fontSize);
					row.createCell( CommonUtils.replacePattern("(\\r\\n|\\n|,)", "<br />", gw.getAcceptanceCriteria()))
							.setFontSize(fontSize);
					row.createCell(16, gw.getNataClassTest()).setFontSize(fontSize);
					table.addHeaderRow(row);
					
*/				}
			}
			//table.draw();

		}

		// pdfDocument.addPage(page);
		//contentStream.close();
		pdfDocument.save(output);
		pdfDocument.close();
		return output;
	}

}
