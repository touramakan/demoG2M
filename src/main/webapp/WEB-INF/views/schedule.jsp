<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<h3>Create Meeting</h3>
<form:form method="POST" action="/g2m/schedule">
 
    <table>
    <tr>
        <td><label for="subject">Subject</label></td>
        <td><input name="subject" value="${meeting.subject}"/></td>
    </tr>
    <tr>
        <td><label for="starttime">Starttime</label></td>
        <td><input name="starttime" value="${meeting.starttime}"/></td>
    </tr>
    <tr>
        <td><label for="endtime">Endtime</label></td>
        <td><input name="endtime" value="${meeting.endtime}"/></td>
    </tr>
    <tr>
        <td><label for="passwordrequired">Passwordrequired</label></td>
        <td><input name="passwordrequired" value="${meeting.passwordrequired}"/></td>
    </tr>
    <tr>
        <td><label for="conferencecallinfo">Conferencecallinfo</label></td>
        <td><input name="conferencecallinfo" value="${meeting.conferencecallinfo}"/></td>
    </tr>
    <tr>
        <td><label for="timezonekey">Timezonekey</label></td>
        <td><input name="timezonekey" value="${meeting.timezonekey}"/></td>
    </tr>
    <tr>
        <td><label for="meetingtype">Meetingtype</label></td>
        <td><input name="meetingtype" value="${meeting.meetingtype}"/></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Schedule Meeting"/>
        </td>
    </tr>
</table> 
 </form:form>
</body>
</html>
