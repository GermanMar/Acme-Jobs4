<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<h2>	
	<acme:message code="administrator.dashboard.form.title.company" />
</h2>
<acme:form-integer code="administrator.dashboard.form.totalAnnounencents" path="totalAnnouncements"/>
<acme:form-integer code="administrator.dashboard.form.totalInvestor" path="totalInvestor"/>
<acme:form-integer code="administrator.dashboard.form.totalCompany" path="totalCompany"/>
<acme:form-double code="administrator.dashboard.form.minimumRequest" path="minimumRequest"/>
<acme:form-double code="administrator.dashboard.form.maximumRequest" path="maximumRequest"/>
<acme:form-double code="administrator.dashboard.form.averageRequest" path="averageRequest"/>
<acme:form-double code="administrator.dashboard.form.desviationRequest" path="desviationRequest"/>
<acme:form-double code="administrator.dashboard.form.minimumOffers" path="minimumOffers"/>
<acme:form-double code="administrator.dashboard.form.maximumOffers" path="maximumOffers"/>
<acme:form-double code="administrator.dashboard.form.averageOffers" path="averageOffers"/>
<acme:form-double code="administrator.dashboard.form.desviationOffers" path="desviationOffers"/>


<div>
	<canvas id="canvas1"></canvas>
</div>

<script type="text/javascript">
	$(document).ready(function(){
		var data = {
				labels: [
					<jstl:forEach var="items" items="${labels}">
					<jstl:out value="\"${items}\"" escapeXml="false"/>,
					</jstl:forEach>
				],
				datasets : [
					{
						label: "Company Records",
						data : [
							<jstl:forEach var="numeC" items="${numC}">
							<jstl:out value="\"${numeC}\"" escapeXml="false"/>,
							</jstl:forEach>
						],backgroundColor: [
							<jstl:forEach var="numeC" items="${numC}">
							<jstl:out value="'#FF6384'" escapeXml="false"/>,
							</jstl:forEach>
			            ]	
						
					},{
						label: "Investor Records",
						data : [
							<jstl:forEach var="numeI" items="${numI}">
							<jstl:out value="\"${numeI}\"" escapeXml="false"/>,
							</jstl:forEach>
						],backgroundColor: [
							<jstl:forEach var="numeI" items="${numI}">
							<jstl:out value="'#8463FF'" escapeXml="false"/>,
							</jstl:forEach>
			            ]		
					}
				]		
		};
		
		var options = {
				scales : {
					yAxes : [
						{
							ticks : {
								suggestedMin : 0.0,
								suggestedMax : 10.0
							}
						}
					]
				},
				legend : {
					display : true
				}
		};
		
		var canvas, context;
		
		canvas = document.getElementById("canvas1");
		context = canvas.getContext("2d");
		new Chart(context, {
			type : "bar",
			data : data,
			options : options
		});
	});
</script>
