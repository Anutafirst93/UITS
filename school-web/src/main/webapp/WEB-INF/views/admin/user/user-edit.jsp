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
        <script type="text/javascript">
            
        </script>
        
        <style type="text/css">
            .absolute{
                position: absolute;
            }
            .main-content{
                float: right;
                width: 82%;
            }
            .head-left{
                width: 240px;
            }
            .fit-content{
                padding-left: 30px;
                padding-right: 30px;
            }
            .tbl-right{
                width: 600px;
            }
            .tbl-user{
                width: 840px;
            }
            .tbl-user-label{
                float: right;
                margin-right: 30px;
            }
            .chbox-medium{
                width: 20px;
                height: 20px;
            }
            
        </style>
    </head>
    <body>
        <%@include file="../common/header-nav.jsp" %>
        <div class="container-fluid fit-content">
            <div class="row">
                <%@include file="../common/left_sidebar.jsp" %>
                <div class="row">
                    <div class="main main-content">
                        <div class="table-responsive">
                            <form method="POST">
                            <table class="table table-bordered tbl-user">                                                   
                                <thead>
                                    <tr class="info">
                                        <th class="head-left">&nbsp;</th>
                                        <th class="tbl-right">&nbsp;</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class="info">
                                        <td>
                                            <div class=" tbl-user-label">
                                                <label for="user-firstname" class="col-sm-2 control-label tbl-user-label">Firstname</label>
                                            </div>
                                        </td>
                                        <td>
                                            <input type="text" name="firstname" class="form-control" value="${user.firstname}" id="user-firstname"/>
                                        </td>
                                    </tr>
                                    <tr class="info">
                                        <td>
                                            <div class=" tbl-user-label">
                                                <label for="user-lastname" class="col-sm-2 control-label tbl-user-label">Lastname</label>
                                            </div>
                                        </td>
                                        <td>
                                            <input type="text" name="lastname" class="form-control" value="${user.lastname}" id="user-lastname"/>
                                        </td>
                                    </tr>
                                    <tr class="info">
                                        <td>
                                            <div class=" tbl-user-label">
                                                <label for="user-email" class="col-sm-2 control-label tbl-user-label">Email</label>
                                            </div>
                                        </td>
                                        <td>
                                            <input type="text" name="email" class="form-control" value="${user.email}" id="user-email"/>
                                        </td>
                                    </tr>
                                    <tr class="info">
                                        <td>
                                            <div class=" tbl-user-label">
                                                <label for="user-phone" class="col-sm-2 control-label tbl-user-label">Phone</label>
                                            </div>
                                        </td>
                                        <td>
                                            <input type="text" name="phone" class="form-control" value="${user.phone}" id="user-phone"/>
                                        </td>
                                    </tr>
                                    <tr class="info">
                                        <td>Group</td>
                                        <td>
                                            <select class="form-control" name="role">
                                                <c:forEach var="role" items="${roles}">
                                                    <c:choose>
                                                        <c:when test="${user.userRole.rolename == role}">
                                                            <option value="${role.role}" selected="selected">${role.role}</option>
                                                        </c:when>
                                                        
                                                        <c:otherwise>
                                                            <option value="${role.role}">${role.role}</option>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                    
                                    <tr class="info">
                                        <td>&nbsp;</td>
                                        <td>
                                            <input type="submit" class="btn btn-primary" value="Save">
                                            <a href="${base}/admin/home" class="btn btn-primary">Cancel</a>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
