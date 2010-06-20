<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Ajax Page Rendering Test</h2><br/>
<p>
This test renders a JSP page with a given parameter and shows the result on the page
via JQuery (by way of SAHA's own applyAjaxResult function)
</p>
<p>
Show table for:  
<c:forEach begin="1" end="12" var="targetNumber"><button onclick="showMultiplicationTable(${targetNumber});">${targetNumber}</button>&nbsp;</c:forEach>
</p>
<div id="multiplicationTable">

</div>