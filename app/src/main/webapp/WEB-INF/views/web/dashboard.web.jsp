<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="tabbable tabs-left">
    <ul class="nav nav-tabs">
        <li class="active"><a href="#option1" data-toggle="tab">News</a></li>
    </ul>
    <div class="tab-content">
        <div class="tab-pane active" id="option1">
            <p>						Welcome back
						<c:out value="${sessionScope.user.userName}" />
						!</p>
        </div>
    </div>
</div>