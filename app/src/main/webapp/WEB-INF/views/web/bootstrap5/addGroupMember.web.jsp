<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="jumbotron">
	<div class="p-3 p-lg-5 mb-4 bg-light rounded-3">
	<div class="container py-3">
		<h2 class="mb-4">Add Group Member</h2>

		<form:form commandName="groupMember" action="saveGroupMember" method="post" id="groupMember">
			<div class="row">
				<div class="col-lg-6">
					<div class="mb-3">
						<label for="firstName" class="form-label">First Name</label>
						<form:input path="firstName" cssClass="form-control" id="firstName" placeholder="Enter First Name"/>
					</div>
					<div class="mb-3">
						<label for="lastName" class="form-label">Last Name</label>
						<form:input path="lastName" cssClass="form-control" id="lastName" placeholder="Enter Last Name"/>
					</div>
					<div class="mb-3">
						<label for="aliasName" class="form-label">Alias</label>
						<form:input path="aliasName" cssClass="form-control" id="aliasName" placeholder="e.g Sam"/>
					</div>
					<div class="mb-3">
						<label for="primaryEmail" class="form-label">Email</label>
						<div class="input-group">
							<form:input path="primaryEmail" cssClass="form-control" id="primaryEmail" placeholder="Enter Email"/>
							<span class="input-group-text"><i class="bi bi-envelope-fill"></i></span>
						</div>
					</div>
					<div class="mb-3">
						<label for="birthday" class="form-label">DOB</label>
						<div class="input-group" id="birthdayPicker" data-td-target-input="nearest" data-td-target-toggle="nearest">
							<form:input path="birthday" cssClass="form-control" id="birthday"
										data-td-target="#birthday" data-td-toggle="datetimepicker" placeholder="Enter DOB"/>
							<span class="input-group-text" data-td-target="#birthday" data-td-toggle="datetimepicker">
            <i class="bi bi-calendar-date-fill"></i>
        </span>
						</div>
					</div>
					<div class="mb-3">
						<label for="mobilephone" class="form-label">Mobile No.</label>
						<div class="input-group">
							<form:input path="mobilephone" cssClass="form-control" id="mobilephone" placeholder="Enter Mobile Phone Number"/>
							<span class="input-group-text"><i class="bi bi-phone-fill"></i></span>
						</div>
					</div>
					<div class="mb-3">
						<label for="otherPhone" class="form-label">Home Phone No</label>
						<div class="input-group">
							<form:input path="otherPhone" cssClass="form-control" id="otherPhone" placeholder="Enter Home Phone Number"/>
							<span class="input-group-text"><i class="bi bi-telephone-fill"></i></span>
						</div>
					</div>
				</div>

				<div class="col-lg-6">
					<div class="mb-3">
						<label for="memberCategoryCode" class="form-label">Member Category Code</label>
						<form:select path="memberCategoryCode" cssClass="form-select" id="memberCategoryCode">
							<option value="">Select One</option>
						</form:select>
					</div>
					<div class="mb-3">
						<label class="form-label">Membership Fees Paid?</label>
						<div>
							<div class="form-check form-check-inline">
								<form:radiobutton path="paidMember" cssClass="form-check-input" id="paidYes" value="true"
												  onclick="$('#moreDetails').show();"/>
								<label class="form-check-label" for="paidYes">Yes</label>
							</div>
							<div class="form-check form-check-inline">
								<form:radiobutton path="paidMember" cssClass="form-check-input" id="paidNo" value="false"
												  onclick="$('#moreDetails').hide();"/>
								<label class="form-check-label" for="paidNo">No</label>
							</div>
						</div>
					</div>

					<div id="moreDetails" style="display: none;">
						<div class="mb-3">
							<label for="membershipStartDate" class="form-label">Membership Dates</label>
							<div class="input-group mb-2" id="membershipRangePicker" data-td-target-input="nearest" data-td-target-toggle="nearest">
								<span class="input-group-text"><i class="bi bi-calendar-date-fill"></i></span>
								<form:input path="membershipStartDate" cssClass="form-control" id="membershipStartDate" placeholder="Start Date"
											data-td-target="#membershipStartDate"/>
								<span class="input-group-text">TO</span>
								<form:input path="membershipEndDate" cssClass="form-control" id="membershipEndDate" placeholder="End Date"
											data-td-target="#membershipEndDate"/>
							</div>
						</div>

						<div class="mb-3">
							<label for="adultCount" class="form-label">Adult Count</label>
							<form:input path="adultCount" cssClass="form-control" id="adultCount" placeholder="No. of Adults"/>
						</div>

						<div class="mb-3">
							<label for="kidCount" class="form-label">Kid Count</label>
							<form:input path="kidCount" cssClass="form-control" id="kidCount" placeholder="No. of Kids"/>
						</div>

						<div class="mb-3">
							<label for="paidMembershipAmount" class="form-label">Membership Amount Paid</label>
							<div class="input-group">
								<span class="input-group-text"><i class="bi bi-currency-dollar"></i></span>
								<form:input path="paidMembershipAmount" cssClass="form-control" id="paidMembershipAmount" placeholder="Amount Paid"/>
							</div>
						</div>
					</div>
				</div>

				<div class="col-12 mt-4">
					<form:hidden path="groupCode" id="groupCode"/>
					<input type="submit" value="SUBMIT" class="btn btn-primary btn-lg w-100 mb-2"/>
					<a href="${pageContext.request.contextPath}/${sessionScope.groupCode}/" class="btn btn-secondary btn-lg w-100">CANCEL</a>
				</div>
			</div>
		</form:form>
	</div>
	</div>
</div>
	<script type="text/javascript">
		$(document).ready(function () {
			new tempusDominus.TempusDominus(document.getElementById('birthdayPicker'), {
				display: { components: { clock: false } },
				localization: { format: 'dd/MM/yyyy' },
				useCurrent: false
			});

			const startPickerEl = document.getElementById('membershipStartDate');
			const endPickerEl = document.getElementById('membershipEndDate');

			const startPicker = new tempusDominus.TempusDominus(startPickerEl, {
				display: { components: { clock: false } },
				localization: { format: 'dd/MM/yyyy' },
				useCurrent: false
			});

			const endPicker = new tempusDominus.TempusDominus(endPickerEl, {
				display: { components: { clock: false } },
				localization: { format: 'dd/MM/yyyy' },
				useCurrent: false
			});

			// Link the two date pickers
			startPicker.subscribe(tempusDominus.Namespace.events.change, (e) => {
				endPicker.updateOptions({
					restrictions: {
						minDate: e.date
					}
				});
			});

			endPicker.subscribe(tempusDominus.Namespace.events.change, (e) => {
				startPicker.updateOptions({
					restrictions: {
						maxDate: e.date
					}
				});
			});

			$('#groupMember').validate({
				rules: {
					firstName: { required: true },
					lastName: { required: false },
					primaryEmail: { required: true, email: true },
					adultCount: { number: true },
					kidCount: { number: true },
					mobilephone: { maxlength: 13 },
					otherPhone: { maxlength: 13 },
					paidMembershipAmount: { number: true },
					memberCategoryCode: { required: true }
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
			});

			$('#moreDetails').hide();
			buildGroupMemberCategoriesOptions('memberCategoryCode');
		});
	</script>