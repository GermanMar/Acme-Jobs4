<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>

    <acme:list-column code="administrator.commercial.list.label.banner" path="banner" width="20%"/>
    <acme:list-column code="administrator.commercial.list.label.slogan" path="slogan" width="40%"/>      
    <acme:list-column code="administrator.commercial.list.label.url" path="url" width="40%"/>     
    <acme:list-column code="administrator.commercial.list.label.card" path="card" width="40%"/>      
	
</acme:list>