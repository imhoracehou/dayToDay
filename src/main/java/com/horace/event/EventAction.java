package com.horace.event;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventAction {
	
	@RequestMapping("event/show")
	public String show() {
		return "event/show";
	}

	@RequestMapping("event/iframe")
	public String iframe() {
		return "event/iframe";
	}
}
