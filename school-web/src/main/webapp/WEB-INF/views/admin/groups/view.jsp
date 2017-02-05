<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://code.jquery.com/jquery-3.1.0.js"></script>
        <link rel="stylesheet" type="text/css" href="http://getbootstrap.com/examples/dashboard/dashboard.css"/>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <script src="http://getbootstrap.com/assets/js/ie-emulation-modes-warning.js"></script>
<!--        <script src="${base}/static/angular.js"></script>
        <script src="${base}/static/angularapp/app.js"></script>
        <script src="${base}/static/angularapp/controllers/home-controller.js"></script>-->
        <script type="text/javascript">
            
        </script>
        
        <style type="text/css">
            .absolute{
                position: absolute;
            }
            .main-content{
                float: right;
                width: 83%;
            }
        </style>
    </head>
    <body>
        <%@include file="../common/header-nav.jsp" %>
        <div class="container-fluid">
            <div class="row">
                <%@include file="../common/left_sidebar.jsp" %>
                <div class="row">
                    <div class="main main-content">
                        <div class="table-responsive">
                            <table class="table table-bordered">
                                <thead>
                                </thead>
                                <tbody>
                                    
                                    <tr>
                                        <td class="info">Group</td>
                                        <td class="info">${group.name}</td>
                                    </tr>
                                    <tr>
                                        <td>Time</td>
                                        <td>
                                            <ul>
                                            <c:forEach var="day" items="${group.days}">
                                                <li>${day}</li>
                                            </c:forEach>
                                            </ul>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2  ">
                                            <ul>
                                                <c:forEach var="student" items="${students}">
                                                    <li>
                                                        ${student.lastname}&nbsp;
                                                        ${student.lastname}&nbsp;
                                                </c:forEach>
                                            </ul>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                            <a class="btn btn-primary" href="${base}/admin/groups">
                                back
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
