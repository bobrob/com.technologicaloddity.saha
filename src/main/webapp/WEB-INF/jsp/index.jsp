<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>SAHA Archetype Start Page</title>
<script type='text/javascript' src='<c:url value="/dwr/interface/AjaxTestService.js"/>'></script>
<script type='text/javascript' src='<c:url value="/dwr/engine.js"/>'></script>
<script type='text/javascript' src='<c:url value="/dwr/util.js"/>'></script>
<script type='text/javascript' src='<c:url value="/js/jquery-1.3.2.min.js"/>'></script>
<script type='text/javascript' src='<c:url value="/js/saha.js"/>'></script>
<link rel="stylesheet" href="<c:url value='css/blueprint/screen.css'/>" type="text/css" media="screen, projection">
<link rel="stylesheet" href="<c:url value='css/blueprint/print.css'/>" type="text/css" media="print">
<!--[if lt IE 8]><link rel="stylesheet" href="<c:url value='css/blueprint/ie.css'/>" 
  type="text/css" media="screen, projection"><![endif]-->
<link rel="stylesheet" href="<c:url value='css/saha.css'/>" type="text/css" media="screen">
<script type="text/javascript">
	function showContentPage(viewName) {
		AjaxTestService.showContentPage(viewName, applyAjaxResults);
	}

	function simpleAjaxTest() {
		AjaxTestService.getServiceName(function(data) {
			$('#ajaxDiv').html(data);
		});
	}	
</script>
</head>
<body>
<div class="container showgrid">
	<div class="span-24 last" id="header">
		<div class="span-4" id="headerleft">
			<img src="<c:url value='images/sahalogo.png'/>" height=80 width=75/>&nbsp;
		</div>
		<div class="span-20 last" id="headerright">
			<h1>SAHA Test Webapp</h1>
		</div>	
	</div>
	<div class="span-4" id="left">
		<jsp:include page="leftMenu.jsp"></jsp:include>
	</div>
	<div class="span-20 last" id="content">
		<jsp:include page="indexMain.jsp"></jsp:include>
	</div>
</div>
</body>
</html>