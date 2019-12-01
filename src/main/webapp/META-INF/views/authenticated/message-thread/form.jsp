<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.message-thread.form.label.title" path="title" />
	<acme:form-moment code="authenticated.message-thread.form.label.creationMoment" path="creationMoment"/>
		
	<!-- Messages -->
	<acme:message code="authenticated.message-thread.messages"/>	
	<c:forEach items="${message}" var="msg">
	    <li>
	    	<Strong>Messages:</Strong>
	    	<p><acme:message code="authenticated.message.title"/>  ${msg.getTitle()}</p>
	    	<p><acme:message code="authenticated.message.creationMoment"/>  ${msg.getCreationMoment()}</p>
	    	<p><acme:message code="authenticated.message.tags"/>  ${msg.getTags()}</p>
	    	<p><acme:message code="authenticated.message.body"/>  ${msg.getBody()}</p>
	    </li>
	</c:forEach>
	
	<acme:form-return code="authenticated.message-thread.form.button.return" />
</acme:form>
