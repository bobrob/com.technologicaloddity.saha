<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Simple Ajax Value Test</h1>
<p>This test retrieves a String from DWR, and replaces it on-screen with jquery</p>
<p>
My service name is <span id="ajaxDiv"><button onclick="simpleAjaxTest()">Click to get service name</button></span>
</p>
<p>
View the <a href="<c:url value='/dwr/test/AjaxTestService'/>" target="_dwrtest">DWR AjaxTestService debug page</a> (DWRController must be debug=true in dispatch-servlet.xml)
</p>