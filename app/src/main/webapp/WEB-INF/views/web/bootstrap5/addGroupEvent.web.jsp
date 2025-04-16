<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="jumbotron">
	<div class="p-3 p-lg-5 card shadow-lg rounded-3 mb-4">
		<div class="card-body">
			<form:form commandName="groupEvent" action="saveGroupEvent" method="post" id="groupEvent">
				<h2 class="mb-4">Add a New Group Event</h2>
				<div class="row g-4">
					<!-- Column 1 -->
					<div class="col-md-6">
						<div class="mb-4">
							<label for="eventCode" class="form-label">Group Event Code</label>
							<div class="input-group">
								<form:input path="eventCode" cssClass="form-control" id="eventCode" placeholder="Enter Event Code"/>
								<span class="input-group-text"><i class="bi bi-envelope-fill"></i></span>
							</div>
						</div>

						<div class="mb-4">
							<label for="eventName" class="form-label">Group Event Name</label>
							<div class="input-group">
								<form:input path="eventName" cssClass="form-control" id="eventName" placeholder="Enter Event Name"/>
								<span class="input-group-text"><i class="bi bi-person-fill"></i></span>
							</div>
						</div>

						<div class="mb-4">
							<label for="description" class="form-label">Group Event Description</label>
							<div class="input-group">
								<form:input path="description" cssClass="form-control" id="description" placeholder="Enter Description"/>
								<span class="input-group-text"><i class="bi bi-pencil-fill"></i></span>
							</div>
						</div>

						<div class="mb-4">
							<label for="groupCode" class="form-label">Group Code</label>
							<div class="input-group">
								<form:input path="groupCode" cssClass="form-control" readonly="true" id="groupCode" placeholder="Enter 3 digit Group Code"/>
								<span class="input-group-text"><i class="bi bi-lock-fill"></i></span>
							</div>
						</div>

						<div class="mb-4">
							<label for="memberCategoryCode" class="form-label">Member Category Code</label>
							<div class="input-group">
								<form:select path="memberCategoryCode" cssClass="form-select" id="memberCategoryCode">
									<option value="">Select One</option>
								</form:select>
							</div>
						</div>

						<div class="mb-4">
							<label for="eventDate" class="form-label">Event Date Time</label>
							<div class="input-group">
								<form:input path="eventDate" cssClass="form-control datetimepicker" id="eventDate" placeholder="Event Date"/>
								<span class="input-group-text"><i class="bi bi-calendar-check-fill"></i></span>
							</div>
						</div>

						<div class="mb-4">
							<label for="rsvpDeadlineDate" class="form-label">RSVP Deadline Date Time</label>
							<div class="input-group">
								<form:input path="rsvpDeadlineDate" cssClass="form-control datetimepicker" readonly="readonly" id="rsvpDeadlineDate" placeholder="RSVP Deadline Date"/>
								<span class="input-group-text"><i class="bi bi-calendar-x-fill"></i></span>
							</div>
						</div>

						<div class="mb-4">
							<label for="expiryDate" class="form-label">Event Expiry Date</label>
							<div class="input-group">
								<form:input path="expiryDate" cssClass="form-control datetimepicker" readonly="readonly" id="expiryDate" placeholder="Date after which event is invisible"/>
								<span class="input-group-text"><i class="bi bi-clock-fill"></i></span>
							</div>
						</div>

						<div class="mb-4">
							<label for="groupEventInviteCodeLength" class="form-label">Event Code Length</label>
							<div class="input-group">
								<form:input path="groupEventInviteCodeLength" cssClass="form-control" id="groupEventInviteCodeLength" placeholder="Enter Event Code Length"/>
								<span class="input-group-text"><i class="bi bi-key-fill"></i></span>
							</div>
						</div>

						<div class="mb-4">
							<label class="form-label">Email RSVP Allowed?</label><br />
							<div class="form-check form-check-inline">
								<form:radiobutton path="emailRsvpAllowed" cssClass="form-check-input" id="emailRsvpAllowed1" value="true" />
								<label class="form-check-label" for="emailRsvpAllowed1">Yes</label>
							</div>
							<div class="form-check form-check-inline">
								<form:radiobutton path="emailRsvpAllowed" cssClass="form-check-input" id="emailRsvpAllowed2" value="false" />
								<label class="form-check-label" for="emailRsvpAllowed2">No</label>
							</div>
						</div>
					</div>

					<!-- Column 2 -->
					<div class="col-md-6">
						<div class="mb-4">
							<label for="maxNumberOfPasses" class="form-label">No. of Event Passes</label>
							<div class="input-group">
								<form:input path="maxNumberOfPasses" cssClass="form-control" id="maxNumberOfPasses" placeholder="Enter max number of passes"/>
								<span class="input-group-text"><i class="bi bi-ticket-detailed-fill"></i></span>
							</div>
						</div>

						<div class="mb-4">
							<label for="externalSurveyRedirectUrl" class="form-label">External Feedback/Survey URL</label>
							<div class="input-group">
								<form:input path="externalSurveyRedirectUrl" cssClass="form-control" id="externalSurveyRedirectUrl" placeholder="Enter Feedback URL"/>
								<span class="input-group-text"><i class="bi bi-link-45deg"></i></span>
							</div>
						</div>

						<div class="mb-4">
							<label for="eventOrganiser" class="form-label">Event Organiser</label>
							<div class="input-group">
								<form:input path="eventOrganiser" cssClass="form-control" id="eventOrganiser" placeholder="Enter Organizer Name"/>
								<span class="input-group-text"><i class="bi bi-person-badge-fill"></i></span>
							</div>
						</div>

						<!-- Radio buttons for Participation and Event types -->

						<!-- Participation Allowed -->
						<div class="mb-4">
							<label class="form-label">Outside Participation Allowed?</label><br />
							<div class="form-check form-check-inline">
								<form:radiobutton path="outsideParticipationAllowed" cssClass="form-check-input" id="outsideParticipationAllowed1" value="true" />
								<label class="form-check-label" for="outsideParticipationAllowed1">Yes</label>
							</div>
							<div class="form-check form-check-inline">
								<form:radiobutton path="outsideParticipationAllowed" cssClass="form-check-input" id="outsideParticipationAllowed2" value="false" />
								<label class="form-check-label" for="outsideParticipationAllowed2">No</label>
							</div>
						</div>

						<!-- Paid Event -->
						<div class="mb-4">
							<label class="form-label">Paid Event?</label><br />
							<div class="form-check form-check-inline">
								<form:radiobutton path="paidEvent" cssClass="form-check-input" id="paidEvent1" value="true" />
								<label class="form-check-label" for="paidEvent1">Yes</label>
							</div>
							<div class="form-check form-check-inline">
								<form:radiobutton path="paidEvent" cssClass="form-check-input" id="paidEvent2" value="false" />
								<label class="form-check-label" for="paidEvent2">No</label>
							</div>
						</div>

						<!-- Pricing Inputs -->
						<div class="mb-4">
							<label class="form-label">Member's Price</label>
							<div class="input-group mb-2">
								<span class="input-group-text">Adult $</span>
								<form:input path="amountPerAdulthead" cssClass="form-control" id="amountPerAdulthead" placeholder="Adult Price"/>
							</div>
							<div class="input-group">
								<span class="input-group-text">Child $</span>
								<form:input path="amountPerKidHead" cssClass="form-control" id="amountPerKidHead" placeholder="Child Price"/>
							</div>
						</div>

						<div class="mb-4">
							<label class="form-label">Non-Member's Price</label>
							<div class="input-group mb-2">
								<span class="input-group-text">Adult $</span>
								<form:input path="amountPerNMAdulthead" cssClass="form-control" id="amountPerNMAdulthead" placeholder="Non-Member Adult"/>
							</div>
							<div class="input-group">
								<span class="input-group-text">Child $</span>
								<form:input path="amountPerNMKidHead" cssClass="form-control" id="amountPerNMKidHead" placeholder="Non-Member Child"/>
							</div>
						</div>

						<div class="mb-4">
							<label for="amountPerFamily" class="form-label">Amount per Family</label>
							<div class="input-group">
								<form:input path="amountPerFamily" cssClass="form-control" id="amountPerFamily" placeholder="Amount Per Family"/>
								<span class="input-group-text"><i class="bi bi-person-fill"></i></span>
							</div>
						</div>

						<!-- Immediate Invite Sent -->
						<div class="mb-4">
							<label class="form-label">Immediate Invite Sent?</label><br />
							<div class="form-check form-check-inline">
								<form:radiobutton path="eventInviteSentImmediately" cssClass="form-check-input" id="eventInviteSentImmediately1" value="true" />
								<label class="form-check-label" for="eventInviteSentImmediately1">Yes</label>
							</div>
							<div class="form-check form-check-inline">
								<form:radiobutton path="eventInviteSentImmediately" cssClass="form-check-input" id="eventInviteSentImmediately2" value="false" />
								<label class="form-check-label" for="eventInviteSentImmediately2">No</label>
							</div>
						</div>
						<div class="mb-4">
							<label class="form-label">Immediate Invite Sent?</label><br />
							<div class="form-check form-check-inline">
								<form:radiobutton path="autoResponseForRSVPAllowed" cssClass="form-check-input" id="autoResponseForRSVPAllowed1" value="true" />
								<label class="form-check-label" for="autoResponseForRSVPAllowed1">Yes</label>
							</div>
							<div class="form-check form-check-inline">
								<form:radiobutton path="autoResponseForRSVPAllowed" cssClass="form-check-input" id="autoResponseForRSVPAllowed2" value="false" />
								<label class="form-check-label" for="autoResponseForRSVPAllowed2">No</label>
							</div>
						</div>
						<div class="mb-4">
							<label for="autoResponseRSVPTemplate" class="form-label">RSVP
								Email Template Name</label>
							<div class="input-group">
								<form:select path="autoResponseRSVPTemplate" cssClass="form-select" id="autoResponseRSVPTemplate">
									<option value="">Select One</option>
								</form:select>
							</div>
						</div>
						<div class="mb-4">
							<label for="processCompletionTemplate" class="form-label">Process Completion
								Email Template Name</label>
							<div class="input-group">
								<form:select path="processCompletionTemplate" cssClass="form-select" id="processCompletionTemplate">
									<option value="">Select One</option>
								</form:select>
							</div>
						</div>

					</div>
					<div class="col-12 mt-4">
						<input type="submit" value="SUBMIT" class="btn btn-primary btn-lg w-100 mb-2"/>
						<a href="${pageContext.request.contextPath}/${sessionScope.groupCode}/" class="btn btn-secondary btn-lg w-100">CANCEL</a>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</div>



<script type="text/javascript">
	$(document).ready(
			function() {
				$("#groupEvent").validate(
						{
							rules : {
								eventCode : {
									required : true,
									minlength : 7,
									maxlength : 7
								},
								eventName : {
									required : true,
									maxlength : 25
								},
								groupCode : {
									required : true,
									minlength : 3,
									maxlength : 3
								},
								eventDate : {
									required : true,
									//dateITA : true
								},
								rsvpDeadlineDate : {
									//dateITA : true
								},
								groupEventInviteCodeLength : {
									number : true
								},
								maxNumberOfPasses : {
									number : true
								},
								externalSurveyRedirectUrl : {
									url : true
								},
								amountPerAdulthead : {
									number : true
								},
								amountPerKidHead : {
									number : true
								},
								amountPerNMAdulthead : {
									number : true
								},
								amountPerNMKidHead : {
									number : true
								}
							},
							errorClass: "text-danger",
							errorElement: "div",
							highlight: function (element) {
								$(element).addClass("is-invalid");
							},
							unhighlight: function (element) {
								$(element).removeClass("is-invalid");
							},
							errorPlacement: function (error, element) {
								if (element.closest('.input-group').length) {
									// Place error *after* .input-group container
									error.insertAfter(element.closest('.input-group'));
								} else {
									error.insertAfter(element);
								}
							}
						})

			});

	$(function() {
		$('#autoResponseRSVPTemplateCtl').hide();
		buildGroupMemberCategoriesOptions('memberCategoryCode');
		buildGroupEmailTemplateOptionsByEventCode("NULL",
				'autoResponseRSVPTemplate');
		buildGroupEmailTemplateOptionsByEventCode("NULL",
				'processCompletionTemplate');
	});
</script>
