<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Hibernate Test</h2>
Thanks!<br/>
Your name has been stored in the database as ${nameMetadata.metavalue}<br/>
To change it, type a new name below and press save<br/>
<input type="text" id="name" name="name"/>&nbsp;<button onclick="saveName();">Save Name</button> 
