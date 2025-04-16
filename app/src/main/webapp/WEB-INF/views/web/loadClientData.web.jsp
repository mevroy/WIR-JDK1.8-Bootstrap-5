<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id="1" style="display: none;">
	<div class="jumbotron">
		<h2>Update Client</h2>
		
		<div class="row">
			<div>


				<form:form commandName="groupClient" action="json/groupClient"
					method="post" id="groupClient"
					onsubmit="event.preventDefault(); javascript:postFormAndToggleError('groupClient','json/groupClient','1', '20');">

					<div class="col-lg-5">
						<div class="form-group" id="clientNameCtl">
							<label class="control-label" for="clientName">Client Name</label>

							<div class="controls">
								<form:input path="clientName" cssClass="form-control"
									id="firstName" placeholder="Enter Client Name" />
							</div>
						</div>
						<div class="form-group" id="clientABNCtl">
							<label class="control-label" for="clientABN">Client ABN</label>

							<div class="controls">
								<form:input path="clientABN" cssClass="form-control"
									id="lastName" placeholder="Enter Client ABN" />
							</div>
						</div>
						<div class="form-group" id="emailCtl">
							<label class="control-label" for="email">Email</label>

							<div class="controls">
								<div class="input-group">
									<form:input path="email" cssClass="form-control"
										id="primaryEmail" placeholder="Enter Email" />
									<div class="input-group-addon">
										<span><i class="glyphicon glyphicon-envelope"></i></span>
									</div>
								</div>
							</div>
						</div>

					</div>
					<div class="col-lg-offset-2 col-lg-5">
						<div class="form-group" id="phoneCtl">
							<label class="control-label" for="phone">Phone No.</label>

							<div class="controls">
								<div class="input-group">
									<form:input path="phone" cssClass="form-control" id="phone"
										placeholder="Enter Phone Number" />
									<div class="input-group-addon">
										<span><i class='glyphicon glyphicon-phone'></i></span>
									</div>
								</div>
							</div>
						</div>
						<div class="form-group" id="faxCtl">
							<label class="control-label" for="otherPhone">Fax</label>

							<div class="controls">
								<div class="input-group">
									<form:input path="fax" cssClass="form-control" id="fax"
										placeholder="Enter Fax Number" />
									<div class="input-group-addon">
										<span><i class='glyphicon glyphicon-phone-alt'></i></span>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="col-lg-12">
						<div class="form-group">
							<form:hidden path="clientId" id="clientId" />
							<button class="btn btn-primary btn-lg btn-block has-spinner"
								type="submit" onclick="return $('#groupMember').valid();"
								data-loading-text="<span class='spinner'><i class='icon-spin glyphicon glyphicon-repeat'></i></span> Loading..">SAVE
								AND CONTINUE</button>
						</div>
					</div>




				</form:form>
			</div>
		</div>
	</div>
</div>



<c:set var="contactCount" value="20"></c:set>
<c:set var="previous" value="1"></c:set>
<c:forEach items="${groupClient.groupClientContact}" var="contacts"
	varStatus="counter">
	<c:set var="contactCount" value="${contactCount + 1}"></c:set>
	<div id="${contactCount - 1}" style="display: none;">
		<div class="jumbotron">
			<h2>
				Client Contacts
				<c:out value="${counter.index +1}"></c:out>
			</h2>
			<div class="row">
				<div>

					<form:form commandName="groupClient"
						action="json/groupClientContact" method="post"
						id="contact${contactCount - 1}"
						onsubmit="event.preventDefault(); javascript:postFormAndToggleError('contact${contactCount - 1}','json/groupClientContact','${contactCount - 1}','${contactCount}');">
						<div class="col-lg-5">
							<div class="form-group"
								id="groupClientContact[${counter.index}].firstNameCtl">
								<label class="control-label"
									for="groupClientContact[${counter.index}].firstName">Contact
									First Name</label>

								<div class="controls">
									<form:input
										path="groupClientContact[${counter.index}].firstName"
										cssClass="form-control" id="firstName"
										placeholder="Enter First Name" />
								</div>
							</div>
							<div class="form-group"
								id="groupClientContact[${counter.index}].lastNameCtl">
								<label class="control-label"
									for="groupClientContact[${counter.index}].lastName">Contact
									Last Name</label>

								<div class="controls">
									<form:input
										path="groupClientContact[${counter.index}].lastName"
										cssClass="form-control" id="lastName"
										placeholder="Enter Last Name" />
								</div>
							</div>

						</div>
						<div class="col-lg-offset-2 col-lg-5">
							<div class="form-group"
								id="groupClientContact[${counter.index}].emailCtl">
								<label class="control-label"
									for="groupClientContact[${counter.index}].email">Email</label>

								<div class="controls">
									<div class="input-group">
										<form:input path="groupClientContact[${counter.index}].email"
											cssClass="form-control" id="email" placeholder="Enter Email" />
										<div class="input-group-addon">
											<span><i class="glyphicon glyphicon-envelope"></i></span>
										</div>
									</div>
								</div>
							</div>
							<div class="form-group"
								id="groupClientContact[${counter.index}].mobilephoneCtl">
								<label class="control-label"
									for="groupClientContact[${counter.index}].mobilephone">Mobile
									No.</label>

								<div class="controls">
									<div class="input-group">
										<form:input
											path="groupClientContact[${counter.index}].mobilephone"
											cssClass="form-control" id="mobilephone"
											placeholder="Enter Mobile Phone Number" />
										<div class="input-group-addon">
											<span><i class='glyphicon glyphicon-phone'></i></span>
										</div>
									</div>
								</div>
							</div>

						</div>

						<div class="col-lg-12">
							<div class="form-group">
								<form:hidden
									path="groupClientContact[${counter.index}].clientContactId"
									id="groupClientContact[${counter.index}].clientContactId" />
								<form:hidden path="clientId" id="clientId" />
								<button class="btn btn-primary btn-lg btn-block has-spinner"
									type="submit"
									onclick="return $('#contact${contactCount - 1}').valid();"
									data-loading-text="<span class='spinner'><i class='icon-spin glyphicon glyphicon-repeat'></i></span> Loading..">SAVE
									AND CONTINUE</button>
							</div>
						</div>


					</form:form>
					<div class="col-lg-12">
						<div class="form-group">
							<button class="btn btn-primary btn-lg btn-block has-spinner"
								type="submit"
								onclick="hideById('${contactCount - 1}'); showById('${previous}');"
								data-loading-text="<span class='spinner'><i class='icon-spin glyphicon glyphicon-repeat'></i></span> Loading..">BACK</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:set var="previous" value="${contactCount - 1}"></c:set>
</c:forEach>

<c:forEach items="${groupClient.groupAddress}" var="contacts"
	varStatus="counter">
	<c:set var="contactCount" value="${contactCount + 1}"></c:set>
	<div id="${contactCount-1}" style="display: none;">
		<div class="jumbotron">
			<h2>
				Address
				<c:out value="${counter.index +1}"></c:out>
			</h2>
			<div class="row">
				<div>

					<form:form commandName="groupClient" action="json/groupAddress"
						method="post" id="contact${contactCount - 1}"
						onsubmit="event.preventDefault(); javascript:postFormAndToggleError('contact${contactCount - 1}','json/groupAddress','${contactCount-1}','${contactCount}');">
						<div class="col-lg-5">
							<div class="form-group"
								id="groupAddress[${counter.index}].addressTypeCtl">
								<label class="control-label"
									for="groupAddress[${counter.index}].addressType">Address
									Type</label>

								<div class="controls">
									<form:select path="groupAddress[${counter.index}].addressType"
										cssClass="form-control" id="addressType"
										placeholder="Enter First Name">
										<form:option value="">Select One</form:option>
										<form:option value="RESIDENCE">RESIDENCE</form:option>
										<form:option value="OFFICE">OFFICE</form:option>
										<form:option value="MAILING">MAILING</form:option>
										<form:option value="SITE">SITE</form:option>
										<form:option value="OTHER">OTHER</form:option>
									</form:select>
								</div>
							</div>
							<div class="form-group"
								id="groupAddress[${counter.index}].poBoxCtl">
								<label class="control-label"
									for="groupAddress[${counter.index}].poBox">PO BOX</label>

								<div class="controls">
									<form:input path="groupAddress[${counter.index}].poBox"
										cssClass="form-control" id="poBox" placeholder="Enter PO Box" />
								</div>
							</div>
							<div class="form-group"
								id="groupAddress[${counter.index}].streetAddressCtl">
								<label class="control-label"
									for="groupAddress[${counter.index}].streetAddress">Street
									Address</label>

								<div class="controls">
									<div class="input-group">
										<form:input
											path="groupAddress[${counter.index}].streetAddress"
											cssClass="form-control" id="streetAddress"
											placeholder="Enter Street Address" />
										<div class="input-group-addon">
											<span><i class="glyphicon glyphicon-envelope"></i></span>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-offset-2 col-lg-5">

							<div class="form-group"
								id="groupAddress[${counter.index}].suburbCtl">
								<label class="control-label"
									for="groupAddress[${counter.index}].suburb">Suburb No.</label>

								<div class="controls">
									<div class="input-group">
										<form:input path="groupAddress[${counter.index}].suburb"
											cssClass="form-control" id="suburb"
											placeholder="Enter Suburb" />
										<div class="input-group-addon">
											<span><i class='glyphicon glyphicon-phone'></i></span>
										</div>
									</div>
								</div>
							</div>

							<div class="form-group"
								id="groupAddress[${counter.index}].stateCtl">
								<label class="control-label"
									for="groupAddress[${counter.index}].state">State No.</label>

								<div class="controls">
									<div class="input-group">
										<form:input path="groupAddress[${counter.index}].state"
											cssClass="form-control" id="state" placeholder="Enter State" />
										<div class="input-group-addon">
											<span><i class='glyphicon glyphicon-phone'></i></span>
										</div>
									</div>
								</div>
							</div>

							<div class="form-group"
								id="groupAddress[${counter.index}].zipCodeCtl">
								<label class="control-label"
									for="groupAddress[${counter.index}].zipCode">ZIP No.</label>

								<div class="controls">
									<div class="input-group">
										<form:input path="groupAddress[${counter.index}].zipCode"
											cssClass="form-control" id="zipCode"
											placeholder="Enter ZIP code" />
										<div class="input-group-addon">
											<span><i class='glyphicon glyphicon-phone'></i></span>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="col-lg-12">
							<div class="form-group">
								<form:hidden path="groupAddress[${counter.index}].addressId"
									id="groupAddress[${counter.index}].addressId" />
								<form:hidden path="clientId" id="clientId" />
								<button class="btn btn-primary btn-lg btn-block has-spinner"
									type="submit"
									onclick="return $('#contact${contactCount - 1}').valid();"
									data-loading-text="<span class='spinner'><i class='icon-spin glyphicon glyphicon-repeat'></i></span> Loading..">SAVE
									AND CONTINUE</button>
							</div>
						</div>


					</form:form>
					<div class="col-lg-12">
						<div class="form-group">
							<button class="btn btn-primary btn-lg btn-block has-spinner"
								type="submit"
								onclick="hideById('${contactCount - 1}'); showById('${previous}');"
								data-loading-text="<span class='spinner'><i class='icon-spin glyphicon glyphicon-repeat'></i></span> Loading..">BACK</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:set var="previous" value="2${contactCount - 1}"></c:set>
</c:forEach>



<div id="${contactCount}" style="display: none;">
	<div class="jumbotron">
	<h2>
				Add Data</h2>
		<div class="row">


			<div id="newDependent" style="display: none;">

				<form:form commandName="groupClientContacts"
					action="json/groupClientContact?clientId=${groupClient.clientId}"
					method="post" id="dependentx"
					onsubmit="event.preventDefault(); javascript:postFormAndToggleError('dependentx','json/groupClientContact?clientId=${groupClient.clientId}','newDependent','addDepButton'); ">
					<div class="col-lg-5">
						<div class="form-group" id="firstNameCtl">
							<label class="control-label" for="firstName">Contact
								First Name</label>

							<div class="controls">
								<form:input path="firstName" cssClass="form-control"
									id="firstName" placeholder="Enter First Name" />
							</div>
						</div>
						<div class="form-group" id="lastNameCtl">
							<label class="control-label" for="lastName">Contact Last
								Name</label>

							<div class="controls">
								<form:input path="lastName" cssClass="form-control"
									id="lastName" placeholder="Enter Last Name" />
							</div>
						</div>


					</div>
					<div class="col-lg-offset-2 col-lg-5">
						<div class="form-group" id="emailCtl">
							<label class="control-label" for="email">Email</label>
							<div class="controls">
								<div class="input-group">
									<form:input path="email" cssClass="form-control" id="email"
										placeholder="Enter Email" />
									<div class="input-group-addon">
										<span><i class="glyphicon glyphicon-envelope"></i></span>
									</div>
								</div>
							</div>
						</div>
						<div class="form-group" id="mobilephoneCtl">
							<label class="control-label" for="mobilephone">Mobile No.</label>

							<div class="controls">
								<div class="input-group">
									<form:input path="mobilephone" cssClass="form-control"
										id="mobilephone" placeholder="Enter Mobile Phone Number" />
									<div class="input-group-addon">
										<span><i class='glyphicon glyphicon-phone'></i></span>
									</div>
								</div>
							</div>
						</div>

					</div>

					<div class="col-lg-12">
						<div class="form-group">
							<button class="btn btn-primary btn-lg btn-block has-spinner"
								type="submit" onclick="return $('#dependentx').valid();"
								data-loading-text="<span class='spinner'><i class='icon-spin glyphicon glyphicon-repeat'></i></span> Loading..">SAVE
								AND CONTINUE</button>
						</div>
					</div>
				</form:form>
				<div class="col-lg-12">
					<div class="form-group">
						<button class="btn btn-default btn-lg btn-block has-spinner"
							type="submit"
							onclick=" hideById('${contactCount}'); showById('previewScreen'); return false;"
							data-loading-text="<span class='spinner'><i class='icon-spin glyphicon glyphicon-repeat'></i></span> Loading..">SKIP</button>
					</div>
				</div>
			</div>


			<div id="newAddress" style="display: none;">

				<form:form commandName="groupAddress"
					action="json/groupAddress?clientId=${groupClient.clientId}"
					method="post" id="dependenty"
					onsubmit="event.preventDefault(); javascript:postFormAndToggleError('dependenty','json/groupAddress?clientId=${groupClient.clientId}','newAddress','addDepButton'); ">
					<div class="col-lg-5">
						<div class="form-group" id="addressTypeCtl">
							<label class="control-label" for="addressType">Address
								Type</label>

							<div class="controls">
								<form:select path="addressType" cssClass="form-control"
									id="addressType" placeholder="Enter Address Type">
									<form:option value="">Select One</form:option>
									<form:option value="RESIDENCE">RESIDENCE</form:option>
									<form:option value="OFFICE">OFFICE</form:option>
									<form:option value="MAILING">MAILING</form:option>
									<form:option value="SITE">SITE</form:option>
									<form:option value="OTHER">OTHER</form:option>

								</form:select>
							</div>
						</div>
						<div class="form-group" id="poBoxCtl">
							<label class="control-label" for="poBox">PO BOX</label>

							<div class="controls">
								<form:input path="poBox" cssClass="form-control" id="poBox"
									placeholder="Enter PO Box" />
							</div>
						</div>
						<div class="form-group" id="streetAddressCtl">
							<label class="control-label" for="streetAddress">Street
								Address</label>

							<div class="controls">
								<div class="input-group">
									<form:input path="streetAddress" cssClass="form-control"
										id="streetAddress" placeholder="Enter Street Address" />
									<div class="input-group-addon">
										<span><i class="glyphicon glyphicon-envelope"></i></span>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-offset-2 col-lg-5">

						<div class="form-group" id="suburbCtl">
							<label class="control-label" for="suburb">Suburb No.</label>

							<div class="controls">
								<div class="input-group">
									<form:input path="suburb" cssClass="form-control" id="suburb"
										placeholder="Enter Suburb" />
									<div class="input-group-addon">
										<span><i class='glyphicon glyphicon-phone'></i></span>
									</div>
								</div>
							</div>
						</div>

						<div class="form-group" id="stateCtl">
							<label class="control-label" for="state">State No.</label>

							<div class="controls">
								<div class="input-group">
									<form:input path="state" cssClass="form-control" id="state"
										placeholder="Enter State" />
									<div class="input-group-addon">
										<span><i class='glyphicon glyphicon-phone'></i></span>
									</div>
								</div>
							</div>
						</div>

						<div class="form-group" id="zipCodeCtl">
							<label class="control-label" for="zipCode">ZIP No.</label>

							<div class="controls">
								<div class="input-group">
									<form:input path="zipCode" cssClass="form-control" id="zipCode"
										placeholder="Enter ZIP code" />
									<div class="input-group-addon">
										<span><i class='glyphicon glyphicon-phone'></i></span>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="col-lg-12">
						<div class="form-group">
							<button class="btn btn-primary btn-lg btn-block has-spinner"
								type="submit" onclick="return $('#dependenty').valid();"
								data-loading-text="<span class='spinner'><i class='icon-spin glyphicon glyphicon-repeat'></i></span> Loading..">SAVE
								AND CONTINUE</button>
						</div>
					</div>
				</form:form>
				<div class="col-lg-12">
					<div class="form-group">
						<button class="btn btn-default btn-lg btn-block has-spinner"
							type="submit"
							onclick=" hideById('${contactCount}'); showById('previewScreen'); return false;"
							data-loading-text="<span class='spinner'><i class='icon-spin glyphicon glyphicon-repeat'></i></span> Loading..">SKIP</button>
					</div>
				</div>
			</div>


			<div id="addDepButton">
				<div class="col-lg-12">
					<div class="form-group">
						<button class="btn btn-primary btn-lg btn-block" type="submit"
							onclick="hideById('addDepButton'); showById('newDependent'); $('#dependentx')[0].reset(); ">ADD
							NEW CONTACTS</button>
					</div>
				</div>
				<div class="col-lg-12">
					<div class="form-group">
						<button class="btn btn-primary btn-lg btn-block" type="submit"
							onclick="hideById('addDepButton'); showById('newAddress'); $('#dependenty')[0].reset(); ">ADD
							NEW ADDRESS</button>
					</div>
				</div>
				<div class="col-lg-12">
					<div class="form-group">
						<button class="btn btn-default btn-lg btn-block has-spinner"
							type="submit"
							onclick="hideById('${contactCount}'); showById('previewScreen');"
							data-loading-text="<span class='spinner'><i class='icon-spin glyphicon glyphicon-repeat'></i></span> Loading..">DONE</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div id="previewScreen" style="display: none;">
	<div class="jumbotron">
		<div class="row">
			<div class="col-lg-12">
				<div class="alert alert-info">
					<i class="icon-exclamation-sign"></i> All changes to your account
					are now complete. Thanks for your time!
				</div>
			</div>
			<div class="col-lg-12">
				<div class="form-group">
					<a href="loadClientData?clientId=${groupClient.clientId}"
						class="btn btn-primary btn-lg btn-block has-spinner"
						data-loading-text="<span class='spinner'><i class='icon-spin glyphicon glyphicon-repeat'></i></span> Loading..">VIEW
						SUMMARY</a>
				</div>
			</div>
		</div>
	</div>
</div>

<div id="0">
	<div class="jumbotron">
		<h2>Client Data</h2>
		<div class="row">
			<c:set var="looper" value="1" />
			<div>
				<div class="table-responsive">
					<table class='table table-striped table-bordered table-condensed'>
						<tr class="danger">
							<td><b>No</b></td>
							<td><b>Name</b></td>
							<td><b>Type</b></td>
						</tr>
						<tr>
							<td>${looper}</td>
							<td>${groupClient.clientName}</td>
							<td>Client</td>
						</tr>

						<c:forEach items="${groupClient.groupClientContact}"
							var="groupClientContacts" varStatus="ctr">
							<c:set var="looper" value="${looper +1}"></c:set>
							<tr>
								<td>${looper}</td>
								<td>${groupClientContacts.firstName} ${groupClientContacts.lastName}</td>
								<td>Client Contact</td>
							</tr>
						</c:forEach>
						<c:forEach items="${groupClient.groupAddress}" var="groupAddress"
							varStatus="ctr">
							<c:set var="looper" value="${looper +1}"></c:set>
							<tr>
								<td>${looper}</td>
								<td>${groupAddress.streetAddress}</td>
								<td>${groupAddress.addressType} Address</td>
							</tr>
						</c:forEach>
					</table>
				</div>

				<div class="col-lg-12">
					<div class="form-group">
						<button class="btn btn-primary btn-lg btn-block has-spinner"
							type="submit" onclick="hideById('0'); showById('1');"
							data-loading-text="<span class='spinner'><i class='icon-spin glyphicon glyphicon-repeat'></i></span> Loading..">EDIT</button>
					</div>
				</div>

				<div id="addNewItems">
					<div class="col-lg-12">
						<div class="form-group">
							<button class="btn btn-primary btn-lg btn-block" type="submit"
								onclick="hideById('0'); hideById('addNewItems'); showById('${contactCount}'); showById('newDependent'); $('#dependentx')[0].reset(); ">ADD
								NEW CONTACTS</button>
						</div>
					</div>
					<div class="col-lg-12">
						<div class="form-group">
							<button class="btn btn-primary btn-lg btn-block" type="submit"
								onclick="hideById('0'); hideById('addNewItems'); showById('${contactCount}'); showById('newAddress'); $('#dependenty')[0].reset(); ">ADD
								NEW ADDRESS</button>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(
			function() {
				$('.input-group.date').datepicker({
					format : "dd/mm/yyyy"
				});

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
								mobilephone : {
									required : true
								}
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

	$("#dependentx").validate(
			{
				rules : {
					firstName : {
						required : true
					},
					lastName : {
						required : false
					},
					primaryEmail : {
						required : false,
						email : true
					},
					mobilephone : {
						required : false
					},
					relationship : {
						required : true
					}
				},
				errorClass : "control-group has-error text-danger",
				validClass : "control-group has-success",
				errorElement : "span",
				highlight : function(element, errorClass, validClass) {
					if (element.type === 'radio') {
						this.findByName(element.name).parent("div").parent(
								"div").removeClass(validClass).addClass(
								errorClass);
					} else {
						$(element).parent("div").parent("div").removeClass(
								validClass).addClass(errorClass);
					}
				},
				unhighlight : function(element, errorClass, validClass) {
					if (element.type === 'radio') {
						this.findByName(element.name).parent("div").parent(
								"div").removeClass(errorClass).addClass(
								validClass);
					} else {
						$(element).parent("div").parent("div").removeClass(
								errorClass).addClass(validClass);
					}
				}
			});

	$("#dependent0").validate(
			{
				rules : {
					firstName : {
						required : true
					},
					lastName : {
						required : false
					},
					primaryEmail : {
						required : false,
						email : true
					},
					mobilephone : {
						required : false
					},
					relationship : {
						required : true
					}
				},
				errorClass : "control-group has-error text-danger",
				validClass : "control-group has-success",
				errorElement : "span",
				highlight : function(element, errorClass, validClass) {
					if (element.type === 'radio') {
						this.findByName(element.name).parent("div").parent(
								"div").removeClass(validClass).addClass(
								errorClass);
					} else {
						$(element).parent("div").parent("div").removeClass(
								validClass).addClass(errorClass);
					}
				},
				unhighlight : function(element, errorClass, validClass) {
					if (element.type === 'radio') {
						this.findByName(element.name).parent("div").parent(
								"div").removeClass(errorClass).addClass(
								validClass);
					} else {
						$(element).parent("div").parent("div").removeClass(
								errorClass).addClass(validClass);
					}
				}
			});
</script>
