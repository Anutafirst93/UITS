<%-- 
    Document   : left_sidebar
    Created on : Oct 7, 2016, 12:50:37 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="url">${req.requestURL}</c:set>
<c:set var="uri" value="${req.requestURI}" />
<c:set var="base" value="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}" />
<div class="col-sm-3 col-md-2 sidebar absolute">
    <ul class="nav nav-sidebar">
        <li class="active"><a href="${base}/admin/users">Users <span class="sr-only">(current)</span></a></li>
        <li><a href="${base}/admin/groups">Security Groups</a></li>
        <li><a href="${base}/admin/postings">Postings</a></li>
        <li><a href="${base}/admin/sessions">My Sessions</a></li>
        <li><a href="${base}/admin/config">Configuration</a></li>
    </ul>
</div>