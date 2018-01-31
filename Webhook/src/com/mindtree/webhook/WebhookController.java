package com.mindtree.webhook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.JsonObject;

@Path("/accountDetails")
public class WebhookController {
	@GET
	@Path("/getAccountNumber")
	@Produces(MediaType.APPLICATION_JSON )
	public Map getAccountNumber(JsonObject jsonObj){
		Map response = new HashMap<String, String>();
		Object obj = null;
		List contextOut = new ArrayList<String>();
		response.put("speech", "123456789");
		response.put("displayText", "Your Account Number is 123456789");
		response.put("data", obj);
		response.put("contextOut", contextOut);
		response.put("source", "source");
		return response;
	}
	
}
