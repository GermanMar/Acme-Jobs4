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

<acme:form readonly="false">
	<acme:form-textbox code="authenticated.job.form.label.reference" path="reference" />
	<acme:form-textbox code="authenticated.job.form.label.title" path="title" />
	<acme:form-moment code="authenticated.job.form.label.deadline" path="deadline"/>
	<acme:form-money code="authenticated.job.form.label.salary" path="salary"/>
	<acme:form-url code="authenticated.job.form.label.moreInfo" path="moreInfo"/>
	<acme:form-textarea code="authenticated.job.form.label.description" path="description"/>
	
	<acme:message code="authenticated.job.descriptor"/>
	<acme:form-textarea readonly="true" code="authenticated.job.form.label.descriptor" path="descriptor"/>
	
	<acme:message code="authenticated.job.duties"/>
	<c:forEach items="${duties}" var="duty">
	    <li>
	    	<Strong>Duty:</Strong>
	    	<p><acme:message code="authenticated.job.title"/>  ${duty.getTitle()}</p>
	    	<p><acme:message code="authenticated.job.description"/>  ${duty.getDescription()}</p>
	    	<p><acme:message code="authenticated.job.percent"/>  ${duty.getPercent()}</p>
	    </li>
	</c:forEach>
		
	<acme:form-return code="authenticated.job.form.button.return" />
</acme:form>
