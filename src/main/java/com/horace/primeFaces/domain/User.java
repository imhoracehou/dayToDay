package com.horace.primeFaces.domain;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "user")
@SessionScoped
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String text;
	private Date date1 = new Date();

	public User() {
		System.out.println("每次Request请求，UserBean都会重新实例化。");
		// session
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext extContext = facesContext.getExternalContext();
		HttpSession session = (HttpSession) extContext.getSession(true);
		session.setAttribute("welcomeWords", "欢迎您使用最牛逼的JSF系统");
		System.out.println(session.getAttribute("welcomeWords"));
	}

	public void checkUser() {
		System.out.println(name);
	}

	public void inputTextBlur(AjaxBehaviorEvent e) {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String type = request.getParameter("type");
		request.getParameter("name");
		System.out.println(e);
		System.out.println("inputTextBlur : " + text);
		System.out.println("ajax param : " + type);
	}

	public void commandButton() {
		System.out.println("commandButton");
	}

	// --------------------------------------------------get and set

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
