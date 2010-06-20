<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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