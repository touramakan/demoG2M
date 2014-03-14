package com.citrixonline.g2m.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import com.citrixonline.g2m.model.MeetingExtended;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AbstractController {
	static final Logger LOGGER = LoggerFactory.getLogger(AbstractController.class);
	protected static final String BASE_URL = "https://api.citrixonline.com/G2M/rest/meetings";
	@Resource
	protected RestTemplate restTemplate;

	public AbstractController() {
		super();
	}

	protected HttpHeaders setHttpHeaders() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("HTTP", "1.1");
		httpHeaders.set("Accept", "application/json");
		httpHeaders.set("content-type", "application/json");
		httpHeaders.set("Authorization", "OAuth oauth_token=RIy2h599wz1TsbiTbZosoiAGaTvF");
		return httpHeaders;
	}

	@SuppressWarnings("unchecked")
	protected ArrayList<MeetingExtended> deserializeString(String json) {
		ArrayList<MeetingExtended> readValue = null;
		ObjectMapper om = new ObjectMapper();
		try {
			LOGGER.info("String to be deserialized: {}", json);
			om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			readValue = (ArrayList<MeetingExtended>) om.readValue(json,new TypeReference<ArrayList<MeetingExtended>>() {});
		} catch (JsonParseException e) {
			LOGGER.error("JsonParseException", e);
		} catch (JsonMappingException e) {
			LOGGER.error("JsonMappingException", e);
		} catch (IOException e) {
			LOGGER.error("IOException", e);
		}
		return readValue;
	}

	protected String jsonifyObject(Object object) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(object);
			LOGGER.info("Serialized object {} {}:", object, jsonString);
		} catch (JsonGenerationException e) {
			LOGGER.error("JsonGenerationException", e);
		} catch (JsonMappingException e) {
			LOGGER.error("JsonMappingException", e);
		} catch (IOException e) {
			LOGGER.error("IOException", e);
		}
		return jsonString;
	}

}