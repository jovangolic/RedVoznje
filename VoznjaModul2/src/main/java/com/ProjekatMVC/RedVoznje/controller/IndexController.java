package com.ProjekatMVC.RedVoznje.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ServletContextAware;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.ServletContext;

@Controller
@RequestMapping(value="/baseURL")
public class IndexController  implements ServletContextAware{
	
	@Autowired
	private ServletContext servletContext;
	
	private String baseURL;

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
	@PostConstruct
	public void init() {
		baseURL = servletContext.getContextPath() + "/";
	}
	
	
	public Map<String, Object> baseURL(){
		Map<String, Object> odgorvor = new LinkedHashMap<>();
		odgorvor.put("status", "ok");
		odgorvor.put("baseURL", baseURL);
		return odgorvor;
	}

}
