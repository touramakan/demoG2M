<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Demo G2M</title>
    <meta charset="utf-8" />
    <script src="http://code.jquery.com/jquery-1.11.0.min.js" type="text/javascript"></script>
</head>
<body>
<h1>
	Demo Go2Meeting  
</h1>
	<div id="content">
	<p> Here are details of scheduled or past meetings </p>
	<br>
	<P> ${pageContent} </P>
	</div>
	<form>
	<div id="buttons">
		<input id="schedule" type="button" name="action" value="Schedule"/>
		<input id="meetings" type="button" name="action" value="Meetings"/>
		<input id="history" type="submit" name="action" value="History"/>
	</div>
	</form>
</body>
</html>
