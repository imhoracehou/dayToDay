package com.horace.easyUI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EasyAction {
	
	@RequestMapping("easyUI/show")
	public String show() {
		return "easyUI/show";
	}
}
