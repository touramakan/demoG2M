package com.citrixonline.g2m.controller;

import java.util.ArrayList;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.citrixonline.g2m.model.MeetingExtended;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MeetingDetailsController extends AbstractController {
	
	static final Logger LOGGER = LoggerFactory.getLogger(MeetingDetailsController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model,@RequestParam(required=false) String action) {
		if(action == null){			
			model.addAttribute("pageContent", "Welcome to the Demo Go2Meeting App" );
		}else if("Meetings".equals(action)){
			LOGGER.info("Fetching meeting ...");
			model.addAttribute("pageContent", "List of scheduled meetings" );
			String param = "?scheduled=true";
			doRestCall(BASE_URL+param, model);
		}else if("History".equals(action)){
			LOGGER.info("Fetching history ...");
			model.addAttribute("pageContent", "List of past meetings" );
			String param = "?history=true&startDate=2014-03-01T09:00:00Z&endDate=2014-03-30T11:00:00Z";
			doRestCall(BASE_URL+param, model);
		}else if("Schedule".equals(action)){
			return "schedule";
		}
		return "home";
	}
	private void doRestCall(String url, Model model){
		HttpHeaders httpHeaders = setHttpHeaders();
		ResponseEntity<String> resp = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<String>(httpHeaders), String.class);
		ArrayList<MeetingExtended> meetingExtended = deserializeString(resp.getBody());
		model.addAttribute("listOfMeetings", meetingExtended );
	}
}
