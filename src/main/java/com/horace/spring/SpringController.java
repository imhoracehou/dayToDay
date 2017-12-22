package com.horace.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.horace.utils.IpUtils;

@Controller
public class SpringController {

	// @RequestMapping("spring/ajaxJson")
	@RequestMapping(value = "spring/ajaxJson", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String ajaxJson(HttpServletRequest request, HttpServletResponse resposne) {
		System.out.println(request.getCharacterEncoding());
		System.out.println(resposne.getCharacterEncoding());
		String url = IpUtils.getRealUrl(request);
		JSONObject obj = new JSONObject();
		obj.put("name", "horace");
		obj.put("chineseName", "贺瑞斯");
		obj.put("sex", "male");
		obj.put("age", "26");
		obj.put("realUrl", url);
		return obj.toString();
	}

}
