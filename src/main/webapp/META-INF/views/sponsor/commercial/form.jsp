<%@ page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="sponsor.commercial.form.label.banner" path="banner" />
	<acme:form-textbox code="sponsor.commercial.form.label.slogan" path="slogan" />
	<acme:form-textbox code="sponsor.commercial.form.label.url" path="url" />
	<acme:form-textbox code="sponsor.commercial.form.label.card" path="card" />

	<acme:form-return code="sponsor.commercial.form.button.return" />
</acme:form>

