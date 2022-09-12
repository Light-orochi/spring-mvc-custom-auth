<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Light_orochi
  Date: 04/09/2022
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

  <%@include file="common.jsp" %>
  <%@include file="sessionCheck.jsp" %>


</head>
<body>
<div class="container">

  <div class="row">
    <div class="col-md-6 offset-md-3">
      <h1 class="text-center mb-3"> Enter your informations to login</h1>
        <form:form action="login-user" method="POST"  modelAttribute="loginUser">
        <div class="row">
            <%-- check for registration error --%>

          <c:if test="${registrationError != null}">
            <div class="alert alert-danger ">
                ${registrationError}
            </div>
          </c:if>
        </div>
       <%-- <div class="mb-3">
            &lt;%&ndash;&ndash;%&gt; &lt;%&ndash;<spring:message code="Enter name" var="placeholder"/>&ndash;%&gt;
          <label for="name" class="form-label">Name</label>

          <form:input   path="name" cssClass="form-control"  placeholder="name"/>
          <form:errors path="name" cssClass="text-danger" />

        </div>--%>
          <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <form:input path="email" cssClass="form-control" placeholder="email"/>
            <form:errors path="email" cssClass="text-danger" />
          </div>
          <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <form:input   path="password" cssClass="form-control"  placeholder="password"/>
            <form:errors path="password" cssClass="text-danger" />   </div>
       <%-- <div class="mb-3">
          <label for="confirm_password" class="form-label">Confirm Password</label>
          <form:input   path="confirm_password" cssClass="form-control"  placeholder="confirm_password"/>
          <form:errors path="confirm_password" cssClass="text-danger" />    </div>
        <div class="mb-3">
          <label for="number" class="form-label">Number</label>
          <form:input   path="number" cssClass="form-control"  placeholder="number"/>
          <form:errors path="number" cssClass="text-danger" />
        </div>
        <div class="mb-3">
          <label for="address" class="form-label">Address</label>
          <form:input   path="address" cssClass="form-control"  placeholder="address"/>
          <form:errors path="address" cssClass="text-danger" />
        </div>--%>
        <div class="row">
          <button type="submit" class="btn btn-primary btn-lg btn-block">Login</button>
        </div>
      </form:form><br>
      <div>Don't  have an Account <a href="${pageContext.request.contextPath}/" class="link">Register</a></div>
    </div>
  </div>
</div>

</body>
</html>
