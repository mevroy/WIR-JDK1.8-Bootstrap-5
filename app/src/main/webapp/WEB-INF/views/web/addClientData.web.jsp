<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id="1">
	<div class="jumbotron">
		<h2>Add Client</h2>

		<div class="row">
			<div>


				<form:form commandName="groupClient" action="groupClient"
					method="post" id="groupClient">

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
