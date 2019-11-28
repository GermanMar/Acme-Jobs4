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

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="false">
	<acme:form-textbox code="employer.offer.form.label.reference" path="reference" />
	<acme:form-textbox code="employer.offer.form.label.title" path="title" />
	<acme:form-moment code="employer.offer.form.label.deadline" path="deadline"/>
	<acme:form-money code="employer.offer.form.label.salary" path="salary"/>
	<acme:form-url code="employer.offer.form.label.moreInfo" path="moreInfo"/>
	<acme:form-textarea code="employer.offer.form.label.description" path="description"/>
	<acme:message code="employer.job.descriptor"/>
	<acme:form-textarea readonly="true" code="employer.job.form.label.descriptor" path="descriptor"/>
	
	<acme:form-submit
	code="authenticated.job.form.button.duty"
	method = "get"
	action="/authenticated/duty/list"/>
						
	<acme:form-return code="employer.offer.form.button.return" />
</acme:form>
