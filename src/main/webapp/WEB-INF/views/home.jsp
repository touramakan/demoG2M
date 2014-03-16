<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Demo G2M</title>
<meta charset="utf-8" />
<script src="http://code.jquery.com/jquery-1.11.0.min.js"
	type="text/javascript"></script>
</head>
<body>
	<form action="/g2m">
		<div id="content">
			<h1>Demo Go2Meeting</h1>
			<br>
			<h3>${pageContent}</h3>
			<p>
				<c:if test="${not empty listOfMeetings}">
					<table>
						<thead>
							<tr>
								<th>Subject</th>
								<th>Passwordrequired</th>
								<th>Starttime</th>
								<th>Endtime</th>
								<th>Date</th>
								<th>NumAttendees</th>
								<th>Organizerkey</th>
								<th>Duration</th>
								<th>JoinURL</th>
								<th>ConferenceCallInfo</th>
								<th>Meetingtype</th>
							</tr>
						</thead>
						<c:forEach items="#{listOfMeetings}" var="meetingExtended">
							<tr>
								<td>${meetingExtended.subject}</td>
								<td>${meetingExtended.passwordrequired}</td>
								<td>${meetingExtended.starttime}</td>
								<td>${meetingExtended.endtime}</td>
								<td>${meetingExtended.date}</td>
								<td>${meetingExtended.numAttendees}</td>
								<td>${meetingExtended.organizerkey}</td>
								<td>${meetingExtended.duration}</td>
								<td>${meetingExtended.joinURL}</td>
								<td>${meetingExtended.conferencecallinfo}</td>
								<td>${meetingExtended.meetingtype}</td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
			</p>
		</div>
		<div id="footer">
			<input id="schedule" type="submit" name="action" value="Schedule" />
			<input id="meetings" type="submit" name="action" value="Meetings" />
			<input id="history" type="submit" name="action" value="History" />
		</div>
	</form>
</body>
</html>
