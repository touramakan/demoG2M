package com.citrixonline.g2m.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class MeetingExtended extends Meeting {

	private String numAttendees;
	private String date;
	private String organizerkey;
	private String duration;
	private String joinURL;
	private String meetingid;
	private String conferenceCallInfo;

	public MeetingExtended(){
		super();
	}
	
	public String getNumAttendees() {
		return numAttendees;
	}
	public void setNumAttendees(String numAttendees) {
		this.numAttendees = numAttendees;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getOrganizerkey() {
		return organizerkey;
	}
	public void setOrganizerkey(String organizerkey) {
		this.organizerkey = organizerkey;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getJoinURL() {
		return joinURL;
	}
	public void setJoinURL(String joinURL) {
		this.joinURL = joinURL;
	}
	public String getMeetingid() {
		return meetingid;
	}
	public void setMeetingid(String meetingid) {
		this.meetingid = meetingid;
	}
	public String getConferenceCallInfo() {
		return conferenceCallInfo;
	}
	public void setConferenceCallInfo(String conferenceCallInfo) {
		this.conferenceCallInfo = conferenceCallInfo;
	}
	
}
