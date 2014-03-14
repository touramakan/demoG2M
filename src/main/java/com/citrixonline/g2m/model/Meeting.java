package com.citrixonline.g2m.model;


public class Meeting {
	private String subject;
	private String starttime;
	private String endtime;
	
	private String passwordrequired ;
	private String conferencecallinfo;
	private String timezonekey;
	private String meetingtype;
	
	public Meeting(){}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getPasswordrequired() {
		return passwordrequired;
	}
	public void setPasswordrequired(String passwordrequired) {
		this.passwordrequired = passwordrequired;
	}
	public String getConferencecallinfo() {
		return conferencecallinfo;
	}
	public void setConferencecallinfo(String conferencecallinfo) {
		this.conferencecallinfo = conferencecallinfo;
	}
	public String getTimezonekey() {
		return timezonekey;
	}
	public void setTimezonekey(String timezonekey) {
		this.timezonekey = timezonekey;
	}
	public String getMeetingtype() {
		return meetingtype;
	}
	public void setMeetingtype(String meetingtype) {
		this.meetingtype = meetingtype;
	}
}
