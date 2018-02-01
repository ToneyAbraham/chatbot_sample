package com.chatbot.messaging;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class MessagingController {

	@RequestMapping(value = "/sample", method = RequestMethod.POST)
	public String hello() {

		/*Map response = new HashMap<String, String>();
		Object obj = null;
		List contextOut = new ArrayList<String>();
		response.put("speech", "123456789");
		response.put("displayText", "Your Account Number is 123456789");
		response.put("data", obj);
		response.put("contextOut", contextOut);
		response.put("source", "source");
		return response;*/
		return "Hello";
	}
}
