<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Light_orochi
  Date: 07/09/2022
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common.jsp"%>
<html>
<head>
    <title>User Panel:Welcome</title>
</head>
<body>

<div class="container">
    <h1 class="alert alert-success">Welcome to name:${sessionScope.name} email: ${sessionScope.email}   </h1>


</div>

 <form:form action="logout" >
     <button type="submit" class="btn btn-primary btn-lg btn-block"  id="logout"  >logout</button>
 </form:form>
</body>
</html>
<script>
    let logout= document.getElementById("logout");

    logout.addEventListener("click",function (){
        if(confirm("are you sure to logout")){
            return true;
        }
        return false;
    });

</script>