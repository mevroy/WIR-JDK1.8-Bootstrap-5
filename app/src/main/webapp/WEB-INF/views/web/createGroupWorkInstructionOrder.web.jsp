<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/res/js/css/bootstrap-select.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/res/bootstrap/js/bootstrap-select.js"></script>

<div class="jumbotron">
	<h2>Create Work Instruction Order</h2>
	<br />
	<div class="span12">

		<form:form commandName="groupWorkInstructionRecord"
			action="saveGroupWorkInstructionRecord" method="post"
			id="groupWorkInstructionRecord">
			<div class="row">
				<div class="col-lg-5">
					<div class="form-group" id="clientIdCtl">
						<label class="control-label" for="clientName">Client </label>

						<div class="controls">
							<div class="input-group">
								<form:select path="groupClient.clientId" data-live-search="true"
									cssClass="form-control" id="clientId"
									onchange="buildAddress(this.value, 'addressId'); buildContact(this.value, 'clientContactId');"
									placeholder="Client Name" />
								<div class="input-group-addon">
									<span><a href="addClientData"><i
											class="glyphicon glyphicon-plus"></i></a></span>
								</div>
							</div>
						</div>

					</div>
					<div class="form-group" id="groupAddressCtl">
						<label class="control-label" for="groupAddress.addressId">Site
							Address </label>

						<div class="controls">
							<form:select path="groupAddress.addressId"
								data-live-search="true" cssClass="form-control" id="addressId"
								placeholder="Site Address">
								<option value="">Select One</option>
							</form:select>
						</div>
					</div>
					<div class="form-group" id="clientContactIdCtl">
						<label class="control-label"
							for="groupClientContact.clientContactId">Contact </label>

						<div class="controls">
							<form:select path="groupClientContact.clientContactId"
								data-live-search="true" cssClass="form-control"
								id="clientContactId" placeholder="Contact">
								<option value="">Select One</option>
							</form:select>
						</div>
					</div>
					<!-- 		<div class="form-group" id="jobNumberCtl">
						<label class="control-label" for="jobNumber">Job Number</label>

						<div class="controls">
							<form:input path="jobNumber" cssClass="form-control"
								id="jobNumber" placeholder="Enter Job Number" />
						</div>
					</div>
					 -->

					<div class="form-group" id="orderNumberCtl">
						<label class="control-label" for="orderNumber">Client PO</label>

						<div class="controls">
							<form:input path="orderNumber" cssClass="form-control"
								id="orderNumber" placeholder="Enter Order Number" />
						</div>
					</div>
					<div class="form-group" id="quoteNumberCtl">
						<label class="control-label" for="quoteNumber">Quote
							Reference Number</label>

						<div class="controls">
							<form:input path="quoteNumber" cssClass="form-control"
								id="quoteNumber" placeholder="Enter Quote Number" />
						</div>
					</div>
					<div class="form-group" id="jobstartEndDateCtl">
						<label class="control-label" for="jobstartEndDate">Job
							Start/End Time </label>
						<div class="controls">
							<div class="input-daterange input-group">

								<div class="input-group-addon">
									<span><i class='glyphicon glyphicon-calendar'></i></span>
								</div>
								<form:input path="jobStart"
									cssClass="form-control form_datetime" id="jobStart"
									placeholder="Start Date Time" />
								<div class="input-group-addon">
									<span>TO</span>
								</div>

								<form:input path="jobEnd" cssClass="form-control form_datetime"
									id="jobEnd" placeholder="End Date Time" />
								<div class="input-group-addon">
									<span><i class='glyphicon glyphicon-calendar'></i></span>
								</div>

							</div>
						</div>
					</div>


					<div class="form-group" id="surfacePrepartionCtl">
						<label class="control-label" for="surfacePrepartion">Surface
							Preparation </label>

						<div class="controls">
							<form:textarea path="surfacePrepartion" cssClass="form-control"
								id="surfacePrepartion" placeholder="Surface Preparation"
								rows="5" />
						</div>
					</div>

				</div>
				<div class="col-lg-offset-2 col-lg-5">
					<div class="form-group" id="travelstartEndDateCtl">
						<label class="control-label" for="travelstartEndDate">Travel
							Start/End Time </label>
						<div class="controls">
							<div class="input-daterange input-group">

								<div class="input-group-addon">
									<span><i class='glyphicon glyphicon-calendar'></i></span>
								</div>
								<form:input path="travelStart"
									cssClass="form-control form_datetime" id="travelStart"
									placeholder="Start Date Time" />
								<div class="input-group-addon">
									<span>TO</span>
								</div>

								<form:input path="travelEnd"
									cssClass="form-control form_datetime" id="travelEnd"
									placeholder="End Date Time" />
								<div class="input-group-addon">
									<span><i class='glyphicon glyphicon-calendar'></i></span>
								</div>

							</div>
						</div>
					</div>
					<div class="form-group" id="materialCtl">
						<label class="control-label" for="material">Material</label>

						<div class="controls">
							<form:input path="material" cssClass="form-control" id="material"
								placeholder="Enter Material" />
						</div>
					</div>



					<div class="form-group" id="suitableAccessCtl">
						<label class="control-label" for="suitableAccess">Suitable
							Access</label>
						<div>
							<div class="radio">
								<label class="radio-inline"> <form:radiobutton
										path="suitableAccess" id="suitableAccess" value="true" /> Yes
								</label> <label class="radio-inline"> <form:radiobutton
										path="suitableAccess" id="suitableAccess" value="false" /> NO
								</label>
							</div>
						</div>

					</div>
					<div class="form-group" id="powerCtl">
						<label class="control-label" for="power">Power?</label>
						<div>
							<div class="radio">
								<label class="radio-inline"> <form:radiobutton
										path="power" id="power" value="true" /> Yes
								</label> <label class="radio-inline"> <form:radiobutton
										path="power" id="power" value="false" /> NO
								</label>
							</div>
						</div>

					</div>

					<div class="form-group" id="lightingCtl">
						<label class="control-label" for="lighting">Lighting</label>
						<div>
							<div class="radio">
								<label class="radio-inline"> <form:radiobutton
										path="lighting" id="lighting" value="true" /> Yes
								</label> <label class="radio-inline"> <form:radiobutton
										path="lighting" id="lighting" value="false" /> NO
								</label>
							</div>
						</div>

					</div>
					<div class="form-group" id="ewpAccessEquipmentCtl">
						<label class="control-label" for="ewpAccessEquipment">EWP
							Access Equipment</label>
						<div>
							<div class="radio">
								<label class="radio-inline"> <form:radiobutton
										path="ewpAccessEquipment" id="ewpAccessEquipment" value="true" />
									Yes
								</label> <label class="radio-inline"> <form:radiobutton
										path="ewpAccessEquipment" id="ewpAccessEquipment"
										value="false" /> NO
								</label>
							</div>
						</div>
					</div>
					<div class="form-group" id="additionalRequirementsCtl">
						<label class="control-label" for="additionalRequirements">Additional
							Requirements</label>

						<div class="controls">
							<form:textarea path="additionalRequirements"
								cssClass="form-control" id="additionalRequirements"
								placeholder="Additional Requirements" rows="5" />
						</div>
					</div>

				</div>

			</div>
			<hr
				style="height: 10px; border: 0; box-shadow: 0 10px 10px -10px #337ab7 inset">

			<!-- 			<div class="row">

				<div class="col-lg-12">
					<input type="button" name="addMore" id="addMore"
						class="btn btn-danger btn-block btn-lg" value="ADD WORK ITEMS"
						onclick="$('#moreDetails').show();" />
				</div>
			</div>  -->
			<h2>Add Work Items</h2>
			<br />
			<div class="row">
				<div id="moreDetails">
					<div class="col-md-4">
						<div class="form-group" id="groupWorkItems[0].testMethodCtl">
							<label class="control-label" for="testMethod">Test Method</label>

							<div class="controls">
								<form:select path="groupWorkItems[0].testMethod"
									data-live-search="true" cssClass="form-control selectpicker"
									id="testMethod"
									onchange="buildWIRDropDowns(this.value, 'itrDocument0' ,'itemProcedure0', 'testStandard0', 'acceptanceCriteria0');"
									placeholder="Test Method" />
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group" id="groupWorkItems[0].itrDocumentCtl">
							<label class="control-label" for="itrDocument">ITR
								Document</label>

							<div class="controls">
								<form:select path="groupWorkItems[0].itrDocument"
									cssClass="form-control selectpicker" id="itrDocument0"
									placeholder="ITR Document">
									<option value="">Select One</option>
								</form:select>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group" id="groupWorkItems[0].itemProcedureCtl">
							<label class="control-label" for="itemProcedure">Test
								Procedure</label>

							<div class="controls">
								<form:select path="groupWorkItems[0].itemProcedure"
									cssClass="form-control selectpicker" id="itemProcedure0"
									placeholder="Item Procedure">
									<option value="">Select One</option>
								</form:select>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group" id="groupWorkItems[0].testStandardCtl">
							<label class="control-label" for="testStandard">Test
								Standard</label>

							<div class="controls">
								<form:select multiple="true" data-live-search="true"
									path="groupWorkItems[0].testStandard"
									cssClass="form-control selectpicker" id="testStandard0"
									placeholder="Enter Test Standard" size="5" />
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group"
							id="groupWorkItems[0].acceptanceCriteriaCtl">
							<label class="control-label" for="acceptanceCriteria">Acceptance
								Criteria</label>

							<div class="controls">
								<form:select multiple="true" data-live-search="true"
									path="groupWorkItems[0].acceptanceCriteria"
									cssClass="form-control selectpicker" id="acceptanceCriteria0"
									placeholder="Enter Acceptane Criteria" size="5" />
							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group" id="groupWorkItems[0].nataClassTestCtl">
							<label class="control-label" for="nataClassTest">NATA
								Class Method</label>

							<div class="controls">
								<form:input path="groupWorkItems[0].nataClassTest"
									cssClass="form-control" id="groupWorkItems[0].nataClassTest"
									placeholder="NATA Class Test" />
							</div>
						</div>
					</div>
				</div>


			</div>

			<c:forEach begin="1" end="4" step="1" var="i">
				<div class="row">
					<div id="moreDetails${i}" class="moreDetails">
						<hr
							style="height: 10px; border: 0; box-shadow: 0 10px 10px -10px #337ab7 inset">

						<div class="col-md-4">
							<div class="form-group" id="groupWorkItems[${i}].testMethodCtl">
								<label class="control-label" for="testMethod">Test
									Method</label>
								<div class="controls">
									<form:select path="groupWorkItems[${i}].testMethod"
										data-live-search="true"
										onchange="buildWIRDropDowns(this.value,  'itrDocument'+${i} , 'itemProcedure'+${i}, 'testStandard'+${i}, 'acceptanceCriteria'+${i});"
										cssClass="form-control" id="testMethod"
										placeholder="Test Method" />
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group" id="groupWorkItems[${i}].itrDocumentCtl">
								<label class="control-label" for="itrDocument">ITR
									Document</label>
								<div class="controls">
									<form:select path="groupWorkItems[${i}].itrDocument"
										cssClass="form-control selectpicker" id="itrDocument${i}"
										placeholder="ITR Document">
										<option value="">Select One</option>
									</form:select>
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group"
								id="groupWorkItems[${i}].itemProcedureCtl">
								<label class="control-label" for="itemProcedure">Test
									Procedure</label>
								<div class="controls">
									<form:select path="groupWorkItems[${i}].itemProcedure"
										cssClass="form-control selectpicker" id="itemProcedure${i}"
										placeholder="Item Procedure">
										<option value="">Select One</option>
									</form:select>
								</div>
							</div>
						</div>

						<div class="col-md-4">
							<div class="form-group" id="groupWorkItems[${i}].testStandardCtl">
								<label class="control-label" for="testStandard">Test
									Standard</label>
								<div class="controls">
									<form:select multiple="true"
										path="groupWorkItems[${i}].testStandard"
										data-live-search="true" cssClass="form-control selectpicker"
										id="testStandard${i}" placeholder="Enter Test Standard"
										size="5" />
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group"
								id="groupWorkItems[${i}].acceptanceCriteriaCtl">
								<label class="control-label" for="acceptanceCriteria">Acceptance
									Criteria</label>
								<div class="controls">
									<form:select multiple="true"
										path="groupWorkItems[${i}].acceptanceCriteria"
										data-live-search="true" cssClass="form-control selectpicker"
										id="acceptanceCriteria${i}"
										placeholder="Enter Acceptane Criteria" size="5" />
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group"
								id="groupWorkItems[${i}].nataClassTestCtl">
								<label class="control-label" for="nataClassTest">NATA
									Class Method</label>
								<div class="controls">
									<form:input path="groupWorkItems[${i}].nataClassTest"
										cssClass="form-control"
										id="groupWorkItems[${i}].nataClassTest"
										placeholder="NATA Class Test" />
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
			<div class="row">
				<div class="col-md-6">
					<input type="button" name="addMore" id="addMore"
						class="btn btn-danger btn-block btn-lg" value="ADD WORK ITEMS"
						onclick="displayWorkItem();" />
				</div>
				<div class="col-md-6">
					<input type="button" name="remove" id="remove"
						class="btn btn-default btn-block btn-lg" value="REMOVE WORK ITEMS"
						onclick="removeWorkItem();" />
				</div>
			</div>
			<div class="row">
				<br />
			</div>
			<div class="row">
				<div class="col-lg-12">
					<form:hidden path="group.id" id="group.id" readonly="true" />
					<input class="btn btn-primary btn-block btn-lg" type="submit"
						value="SUBMIT" /> <a
						href="${pageContext.request.contextPath}/${sessionScope.groupCode}/"
						class="btn btn-default btn-block btn-lg">CANCEL</a>
				</div>
			</div>

		</form:form>


	</div>

</div>

<script type="text/javascript">
	$(document).ready(
			function() {
				$("#groupMember").validate(
						{
							rules : {
								firstName : {
									required : true
								},
								lastName : {
									required : false
								},
								primaryEmail : {
									required : true,
									email : true
								},

								adultCount : {
									number : true
								},
								kidCount : {
									number : true
								},
								mobilephone : {
									maxlength : 13
								},
								otherPhone : {
									maxlength : 13
								},
								paidMembershipAmount : {
									number : true
								},
								memberCategoryCode : {
									required : true
								}
							},
							messages : {

							},
							errorPlacement : function(error, element) {
								error.appendTo(element.parent("div").parent(
										"div"));
							},
							errorClass : "control-group has-error text-danger",
							validClass : "control-group has-success",
							errorElement : "span",
							highlight : function(element, errorClass,
									validClass) {
								if (element.type === 'radio') {
									this.findByName(element.name).parent("div")
											.parent("div").removeClass(
													validClass).addClass(
													errorClass);
								} else {
									$(element).parent("div").parent("div")
											.removeClass(validClass).addClass(
													errorClass);
								}
							},
							unhighlight : function(element, errorClass,
									validClass) {
								if (element.type === 'radio') {
									this.findByName(element.name).parent("div")
											.parent("div").removeClass(
													errorClass).addClass(
													validClass);
								} else {
									$(element).parent("div").parent("div")
											.removeClass(errorClass).addClass(
													validClass);
								}
							}
						})

			});

	$(function() {
		buildClients('clientId');
		buildTestMethods('testMethod');
		//buildAcceptanceCriteria('acceptanceCriteria');
		//buildTestMethodStandards('testStandard');
		
		$('.moreDetails').hide();
	});
	var division = 1;
	function displayWorkItem() {
		showById('moreDetails' + division);
		division++;
	}

	function removeWorkItem() {
		hideById('moreDetails' + division);
		division = division - 1;
	}
</script>
