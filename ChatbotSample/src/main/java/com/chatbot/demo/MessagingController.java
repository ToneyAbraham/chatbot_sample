package com.chatbot.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class MessagingController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MessagingController.class);
	
	@RequestMapping(value = "/sample", method = RequestMethod.POST)
	public Map<String, Object> hello(@RequestBody Map<String, Object> json) {
		
		
		Map<String, Object> result = (Map<String, Object>) json.get("result");
		Map<String, Object> params = (Map<String, Object>) result.get("parameters");
		Map<String, Object> response = new HashMap<>();
		Object obj = null;
		List<String> contextOut = new ArrayList<String>();
		if(!params.isEmpty()){
			Object choices = params.get("choices");
			Object quantity = params.get("quantity");
			Object type = params.get("type");
			Object flavors = params.get("flavors");
			Object paymentType = params.get("paymentType");
			LOGGER.info("logging params " + choices + " : " + quantity + " : " + type + " : " + flavors + " : " + paymentType);
			if(choices != null){
				response.put("speech", "We've chocolate, Strowberry, Vanilla and Mango available");
				response.put("displayText", "We've chocolate, Strowberry, Vanilla and Mango available");
				response.put("data", obj);
				response.put("contextOut", contextOut);
				response.put("source", "webhook-foodcorner");
			}else if(quantity != null && type != null && flavors != null){
				response.put("speech", "You've ordered" + quantity + " " + type + " " + flavors + ". How would you like to pay? Card or Net Banking");
				response.put("displayText", "You've ordered" + quantity + " " + type + " " + flavors + ". How would you like to pay? Card or Net Banking");
				response.put("data", obj);
				response.put("contextOut", contextOut);
				response.put("source", "webhook-foodcorner");
			}else if(paymentType != null){
				response.put("speech", "You've successfully placed order. Enjoy your icecream");
				response.put("displayText", "You've successfully placed order. Enjoy your icecream");
				response.put("data", obj);
				response.put("contextOut", contextOut);
				response.put("source", "webhook-foodcorner");
			}
			return response;
		}
		response.put("speech", "response from server");
		response.put("displayText", "response from server");
		response.put("data", obj);
		response.put("contextOut", contextOut);
		response.put("source", "webhook-foodcorner");
		return response;
	}
}
