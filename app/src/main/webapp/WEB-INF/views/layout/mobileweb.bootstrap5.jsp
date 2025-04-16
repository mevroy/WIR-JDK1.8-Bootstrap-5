<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
    <title><c:if test="${groupName ne null}"><c:out value="${groupName}"/> - </c:if><tiles:insertAttribute name="title" ignore="true"/></title>  
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/res/custom/images/email/generic/${sessionScope.groupCode}Logo.png">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=yes">

    <!-- Bootstrap 5.3.3 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <!-- Bootstrap 5.3.3 JS Bundle (includes Popper) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" crossorigin="anonymous"></script>

    <!-- Tempus Dominus DateTime Picker CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@eonasdan/tempus-dominus@6.9.4/dist/css/tempus-dominus.min.css" crossorigin="anonymous">    <!-- Bootstrap Icons 1.10.5 CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" integrity="sha384-Ay26V7L8bsJTsX9Sxclnvsn+hkdiwRnrjZJXqKmkIDobPgIIWBOVguEcQQLDuhfN" crossorigin="anonymous">


    <!-- Optional Custom Styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/js/css/jquery-ui.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/app.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/sticky.css"/>

    <!-- jQuery (required for jQuery UI) -->
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>

    <!-- jQuery UI (if still used elsewhere) -->
    <script src="${pageContext.request.contextPath}/res/js/jquery/jquery-ui.min.js"></script>


    <!-- Tempus Dominus JS -->
    <script src="https://cdn.jsdelivr.net/npm/@eonasdan/tempus-dominus@6.9.4/dist/js/tempus-dominus.min.js" crossorigin="anonymous"></script>

    <!-- Other Custom Scripts -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery/jquery.validate/1.15.0/jquery.validate.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery/jquery.validate/1.15.0/additional-methods.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery/jquery.countdown.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/res/js/notify/notify.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/res/bootstrap/5.0.0/js/custom-bootstrap5.js"></script>

    
    
</head>
<body>
<!-- page -->
<div class="wrapper">
    <div class="container">
        <!-- header  -->
        <header id="header">
            <tiles:insertAttribute name="header"/>
        </header> 
        <!-- /header -->

        <!-- message -->
        <div id="message">
            <tiles:insertAttribute name="message"/>
        </div>
        <!-- /header -->

        <!-- content -->
        <div id="content">
            <tiles:insertAttribute name="content"/>
        </div>
        <!-- /content -->
    </div>
    <div class="push"><!--//--></div>
</div>
<!-- /page -->
<!-- footer -->
<footer>
    <div class="container">
        <tiles:insertAttribute name="footer"/>
    </div>
</footer>
<!-- /footer -->
</body>
</html>
