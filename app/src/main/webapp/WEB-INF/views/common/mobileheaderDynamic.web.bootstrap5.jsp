<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" data-bs-theme="light">
	<div class="container-fluid">
		<a class="navbar-brand active" href="#">
			<c:choose>
				<c:when test="${sessionScope.group ne null and sessionScope.group.description ne null}">
					<c:out value="${sessionScope.group.description}" />
				</c:when>
				<c:otherwise>Portal</c:otherwise>
			</c:choose>
		</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#header-navbar" aria-controls="header-navbar" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="header-navbar">
			<c:if test="${sessionScope.group ne null}">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<c:forEach items="${sessionScope.groupMainLinks}" var="groupMainLink">
						<c:if test="${groupMainLink.visibleToUser}">
							<li class="nav-item dropdown">
								<a class="nav-link dropdown-toggle" href="#" id="dropdown-${groupMainLink.linkName}" role="button" data-bs-toggle="dropdown" aria-expanded="false">
										${groupMainLink.linkName}
								</a>
								<ul class="dropdown-menu" aria-labelledby="dropdown-${groupMainLink.linkName}">
									<c:forEach items="${groupMainLink.groupSubLinksForUI}" var="groupSubLink" varStatus="status">
										<c:if test="${groupSubLink.visibleToUser}">
											<c:choose>
												<c:when test="${groupSubLink.divider}">
													<li><hr class="dropdown-divider" /></li>
												</c:when>
												<c:when test="${groupSubLink.javascript ne null and !empty groupSubLink.javascript}">
													<li><a class="dropdown-item" href="#" onclick="javascript:${groupSubLink.javascript}">${groupSubLink.linkName}</a></li>
												</c:when>
												<c:when test="${groupSubLink.url ne null and groupSubLink.url ne '#'}">
													<li><a class="dropdown-item" href="${groupSubLink.url}">${groupSubLink.linkName}</a></li>
												</c:when>
											</c:choose>
										</c:if>
									</c:forEach>
								</ul>
							</li>
						</c:if>
					</c:forEach>
				</ul>
			</c:if>

			<c:if test="${sessionScope.groupName ne null}">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<li class="nav-item dropdown">
						<c:choose>
							<c:when test="${sessionScope.user ne null || not empty sessionScope.user}">
								<a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
									<i class="bi bi-person-circle me-1"></i>Welcome, ${user.userName}
								</a>
								<ul class="dropdown-menu dropdown-menu-end" aria-labelledby="userDropdown">
									<li><a class="dropdown-item" href="logoutUser">Logout</a></li>
								</ul>
							</c:when>
							<c:when test="${sessionScope.groupMember ne null}">
								<a class="nav-link" href="#"><i class="bi bi-person-circle me-1"></i>Welcome,
									<c:choose>
										<c:when test="${!empty sessionScope.groupMember.aliasName}">${sessionScope.groupMember.aliasName}</c:when>
										<c:otherwise>${sessionScope.groupMember.firstName} ${sessionScope.groupMember.lastName}</c:otherwise>
									</c:choose>
								</a>
							</c:when>
							<c:otherwise>
								<a class="nav-link dropdown-toggle" href="#" id="loginDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
									User Sign In
								</a>
								<div class="dropdown-menu dropdown-menu-end p-4" style="min-width: 300px;">
									<form id="loginUserForm1" method="post" action="loginUser" onsubmit="return validateFormAndToggleButton('loginUserForm1');">
										<div class="mb-3">
											<label for="username_lgn" class="form-label">Username</label>
											<input type="text" class="form-control" id="username_lgn" name="username" placeholder="Username" />
										</div>
										<div class="mb-3">
											<label for="password_lgn" class="form-label">Password</label>
											<input type="password" class="form-control" id="password_lgn" name="password" placeholder="Password" />
										</div>
										<div class="mb-3">
											<button type="submit" class="btn btn-primary w-100">Login</button>
										</div>
										<div class="mb-3 text-center">
											<a href="#">Forgot your password?</a>
										</div>
									</form>
								</div>
							</c:otherwise>
						</c:choose>
					</li>
				</ul>
			</c:if>
		</div>
	</div>
</nav>
