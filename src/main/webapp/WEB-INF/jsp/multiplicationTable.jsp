<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table border="3" cellpadding="5">
<c:forEach begin="1" end="12" var="rowNum">
<tr>
	<td>${targetNumber} x ${rowNum}</td>
	<td>${targetNumber * rowNum}</td>
</tr>
</c:forEach>
</table>