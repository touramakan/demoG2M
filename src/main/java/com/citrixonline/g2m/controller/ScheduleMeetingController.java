package com.citrixonline.g2m.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;

import com.citrixonline.g2m.model.Meeting;
import com.citrixonline.g2m.model.MeetingExtended;

@Controller
@RequestMapping(value="/schedule")
public class ScheduleMeetingController extends AbstractController{

	static final Logger LOGGER = LoggerFactory.getLogger(ScheduleMeetingController.class);
	

	public ModelAndView showForm(Meeting meetingDetails, @RequestParam(required=false) String action){
		
		return new ModelAndView("schedule", "meetingDetails", meetingDetails);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView scheduleMeeting(Meeting meetingDetails, HttpServletRequest httpRequest) {
		LOGGER.info("scheduling meeting ...");
		ModelAndView modelAndView = new ModelAndView("home");

		String jsonString = jsonifyObject(meetingDetails);
		LOGGER.info("The meeting object as json: {}", jsonString);
		try{			
			HttpHeaders httpHeaders = setHttpHeaders();
			HttpEntity<String>request = new HttpEntity<String>(jsonString, httpHeaders);
			ResponseEntity<String> resp = restTemplate.postForEntity(BASE_URL, request, String.class);
			if(resp.getBody() != null){
				ArrayList<MeetingExtended> meetingExtended = deserializeString(resp.getBody());
				modelAndView.addObject("listOfMeetings", meetingExtended );
				modelAndView.addObject("pageContent", "Meeting has been successfully created\n");
			}else{
				modelAndView.addObject("pageContent", "Error occured while creating the meeting \n"  );
			}
		}catch(HttpClientErrorException e){
			modelAndView.addObject("pageContent", "Error occured while creating the meeting \n"+ e.getResponseBodyAsString() );			
		}
		return modelAndView;
	}
}
