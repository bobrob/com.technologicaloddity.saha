<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>SAHA Archetype Start Page</title>
<script type='text/javascript' src='<c:url value="/dwr/interface/AjaxTestService.js"/>'></script>
<script type='text/javascript' src='<c:url value="/dwr/engine.js"/>'></script>
<script type='text/javascript' src='<c:url value="/js/jquery-1.3.2.min.js"/>'></script>
<script type='text/javascript' src='<c:url value="/js/saha.js"/>'></script>
<script type='text/javascript'>

	function simpleAjaxTest() {
		AjaxTestService.getServiceName(function(data) {
			$('#ajaxDiv').html(data);
		});
	}

	function showMultiplicationTable(number) {
		AjaxTestService.showMultiplicationTable(number, applyAjaxResults);
	}

	function saveName() {
		var name = $('#name').val();
		if(name) {
			AjaxTestService.storeName(name, applyAjaxResults);
		}
	}

	function removeName() {
		AjaxTestService.removeName(applyAjaxResults);
	}

</script>
</head>
<body>
<h1>Welcome to SAHA</h1>
<h2>Spring + Ajax + Hibernate + Annotations</h2>
<hr>
<p>
Included in this build
<ul>
	<li>Spring 3.0.2</li>
	<li>DWR 3.0.M1</li>
	<li>Hibernate 3.3.2.GA</li>
	<li>JQuery Core 1.3.2</li>
	<li>MySQL Driver 5.1.2</li>
	<li>JSTL 1.1.2</li>
	<li>Servlet 2.4 (compatible with Tomcat 5.5+)</li>
	<li>JSP 2.0 (compatible with Tomcat 5.5+)</li>
</ul>
</p>
<div id="welcome">
<h2>Hibernate Test</h2>
<c:choose>
	<c:when test="${empty nameMetadata.metavalue }">
		Welcome!<br/>
		Your name is not in the database currently.<br/>
		Enter it here to store in the database<br/>
	</c:when>
	<c:otherwise>
		Welcome back, ${nameMetadata.metavalue}!<br/>
		Your name is stored in the database, so I knew who you were.<br/>
		If you would like to change it, enter the new name below.<br/>
	</c:otherwise>
</c:choose>
<input type="text" id="name" name="name"/>&nbsp;<button onclick="saveName();">Save Name</button> 
</div>
<p>
<button onclick="removeName()">Remove Name from Database</button>
</p>
<p>
<h2>Simple Ajax Value Test</h2>
Test DWR/Ajax.  My service name is <span id="ajaxDiv"><button onclick="simpleAjaxTest()">Click to get service name</button></span>
</p>
<p>
View the <a href="<c:url value='/dwr/test/AjaxTestService'/>">DWR AjaxTestService debug page</a>
</p>
<p>
<h2>Ajax Page Rendering Test</h2><br/>
Show table for:  
<c:forEach begin="1" end="12" var="targetNumber"><button onclick="showMultiplicationTable(${targetNumber});">${targetNumber}</button>&nbsp;</c:forEach>
</p>
<div id="multiplicationTable">
Placeholder for multiplication table
</div>
</body>
</html>